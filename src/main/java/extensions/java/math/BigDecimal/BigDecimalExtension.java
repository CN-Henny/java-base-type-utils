package extensions.java.math.BigDecimal;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

/**
 * BigDecimal Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
 *
 * @author Henny
 * @since 2022/8/8 16:15
 */
@Extension
public class BigDecimalExtension {
    public static String customNousedF_E(@This BigDecimal source) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(source);
    }

    /**
     * Sum Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:55
     * @version 1.0
     * @mdate 2022/10/18 15:55
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, BigDecimal... nums) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal item : nums) {
            result = result.add(item);
        }
        return result;
    }

    /**
     * Sum Number Re bigDecimal Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @param nums
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:47
     * @version 1.0
     * @mdate 2022/10/18 15:47
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, BigDecimal errorBack, BigDecimal... nums) {
        try {
            return source.customSumAll(nums);
        } catch (Exception ex) {
            return errorBack;
        }
    }
}
