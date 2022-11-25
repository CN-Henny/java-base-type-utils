package extensions.java.lang.Double;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Double Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
 *
 * @author Henny
 * @since 2022/8/8 16:17
 */
@Extension
public class DoubleExtension {
    final static short maxShort = 32767;

    final static int maxInteger = 0x7fffffff;

    final static long maxLong = 0x7fffffffffffffffL;

    final static float maxFloat = 0x1.fffffeP+127f;

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
    private static void isNullException(Double source) {
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
    private static void isInteger(Double source) {
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
    private static void isMax(Double source, String max) {
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
            case "Float": {
                if (source > maxFloat) {
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
    private static void compareDecimalsLengthToEnter(Double source, Integer decimalsLength) {
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
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Boolean customIsNull(@This Double source) {
        return source == null;
    }

    /**
     * If source Is Not Null Re true Else Re false
     * Null Range : Null
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This Double source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:30
     * @version 1.0
     * @mdate 2022/8/8 13:30
     * @since 1.0
     */
    public static Double customIsNotNull(@This Double source, Double errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    /**
     * If source Is Zero Re true Else Re false
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Boolean customIsZero(@This Double source) {
        return source.customIsNull() ? false : source == 0 ? true : false;
    }

    /**
     * If source Is Not Zero Re true Else Re false
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Boolean customIsNotZero(@This Double source) {
        return !source.customIsZero();
    }

    /**
     * If source Is Not Zero Re source Exception Re errorBack
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:34
     * @version 1.0
     * @mdate 2022/8/8 13:34
     * @since 1.0
     */
    public static Double customIsNotZero(@This Double source, Double errorBack) {
        return !source.customIsZero() ? source : errorBack;
    }

    /**
     * source Judge Positive And Negative Numbers
     * If source=0 Re 0
     * If source>0 Re 1
     * If source<0 Re -1
     *
     * @param source 源数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:47
     * @version 1.0
     * @mdate 2022/8/8 15:47
     * @since 1.0
     */
    public static Integer customIsSign(@This Double source) {
        isNullException(source);
        return source > 0 ? 1 : source == 0 ? 0 : -1;
    }

    /**
     * 判断正负数如果异常则返回errorback
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/11/14 17:54
     * @version 1.0
     * @mdate 2022/11/14 17:54
     * @since 1.0
     */
    public static Integer customIsSign(@This Double source, Integer errorBack) {
        try {
            return source > 0 ? 1 : source == 0 ? 0 : -1;
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion

    //region 功能型

    /**
     * source Equal condition If Identical Re true Else Re false
     *
     * @param source    源数据
     * @param condition 比较数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:15
     * @version 1.1
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Boolean customEqual(@This Double source, Double condition) {
        isNullException(source);
        return source.equals(condition);
    }

    //TODO 比较需不需要区分类型

    /**
     * source Equal condition If Identical Re true Else Re false Exception Re errorBack
     *
     * @param source    源数据
     * @param condition 比较数据
     * @param errorBack 错误返回
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:15
     * @version 1.1
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Boolean customEqual(@This Double source, Double condition, Boolean errorBack) {
        try {
            return source.equals(condition);
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
     * @param source    源数据
     * @param condition 比较数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:15
     * @version 1.1
     * @mdate 2022/8/9 10:15
     * @since 1.0
     */
    public static Integer customCompareTo(@This Double source, Double condition) {
        isNullException(source);
        isNullException(condition);
        return source.compareTo(condition);
    }

    /**
     * source Compare To condition Exception Re errorBack
     *
     * @param source    源数据
     * @param condition 比较数据
     * @param errorBack 错误返回
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/19 18:29
     * @version 1.1
     * @mdate 2022/10/19 18:29
     * @since 1.0
     */
    public static Integer customCompareTo(@This Double source, Double condition, Integer errorBack) {
        try {
            return source.compareTo(condition);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * source ABS
     *
     * @param source 源数据
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:16
     * @version 1.0
     * @mdate 2022/8/9 10:16
     * @since 1.0
     */
    public static Double customAbs(@This Double source) {
        isNullException(source);
        return source > 0 ? source : -source;
    }

    /**
     * Double Decimals Length Re length
     * eg: 100.01001  Re 5
     *
     * @param source 源数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:25
     * @version 1.1
     * @mdate 2022/8/9 10:25
     * @since 1.0
     */
    public static Integer customDecimalsLength(@This Double source) {
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
                throw new NullPointerException("com.dlanqi:base-type-utils Error : Un Know Exception 有可能传入的值不时Double");
            }
        }
    }

    /**
     * Double Decimals Length Re length Exception Re errorBack
     * eg: 100.01001  Re 5
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:26
     * @version 1.0
     * @mdate 2022/8/9 10:26
     * @since 1.0
     */
    public static Integer customDecimalsLength(@This Double source, Integer errorBack) {
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
     * @param source 源数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:26
     * @version 1.1
     * @mdate 2022/8/9 10:26
     * @since 1.0
     */
    public static Integer customIntegerLength(@This Double source) {
        isNullException(source);
        String[] doubleArray = source.toString().split("\\.");
        switch (doubleArray.length) {
            case 1:
            case 2: {
                return doubleArray[0].length();
            }
            default: {
                //TODO 异常
                throw new NullPointerException("com.dlanqi:base-type-utils Error : Un Know Exception 有可能传入的值不时Double");
            }
        }
    }

    /**
     * Double Integer Length Re length Exception Re errorBack
     * eg: 100.01001  Re 3
     *
     * @param source    源数据
     * @param errorBack 错误返回
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:27
     * @version 1.0
     * @mdate 2022/8/9 10:27
     * @since 1.0
     */
    public static Integer customIntegerLength(@This Double source, Integer errorBack) {
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
     * eg: decimalsLength=1 1.55->1.6
     * eg: decimalsLength=2 1.555->1.56
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundHalfUp(@This Double source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Contain Five
     * eg: decimalsLength=1 1.55->1.6
     * eg: decimalsLength=2 1.555->1.56
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @param errorBack      错误返回
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundHalfUp(@This Double source, Integer decimalsLength, Double errorBack) {
        try {
            return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * According To decimalsLength Rounding Re double
     * Not Contain Five
     * eg: decimalsLength=1 1.55->1.5
     * eg: decimalsLength=2 1.555->1.55
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundHalfDown(@This Double source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Not Contain Five
     * eg: decimalsLength=1 1.55->1.5
     * eg: decimalsLength=2 1.555->1.55
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @param errorBack      错误返回
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundHalfDown(@This Double source, Integer decimalsLength, Double errorBack) {
        try {
            return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_HALF_DOWN).doubleValue();
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
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundDown(@This Double source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Discard
     * eg: decimalsLength=0 1.5->1      1.9->1
     * eg: decimalsLength=1 1.55->1.5   1.56->1.5
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @param errorBack      错误返回
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundDown(@This Double source, Integer decimalsLength, Double errorBack) {
        try {
            return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_DOWN).doubleValue();
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
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundUp(@This Double source, Integer decimalsLength) {
        isNullException(source);
        compareDecimalsLengthToEnter(source, decimalsLength);
        return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_UP).doubleValue();
    }

    /**
     * According To decimalsLength Rounding Re double Exception Re errorBack
     * Enter
     * eg: decimalsLength=0 1.5->1      1.1->2
     * eg: decimalsLength=1 1.55->1.5   1.56->1.5
     *
     * @param source         源数据
     * @param decimalsLength 截取位数
     * @param errorBack      错误返回
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/9 10:44
     * @version 1.1
     * @mdate 2022/8/9 10:44
     * @since 1.0
     */
    public static Double customRoundUp(@This Double source, Integer decimalsLength, Double errorBack) {
        try {
            return new BigDecimal(source).customRoundHalf(decimalsLength, BigDecimal.ROUND_UP).doubleValue();
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
     * @version 1.1
     * @mdate 2022/8/9 13:41
     * @since 1.0
     */
    public static String customNousedF_E(@This Double source) {
        isNullException(source);
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return nf.format(source);
    }

    public static Double customGetValue(@This Double source, Double errorBack) {
        return source.customIsNull() ? errorBack : source;
    }

    public static Double customGetValue(@This Double source) {
        return source.customIsNull() ? 0 : source;
    }

    //endregion

    //region   转换型

    /**
     * Double To Byte Re byte
     *
     * @param source
     * @return java.lang.Byte
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:05
     * @version 1.0
     * @mdate 2022/8/8 15:05
     * @since 1.0
     */
    public static Byte customToByte(@This Double source) {
        isNullException(source);
        return (byte) source.intValue();
    }

    /**
     * Double To Byte Re byte Exception Re errorBack
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
    public static Byte customToByte(@This Double source, Byte errorBack) {
        try {
            return (byte) source.intValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Double To Float Re float
     *
     * @param source
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:28
     * @version 1.0
     * @mdate 2022/8/8 15:28
     * @since 1.0
     */
    public static Float customToFloat(@This Double source) {
        isNullException(source);
        isMax(source, "Float");
        return source.floatValue();
    }

    /**
     * Double To Float Re float Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:28
     * @version 1.0
     * @mdate 2022/8/8 15:28
     * @since 1.0
     */
    public static Float customToFloat(@This Double source, Float errorBack) {
        try {
            return source.floatValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Double To Integer Re integer
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:32
     * @version 1.0
     * @mdate 2022/8/8 15:32
     * @since 1.0
     */
    public static Integer customToInteger(@This Double source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Integer");
        return source.intValue();
    }

    /**
     * Double To Integer Re integer Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:32
     * @version 1.0
     * @mdate 2022/8/8 15:32
     * @since 1.0
     */
    public static Integer customToInteger(@This Double source, Integer errorBack) {
        try {
            return source.intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Double To Long Re long
     *
     * @param source
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:10
     * @version 1.0
     * @mdate 2022/8/8 15:10
     * @since 1.0
     */
    public static Long customToLong(@This Double source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Long");
        return source.longValue();
    }

    /**
     * Double To Double Re double Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:28
     * @version 1.0
     * @mdate 2022/8/8 15:28
     * @since 1.0
     */
    public static Long customToLong(@This Double source, Long errorBack) {
        try {
            return source.longValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Double To Short Re short
     *
     * @param source
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:33
     * @version 1.0
     * @mdate 2022/8/8 15:33
     * @since 1.0
     */
    public static Short customToShort(@This Double source) {
        isNullException(source);
        isInteger(source);
        isMax(source, "Short");
        return source.shortValue();
    }

    /**
     * Double To Short Re short Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:33
     * @version 1.0
     * @mdate 2022/8/8 15:33
     * @since 1.0
     */
    public static Short customToShort(@This Double source, Short errorBack) {
        try {
            return source.shortValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Double To String Re string
     *
     * @param source
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:35
     * @version 1.0
     * @mdate 2022/8/8 15:35
     * @since 1.0
     */
    public static String customToString(@This Double source) {
        isNullException(source);
        return source.toString();
    }

    /**
     * Double To String Re string Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:35
     * @version 1.0
     * @mdate 2022/8/8 15:35
     * @since 1.0
     */
    public static String customToString(@This Double source, String errorBack) {
        try {
            return source.toString();
        } catch (Exception ex) {
            //TODO 警告
            return errorBack;
        }
    }

    /**
     * Double To BigDecimal Re bigDecimal
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:36
     * @version 1.0
     * @mdate 2022/8/8 15:36
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Double source) {
        isNullException(source);
        return new BigDecimal(source.toString());
    }

    /**
     * Double To BigDecimal Re bigDecimal Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:36
     * @version 1.0
     * @mdate 2022/8/8 15:36
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This Double source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source.toString());
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion

    //region  计算型

    //region  加法

    public static List<BigDecimal> customSumAll(Double... nums) {
        nums.customToList().customToBigDecimalList(e -> e.customToBigDecimal());
        return null;
    }


    //endregion

    //endregion
}
