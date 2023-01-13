package extensions.java.util.List;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Extension
public class ListExtension {

    //region 判断型
    public static Boolean customIsNull(@This List<Object> source) {
        return source == null;
    }

    /**
     * If source Is Not Null Re true Else Re false
     * Null Range : Null
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:26
     * @version 1.0
     * @mdate 2022/8/5 14:26
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This List<Object> source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:08
     * @version 1.0
     * @mdate 2022/8/5 15:08
     * @since 1.0
     */
    public static @Self List<Object> customIsNotNull(@This List<Object> source, List<Object> errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    /**
     * If source Is Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:54
     * @version 1.0
     * @mdate 2022/8/5 14:54
     * @since 1.0
     */
    public static Boolean customIsEmpty(@This List<Object> source) {
        return source.customIsNull() || (source.count() == 0);
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     * 20221025修改引用错误
     * 20221026改错接口了掉到了IsNull上
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:57
     * @version 1.0.2
     * @mdate 2022/10/25 11:57
     * @since 1.0
     */
    public static Boolean customIsNotEmpty(@This List<Object> source) {
        return !source.customIsEmpty();
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:09
     * @version 1.0
     * @mdate 2022/8/5 15:09
     * @since 1.0
     */
    public static @Self List<Object> customIsNotEmpty(@This List<Object> source, List<Object> errorBack) {
        return source.customIsNotEmpty() ? source : errorBack;
    }
    //endregion

    //region 功能型

    /**
     * 获取list中第一个元素如果没有返回默认值
     *
     * @param source
     * @param clazz
     * @return T
     * @throws
     * @author Henny
     * @cdate 2023/1/13 16:54
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/13 16:54
     * @since 1.0
     */
    public static <E, T> T customFindFirstOrDefault(@This List<E> source, T clazz) {
        if (source.count() < 1) {
            return clazz;
        } else {
            return (T) source.get(0);
        }
    }

    //endregion

    /**
     * 连续向队列添加元素
     *
     * @param source
     * @param key
     * @return java.util.List<java.lang.Object>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 20:37
     * @version 1.0
     * @mdate 2022/10/24 20:37
     * @since 1.0
     */
    public static @Self List<Object> customAdd(@This List<Object> source, Object key) {
        source.add(key);
        return source;
    }

    public static @Self List<Object> customAddAll(@This List<Object> source, List<Object> key) {
        source.addAll(key);
        return source;
    }

    /**
     * List用特定字符拼接
     *
     * @param source
     * @param key
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/11/7 19:39
     * @version 1.0
     * @mdate 2022/11/7 19:39
     * @since 1.0
     */
    public static String customJoin(@This List<Object> source, String key) {
        return source.stream().map(String::valueOf).collect(Collectors.joining(key));
    }

    /**
     * List类型转换
     *
     * @param source
     * @param clazz
     * @return java.util.List<T>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 21:00
     * @version 1.0
     * @mdate 2022/10/24 21:00
     * @since 1.0
     */
    public static <E, T> List<T> customConvertList(@This List<E> source, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (source.isEmpty()) {
            return list;
        }
        for (Object item : source) {
            //把源对象类型强制转换为目标对象
            T target = JSON.parseObject(JSON.toJSONString(item), clazz);
            //把源对象属性赋值给目标对象
            BeanUtil.copyProperties(item, target);
            list.add(target);
        }
        return list;
    }

    //public static <E, T> Integer plus(@This List<E> thiz, List<E> that) {
    //    return 1;
    //}

    /**
     * 始终获得一个非null的对象
     *
     * @param source
     * @param errorBack
     * @return java.util.List<E>
     * @throws
     * @author Henny
     * @cdate 2022/11/25 15:44
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/25 15:44
     * @since 1.0
     */
    public static <E, T> List<E> customGetValue(@This List<E> source, List<E> errorBack) {
        return source == null ? errorBack : source;
    }

    /**
     * 始终获得一个非null的对象
     *
     * @param source
     * @return java.util.List<E>
     * @throws
     * @author Henny
     * @cdate 2022/11/25 15:45
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/25 15:45
     * @since 1.0
     */
    public static <E, T> List<E> customGetValue(@This List<E> source) {
        return source == null ? new ArrayList<>() : source;
    }
}
