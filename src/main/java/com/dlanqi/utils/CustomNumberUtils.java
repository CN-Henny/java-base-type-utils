package com.dlanqi.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义数字Utils
 * Copyright: Copyright (C) 2020 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2020/11/11 13:47
 */
public class CustomNumberUtils {

    /**
     * Object to int
     *
     * @param obj 入参
     * @return {@link int}
     */
    public static int obj2Int(Object obj) {
        int i = 0;
        if (null != obj) {
            i = Integer.parseInt(obj.toString());
        }
        return i;
    }

    /**
     * Object to Long
     * 只要转换不报错就保存，报错就跳过
     *
     * @param obj 入参
     * @return {@link Long}
     */
    public static Long obj2Long(Object obj) {
        long l = 0L;
        if (null != obj && !"".equals(obj)) {
            try {
                l = Long.parseLong(obj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return l;
    }

    /**
     * Object to BigDecimal
     * 如果入参是null，则返回new BigDecimal(0)
     *
     * @param obj 入参
     * @return {@link BigDecimal}
     */
    public static BigDecimal obj2BigDecimal(Object obj) {
        BigDecimal bdValue = new BigDecimal(0);
        if (null != obj) {
            bdValue = BigDecimal.valueOf(Double.parseDouble(obj.toString()));
        }
        return bdValue;
    }

    /**
     * ids<Object> 转换 ids<List<Long>>
     *
     * @param list 集合
     * @return {@link List<Long>}
     */
    public static List<Long> convertToList(Object list) {

        if (!(list instanceof Collection)) {
            return null;
        }

        List<?> params = (List<?>) list;
        List<Long> results = new ArrayList<>();

        params.forEach(param -> {
            if (param instanceof Integer) {
                int intValue = Integer.parseInt(String.valueOf(param));
                results.add((long) intValue);
            }
            if (param instanceof Long) {
                results.add(Long.parseLong(String.valueOf(param)));
            }
        });
        return results;
    }

    /**
     * 获取补位码
     *
     * @param codeList  目前有的集合
     * @param startCode 初始码
     * @return {@link int}
     */
    public static int getComplementCode(List<Integer> codeList, Integer startCode) {
        int max = codeList.stream().max(Integer::compareTo).orElse(startCode);
        List<Integer> codeSeriesList = new ArrayList<>();
        for (int i = startCode; i <= max; i++) {
            codeSeriesList.add(i);
        }
        //两个集合取交集如果有那么说明有删除了的数据，然后取最新的一个补位为牌号码，如果没有最大的+1
        codeSeriesList.removeAll(codeList);
        if (codeSeriesList.size() > 0) {
            return codeSeriesList.stream().min(Integer::compareTo).orElse(startCode);
        }
        return max + 1;
    }

    /**
     * 获取实体对应的主键值
     *
     * @param obj 实体对象
     * @return {@link Long}
     * @author Rex
     * @since 2021/12/16 16:11
     */
    public static Long getObjectId(Object obj, String methodName) {
        Long objectId = 0L;
        Class<?> classType = obj.getClass();
        String getMethodName = "getObjectId";
        if (com.dlanqi.utils.CustomStringUtils.isNotEmpty(methodName)) {
            getMethodName = methodName;
        }
        Method getMethod = null;
        try {
            getMethod = classType.getMethod(getMethodName);
            Object value = getMethod.invoke(obj);
            objectId = obj2Long(value);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return objectId;
    }

    /**
     * 保留指定位数
     *
     * @param d            默认值
     * @param p            参数
     * @param newScale     保留位数
     * @param roundingMode The rounding mode to apply
     * @return {@link BigDecimal}
     * @author Rex
     * @since 2022/5/11 12:43
     */
    @Deprecated
    public static BigDecimal getBigDecimalScale(BigDecimal d, BigDecimal p, int newScale, int roundingMode) {
        if (null == p) {
            return d;
        }
        return p.setScale(newScale, roundingMode);
    }

    /**
     * 保留指定位数默认返回0
     *
     * @param p            参数
     * @param newScale     保留位数
     * @param roundingMode The rounding mode to apply
     * @return {@link BigDecimal}
     * @author Rex
     * @since 2022/5/11 12:43
     */
    @Deprecated
    public static BigDecimal getBigDecimalScale(BigDecimal p, int newScale, int roundingMode) {
        return getBigDecimalScale(new BigDecimal(0), p, newScale, roundingMode);
    }

    /**
     * 保留2位数（四舍五入）默认返回0
     *
     * @param p 参数
     * @return {@link BigDecimal}
     * @author Rex
     * @since 2022/5/11 12:43
     */
    @Deprecated
    public static BigDecimal getBigDecimalScale(BigDecimal p) {
        return getBigDecimalScale(new BigDecimal(0), p, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 多个数字求和
     *
     * @param args 参数
     * @return {@link BigDecimal}
     * @author Rex
     * @since 2022/7/6 13:27
     */
    @Deprecated
    public static BigDecimal addAll(BigDecimal... args) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal item : args) {
            result = result.add(obj2BigDecimal(item));
        }
        return result;
    }

    /**
     * 判断是否是空或者0
     *
     * @param bigDecimal 参数
     * @return {@link Boolean}
     * @author Rex
     * @since 2022/7/21 10:34
     */
    @Deprecated
    public static Boolean isNullOrZero(BigDecimal bigDecimal) {
        return bigDecimal == null || BigDecimal.ZERO.equals(bigDecimal);
    }

}
