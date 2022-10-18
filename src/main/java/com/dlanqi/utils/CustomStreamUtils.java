package com.dlanqi.utils;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 流工具类
 * Copyright: Copyright (C) 2021 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author Rex
 * @since 2021/11/17 10:44
 */
public class CustomStreamUtils {

    /**
     * 按照指定的key去重
     *
     * @param keyExtractor
     * @return
     * @author Rex
     * @since 2021/11/17 10:45
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}
