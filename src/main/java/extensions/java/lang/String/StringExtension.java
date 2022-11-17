package extensions.java.lang.String;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Extension
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: Henny
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

    public final static int FormatDate = 1;

    public final static int FormatTime = 2;

    /**
     * Null Exception Throw
     *
     * @param source 源数据
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/5 13:25
     * @version 1.0
     * @mdate 2022/8/5 13:25
     * @since 1.0
     */
    private static void isNullException(String source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            throw new NullPointerException("com.dlanqi:base-type-utils Error : source is null");
        }
    }

    /**
     * Integer Exception
     * Is Not Integer Re False
     *
     * @param source 源数据
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:14
     * @version 1.0
     * @mdate 2022/8/6 16:14
     * @since 1.0
     */
    private static void isIntegerException(String source) {
        Character[] chars = source.customToCharacterArray();
        for (Character charValue : chars) {
            if (!Character.isDigit(charValue)) {
                //TODO 增加异常返回
                throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is not Integer");
            }
        }
    }

    /**
     * Float Exception
     * Is Not Integer And Is Not Float Re False
     *
     * @param source 源数据
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
                    throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is not float");
                }
            } else {
                //TODO 增加异常返回
                System.out.println(source + "包含多个小数点");
                throw new NumberFormatException("com.dlanqi:base-type-utils Error : source contain more point");
            }
        } else {
            if (!pattern.matcher(source).matches()) {
                //TODO 增加异常返回
                throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is not Integer and float");
            }
        }
    }

    /**
     * 判断转换是否超出最大值
     *
     * @param source 源数据
     * @param max    最大值
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
            throw new NumberFormatException("com.dlanqi:base-type-utils Error : source is too long");
        }
    }

    /**
     * 替换字符源方法
     *
     * @param templateContent 文本
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/11/16 15:11
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/16 15:11
     * @since 1.0
     */
    private static String replaceChSym(String templateContent) {
        isNullException(templateContent);
        templateContent = templateContent.replaceAll("《", "&#x300A;");
        templateContent = templateContent.replaceAll("》", "&#x300B;");
        templateContent = templateContent.replaceAll("（", "&#xFF08;");
        templateContent = templateContent.replaceAll("）", "&#xFF09;");
        templateContent = templateContent.replaceAll("“", "&#x201C;");
        templateContent = templateContent.replaceAll("”", "&#x201D;");
        templateContent = templateContent.replaceAll("、", "&#x3001;");
        templateContent = templateContent.replaceAll("，", "&#xFF0C;");
        templateContent = templateContent.replaceAll("。", "&#x3002;");
        templateContent = templateContent.replaceAll("；", "&#xFF1B;");
        templateContent = templateContent.replaceAll("：", "&#xFF1A;");
        return templateContent;
    }

    //region 判断型

    /**
     * If source Is Null Re true Else Re false
     * Null Range : Null
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:25
     * @version 1.0
     * @mdate 2022/8/5 14:25
     * @since 1.0
     */
    public static Boolean customIsNull(@This String source) {
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
     * @cdate 2022/8/5 14:26
     * @version 1.0
     * @mdate 2022/8/5 14:26
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This String source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:08
     * @version 1.0
     * @mdate 2022/8/5 15:08
     * @since 1.0
     */
    public static String customIsNotNull(@This String source, String errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    /**
     * If source Is Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:54
     * @version 1.0
     * @mdate 2022/8/5 14:54
     * @since 1.0
     */
    public static Boolean customIsEmpty(@This String source) {
        return source.customIsNull() || (source.equals(""));
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     * 20221025修改引用错误
     * 20221026改错接口了掉到了IsNull上
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 14:57
     * @version 1.0.2
     * @mdate 2022/10/25 11:57
     * @since 1.0
     */
    public static Boolean customIsNotEmpty(@This String source) {
        return !source.customIsEmpty();
    }

    /**
     * If source Is Not Empty Re true Else Re false
     * Null Range : Null , ""
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:09
     * @version 1.0
     * @mdate 2022/8/5 15:09
     * @since 1.0
     */
    public static String customIsNotEmpty(@This String source, String errorBack) {
        return source.customIsNotEmpty() ? source : errorBack;
    }

    /**
     * If source Is Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:00
     * @version 1.0
     * @mdate 2022/8/5 15:00
     * @since 1.0
     */
    public static Boolean customIsBlank(@This String source) {
        int strLen;
        if (source == null || (strLen = source.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(source.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * If source Is Not Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:01
     * @version 1.0
     * @mdate 2022/8/5 15:01
     * @since 1.0
     */
    public static Boolean customIsNotBlank(@This String source) {
        return !source.customIsBlank();
    }

    /**
     * If source Is Not Blank Re true Else Re false
     * Null Range : Null , "" , WhiteChar
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/5 15:10
     * @version 1.0
     * @mdate 2022/8/5 15:10
     * @since 1.0
     */
    public static String customIsNotBlank(@This String source, String errorBack) {
        return source.customIsNotBlank() ? source : errorBack;
    }

    /**
     * If source Is Integer Re true Else Re fasle
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:51
     * @version 1.0
     * @mdate 2022/8/6 15:51
     * @since 1.0
     */
    public static Boolean customIsInteger(@This String source) {
        isNullException(source);
        Character[] chars = source.customToCharacterArray();
        for (Character charValue : chars) {
            if (!Character.isDigit(charValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If source Is Integer Re true Else Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.1
     * @mdate 2022/11/16 10:53
     * @since 1.0
     */
    public static Boolean customIsInteger(@This String source, Boolean errorBack) {
        try {
            Character[] chars = source.customToCharacterArray();
            for (Character charValue : chars) {
                if (!Character.isDigit(charValue)) {
                    return false;
                }
            }
            return true;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * If source Is Integer Re source Else Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/11/16 11:11
     * @version 1.1
     * @mdate 2022/11/16 11:11
     * @since 1.0
     */
    public static String customIsInteger(@This String source, String errorBack) {
        if (source.customIsInteger(false)) {
            return source;
        } else {
            return errorBack;
        }
    }

    /**
     * If source Is Not Integer Re true Else Re fasle
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static Boolean customIsNotInteger(@This String source) {
        return !source.customIsInteger();
    }

    /**
     * If source Is Float Re true Else Re fasle
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:51
     * @version 1.0
     * @mdate 2022/8/6 15:51
     * @since 1.0
     */
    public static Boolean customIsFloat(@This String source) {
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
     * If source Is Float Re true Else Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static Boolean customIsFloat(@This String source, Boolean errorBack) {
        try {
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
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * If source Is Float Re source Else Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/11/16 12:37
     * @version 1.0
     * @mdate 2022/11/16 12:37
     * @since 1.0
     */
    public static String customIsFloat(@This String source, String errorBack) {
        if (source.customIsFloat(false)) {
            return source;
        } else {
            return errorBack;
        }
    }

    /**
     * If source Is Not Float Re true Else Re fasle
     *
     * @param source 源数据
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:53
     * @version 1.0
     * @mdate 2022/8/6 15:53
     * @since 1.0
     */
    public static Boolean customIsNotFloat(@This String source) {
        return !source.customIsFloat();
    }

    /**
     * source Compare To condition
     * If content is JSONObject Re 1
     * If content is JSONArray Re 2
     * If content is Not JSON Re 0
     *
     * @param source 源数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:28
     * @version 1.0
     * @mdate 2022/10/18 15:28
     * @since 1.0
     */
    public static Integer customIsJson(@This String source) {
        try {
            isNullException(source);
            Object object = JSON.parse(source);
            if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) object;
                return 1;
            } else if (object instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object;
                return 2;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * If source Is JSON Re true Else Re fasle
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/18 15:35
     * @version 1.0
     * @mdate 2022/10/18 15:35
     * @since 1.0
     */
    public static String customIsJson(@This String source, String errorBack) {
        if (source.customIsJson() == 0) {
            return errorBack;
        } else {
            return source;
        }
    }
    //endregion

    //region 功能型

    /**
     * 替换富文本中的特殊符号以便在XNL中使用
     *
     * @param html 源数据
     * @return java.lang.String
     * @throws
     * @author Henny
     * @cdate 2022/10/17 20:12
     * @version 1.0
     * @mdate 2022/10/17 20:12
     * @since 1.0
     */
    public static String customReplaceSpecialSymbols(@This String html) {
        isNullException(html);
        //替换单引号
        html = html.replace("'", "&apos;");
        //替换&
        html = html.replaceAll("&", "&amp;");
        //替换双引号
        html = html.replace("\"", "&quot;");
        // 替换跳格
        html = html.replace("\t", "&nbsp;&nbsp;");
        // 替换空格
        html = html.replace(" ", "&nbsp;");
        //替换左尖括号
        html = html.replace("<", "&lt;");
        //替换右尖括号
        html = html.replaceAll(">", "&gt;");
        html = html.replaceAll("\r", "");
        html = html.replaceAll("\n", "");
        return html;
    }

    /**
     * 获取富文本字数
     *
     * @param html 源数据
     * @return java.lang.Integer
     * @throws
     * @author Rex
     * @cdate 2022/10/17 20:26
     * @version 1.1
     * @mdate 2022/11/16 13:24
     * @since 1.0
     */
    public static Integer customGetTextAreaWordCount(@This String html) {
        isNullException(html);
        String resultNoTag = html.customRemoveHtmlTag();
        return resultNoTag.length();
    }

    /**
     * 删除Html标签
     *
     * @param inputString 源数据
     * @return java.lang.String
     * @throws
     * @author Rex
     * @cdate 2022/10/17 20:18
     * @version 1.0
     * @mdate 2022/10/17 20:18
     * @since 1.0
     */
    public static String customRemoveHtmlTag(@This String inputString) {
        isNullException(inputString);
        // 含html标签的字符串
        String textStr = "";
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regExScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regExStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            // 定义HTML标签的正则表达式
            String regExHtml = "<[^>]+>";
            // 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            String regExSpecial = "\\&[a-zA-Z]{1,10};";
            textStr = inputString.customRegexStr(regExScript, regExStyle, regExHtml, regExSpecial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回文本字符串
        return textStr;
    }

    /**
     * 按照正则获取字符串
     *
     * @param htmlStr 源数据
     * @param args 正则
     * @return java.lang.String
     * @throws
     * @author Rex
     * @cdate 2022/10/17 20:19
     * @version 1.0
     * @mdate 2022/10/17 20:19
     * @since 1.0
     */
    public static String customRegexStr(@This String htmlStr, String... args) {
        Pattern pScript;
        Matcher mScript;
        for (String regEx : args) {
            pScript = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            mScript = pScript.matcher(htmlStr);
            // 过滤
            htmlStr = mScript.replaceAll("");
        }
        return htmlStr;
    }

    /**
     * 替换占位符
     *
     * @param templateContent 源数据
     * @param paramMap 替换集合
     * @return java.lang.String
     * @throws
     * @author Rex
     * @cdate 2022/10/18 14:02
     * @version 1.0
     * @mdate 2022/10/18 14:02
     * @since 1.0
     */
    public static String customReplaceTemplateContent(@This String templateContent, Map<String, Object> paramMap) {
        if (templateContent == null || "".equals(templateContent)) {
            return null;
        }
        for (String key : paramMap.keySet()) {
            String regex = String.format("\\$\\{%s\\}", key);
            String value = paramMap.get(key).toString();
            value = replaceChSym(value);
            templateContent = templateContent.replaceAll(regex, value);
        }
        return templateContent;
    }

    /**
     * 手机号打码
     *
     * @param phone 源数据
     * @return java.lang.String
     * @throws
     * @author Rex
     * @cdate 2022/10/18 15:11
     * @version 1.0
     * @mdate 2022/10/18 15:11
     * @since 1.0
     */
    public static String customMaskPhone(@This String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 获取日期间隔月份集合
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return java.util.List<java.lang.String>
     * @throws
     * @author Rex
     * @cdate 2022/10/18 17:07
     * @version 1.0
     * @mdate 2022/10/18 17:07
     * @since 1.0
     */
    public static List<String> customGetMonthListByDateRange(@This String startTime, String endTime) {
        SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM");
        Date startDate = DateUtil.parse(startTime);
        Date endDate = DateUtil.parse(endTime);
        List<String> month = new ArrayList<>();
        month.add(dfm.format(startDate));
        if (!dfm.format(startDate).equals(dfm.format(endDate))) {
            long monthsBetween = ChronoUnit.MONTHS.between(
                    LocalDate.parse(startTime).withDayOfMonth(1),
                    LocalDate.parse(endTime).withDayOfMonth(1));
            for (int i = 1; i <= (int) monthsBetween; i++) {
                Date addDate = DateUtil.offsetMonth(startDate, i);
                month.add(dfm.format(addDate));
            }
        }
        return month;
    }

    /**
     * 给定时间段和星期几，计算该时间段内共有多少个给定的星期几
     *
     * @param start   开始时间,格式yyyy-MM-dd
     * @param endTime 结束时间，格式yyyy-MM-dd
     * @param week    星期几，从星期一到星期天，分别用数字1-7表示
     * @return java.lang.Long  星期几统计数
     * @throws
     * @author Rex
     * @cdate 2022/10/18 17:17
     * @version 1.1
     * @muser Henny
     * @mdate 2022/11/16 14:07
     * @since 1.0
     */
    public static Long customGetWeekNumberByDateRange(@This String start, String endTime, Integer week) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //计数
        long sunDay = 0;
        try {
            Calendar startDate = Calendar.getInstance();
            startDate.setTime(format.parse(start));
            Calendar endDate = Calendar.getInstance();
            endDate.setTime(format.parse(endTime));
            //开始日期是星期几 结束日期是星期几
            int sw = startDate.get(Calendar.DAY_OF_WEEK) - 1;
            int ew = endDate.get(Calendar.DAY_OF_WEEK) - 1;
            long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
            //给定时间段内一共有多少天
            long days = diff / (1000 * 60 * 60 * 24);
            //给定时间内，共有多少个星期
            //总的星期几统计数
            sunDay = Math.round(Math.ceil(((days + sw + (7 - ew)) / 7.0)));
            //给定的星期几小于起始日期的星期几，需要减少一天
            if (week < sw) {
                sunDay--;
            }
            //给定的星期几大于结束日期的星期几，需要减少一天
            if (week > ew) {
                sunDay--;
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
        return sunDay;
    }

    /**
     * 获取时间段内的日期集合
     *
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return java.util.List<java.lang.String>
     * @throws
     * @author Rex
     * @cdate 2022/10/18 17:20
     * @version 1.0
     * @mdate 2022/10/18 17:20
     * @since 1.0
     */
    public static List<String> customGetWeekListOfDateRange(@This String startDate, String endDate) {
        List<String> dateList = new ArrayList<>();
        long betweenDay = DateUtil.betweenDay(DateUtil.parse(startDate), DateUtil.parse(endDate), true);
        for (int i = 0; i <= betweenDay; i++) {
            DateTime dateTime = DateUtil.offsetDay(DateUtil.parse(startDate), i);
            dateList.add(DateUtil.format(dateTime, "yyyy-MM-dd"));
        }
        return dateList;
    }

    /**
     * 获取日期范围内指定星期的日期
     *
     * @param start 开始时间
     * @param end 结束时间
     * @param week 星期几
     * @return java.util.List<java.lang.String>
     * @throws
     * @author Rex
     * @cdate 2022/10/18 17:22
     * @version 1.0
     * @mdate 2022/10/18 17:22
     * @since 1.0
     */
    public static List<String> customGetDateListOfDateRangeByWeek(@This String start, String end, int week) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<>();
        //字符串转LocalDate
        LocalDate startLocalDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endLocalDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        long days = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

        //计算有多少, 指定星期几
        Calendar startCalender = GregorianCalendar.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()));
        //for (int i = 0; i < days - 1; i++) {
        for (int i = 0; i < days; i++) {
            startCalender.add(Calendar.DATE, 1);

            if (startCalender.get(Calendar.DAY_OF_WEEK) == week + 1) {
                // 1代表周日，7代表周六
                LocalDate localDate = LocalDateTime.ofInstant(startCalender.toInstant(), ZoneOffset.systemDefault()).toLocalDate();
                ZoneId zone = ZoneId.systemDefault();
                Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
                Date date = Date.from(instant);
                list.add(df.format(date));
            }
        }
        return list;
    }

    public static <T> List<T> customSplit(@This String source,String sign,Class<T> t){
        List<T> list = new ArrayList<>();
        List<String> sourceList = source.split(sign).toList();

        return list;
    }

    //endregion

    //region 转换型

    /**
     * String To Byte[] Re byte[]
     *
     * @param source 源数据
     * @return java.lang.Byte[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:56
     * @version 1.0
     * @mdate 2022/8/6 14:56
     * @since 1.0
     */
    public static Byte[] customToByteArray(@This String source) {
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
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Byte[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:57
     * @version 1.0
     * @mdate 2022/8/6 14:57
     * @since 1.0
     */
    public static Byte[] customToByteArray(@This String source, Byte[] errorBack) {
        try {
            byte[] byteArray = source.getBytes();
            Byte[] byteObjects = new Byte[byteArray.length];
            for (int i = 0; i < byteArray.length; i++) {
                byteObjects[i] = byteArray[i];
            }
            return byteObjects;
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Character[] Re character[]
     *
     * @param source 源数据
     * @return java.lang.Character[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:58
     * @version 1.0
     * @mdate 2022/8/6 14:58
     * @since 1.0
     */
    public static Character[] customToCharacterArray(@This String source) {
        isNullException(source);
        return source.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    }

    /**
     * String To Character[] Re character[] Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Character[]
     * @throws
     * @author Henny
     * @cdate 2022/8/6 14:59
     * @version 1.0
     * @mdate 2022/8/6 14:59
     * @since 1.0
     */
    public static Character[] customToCharacterArray(@This String source, Character[] errorBack) {
        try {
            return source.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Double Re double
     *
     * @param source 源数据
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:57
     * @version 1.0
     * @mdate 2022/8/6 15:57
     * @since 1.0
     */
    public static Double customToDouble(@This String source) {
        isNullException(source);
        isFloatException(source);
        return Double.parseDouble(source);
    }

    /**
     * String To Double Re double Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Double
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:57
     * @version 1.0
     * @mdate 2022/8/6 15:57
     * @since 1.0
     */
    public static Double customToDouble(@This String source, Double errorBack) {
        try {
            return Double.parseDouble(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Float Re float
     *
     * @param source 源数据
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:53
     * @version 1.0
     * @mdate 2022/8/6 16:53
     * @since 1.0
     */
    public static Float customToFloat(@This String source) {
        isNullException(source);
        isFloatException(source);
        isMax(source, "Float");
        return Float.parseFloat(source);
    }

    /**
     * String To Float Re float Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Float
     * @throws
     * @author Henny
     * @cdate 2022/8/6 16:53
     * @version 1.0
     * @mdate 2022/8/6 16:53
     * @since 1.0
     */
    public static Float customToFloat(@This String source, Float errorBack) {
        try {
            return Float.parseFloat(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Integer Re integer
     *
     * @param source 源数据
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:04
     * @version 1.0
     * @mdate 2022/8/6 17:04
     * @since 1.0
     */
    public static Integer customToInteger(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Integer");
        return Integer.parseInt(source);
    }

    /**
     * String To Integer Re integer Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:05
     * @version 1.0
     * @mdate 2022/8/6 17:05
     * @since 1.0
     */
    public static Integer customToInteger(@This String source, Integer errorBack) {
        try {
            return Integer.parseInt(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Long Re long
     *
     * @param source 源数据
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Long customToLong(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Long");
        return Long.parseLong(source);
    }

    /**
     * String To Long Re long Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Long
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Long customToLong(@This String source, Long errorBack) {
        try {
            return Long.parseLong(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Short Re short
     *
     * @param source 源数据
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Short customToShort(@This String source) {
        isNullException(source);
        isIntegerException(source);
        isMax(source, "Short");
        return Short.parseShort(source);
    }

    /**
     * String To Short Re short Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.lang.Short
     * @throws
     * @author Henny
     * @cdate 2022/8/6 17:07
     * @version 1.0
     * @mdate 2022/8/6 17:07
     * @since 1.0
     */
    public static Short customToShort(@This String source, Short errorBack) {
        try {
            return Short.parseShort(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To BigDecimal Re bigDecimal
     *
     * @param source 源数据
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:01
     * @version 1.0
     * @mdate 2022/8/6 15:01
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This String source) {
        isNullException(source);
        return new BigDecimal(source);
    }

    /**
     * String To BigDecimal Re bigDecimal Exception Re errorBack
     *
     * @param source 源数据
     * @param errorBack 错误返回
     * @return java.math.BigDecimal
     * @throws
     * @author Henny
     * @cdate 2022/8/6 15:02
     * @version 1.0
     * @mdate 2022/8/6 15:02
     * @since 1.0
     */
    public static BigDecimal customToBigDecimal(@This String source, BigDecimal errorBack) {
        try {
            return new BigDecimal(source);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * String To Date Re date
     *
     * @param source 源数据
     * @param formatType 格式化类型
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/10/20 9:58
     * @version 1.0
     * @mdate 2022/10/20 9:58
     * @since 1.0
     */
    public static Date customToDate(@This String source, int formatType) throws Exception {
        switch (formatType) {
            case 1:
                SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
                return simpleDateFormatDate.parse(source);
            case 2:
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return simpleDateFormatTime.parse(source);
            default:
                throw new Exception("com.dlanqi:base-type-utils Error : formatType is null or Non conformance");
        }
    }

    /**
     * String To Date Re date Exception Re errorBack
     *
     * @param source 源数据
     * @param formatType 格式化类型
     * @param errorBack 错误返回
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/10/20 9:58
     * @version 1.0
     * @mdate 2022/10/20 9:58
     * @since 1.0
     */
    public static Date customToDate(@This String source, int formatType, Date errorBack) {
        try {
            return source.customToDate(formatType);
        } catch (Exception ex) {
            return errorBack;
        }
    }
    //endregion

    public static String and(@This String source, String target) {

        return source.customIsNotNull("") + "#" + target.customIsNotNull("");

    }

    public static String or(@This String source, String target) {
        return source.customIsNotNull("") + "@" + target.customIsNotNull("");
    }
}