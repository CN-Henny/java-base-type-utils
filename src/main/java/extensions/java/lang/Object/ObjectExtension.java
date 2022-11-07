package extensions.java.lang.Object;

import cn.hutool.core.bean.BeanUtil;
import com.Utils.ColumnUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.Nullable;

import java.beans.FeatureDescriptor;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Extension
public class ObjectExtension {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 模型转换相关
     */
    public final static int Copy = 0;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 排除掉
     * source中所有字段为null的字段
     */
    public final static int CopyIgnoreNull = 1;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 排除掉
     * source中所有字段为“”的字段
     */
    public final static int CopyIgnoreEmpty = 2;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 排除掉
     * source中所有字段为null和“”的字段
     */
    public final static int CopyIgnoreEmptyOrNull = 3;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 排除掉
     * source中所有字段为传入值为List-String的字段
     */
    public final static int CopyIgnoreFilter = 4;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 只替换
     * source中所有字段为null的字段
     */
    public final static int CopyContainsNull = 5;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 只替换
     * source中所有字段为“”的字段
     */
    public final static int CopyContainsEmpty = 6;

    /**
     * 模型转换相关，标识在模型转换过程中
     * 只替换
     * source中所有字段为List-String的字段
     */
    public final static int CopyContainsEmptyOrNull = 7;

    /**
     * 描述
     */
    public final static int CopyContainsFilter = 8;

    /**
     * 模型转换基础方法
     *
     * @param source
     * @param filterStr
     * @param type
     * @return java.lang.String[]
     * @throws
     * @author Henny
     * @cdate 2022/10/28 14:46
     * @version 1.0
     * @mdate 2022/10/28 14:46
     * @since 1.0
     */
    private static String[] getPassNameArray(Object source, List<String> filterStr, int type) {
        List<String> resultList = new ArrayList<>();
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        Supplier<Stream<String>> sss = () -> Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName);
        filterStr.forEach(item -> {
            List<String> filterList = sss.get()
                    .filter(propertyName -> ((wrappedSource.getPropertyValue(propertyName) != null
                            && wrappedSource.getPropertyValue(propertyName).toString().equals(item))
                            || wrappedSource.getPropertyValue(propertyName) == item)
                            && !resultList.contains(propertyName))
                    .collect(Collectors.toList());
            resultList.addAll(filterList);
        });
        if (type < 5) {
            return resultList.toArray(new String[resultList.size()]);
        } else {
            List<String> reduce1 = sss.get().filter(e -> !resultList.contains(e)).collect(Collectors.toList());
            return reduce1.toArray(new String[resultList.size()]);
        }
    }

    //region   判断型


    //endregion

    //region   功能型

    /**
     * 对比两个对象返回不同值的属性map
     *
     * @param source
     * @param target
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @throws
     * @author Henny
     * @cdate 2022/10/18 16:08
     * @version 1.0
     * @mdate 2022/10/18 16:08
     * @since 1.0
     */
    public static Map<String, Object> systemCustomGetModifyContent(@This Object source, Object target) {
        Map<String, Object> modifies = new HashMap<>(16);
         /*
          process null problem, if all null means equal
          if only source is null means all modified
          if only target is null means nothing changed
         */
        if (null == source || null == target) {
            if (null == source && null == target) {
                return modifies;
            } else if (null == target) {
                return modifies;
            } else {
                return mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
                });
            }
        }
        // source and target must be same class type
        if (!Objects.equals(source.getClass().getName(), target.getClass().getName())) {
            throw new ClassCastException("source and target are not same class type");
        }
        Map<String, Object> sourceMap = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> targetMap = mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
        });
        sourceMap.forEach((k, v) -> {
            Object targetValue = targetMap.get(k);
            if (!Objects.equals(v, targetValue)) {
                modifies.put(k, targetValue);
            }
        });
        return modifies;
    }

    /**
     * 获取实体类的字段名称
     *
     * @param thiz
     * @param fn
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/27 20:38
     * @version 1.0
     * @mdate 2022/10/27 20:38
     * @since 1.0
     */
    public static <T> String customGetFieldName(@This Object thiz, ColumnUtil.SFunction<T, ?> fn) {
        return thiz.customGetFieldName(fn, "");
    }

    /**
     * 获取实体类的字段名称
     *
     * @param thiz
     * @param fn
     * @param split 分隔符，多个字母自定义分隔符
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/27 20:37
     * @version 1.0
     * @mdate 2022/10/27 20:37
     * @since 1.0
     */
    public static <T> String customGetFieldName(@This Object thiz, ColumnUtil.SFunction<T, ?> fn, String split) {
        return thiz.customGetFieldName(fn, split, 0);
    }

    /**
     * 获取实体类的字段名称
     *
     * @param thiz
     * @param fn
     * @param split  分隔符，多个字母自定义分隔符
     * @param toType 转换方式，多个字母以大小写方式返回 0.不做转换 1.大写 2.小写
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/27 20:37
     * @version 1.0
     * @mdate 2022/10/27 20:37
     * @since 1.0
     */
    public static <T> String customGetFieldName(@This Object thiz, ColumnUtil.SFunction<T, ?> fn, String split, Integer toType) {
        return ColumnUtil.getFieldName(fn, split, toType);
    }

    //endregion

    //region   转换型

    /**
     * 拷贝实体
     *
     * @param thiz
     * @param target
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/10/28 14:13
     * @version 1.0
     * @mdate 2022/10/28 14:13
     * @since 1.0
     */
    public static <T> void customCopyPropertiesTo(@This Object thiz, Object target, ColumnUtil.SFunction<T,?> fn) {
        thiz.customCopyPropertiesTo(target, ObjectExtension.Copy);
    }

    /**
     * 拷贝实体
     *
     * @param thiz
     * @param target
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/10/28 14:13
     * @version 1.0
     * @mdate 2022/10/28 14:13
     * @since 1.0
     */
    public static <T> void customCopyPropertiesTo(@This Object thiz, Object target) {
        thiz.customCopyPropertiesTo(target, ObjectExtension.Copy);
    }

    /**
     * 拷贝实体
     *
     * @param thiz
     * @param target
     * @param specialType
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/10/28 14:13
     * @version 1.0
     * @mdate 2022/10/28 14:13
     * @since 1.0
     */
    public static <T> void customCopyPropertiesTo(@This Object thiz, Object target, int specialType) {
        thiz.customCopyPropertiesTo(target, specialType, new ArrayList());
    }

    /**
     * 拷贝实体
     *
     * @param thiz
     * @param target
     * @param specialType
     * @param specialStrList
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/10/28 14:37
     * @version 1.0
     * @mdate 2022/10/28 14:37
     * @since 1.0
     */
    public static <T> void customCopyPropertiesTo(@This Object thiz, Object target, int specialType, List<String> specialStrList) {
        switch (specialType) {
            case CopyIgnoreNull:
            case CopyContainsNull: {
                specialStrList.add(null);
                break;
            }
            case CopyIgnoreEmpty:
            case CopyContainsEmpty: {
                specialStrList.add("");
                break;
            }
            case CopyIgnoreEmptyOrNull:
            case CopyContainsEmptyOrNull: {
                specialStrList.add(null);
                specialStrList.add("");
                break;
            }
        }
        String[] filterList = getPassNameArray(thiz, specialStrList, specialType);
        BeanUtils.copyProperties(thiz, target, filterList);
    }

    //endregion
}
