package extensions.java.lang.Float;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

/**
 * Float Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
 *
 * @author Henny
 * @since 2022/8/10 10:18
 */
@Extension
public class FloatExtension {

    final static short maxShort = 32767;

    final static int maxInteger = 0x7fffffff;

    final static long maxLong = 0x7fffffffffffffffL;

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
    private static void isNullException(Float source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            throw new NullPointerException("com.dlanqi:base-type-utils Error : source is null");
        }
    }

    /**
     * 判断小数点后是否没有值
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/8 19:46
     * @version 1.0
     * @mdate 2022/8/8 19:46
     * @since 1.0
     */
    private static void isInteger(Float source) {
        double eps = 1e-10;
        boolean isInteger = source - Math.floor(source) < eps;
        if (!isInteger) {
            System.out.println("有小数位。将丢失小数后内容");
            throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is a float");
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
    private static void isMax(Float source, String max) {
        boolean flag = false;
        switch (max) {
            case "Short": {
                if (source > maxShort) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
            case "Integer": {
                if (source > maxInteger) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
            case "Long": {
                if (source > maxLong) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
        }
        if (flag) {
            System.out.println("超出长度");
            throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is too long");
        }
    }

    /**
     * 比较截取位数和源小数位数
     *
     * @param source
     * @param decimalsLength
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/9 13:46
     * @version 1.0
     * @mdate 2022/8/9 13:46
     * @since 1.0
     */
    private static void compareDecimalsLengthToEnter(Float source, Integer decimalsLength) {
        Integer sourceDecimalsLength = source.customDecimalsLength();
        if (decimalsLength > sourceDecimalsLength) {
            //TODO 提示截取位数不够
            System.out.println("源数据小数位不够");
            throw new NumberFormatException("com.dlanqi:base-type-utils Error : source decimals is too short");
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
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Boolean customIsNull(@This Float source) {
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
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This Float source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Double customIsNotNull(@This Float source, Double errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    /**
     * If source Is Zero Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Boolean customIsZero(@This Float source) {
        return source.customIsNull() ? false : source == 0 ? true : false;
    }

    /**
     * If source Is Not Zero Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Boolean customIsNotZero(@This Float source) {
        return !source.customIsZero();
    }

    /**
     * If source Is Not Zero Re source Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Double customIsNotZero(@This Float source, Double errorBack) {
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
    public static Integer customIsSign(@This Float source) {
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
     * @cdate 2022/8/9 10:15
     * @version 1.0
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Boolean customEqual(@This Float source, Float condition) {
        isNullException(source);
        return source == condition ? true : false;
    }

    //TODO 比较需不需要区分类型F

    /**
     * source Equal condition If Identical Re true Else Re false Exception Re errorBack
     *
     * @param source
     * @param condition
     * @param errorBack
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:15
     * @version 1.0
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Boolean customEqual(@This Float source, Float condition, Boolean errorBack) {
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
     * @cdate 2022/8/9 10:15
     * @version 1.0
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Integer customCompareTo(@This Float source, Float condition) {
        isNullException(source);
        isNullException(condition);
        return (source < condition) ? -1 : ((source == condition) ? 0 : 1);
    }

    /**
     * source ABS
     *
     * @param source
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:16
     * @version 1.0
     * @mdate 2022/8/9 10:16
     * @since 1.0
     */
    public static Float customAbs(@This Float source) {
        isNullException(source);
        return source > 0 ? source : -source;
    }

    /**
     * Double Decimals Length Re length
     * eg: 100.01001  Re 5
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:25
     * @version 1.0
     * @mdate 2022/8/9 10:25
     * @since 1.0
     */
    public static Integer customDecimalsLength(@This Float source) {
        isNullException(source);
        String[] doubleArray = source.toString().split("\\.");
        switch (doubleArray.length) {
            case 1: {
                return 0;
            }
            case 2: {
                return doubleArray[1].length();
            }
            default: {
                //TODO 异常
                return null;
            }
        }
    }

    /**
     * Double Decimals Length Re length Exception Re errorBack
     * eg: 100.01001  Re 5
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:26
     * @version 1.0
     * @mdate 2022/8/9 10:26
     * @since 1.0
     */
    public static Integer customDecimalsLength(@This Float source, Integer errorBack) {
        try {
            String[] doubleArray = source.toString().split("\\.");
            return doubleArray[1].length();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Double Integer Length Re length
     * eg: 100.01001  Re 3
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:26
     * @version 1.0
     * @mdate 2022/8/9 10:26
     * @since 1.0
     */
    public static Integer customIntegerLength(@This Float source) {
        isNullException(source);
        String[] doubleArray = source.toString().split("\\.");
        switch (doubleArray.length) {
            case 1: {
                return 0;
            }
            case 2: {
                return doubleArray[0].length();
            }
            default: {
                //TODO 异常
                return null;
            }
        }
    }

    /**
     * Double Integer Length Re length Exception Re errorBack
     * eg: 100.01001  Re 3
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:27
     * @version 1.0
     * @mdate 2022/8/9 10:27
     * @since 1.0
     */
    public static Integer customIntegerLength(@This Float source, Integer errorBack) {
        try {
            String[] doubleArray = source.toString().split("\\.");
            return doubleArray[0].length();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * According To decimalsLength Rounding Re double
     * Contain Five
     * eg: decimalsLength=0 1.5->2
     * eg: decimalsLength=1 1.55->1.6
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundHalfUp(@This Float source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).setScale(decimalsLength.customIsNotNull(0), BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Contain Five
     * eg: decimalsLength=0 1.5->2
     * eg: decimalsLength=1 1.55->1.6
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundHalfUp(@This Float source, Integer decimalsLength, Float errorBack) {
        try {
            return new BigDecimal(source).setScale(decimalsLength, BigDecimal.ROUND_HALF_UP).floatValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * According To decimalsLength Rounding Re double
     * Not Contain Five
     * eg: decimalsLength=0 1.5->1
     * eg: decimalsLength=1 1.55->1.5
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundHalfDown(@This Float source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).setScale(decimalsLength.customIsNotNull(0), BigDecimal.ROUND_HALF_DOWN).floatValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Not Contain Five
     * eg: decimalsLength=0 1.5->1
     * eg: decimalsLength=1 1.55->1.5
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundHalfDown(@This Float source, Integer decimalsLength, Float errorBack) {
        try {
            return new BigDecimal(source).setScale(decimalsLength, BigDecimal.ROUND_HALF_DOWN).floatValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * According To decimalsLength Rounding Re double
     * Discard
     * eg: decimalsLength=0 1.5->1
     * eg: decimalsLength=1 1.55->1.5   1.56->1.5
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundDown(@This Float source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).setScale(decimalsLength.customIsNotNull(0), BigDecimal.ROUND_DOWN).floatValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Discard
     * eg: decimalsLength=0 1.5->1      1.9->1
     * eg: decimalsLength=1 1.55->1.5   1.56->1.5
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundDown(@This Float source, Integer decimalsLength, Float errorBack) {
        try {
            return new BigDecimal(source).setScale(decimalsLength, BigDecimal.ROUND_DOWN).floatValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * According To decimalsLength Rounding Re double
     * Enter
     * eg: decimalsLength=0 1.5->2      1.1->2
     * eg: decimalsLength=1 1.55->1.6   1.51->1.6
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundUp(@This Float source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).setScale(decimalsLength.customIsNotNull(0), BigDecimal.ROUND_UP).floatValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Enter
     * eg: decimalsLength=0 1.5->1      1.1->2
     * eg: decimalsLength=1 1.55->1.5   1.56->1.5
     *
     * @param source
     * @param decimalsLength
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.0
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Float customRoundUp(@This Float source, Integer decimalsLength, Float errorBack) {
        try {
            return new BigDecimal(source).setScale(decimalsLength, BigDecimal.ROUND_UP).floatValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * 格式化数据，不使用科学计数法
     *
     * @param source
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/9 13:41
     * @version 1.0
     * @mdate 2022/8/9 13:41
     * @since 1.0
     */
    public static String customNousedF_E(@This Float source) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(source);
    }

    public static Float customGetValue(@This Float source, Float errorBack) {
        return source.customIsNull() ? errorBack : source;
    }

    public static Float customGetValue(@This Float source) {
        return source.customIsNull() ? 0 : source;
    }

    //endregion

    //region   转换型

    /**
     * Float To Byte Re byte
     *
     * @param source
     * @return java.lang.Byte
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:23
     * @version 1.0
     * @mdate 2022/8/10 10:23
     * @since 1.0
     */
    public static Byte customToByte(@This Float source) {
        isNullException(source);
        return (byte) source.intValue();
    }

    /**
     * Float To Byte Re byte Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:05
     * @version 1.0
     * @mdate 2022/8/8 15:05
     * @since 1.0
     */
    public static Byte customToByte(@This Float source, Byte errorBack) {
        try {
            return (byte) source.intValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Float To Double Re double
     *
     * @param source
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:24
     * @version 1.0
     * @mdate 2022/8/10 10:24
     * @since 1.0
     */
    public static Double customToDouble(@This Float source) {
        isNullException(source);
        return source.doubleValue();
    }

    /**
     * Float To Double Re double Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:24
     * @version 1.0
     * @mdate 2022/8/10 10:24
     * @since 1.0
     */
    public static Double customToDouble(@This Float source, Double errorBack) {
        try {
            return source.doubleValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Float To Integer Re integer
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:24
     * @version 1.0
     * @mdate 2022/8/10 10:24
     * @since 1.0
     */
    public static Integer customToInteger(@This Float source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Integer");
        return source.intValue();
    }

    /**
     * Float To Integer Re integer Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:24
     * @version 1.0
     * @mdate 2022/8/10 10:24
     * @since 1.0
     */
    public static Integer customToInteger(@This Float source, Integer errorBack) {
        try {
            return source.intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Float To Long Re long
     *
     * @param source
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:24
     * @version 1.0
     * @mdate 2022/8/10 10:24
     * @since 1.0
     */
    public static Long customToLong(@This Float source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Long");
        return source.longValue();
    }

    /**
     * Float To Double Re double Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static Long customToLong(@This Float source, Long errorBack) {
        try {
            return source.longValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Float To Short Re short
     *
     * @param source
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static Short customToShort(@This Float source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Short");
        return source.shortValue();
    }

    /**
     * Float To Short Re short Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static Short customToShort(@This Float source, Short errorBack) {
        try {
            return source.shortValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Float To String Re string
     *
     * @param source
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static String customToString(@This Float source) {
        isNullException(source);
        return source.toString();
    }

    /**
     * Float To String Re string Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static String customToString(@This Float source, String errorBack) {
        try {
            return source.toString();
        } catch (Exception ex) {
            //TODO 警告
            return errorBack;
        }
    }

    /**
     * Float To BigDecimal Re bigDecimal
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Float source) {
        isNullException(source);
        return new BigDecimal(source.toString());
    }

    /**
     * Float To BigDecimal Re bigDecimal Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/10 10:25
     * @version 1.0
     * @mdate 2022/8/10 10:25
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Float source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source.toString());
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion

    //region  计算型

    /**
     * Sum Number Re float
     *
     * @param source
     * @param nums
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:49
     * @version 1.0
     * @mdate 2022/10/18 15:49
     * @since 1.0
     */
    public static Float customSumAll(@This Float source, Float... nums) {
        for (Float item : nums) {
            source = source + item;
        }
        return source;
    }

    /**
     * Sum Number Re float Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @param nums
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:50
     * @version 1.0
     * @mdate 2022/10/18 15:50
     * @since 1.0
     */
    public static Float customSumAll(@This Float source, Float errorBack, Float... nums) {
        try {
            return source.customSumAll(nums);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    //endregion
}
