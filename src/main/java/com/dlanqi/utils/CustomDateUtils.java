package com.dlanqi.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 自定义日期Utils
 * Copyright: Copyright (C) 2020 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2020/11/11 14:05
 */
public class CustomDateUtils {

    /**
     * 时间累加
     *
     * @param date       时间
     * @param dayOfMonth 天
     * @return {@link Date}
     */
    @Deprecated
    public static Date plusDay(Date date, int dayOfMonth) {
        if (date == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, dayOfMonth);
        return ca.getTime();
    }
}
