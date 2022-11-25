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

    public static <E, T> List<E> customGetValue(@This List<E> source, List<E> errorBack) {
        return source == null ? errorBack : source;
    }

    public static <E, T> List<E> customGetValue(@This List<E> source) {
        return source == null ? new ArrayList<>() : source;
    }
}
