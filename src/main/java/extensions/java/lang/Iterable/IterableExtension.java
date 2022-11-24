package extensions.java.lang.Iterable;

import com.Interface.*;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.*;

@Extension
public class IterableExtension {


    //region 功能型

    /**
     * 按条件提取list
     *
     * @param thiz
     * @param after
     * @return java.util.List<T>
     * @throws
     * @author Henny
     * @cdate 2022/10/24 11:00
     * @version 1.0
     * @mdate 2022/10/24 11:00
     * @since 1.0
     */
    public static <T> List<T> customToLambdaSelect(@This Iterable<T> thiz, LambdaIterableInterfaceExtension<? super T> after) {
        List<T> objectList = new ArrayList<>();
        for (T element : thiz) {
            if (after.action(element)) {
                objectList.add(element);
            }
        }
        return objectList;
    }

    public static <T, R> List<T> customToLambdaDistinct(@This Iterable<T> thiz, LambdaGetValueInterface<? super T, R> after) {
        List<T> objectList = new ArrayList<>();
        for (T element : thiz) {
            R a = after.apply(element);
            System.out.println(a);
        }

        return null;
    }

    //endregion

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
        if (thiz == null) {
            return longs;
        }
        for (T element : thiz) {
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

    //region 内部多级方法

    public static <T> List<BigDecimal> customMoreLevelToBigDecimalList(@This Iterable<T> thiz, ToListBigDecimalInterfaceExtension<? super T> after) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (T element : thiz) {
            bigDecimals.addAll(after.action(element));
        }
        return bigDecimals;
    }

    public static <T> List<Long> customMoreLevelToLongList(@This Iterable<T> thiz, ToListLongInterfaceExtension<? super T> after) {
        List<Long> longs = new ArrayList<>();
        for (T element : thiz) {
            longs.addAll(after.action(element));
        }
        return longs;
    }

    public static <T> List<String> customMoreLevelToStringList(@This Iterable<T> thiz, ToListStringInterfaceExtension<? super T> after) {
        List<String> strings = new ArrayList<>();
        for (T element : thiz) {
            strings.addAll(after.action(element));
        }
        return strings;
    }

    public static <T> List<Double> customMoreLevelToDoubleList(@This Iterable<T> thiz, ToListDoubleInterfaceExtension<? super T> after) {
        List<Double> doubles = new ArrayList<>();
        for (T element : thiz) {
            doubles.addAll(after.action(element));
        }
        return doubles;
    }

    public static <T> List<Float> customMoreLevelToFloatList(@This Iterable<T> thiz, ToListFloatInterfaceExtension<? super T> after) {
        List<Float> floats = new ArrayList<>();
        for (T element : thiz) {
            floats.addAll(after.action(element));
        }
        return floats;
    }

    public static <T> List<Integer> customMoreLevelToIntegerList(@This Iterable<T> thiz, ToListIntegerInterfaceExtension<? super T> after) {
        List<Integer> integers = new ArrayList<>();
        for (T element : thiz) {
            integers.addAll(after.action(element));
        }
        return integers;
    }

    public static <T> List<Date> customMoreLevelToDateList(@This Iterable<T> thiz, ToListDateInterfaceExtension<? super T> after) {
        List<Date> dates = new ArrayList<>();
        for (T element : thiz) {
            dates.addAll(after.action(element));
        }
        return dates;
    }

    //endregion

    //endregion

}
