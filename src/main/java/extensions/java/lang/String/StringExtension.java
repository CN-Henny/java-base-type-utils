package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Henny
 * @since 2022/8/8 16:06
 */
@Extension
public class StringExtension {

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
    private static void isNullException(String source) {
        if (source.isNull()) {
            //TODO 增加异常返回
            System.out.println(source + "是空的");
        }
    }

    /**
     * Integer Exception
     * Is Not Integer Re False
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:14
     * @version 1.0
     * @mdate 2022/8/6 16:14
     * @since 1.0
     */
    private static void isIntegerException(String source) {
        Character[] chars = source.toCharacterArray();
        for (Character charValue : chars) {
            if (!Character.isDigit(charValue)) {
                //TODO 增加异常返回
                System.out.println(charValue + "不是数字");
            }
        }
    }

    /**
     * Float Exception
     * Is Not Integer And Is Not Float Re False
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:12
     * @version 1.0
     * @mdate 2022/8/6 16:12
     * @since 1.0
     */
    private static void isFloatException(String source) {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (source.indexOf(".") > 0) {//判断是否有小数点
            if (source.indexOf(".") == source.lastIndexOf(".") && source.split("\\.").length == 2) { //判断是否只有一个小数点
                if (!pattern.matcher(source.replace(".", "")).matches()) {
                    //TODO 增加异常返回
                    System.out.println(source + "不是小数");
                }
            } else {
                //TODO 增加异常返回
                System.out.println(source + "包含多个小数点");
            }
        } else {
            if (!pattern.matcher(source).matches()) {
                //TODO 增加异常返回
                System.out.println(source + "不是小数也不是整数");
            }
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
     * @cdate 2022/8/8 19:44
     * @version 1.0
     * @mdate 2022/8/8 19:44
     * @since 1.0
     */
    private static void isMax(String source, String max) {
        Double maxNum = Double.parseDouble(source);
        boolean flag = false;
        switch (max) {
            case "Short": {
                if (maxNum > maxShort) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
            case "Integer": {
                if (maxNum > maxInteger) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
            case "Long": {
                if (maxNum > maxLong) {
                    //TODO 超长提醒
                    flag = true;
                }
                break;
            }
            case "Float": {
                if (maxNum > maxFloat) {
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
    public static Boolean isNull(@This String source) {
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
    public static Boolean isNotNull(@This String source) {
        return !source.isNull();
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
    public static String isNotNull(@This String source, String errorBack) {
        return source.isNotNull() ? source : errorBack;
    }

    /**
     * If source Is Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:54
     * @version 1.0
     * @mdate 2022/8/5 14:54
     * @since 1.0
     */
    public static Boolean isEmpty(@This String source) {
        return source.isNull() ? true : source.equals("") ? true : false;
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:57
     * @version 1.0
     * @mdate 2022/8/5 14:57
     * @since 1.0
     */
    public static Boolean isNotEmpty(@This String source) {
        return !source.isEmpty();
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:09
     * @version 1.0
     * @mdate 2022/8/5 15:09
     * @since 1.0
     */
    public static String isNotEmpty(@This String source, String errorBack) {
        return source.isNotEmpty() ? source : errorBack;
    }

    /**
     * If source Is Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:00
     * @version 1.0
     * @mdate 2022/8/5 15:00
     * @since 1.0
     */
    public static Boolean isBlank(@This String source) {
        int strLen;
        if (source == null || (strLen = source.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(source.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * If source Is Not Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:01
     * @version 1.0
     * @mdate 2022/8/5 15:01
     * @since 1.0
     */
    public static Boolean isNotBlank(@This String source) {
        return !source.isBlank();
    }

    /**
     * If source Is Not Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:10
     * @version 1.0
     * @mdate 2022/8/5 15:10
     * @since 1.0
     */
    public static String isNotBlank(@This String source, String errorBack) {
        return source.isNotBlank() ? source : errorBack;
    }

    /**
     * If source Is Integer Re true Else Re fasle
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:51
     * @version 1.0
     * @mdate 2022/8/6 15:51
     * @since 1.0
     */
    public static Boolean isInteger(@This String source) {
        isNullException(source);
        Character[] chars = source.toCharacterArray();
        for (Character charValue : chars) {
            if (!Character.isDigit(charValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If source Is Integer Re source Else Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static String isInteger(@This String source, String errorBack) {
        return source.isNotInteger() ? source : errorBack;
    }

    /**
     * If source Is Not Integer Re true Else Re fasle
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static Boolean isNotInteger(@This String source) {
        return !source.isInteger();
    }

    /**
     * If source Is Float Re true Else Re fasle
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:51
     * @version 1.0
     * @mdate 2022/8/6 15:51
     * @since 1.0
     */
    public static Boolean isFloat(@This String source) {
        isNullException(source);
        Pattern pattern = Pattern.compile("[0-9]*");
        if (source.indexOf(".") > 0) {//判断是否有小数点
            if (source.indexOf(".") == source.lastIndexOf(".") && source.split("\\.").length == 2) { //判断是否只有一个小数点
                return pattern.matcher(source.replace(".", "")).matches();
            } else {
                return false;
            }
        } else {
            return pattern.matcher(source).matches();
        }
    }

    /**
     * If source Is Float Re source Else Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static String isFloat(@This String source, String errorBack) {
        return source.isNotFloat() ? source : errorBack;
    }

    /**
     * If source Is Not Float Re true Else Re fasle
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static Boolean isNotFloat(@This String source) {
        return !source.isFloat();
    }
    //endregion

    //region 功能型
    //endregion

    //region 转换型

    /**
     * String To Byte[] Re byte[]
     *
     * @param source
     * @return java.lang.Byte[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:56
     * @version 1.0
     * @mdate 2022/8/6 14:56
     * @since 1.0
     */
    public static Byte[] toByteArray(@This String source) {
        isNullException(source);
        byte[] byteArray = source.getBytes();
        Byte[] byteObjects = new Byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            byteObjects[i] = Byte.valueOf(byteArray[i]);
        }
        return byteObjects;
    }

    /**
     * String To Byte[] Re byte[] Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Byte[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:57
     * @version 1.0
     * @mdate 2022/8/6 14:57
     * @since 1.0
     */
    public static Byte[] toByteArray(@This String source, Byte[] errorBack) {
        try {
            byte[] byteArray = source.getBytes();
            Byte[] byteObjects = new Byte[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                byteObjects[i] = Byte.valueOf(byteArray[i]);
            }
            return byteObjects;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Character[] Re character[]
     *
     * @param source
     * @return java.lang.Character[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:58
     * @version 1.0
     * @mdate 2022/8/6 14:58
     * @since 1.0
     */
    public static Character[] toCharacterArray(@This String source) {
        isNullException(source);
        return source.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    }

    /**
     * String To Character[] Re character[] Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Character[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:59
     * @version 1.0
     * @mdate 2022/8/6 14:59
     * @since 1.0
     */
    public static Character[] toCharacterArray(@This String source, Character[] errorBack) {
        try {
            return source.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Double Re double
     *
     * @param source
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:57
     * @version 1.0
     * @mdate 2022/8/6 15:57
     * @since 1.0
     */
    public static Double toDouble(@This String source) {
        isNullException(source);
        isFloatException(source);
        return Double.parseDouble(source);
    }

    /**
     * String To Double Re double Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:57
     * @version 1.0
     * @mdate 2022/8/6 15:57
     * @since 1.0
     */
    public static Double toDouble(@This String source, Double errorBack) {
        try {
            return Double.parseDouble(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Float Re float
     *
     * @param source
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:53
     * @version 1.0
     * @mdate 2022/8/6 16:53
     * @since 1.0
     */
    public static Float toFloat(@This String source) {
        isNullException(source);
        isFloatException(source);
        isMax(source, "Float");
        return Float.parseFloat(source);
    }

    /**
     * String To Float Re float Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:53
     * @version 1.0
     * @mdate 2022/8/6 16:53
     * @since 1.0
     */
    public static Float toFloat(@This String source, Float errorBack) {
        try {
            return Float.parseFloat(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Integer Re integer
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:04
     * @version 1.0
     * @mdate 2022/8/6 17:04
     * @since 1.0
     */
    public static Integer toInteger(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Integer");
        return Integer.parseInt(source);
    }

    /**
     * String To Integer Re integer Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:05
     * @version 1.0
     * @mdate 2022/8/6 17:05
     * @since 1.0
     */
    public static Integer toInteger(@This String source, Integer errorBack) {
        try {
            return Integer.parseInt(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Long Re long
     *
     * @param source
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Long toLong(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Long");
        return Long.parseLong(source);
    }

    /**
     * String To Long Re long Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Long toLong(@This String source, Long errorBack) {
        try {
            return Long.parseLong(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Short Re short
     *
     * @param source
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Short toShort(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Short");
        return Short.parseShort(source);
    }

    /**
     * String To Short Re short Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Short toShort(@This String source, Short errorBack) {
        try {
            return Short.parseShort(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To BigDecimal Re bigDecimal
     *
     * @param source
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:01
     * @version 1.0
     * @mdate 2022/8/6 15:01
     * @since 1.0
     */
    public static BigDecimal toBigDecimal(@This String source) {
        isNullException(source);
        return new BigDecimal(source);
    }

    /**
     * String To BigDecimal Re bigDecimal Exception Re errorBack
     *
     * @param source
     * @param errorBack
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:02
     * @version 1.0
     * @mdate 2022/8/6 15:02
     * @since 1.0
     */
    public static BigDecimal toBigDecimal(@This String source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion
}