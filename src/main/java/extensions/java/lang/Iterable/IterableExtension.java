package extensions.java.lang.Iterable;

import com.Interface.*;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Extension
public class IterableExtension {
    public static <T> List<T> customToLambda(@This Iterable<T> thiz, LambdaIterableInterfaceExtension<? super T> after) {
        List<T> objectList = new ArrayList<>();
        for (T element : thiz) {
            if(after.action(element)){
                objectList.add(element);
            }
        }
        return objectList;
    }

    //region 转换型

    /**
     * List-Object转List-BigDecimalList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.math.BigDecimal>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 9:51
     * @mdate 2022/10/24 9:51
     * @since 1.0
     */
    public static <T> List<BigDecimal> customToBigDecimalList(@This Iterable<T> thiz, ToBigDecimalInterfaceExtension<? super T> after) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            bigDecimals.add(after.action(element));
        }
        return bigDecimals;
    }

    /**
     * List-Object转List-LongList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.lang.Long>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 9:53
     * @version 1.0
     * @mdate 2022/10/24 9:53
     * @since 1.0
     */
    public static <T> List<Long> customToLongList(@This Iterable<T> thiz, ToLongInterfaceExtension<? super T> after) {
        List<Long> longs = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            longs.add(after.action(element));
        }
        return longs;
    }

    /**
     * List-Object转List-StringList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.lang.String>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 9:53
     * @version 1.0
     * @mdate 2022/10/24 9:53
     * @since 1.0
     */
    public static <T> List<String> customToStringList(@This Iterable<T> thiz, ToStringInterfaceExtension<? super T> after) {
        List<String> strings = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            strings.add(after.action(element));
        }
        return strings;
    }

    /**
     * List-Object转List-DoubleList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.lang.Double>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 9:58
     * @version 1.0
     * @mdate 2022/10/24 9:58
     * @since 1.0
     */
    public static <T> List<Double> customToDoubleList(@This Iterable<T> thiz, ToDoubleInterfaceExtension<? super T> after) {
        List<Double> doubles = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            doubles.add(after.action(element));
        }
        return doubles;
    }

    /**
     * List-Object转List-FloatList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.lang.Float>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 10:00
     * @version 1.0
     * @mdate 2022/10/24 10:00
     * @since 1.0
     */
    public static <T> List<Float> customToFloatList(@This Iterable<T> thiz, ToFloatInterfaceExtension<? super T> after) {
        List<Float> floats = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            floats.add(after.action(element));
        }
        return floats;
    }

    /**
     * List-Object转List-IntegerList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.lang.Integer>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 10:02
     * @version 1.0
     * @mdate 2022/10/24 10:02
     * @since 1.0
     */
    public static <T> List<Integer> customToIntegerList(@This Iterable<T> thiz, ToIntegerInterfaceExtension<? super T> after) {
        List<Integer> integers = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            integers.add(after.action(element));
        }
        return integers;
    }

    /**
     * List-Object转List-DateList
     * 可用作类型转换或实体列表字段提取并转换
     *
     * @param thiz
     * @param after
     * @return java.util.List<java.util.Date>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 10:04
     * @version 1.0
     * @mdate 2022/10/24 10:04
     * @since 1.0
     */
    public static <T> List<Date> customToDateList(@This Iterable<T> thiz, ToDateInterfaceExtension<? super T> after) {
        List<Date> dates = new ArrayList<>();
        for (T element : thiz) {
            after.action(element);
            dates.add(after.action(element));
        }
        return dates;
    }

    //endregion
}
