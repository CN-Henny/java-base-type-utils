package com.dlanqi.utils;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义字符串Utils
 * Copyright: Copyright (C) 2020 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2020/4/21 17:37
 */
public class CustomStringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return {@link Boolean}
     * @author Rex
     * @date 2021/6/8 15:43
     */
    public static boolean isEmpty(Object str) {
        if (str == null) {
            return true;
        }
        if ("".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为非空
     *
     * @param str
     * @return {@link Boolean}
     * @author Rex
     * @date 2021/6/8 15:43
     */
    public static boolean isNotEmpty(Object str) {
        if (str == null) {
            return false;
        }
        if ("".equals(str)) {
            return false;
        }
        return true;
    }

    /**
     * 获取aop参数字符串
     *
     * @param obj 入参
     * @return {@link String}
     * @author Rex
     */
    public static String getArgs(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        if (null != obj) {
            String str = JSONObject.toJSONString(obj);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取字符串，null返回""
     *
     * @param obj 入参
     * @return {@link String}
     * @author Rex
     */
    public static String getStr(Object obj) {
        if (CustomStringUtils.isEmpty(obj)) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * 获取字符串，null返回指定字符串
     *
     * @param obj       入参
     * @param defString 为空时返回用
     * @return {@link String}
     * @author Rex
     */
    public static String getStr(Object obj, String defString) {
        if (CustomStringUtils.isEmpty(obj)) {
            return defString;
        } else {
            return obj.toString();
        }
    }

    /**
     * 替换富文本中的特殊符号以便在XNL中使用
     *
     * @param html html字符串
     * @return {@link String}
     */
    public static String replaceSpecialSymbols(String html) {
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
     * 删除Html标签
     *
     * @param inputString 入参
     * @return {@link String}
     * @author Rex
     */
    public static String removeHtmlTag(String inputString) {
        if (inputString == null) {
            return "";
        }
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
            textStr = getString(inputString, regExScript, regExStyle, regExHtml, regExSpecial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回文本字符串
        return textStr;
    }

    /**
     * 按照正则获取字符串
     *
     * @param htmlStr html字符串
     * @param args    正则参数
     * @return {@link String}
     * @author Rex
     * @since 2021/11/25 10:45
     */
    private static String getString(String htmlStr, String... args) {
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
     * 获取富文本字数
     *
     * @param obj 入参
     * @return {@link int}
     * @author Rex
     */
    public static int getTextAreaWordCount(Object obj) {
        if (null == obj) {
            return 0;
        }
        String resultNoTag = removeHtmlTag(obj.toString());
        return resultNoTag.length();
    }

    /**
     * 完成占位符替换后需要将mht字符转码，因为mht采用3Dus-ascii编码，
     * 该编码格式为10进制的ASCII码（非16进制）
     * 如果不进行处理，会导致最终导出的文件中有中文乱码
     *
     * @param s 入参
     * @return {@link String}
     */
    public static String string2ASCII(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder asciiString = new StringBuilder();
        int n = 0;
        for (char c : chars) {
            n = c;
            String a = "";
            if ((19968 <= n && n < 40623)) {
                a = "&#" + n + ";";
            } else {
                a = c + "";
            }
            asciiString.append(a);
        }
        return asciiString.toString();
    }

    /**
     * 替换占位符
     *
     * @param templateContent 原始字符串
     * @param paramMap        需要替换的占位符
     * @return {@link String}
     * @author Rex
     */
    public static String replaceTemplateContent(String templateContent, Map<String, Object> paramMap) {
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

    public static String replaceChSym(String templateContent) {
        if (templateContent == null || "".equals(templateContent)) {
            return null;
        }
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

    /**
     * 左补位0
     *
     * @param total 需要补位的总长度
     * @param i     需要补位的数
     * @return {@link String}
     * @author Rex
     */
    public static String leftFill(int total, int i) {
        String result = "";
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(total);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(total);
        result = nf.format(i);
        return result;
    }

    /**
     * 左补位指定的数字
     *
     * @param total 需要补位的总长度
     * @param i     需要补位的数
     * @return {@link String}
     * @author Rex
     */
    public static String leftFill(int total, Long i) {
        String result = "";
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(total);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(total);
        result = nf.format(i);
        return result;
    }

    /**
     * 获取布尔值翻译
     *
     * @param value 布尔对象
     * @return {@link String} 返回 是否
     * @author Rex
     */
    public static String getBoolStr(Object value) {
        return getBoolStr(value, "否");
    }

    /**
     * 获取布尔值翻译
     *
     * @param value  布尔对象
     * @param defStr 默认值
     * @return {@link String} 返回 是否
     * @author Rex
     */
    public static String getBoolStr(Object value, String defStr) {
        try {
            if (null == value) {
                return defStr;
            }
            if (1 == CustomNumberUtils.obj2Int(value)) {
                return "是";
            }
            if (0 == CustomNumberUtils.obj2Int(value)) {
                return "否";
            } else {
                return defStr;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return defStr;
        }
    }

    /**
     * 校验第一个字符串是否包含在第二个的逗号拼接的字符串里
     *
     * @param str  单个字符串
     * @param strs 逗号拼接字符串
     * @return {@link Boolean} 如果包含返回true
     * @author Rex
     */
    //public static boolean checkStrInStrs(String str, String strs) {
    //    if (CustomStringUtils.isEmpty(str)) {
    //        return false;
    //    }
    //    if (CustomStringUtils.isEmpty(strs)) {
    //        return false;
    //    }
    //    List<String> strArr = Arrays.asList(strs.split(SymbolConst.Symbol.COMMA).clone());
    //    return strArr.contains(str);
    //}

    /**
     * 手机号打码
     *
     * @param phone 手机号
     * @return 中间四位打码的手机号
     * @author Rex
     */
    public static String maskPhone(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 使用StringBuilder连接字符串
     *
     * @param args
     * @return {@link String}
     * @author Rex
     * @date 2021/6/8 15:31
     */
    public static String appendString(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : args) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    /**
     * 判断是否是json格式
     *
     * @param content
     * @return boolean
     * @author Rex
     * @date 2021/6/25 16:20
     */
    public static boolean isJson(String content) {
        try {
            JSONObject.isValidObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取拼音首字母
     * 并替换掉空格
     *
     * @param str 原字符串
     * @return {@link String}
     * @author Rex
     * @since 2021/11/25 10:49
     */
    public static String getFirstPhoneticAlphabet(String str) {
        final String SEPARATOR = "@@##";
        String result = "";
        result = PinyinUtil.getFirstLetter(str, SEPARATOR);
        result = result.replaceAll(SEPARATOR, "").replaceAll(" ", "");
        return result;
    }

    /**
     * 获取拼音全拼
     * 并替换掉空格
     *
     * @param str 原字符串
     * @return {@link String}
     * @author Rex
     * @since 2021/11/25 10:49
     */
    public static String getFullPhoneticAlphabet(String str) {
        final String SEPARATOR = "@@##";
        String result = "";
        result = PinyinUtil.getPinyin(str).toLowerCase();
        result = result.replaceAll(SEPARATOR, "").replaceAll(" ", "");
        return result;
    }

    /**
     * 获取实体对应的字符串值
     *
     * @param obj        实体对象
     * @param methodName 方法名称
     * @return {@link Long}
     * @author Rex
     * @since 2021/12/16 16:11
     */
    public static String getItemValue(Object obj, String methodName) {
        String itemValue = null;
        Class<?> classType = obj.getClass();
        String getMethodName = "getObjectId";
        if (CustomStringUtils.isNotEmpty(methodName)) {
            getMethodName = methodName;
        }
        Method getMethod = null;
        try {
            getMethod = classType.getMethod(getMethodName);
            Object value = getMethod.invoke(obj);
            itemValue = getStr(value);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return itemValue;
    }
}
