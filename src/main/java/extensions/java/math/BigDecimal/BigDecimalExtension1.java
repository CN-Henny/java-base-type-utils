package extensions.java.math.BigDecimal;

import manifold.ext.rt.api.ComparableUsing;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

@Extension
public abstract class BigDecimalExtension1 implements ComparableUsing<BigDecimal> {
    /**
     * Supports binary operator {@code +}
     */
    //public static BigDecimal plus(@This BigDecimal thiz, BigDecimal that) {
    //    return thiz.add(that);
    //}
}
