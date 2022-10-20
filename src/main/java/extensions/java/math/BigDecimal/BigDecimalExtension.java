package extensions.java.math.BigDecimal;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.List;

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

    /**
     * 默认精度为12
     */
    private static int scala = 12;

    /**
     * 默认舍入模式为 BigDecimal.ROUND_CEILING
     */
    private static int roundingMode = BigDecimal.ROUND_CEILING;

    private static BigDecimal zeroDecimal = new BigDecimal("0");

    private static void initPara() {
        BigDecimalExtension.scala = 12;
        BigDecimalExtension.roundingMode = BigDecimal.ROUND_CEILING;
    }

    private static void initPara(int scala) {
        BigDecimalExtension.scala = scala;
    }

    private static void initPara(int scala, int roundingMode) {
        BigDecimalExtension.scala = scala;
        BigDecimalExtension.roundingMode = roundingMode;
    }

    private static BigDecimal of(BigDecimal bigDecimal) {
        return bigDecimal.setScale(scala, roundingMode);
    }

    private static void isNullException(BigDecimal source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            throw new NullPointerException("com.dlanqi:base-type-utils Error : source is null");
        }
    }

    private static void isZeroWarning(BigDecimal source) {
        if (source.customIsZero()) {
            //TODO 增加异常返回
            System.out.println("com.dlanqi:base-type-utils Warning : source is zero ");
        }
    }

    private static void isZeroException(BigDecimal source) {
        if (source.customIsZero()) {
            //TODO 增加异常返回
            throw new ArithmeticException("com.dlanqi:base-type-utils Error : source is zero ");
        }
    }

    //region   判断型

    /**
     * If source Is Null Re true Else Re false
     * Null Range : Null
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:25
     * @version 1.0
     * @mdate 2022/8/5 14:25
     * @since 1.0
     */
    public static Boolean customIsNull(@This BigDecimal source) {
        return source == null;
    }

    /**
     * If source Is Not Null Re true Else Re false
     * Null Range : Null
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:26
     * @version 1.0
     * @mdate 2022/8/5 14:26
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This BigDecimal source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:08
     * @version 1.0
     * @mdate 2022/8/5 15:08
     * @since 1.0
     */
    public static BigDecimal customIsNotNull(@This BigDecimal source, BigDecimal errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    /**
     * If source Is Zero Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:26
     * @version 1.0
     * @mdate 2022/8/5 13:26
     * @since 1.0
     */
    public static Boolean customIsZero(@This BigDecimal source) {
        return source.customIsNull() ? false : source.compareTo(BigDecimal.ZERO) == 0 ? true : false;
    }

    /**
     * If source Is Not Zero Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:27
     * @version 1.0
     * @mdate 2022/8/5 13:27
     * @since 1.0
     */
    public static Boolean customIsNotZero(@This BigDecimal source) {
        return !source.customIsZero();
    }

    /**
     * If source Is Not Zero Re source Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:33
     * @version 1.0
     * @mdate 2022/8/8 13:33
     * @since 1.0
     */
    public static BigDecimal customIsNotZero(@This BigDecimal source, BigDecimal errorBack) {
        return !source.customIsZero() ? source : errorBack;
    }

    //endregion

    //region   功能型

    /**
     * 取消科学计数法
     *
     * @param source
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/19 13:43
     * @version 1.0
     * @mdate 2022/10/19 13:43
     * @since 1.0
     */
    public static String customNousedF_E(@This BigDecimal source) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(source);
    }

    //endregion

    //region   转换型

    //endregion

    //region   计算型基础函数

    //region 加法

    /**
     * customSum
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:15
     * @version 1.0
     * @mdate 2022/10/19 14:15
     * @since 1.0
     */
    private static BigDecimal customSum(BigDecimal source, BigDecimal... nums) {
        return customSum(source, nums.customToList());
    }

    /**
     * customSum
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:48
     * @version 1.0
     * @mdate 2022/10/19 14:48
     * @since 1.0
     */
    private static BigDecimal customSum(BigDecimal source, List<BigDecimal> nums) {
        isNullException(source);
        BigDecimal bigDecimal = source;
        for (BigDecimal item : nums) {
            isNullException(item);
            bigDecimal = bigDecimal.add(item);
        }
        return of(bigDecimal);
    }

    //endregion

    //region 减法

    /**
     * customSubtract
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:15
     * @version 1.0
     * @mdate 2022/10/19 14:15
     * @since 1.0
     */
    private static BigDecimal customSubtract(BigDecimal source, BigDecimal... nums) {
        return customSubtract(source, nums.customToList());
    }

    /**
     * customSubtract
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:48
     * @version 1.0
     * @mdate 2022/10/19 14:48
     * @since 1.0
     */
    private static BigDecimal customSubtract(BigDecimal source, List<BigDecimal> nums) {
        isNullException(source);
        BigDecimal bigDecimal = source;
        for (BigDecimal item : nums) {
            isNullException(item);
            bigDecimal = bigDecimal.subtract(item);
        }
        return of(bigDecimal);
    }

    //endregion

    //region 乘法

    /**
     * customMultiply
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:15
     * @version 1.0
     * @mdate 2022/10/19 14:15
     * @since 1.0
     */
    private static BigDecimal customMultiply(BigDecimal source, BigDecimal... nums) {
        return customMultiply(source, nums.customToList());
    }

    /**
     * customMultiply
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:48
     * @version 1.0
     * @mdate 2022/10/19 14:48
     * @since 1.0
     */
    private static BigDecimal customMultiply(BigDecimal source, List<BigDecimal> nums) {
        isNullException(source);
        BigDecimal bigDecimal = source;
        for (BigDecimal item : nums) {
            isNullException(item);
            bigDecimal = bigDecimal.multiply(item);
        }
        return of(bigDecimal);
    }

    //endregion

    //region 除法

    /**
     * customDivide
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:15
     * @version 1.0
     * @mdate 2022/10/19 14:15
     * @since 1.0
     */
    private static BigDecimal customDivide(BigDecimal source, BigDecimal... nums) {
        return customDivide(source, nums.customToList());
    }

    /**
     * customDivide
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:48
     * @version 1.0
     * @mdate 2022/10/19 14:48
     * @since 1.0
     */
    private static BigDecimal customDivide(BigDecimal source, List<BigDecimal> nums) {
        isZeroWarning(source);
        BigDecimal bigDecimal = source;
        for (BigDecimal item : nums) {
            isZeroException(item);
            bigDecimal = bigDecimal.divide(item);
        }
        return of(bigDecimal);
    }

    //endregion

    //endregion

    //region   计算型

    //region 加法

    /**
     * Sum Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:44
     * @version 1.0
     * @mdate 2022/10/19 14:44
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, BigDecimal... nums) {
        initPara();
        return customSum(source, nums);
    }

    /**
     * Sum Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:44
     * @version 1.0
     * @mdate 2022/10/19 14:44
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, int scala, int roundingMode, BigDecimal... nums) {
        initPara(scala, roundingMode);
        return customSum(source, nums);
    }

    /**
     * Sum Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:44
     * @version 1.0
     * @mdate 2022/10/19 14:44
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, List<BigDecimal> nums) {
        initPara();
        return customSum(source, nums);
    }

    /**
     * Sum Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 14:44
     * @version 1.0
     * @mdate 2022/10/19 14:44
     * @since 1.0
     */
    public static BigDecimal customSumAll(@This BigDecimal source, int scala, int roundingMode, List<BigDecimal> nums) {
        initPara(scala, roundingMode);
        return customSum(source, nums);
    }

    //endregion

    //region 减法

    /**
     * Subtract Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:01
     * @version 1.0
     * @mdate 2022/10/19 15:01
     * @since 1.0
     */
    public static BigDecimal customSubtractAll(@This BigDecimal source, BigDecimal... nums) {
        initPara();
        return customSubtract(source, nums);
    }

    /**
     * Subtract Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customSubtractAll(@This BigDecimal source, int scala, int roundingMode, BigDecimal... nums) {
        initPara(scala, roundingMode);
        return customSubtract(source, nums);
    }

    /**
     * Subtract Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customSubtractAll(@This BigDecimal source, List<BigDecimal> nums) {
        initPara();
        return customSubtract(source, nums);
    }

    /**
     * Subtract Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customSubtractAll(@This BigDecimal source, int scala, int roundingMode, List<BigDecimal> nums) {
        initPara(scala, roundingMode);
        return customSubtract(source, nums);
    }

    //endregion

    //region 乘法

    /**
     * Multiply Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customMultiplyAll(@This BigDecimal source, BigDecimal... nums) {
        initPara();
        return customMultiply(source, nums);
    }

    /**
     * Multiply Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customMultiplyAll(@This BigDecimal source, int scala, int roundingMode, BigDecimal... nums) {
        initPara(scala, roundingMode);
        return customMultiply(source, nums);
    }

    /**
     * Multiply Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:02
     * @version 1.0
     * @mdate 2022/10/19 15:02
     * @since 1.0
     */
    public static BigDecimal customMultiplyAll(@This BigDecimal source, List<BigDecimal> nums) {
        initPara();
        return customMultiply(source, nums);
    }

    /**
     * Multiply Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:03
     * @version 1.0
     * @mdate 2022/10/19 15:03
     * @since 1.0
     */
    public static BigDecimal customMultiplyAll(@This BigDecimal source, int scala, int roundingMode, List<BigDecimal> nums) {
        initPara(scala, roundingMode);
        return customMultiply(source, nums);
    }

    //endregion

    //region 除法

    /**
     * Divide Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:03
     * @version 1.0
     * @mdate 2022/10/19 15:03
     * @since 1.0
     */
    public static BigDecimal customDivideAll(@This BigDecimal source, BigDecimal... nums) {
        initPara();
        return customDivide(source, nums);
    }

    /**
     * Divide Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:03
     * @version 1.0
     * @mdate 2022/10/19 15:03
     * @since 1.0
     */
    public static BigDecimal customDivideAll(@This BigDecimal source, int scala, int roundingMode, BigDecimal... nums) {
        initPara(scala, roundingMode);
        return customDivide(source, nums);
    }

    /**
     * Divide Number Re bigDecimal
     *
     * @param source
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:03
     * @version 1.0
     * @mdate 2022/10/19 15:03
     * @since 1.0
     */
    public static BigDecimal customDivideAll(@This BigDecimal source, List<BigDecimal> nums) {
        initPara();
        return customDivide(source, nums);
    }

    /**
     * Divide Number Re bigDecimal
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @param nums
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/10/19 15:03
     * @version 1.0
     * @mdate 2022/10/19 15:03
     * @since 1.0
     */
    public static BigDecimal customDivideAll(@This BigDecimal source, int scala, int roundingMode, List<BigDecimal> nums) {
        initPara(scala, roundingMode);
        return customDivide(source, nums);
    }

    //endregion

    //endregion
}
