package extensions.java.lang.Double;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

/**
 * Double Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
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
        if (source.isNull()) {
            //TODO 增加异常返回

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
    public static Boolean isNull(@This Double source) {
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
    public static Boolean isNotNull(@This Double source) {
        return !source.isNull();
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
    public static Double isNotNull(@This Double source, Double errorBack) {
        return source.isNotNull() ? source : errorBack;
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
    public static Boolean isZero(@This Double source) {
        return source.isNull() ? false : source == 0 ? true : false;
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
    public static Boolean isNotZero(@This Double source) {
        return !source.isZero();
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
    public static Double isNotZero(@This Double source, Double errorBack) {
        return !source.isZero() ? source : errorBack;
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
    public static Integer isSign(@This Double source) {
        isNullException(source);
        return source > 0 ? 1 : source == 0 ? 0 : -1;
    }
    //endregion

    //region 功能型

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
    public static Byte toByte(@This Double source) {
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
    public static Byte toByte(@This Double source, Byte errorBack) {
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
    public static Float toFloat(@This Double source) {
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
    public static Float toFloat(@This Double source, Float errorBack) {
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
    public static Integer toInteger(@This Double source) {
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
    public static Integer toInteger(@This Double source, Integer errorBack) {
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
    public static Long toLong(@This Double source) {
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
    public static Long toLong(@This Double source, Long errorBack) {
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
    public static Short toShort(@This Double source) {
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
    public static Short toShort(@This Double source, Short errorBack) {
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
    public static String toString(@This Double source) {
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
    public static String toString(@This Double source, String errorBack) {
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
    public static BigDecimal toBigDecimal(@This Double source) {
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
    public static BigDecimal toBigDecimal(@This Double source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source.toString());
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion
}
