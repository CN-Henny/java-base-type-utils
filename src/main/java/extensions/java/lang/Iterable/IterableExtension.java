package extensions.java.lang.Iterable;

import extensions.java.lang.Long.LongInterfaceExtension;
import extensions.java.lang.String.StringInterfaceExtension;
import extensions.java.math.BigDecimal.BigDecimalInterfaceExtension;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Extension
public class IterableExtension {
    public static <T> T customSelect(@This Iterable<T> thiz) {
        return null;
    }

    //region 转换型

    public static <T> List<BigDecimal> toBigDecimalList(@This Iterable<T> source, BigDecimalInterfaceExtension<? super T> after) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (T element : source) {
            after.action(element);
            bigDecimals.add(after.action(element));
        }
        return bigDecimals;
    }

    public static <T> List<Long> toLongList(@This Iterable<T> source, LongInterfaceExtension<? super T> after) {
        List<Long> longs = new ArrayList<>();
        for (T element : source) {
            after.action(element);
            longs.add(after.action(element));
        }
        return longs;
    }

    public static <T> List<String> toStringList(@This Iterable<T> source, StringInterfaceExtension<? super T> after) {
        List<String> strings = new ArrayList<>();
        for (T element : source) {
            after.action(element);
            strings.add(after.action(element));
        }
        return strings;
    }

    //endregion
}
