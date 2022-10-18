package com.dlanqi.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义集合类共通
 * Copyright: Copyright (C) 2021 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author rex
 * @since 2021/9/3 13:52
 */
public class CustomCollectionUtils {



    /**
     * 对象转换(目前能转List<T>和String[])
     *
     * @param obj   对象
     * @param clazz 要转换的对象类型
     * @return {@link List<T>}
     * @author Rex
     * @since 2021/9/3 16:19
     */
    public static <T> List<T> objToList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
        } else if (obj instanceof String[]) {
            for (Object o : (String[]) obj) {
                result.add(clazz.cast(o));
            }
        }
        return result;
    }

    /**
     * 获取多个集合的交集 返回交集的集合
     * @param paramList
     * @return {@link List<T> }
     * @author LuHongYu
     * @date 2022/8/23 17:04
     */
    public static <T> List<T> getIntersection(List<List<T>> paramList) {
        if (paramList.size() == 1) {
            return paramList.get(0);
        }
        List<T> list = paramList.get(0);
        for (int i = 1; i < paramList.size(); i++) {
            if (null == paramList.get(i)){
                break;
            }
            List<T> temp = paramList.get(i);
            list.retainAll(temp);
        }
        return list;
    }

    /**
     * 获取多个集合是否交集
     * @param paramList
     * @return {@link Boolean }
     * @author LuHongYu
     * @date 2022/8/23 17:03
     */
    public static <T> Boolean getIntersectionBoolean(List<List<T>> paramList) {
        return getIntersection(paramList).size() > 0;
    }
}
