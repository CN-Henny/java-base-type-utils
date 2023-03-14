package extensions.java.math.BigDecimal;

import com.Const.java.math.Bigdecimal.CustomConstBigDecmial;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.Arrays;
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
    private static int scala = 2;

    /**
     * 默认舍入模式为 BigDecimal.ROUND_CEILING
     */
    private static int roundingMode = BigDecimal.ROUND_HALF_UP;

    private static void initPara() {
        BigDecimalExtension.scala = 2;
        BigDecimalExtension.roundingMode = BigDecimal.ROUND_HALF_UP;
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

    private static void isNullWarning(BigDecimal source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            System.out.println("com.dlanqi:base-type-utils Warning : source is zero ");
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
     * 四舍五入
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/1/13 16:39
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/13 16:39
     * @since 1.0
     */
    public static BigDecimal customRound(@This BigDecimal source) {
        initPara();
        return of(source);
    }

    /**
     * 四舍五入
     *
     * @param source
     * @param scala
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/11/8 10:51
     * @version 1.1
     * @mdate 2022/11/8 10:51
     * @since 1.0
     */
    public static BigDecimal customRound(@This BigDecimal source, int scala) {
        initPara(scala);
        return of(source);
    }

    /**
     * 四舍五入
     *
     * @param source
     * @param scala
     * @param roundingMode
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/11/10 10:50
     * @version 1.1
     * @mdate 2022/11/10 10:50
     * @since 1.0
     */
    public static BigDecimal customRound(@This BigDecimal source, int scala, int roundingMode) {
        initPara(scala, roundingMode);
        return of(source);
    }

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

    /**
     * 永远获取一个合法的bigdecmial
     *
     * @param source
     * @param errorBack
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:16
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:16
     * @since 1.0
     */
    public static BigDecimal customGetValue(@This BigDecimal source, BigDecimal errorBack) {
        return source.customIsNull() ? errorBack : source;
    }

    /**
     * 永远获取一个合法的bigdecmial
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:17
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:17
     * @since 1.0
     */
    public static BigDecimal customGetValue(@This BigDecimal source) {
        return source.customIsNull() ? new BigDecimal(0) : source;
    }

    /**
     * source 大于  target   返回true    否则返回false
     *
     * @param source
     * @param target
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:19
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:19
     * @since 1.0
     */
    public static Boolean customGreater(@This BigDecimal source, BigDecimal target) {
        isNullException(source);
        isNullException(target);
        return source.compareTo(target) > 0;
    }

    /**
     * source 大于等于  target   返回true    否则返回false
     *
     * @param source
     * @param target
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:20
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:20
     * @since 1.0
     */
    public static Boolean customGreaterAndEqual(@This BigDecimal source, BigDecimal target) {
        isNullException(source);
        isNullException(target);
        return target.compareTo(source) < 0;
    }

    /**
     * source 小于  target   返回true    否则返回false
     *
     * @param source
     * @param target
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:20
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:20
     * @since 1.0
     */
    public static Boolean customSmaller(@This BigDecimal source, BigDecimal target) {
        isNullException(source);
        isNullException(target);
        return source.compareTo(target) < 0;
    }

    /**
     * source 小于等于  target   返回true    否则返回false
     *
     * @param source
     * @param target
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2023/1/18 12:20
     * @version 1.0
     * @muser Henny
     * @mdate 2023/1/18 12:20
     * @since 1.0
     */
    public static Boolean customSmallerAndEqual(@This BigDecimal source, BigDecimal target) {
        isNullException(source);
        isNullException(target);
        return target.compareTo(source) > 0;
    }

    /**
     * 元转万元
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 14:18
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:18
     * @since 2.1.37
     */
    @Deprecated
    public static BigDecimal customConvertToTenThousand(@This BigDecimal source) {
        isNullException(source);
        return source.customDivideAll(CustomConstBigDecmial.TenThousand);
    }

    /**
     * 万元转元
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 14:26
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:26
     * @since 2.1.37
     */
    @Deprecated
    public static BigDecimal customConvertFromTenThousand(@This BigDecimal source) {
        isNullException(source);
        return source.customSubtractAll(CustomConstBigDecmial.TenThousand);
    }

    /**
     * 元转万元
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 14:18
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:18
     * @since 2.1.39
     */
    public static BigDecimal customDivideTenThousand(@This BigDecimal source) {
        isNullException(source);
        return source.customDivideAll(CustomConstBigDecmial.TenThousand);
    }

    /**
     * 万元转元
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 14:26
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 14:26
     * @since 2.1.39
     */
    public static BigDecimal customSubtractTenThousand(@This BigDecimal source) {
        isNullException(source);
        return source.customSubtractAll(CustomConstBigDecmial.TenThousand);
    }

    /**
     * 乘100
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 15:11
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 15:11
     * @since 2.1.37
     */
    public static BigDecimal customMultiplyOneHundred(@This BigDecimal source) {
        isNullException(source);
        return source.customToDouble().customPercentage().customToBigDecimal();
    }

    /**
     * 除100
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2023/2/22 15:11
     * @version 1.0
     * @muser Henny
     * @mdate 2023/2/22 15:11
     * @since 2.1.37
     */
    public static BigDecimal customDivideOneHundred(@This BigDecimal source) {
        isNullException(source);
        return source.customToDouble().customUnPercentage().customToBigDecimal();
    }

    //endregion

    //region   转换型

    public static Double customToDouble(@This BigDecimal source) {
        isNullException(source);
        return source.doubleValue();
    }

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
     * @version 1.1
     * @muser Henny
     * @mdate 2022/11/17 16:40
     * @since 1.0
     */
    private static BigDecimal customSum(BigDecimal source, BigDecimal... nums) {
        return customSum(source, Arrays.asList(nums));
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
        //如果传进来一个空list则直接返回source
        if (nums.customIsNotNull()) {
            for (BigDecimal item : nums) {
                isNullWarning(item);
                //加法如果是list null则当成加了一个0
                bigDecimal = bigDecimal.add(item.customGetValue());
            }
            return bigDecimal;
        } else {
            return source;
        }
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
     * @version 1.1
     * @muser Henny
     * @mdate 2022/11/17 16:40
     * @since 1.0
     */
    private static BigDecimal customSubtract(BigDecimal source, BigDecimal... nums) {
        return customSubtract(source, Arrays.asList(nums));
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
        //如果传进来一个空list则直接返回source
        if (nums.customIsNotNull()) {
            for (BigDecimal item : nums) {
                isNullWarning(item);
                //加法如果是list null则当成减了一个0
                bigDecimal = bigDecimal.subtract(item.customGetValue());
            }
            return bigDecimal;
        } else {
            return source;
        }
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
     * @version 1.1
     * @muser Henny
     * @mdate 2022/11/17 16:40
     * @since 1.0
     */
    private static BigDecimal customMultiply(BigDecimal source, BigDecimal... nums) {
        return customMultiply(source, Arrays.asList(nums));
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
        return bigDecimal;
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
     * @version 1.1
     * @muser Henny
     * @mdate 2022/11/17 16:41
     * @since 1.0
     */
    private static BigDecimal customDivide(BigDecimal source, BigDecimal... nums) {
        return customDivide(source, Arrays.asList(nums));
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
            bigDecimal = bigDecimal.divide(item, 12, BigDecimal.ROUND_HALF_UP);
        }
        return bigDecimal;
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
        return of(customSum(source, nums));
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
        return of(customSum(source, nums));
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
        return of(customSubtract(source, nums));
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
        return of(customSubtract(source, nums));
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
        return of(customMultiply(source, nums));
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
        return of(customMultiply(source, nums));
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
        return of(customDivide(source, nums));
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
        return of(customDivide(source, nums));
    }

    //endregion

    //endregion

    //public static BigDecimal plus(@This BigDecimal thiz, BigDecimal that) {
    //    return thiz.add(that);
    //}
}

