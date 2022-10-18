package extensions.java.lang.Long;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Long Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
 *
 * @author Henny
 * @since 2022/8/8 16:07
 */
@Extension
public class LongExtension {

    final static short maxShort = 32767;

    final static int maxInteger = 0x7fffffff;

    /**
     * Null Exception Throw
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:29
     * @version 1.0
     * @mdate 2022/8/8 13:29
     * @since 1.0
     */
    private static void isNullException(Long source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            System.out.println(source + "是空的");
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
     * @cdate 2022/8/8 19:46
     * @version 1.0
     * @mdate 2022/8/8 19:46
     * @since 1.0
     */
    private static void isMax(Long source, String max) {
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
        }
        if (flag) {
            System.out.println("超出长度");
        }
    }

    //region   判断型

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
    public static Boolean customIsNull(@This Long source) {
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
    public static Boolean customIsNotNull(@This Long source) {
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
    public static Long customIsNotNull(@This Long source, Long errorBack) {
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
    public static Boolean customIsZero(@This Long source) {
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
    public static Boolean customIsNotZero(@This Long source) {
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
    public static Long customIsNotZero(@This Long source, Integer errorBack) {
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
    public static Integer customIsSign(@This Long source) {
        isNullException(source);
        return source > 0 ? 1 : source == 0 ? 0 : -1;
    }
    //endregion

    //region 功能型

    //TODO 比较需不需要区分类型

    /**
     * source Equal condition If Identical Re true Else Re false
     *
     * @param source
     * @param condition
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:36
     * @version 1.0
     * @mdate 2022/8/8 13:36
     * @since 1.0
     */
    public static Boolean customEqual(@This Long source, Long condition) {
        isNullException(source);
        return source == condition ? true : false;
    }

    /**
     * source Equal condition If Identical Re true Else Re false Exception Re errorBack
     *
     * @param source
     * @param condition
     * @param errorBack
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:36
     * @version 1.0
     * @mdate 2022/8/8 13:36
     * @since 1.0
     */
    public static Boolean customEqual(@This Long source, Long condition, Boolean errorBack) {
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
     * @cdate 2022/8/8 13:37
     * @version 1.0
     * @mdate 2022/8/8 13:37
     * @since 1.0
     */
    public static Integer customCompareTo(@This Long source, Long condition) {
        isNullException(source);
        isNullException(condition);
        return (source < condition) ? -1 : ((source == condition) ? 0 : 1);
    }

    /**
     * source ABS
     *
     * @param source
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/8 15:52
     * @version 1.0
     * @mdate 2022/8/8 15:52
     * @since 1.0
     */
    public static Long customAbs(@This Long source) {
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
     * @cdate 2022/8/8 13:38
     * @version 1.0
     * @mdate 2022/8/8 13:38
     * @since 1.0
     */
    public static Integer customLength(@This Long source) {
        long p = 10;
        for (int i = 1; i < 19; i++) {
            if (source < p)
                return i;
            p = 10 * p;
        }
        return 19;
    }

    /**
     * Enter source Re Judgment Digits Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/8 13:38
     * @version 1.0
     * @mdate 2022/8/8 13:38
     * @since 1.0
     */
    public static Integer customLength(@This Long source, Integer errorBack) {
        try {
            long p = 10;
            for (int i = 1; i < 19; i++) {
                if (source < p)
                    return i;
                p = 10 * p;
            }
            return 19;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Long To Date And Format Re formatStr
     *
     * @param source
     * @param formatStr
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/9 14:43
     * @version 1.0
     * @mdate 2022/8/9 14:43
     * @since 1.0
     */
    public static String customToDateFormat(@This Long source, String formatStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        return simpleDateFormat.format(source.customToDate());
    }

    /**
     * Long To Date And Format Re formatStr Exception Re errorBack
     *
     * @param source
     * @param formatStr
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/9 14:46
     * @version 1.0
     * @mdate 2022/8/9 14:46
     * @since 1.0
     */
    public static String customToDateFormat(@This Long source, String formatStr, String errorBack) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            return simpleDateFormat.format(source.customToDate());
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Sum Number Re long
     *
     * @param source
     * @param nums
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:51
     * @version 1.0
     * @mdate 2022/10/18 15:51
     * @since 1.0
     */
    public static Long customSumAll(@This Long source, Long... nums) {
        for (Long item : nums) {
            source = source + item;
        }
        return source;
    }

    /**
     * Sum Number Re long Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @param nums
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:51
     * @version 1.0
     * @mdate 2022/10/18 15:51
     * @since 1.0
     */
    public static Long customSumAll(@This Long source, Long errorBack, Long... nums) {
        try {
            return source.customSumAll(nums);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    //endregion

    //region   转换型

    /**
     * Long To Byte Re byte
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
    public static Byte customToByte(@This Long source) {
        isNullException(source);
        return (byte) source.intValue();
    }

    /**
     * Long To Byte Re byte Exception Re errorBack
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
    public static Byte customToByte(@This Long source, Byte errorBack) {
        try {
            return (byte) source.intValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Long To Double Re double
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
    public static Double customToDouble(@This Long source) {
        isNullException(source);
        return source.doubleValue();
    }

    /**
     * Long To Double Re double Exception Re errorBack
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
    public static Double customToDouble(@This Long source, Double errorBack) {
        try {
            return source.doubleValue();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Long To Float Re float
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
    public static Float customToFloat(@This Long source) {
        isNullException(source);
        return source.floatValue();
    }

    /**
     * Long To Float Re float Exception Re errorBack
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
    public static Float customToFloat(@This Long source, Float errorBack) {
        try {
            return source.floatValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Long To Integer Re integer
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
    public static Integer customToInteger(@This Long source) {
        isNullException(source);
        isMax(source, "Integer");
        return source.intValue();
    }

    /**
     * Long To Integer Re integer Exception Re errorBack
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
    public static Integer customToInteger(@This Long source, Integer errorBack) {
        try {
            return source.intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Long To Short Re short
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
    public static Short customToShort(@This Long source) {
        isNullException(source);
        isMax(source, "Short");
        return source.shortValue();
    }

    /**
     * Long To Short Re short Exception Re errorBack
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
    public static Short customToShort(@This Long source, Short errorBack) {
        try {
            return source.shortValue();
        } catch (Exception ex) {
            ex.printStackTrace();
            return errorBack;
        }
    }

    /**
     * Long To String Re string
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
    public static String customToString(@This Long source) {
        isNullException(source);
        return source.toString();
    }

    /**
     * Long To String Re string Exception Re errorBack
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
    public static String customToString(@This Long source, String errorBack) {
        try {
            return source.toString();
        } catch (Exception ex) {
            //TODO 警告
            return errorBack;
        }
    }

    /**
     * Long To BigDecimal Re bigDecimal
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
    public static BigDecimal customToBigDecimal(@This Long source) {
        isNullException(source);
        return new BigDecimal(source.toString());
    }

    /**
     * Long To BigDecimal Re bigDecimal Exception Re errorBack
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
    public static BigDecimal customToBigDecimal(@This Long source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source.toString());
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * Long To Date Re date
     *
     * @param source
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/8/9 14:47
     * @version 1.0
     * @mdate 2022/8/9 14:47
     * @since 1.0
     */
    public static Date customToDate(@This Long source) {
        return new Date(source);
    }

    /**
     * Long To Date Re date Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/8/9 14:48
     * @version 1.0
     * @mdate 2022/8/9 14:48
     * @since 1.0
     */
    public static Date customToDate(@This Long source, Date errorBack) {
        try {
            return new Date(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion
}