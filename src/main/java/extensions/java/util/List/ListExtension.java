package extensions.java.util.List;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.Self;
import manifold.ext.rt.api.This;

import java.util.ArrayList;
import java.util.List;

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
    public static <T> @Self List<T> customConvertList(@This List<?> source, Class<T> clazz) {
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
}
