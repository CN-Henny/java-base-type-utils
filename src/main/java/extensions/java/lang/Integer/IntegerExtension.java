package extensions.java.lang.Integer;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Integer Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
 *
 * @author Henny
 * @since 2022/7/28 15:42
 */

@Extension
public class IntegerExtension {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    final static short maxShort = 32767;

    /**
     * Null Exception Throw
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:25
     * @version 1.0
     * @mdate 2022/8/5 13:25
     * @since 1.0
     */
    private static void isNullException(Integer source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回

        }
    }

    /**
     * 判断转换是否超出最大值
     *
     * @param source
     * @param max
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/8 19:45
     * @version 1.0
     * @mdate 2022/8/8 19:45
     * @since 1.0
     */
    private static void isMax(Integer source, String max) {
        boolean flag = false;
        switch (max) {
            case "Short": {
                if (source > maxShort) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
        }
        if (flag) {
            System.out.println("超出长度");
        }
    }

    //region 判断型

    /**
     * If source Is Null Re true Else Re false
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
    public static Boolean customIsNull(@This Integer source) {
        return source == null ? true : false;
    }

    /**
     * If source Is Not Null Re true Else Re false
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
    public static Boolean customIsNotNull(@This Integer source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:27
     * @version 1.0
     * @mdate 2022/8/5 13:27
     * @since 1.0
     */
    public static Integer customIsNotNull(@This Integer source, Integer errorBack) {
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
    public static Boolean customIsZero(@This Integer source) {
        return source.customIsNull() ? false : source == 0 ? true : false;
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
    public static Boolean customIsNotZero(@This Integer source) {
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
    public static Integer customIsNotZero(@This Integer source, Integer errorBack) {
        return !source.customIsZero() ? source : errorBack;
    }

    /**
     * source Judge Positive And Negative Numbers
     * If source=0 Re 0
     * If source>0 Re 1
     * If source<0 Re -1
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:47
     * @version 1.0
     * @mdate 2022/8/8 15:47
     * @since 1.0
     */
    public static Integer customIsSign(@This Integer source) {
        isNullException(source);
        return source > 0 ? 1 : source == 0 ? 0 : -1;
    }
    //endregion

    //region 功能型

    /**
     * source Equal condition If Identical Re true Else Re false
     *
     * @param source
     * @param condition
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:27
     * @version 1.0
     * @mdate 2022/8/5 13:27
     * @since 1.0
     */
    public static Boolean customEqual(@This Integer source, Integer condition) {
        isNullException(source);
        return source == condition ? true : false;
    }

    //TODO 比较需不需要区分类型

    /**
     * source Equal condition If Identical Re true Else Re false Exception Re errorBack
     *
     * @param source
     * @param condition
     * @param errorBack
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:27
     * @version 1.0
     * @mdate 2022/8/5 13:27
     * @since 1.0
     */
    public static Boolean customEqual(@This Integer source, Integer condition, Boolean errorBack) {
        try {
            return source == condition ? true : false;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * source Compare To condition
     * If source=condition Re 0
     * If source>condition Re 1
     * If source<condition Re -1
     *
     * @param source
     * @param condition
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Integer customCompareTo(@This Integer source, Integer condition) {
        isNullException(source);
        isNullException(condition);
        return (source < condition) ? -1 : ((source == condition) ? 0 : 1);
    }

    /**
     * source ABS
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:47
     * @version 1.0
     * @mdate 2022/8/8 15:47
     * @since 1.0
     */
    public static Integer customAbs(@This Integer source) {
        isNullException(source);
        return source > 0 ? source : -source;
    }

    /**
     * Enter source Re Judgment Digits
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Integer customLength(@This Integer source) {
        isNullException(source);
        for (int i = 0; ; i++)
            if (source <= sizeTable[i])
                return i + 1;
    }

    /**
     * Enter source Re Judgment Digits Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Integer customLength(@This Integer source, Integer errorBack) {
        try {
            for (int i = 0; ; i++)
                if (source <= sizeTable[i])
                    return i + 1;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * 左补位0.传入补0个数
     *
     * @param source
     * @param zeroNumber
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/18 14:18
     * @version 1.0
     * @mdate 2022/10/18 14:18
     * @since 1.0
     */
    public static String customLeftFillZero(@This Integer source, int zeroNumber) {
        String result = "";
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(source);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(source);
        result = nf.format(zeroNumber);
        return result;
    }

    /**
     * Sum Number Re integer
     *
     * @param source
     * @param nums
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:51
     * @version 1.0
     * @mdate 2022/10/18 15:51
     * @since 1.0
     */
    public static Integer customSumAll(@This Integer source, Integer... nums) {
        for (Integer item : nums) {
            source = source + item;
        }
        return source;
    }

    /**
     * Sum Number Re integer Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @param nums
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:50
     * @version 1.0
     * @mdate 2022/10/18 15:50
     * @since 1.0
     */
    public static Integer customSumAll(@This Integer source, Integer errorBack, Integer... nums) {
        try {
            return source.customSumAll(nums);
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion

    //region 转换型

    /**
     * Integer To Byte Re byte
     *
     * @param source
     * @return java.lang.Byte
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Byte customToByte(@This Integer source) {
        isNullException(source);
        return (byte) source.intValue();
    }

    /**
     * Integer To Byte Re byte Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Byte
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Byte customToByte(@This Integer source, Byte errorBack) {
        try {
            return (byte) source.intValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Integer To Double Re double
     *
     * @param source
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:28
     * @version 1.0
     * @mdate 2022/8/5 13:28
     * @since 1.0
     */
    public static Double customToDouble(@This Integer source) {
        isNullException(source);
        return source.doubleValue();
    }

    /**
     * Integer To Double Re double Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:29
     * @version 1.0
     * @mdate 2022/8/5 13:29
     * @since 1.0
     */
    public static Double customToDouble(@This Integer source, Double errorBack) {
        try {
            return source.doubleValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Integer To Float Re float
     *
     * @param source
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:29
     * @version 1.0
     * @mdate 2022/8/5 13:29
     * @since 1.0
     */
    public static Float customToFloat(@This Integer source) {
        isNullException(source);
        return source.floatValue();
    }

    /**
     * Integer To Float Re float Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:29
     * @version 1.0
     * @mdate 2022/8/5 13:29
     * @since 1.0
     */
    public static Float customToFloat(@This Integer source, Float errorBack) {
        try {
            return source.floatValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Integer To Long Re long
     *
     * @param source
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:29
     * @version 1.0
     * @mdate 2022/8/5 13:29
     * @since 1.0
     */
    public static Long customToLong(@This Integer source) {
        isNullException(source);
        return source.longValue();
    }

    /**
     * Integer To Long Re long Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:29
     * @version 1.0
     * @mdate 2022/8/5 13:29
     * @since 1.0
     */
    public static Long customToLong(@This Integer source, Long errorBack) {
        try {
            return source.longValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Integer To Short Re short
     *
     * @param source
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static Short customToShort(@This Integer source) {
        isNullException(source);
        isMax(source, "Short");
        return source.shortValue();
    }

    /**
     * Integer To Short Re short Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static Short customToShort(@This Integer source, Short errorBack) {
        try {
            return source.shortValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Integer To String Re string
     *
     * @param source
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static String customToString(@This Integer source) {
        isNullException(source);
        return source.toString();
    }

    /**
     * Integer To String Re string Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static String customToString(@This Integer source, String errorBack) {
        try {
            return source.toString();
        } catch (Exception ex) {
            //TODO 警告
            return errorBack;
        }
    }

    /**
     * Integer To BigDecimal Re bigDecimal
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Integer source) {
        isNullException(source);
        return new BigDecimal(source.toString());
    }

    /**
     * Integer To BigDecimal Re bigDecimal Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:30
     * @version 1.0
     * @mdate 2022/8/5 13:30
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Integer source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source.toString());
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion
}