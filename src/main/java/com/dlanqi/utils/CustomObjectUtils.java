package com.dlanqi.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dlanqi.cusinterface.ColumnName;
import com.dlanqi.model.CusObjectDifferent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dom4j.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 自定义对象处理类
 * Copyright: Copyright (C) 2020 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author DH
 * @since 2022/5/26 16:19
 */
public class CustomObjectUtils {

    //region 对比两个对象返回不同值的属性map

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 对比两个对象返回不同值的属性map
     *
     * @param source source object
     * @param target target object
     * @return the modified fields and value after modify
     */
    @Deprecated
    public static Map<String, Object> getModifyContent(Object source, Object target) {
        Map<String, Object> modifies = new HashMap<>(16);
         /*
          process null problem, if all null means equal
          if only source is null means all modified
          if only target is null means nothing changed
         */
        if (null == source || null == target) {
            if (null == source && null == target) {
                return modifies;
            } else if (null == target) {
                return modifies;
            } else {
                return mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
                });
            }
        }
        // source and target must be same class type
        if (!Objects.equals(source.getClass().getName(), target.getClass().getName())) {
            throw new ClassCastException("source and target are not same class type");
        }
        Map<String, Object> sourceMap = mapper.convertValue(source, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> targetMap = mapper.convertValue(target, new TypeReference<Map<String, Object>>() {
        });
        sourceMap.forEach((k, v) -> {
            Object targetValue = targetMap.get(k);
            if (!Objects.equals(v, targetValue)) {
                modifies.put(k, targetValue);
            }
        });
        return modifies;
    }
    //endregion

    //region  数据修改对比统计

    /**
     * 数据修改对比统计
     *
     * @param oldT      修改前
     * @param newT      修改后
     * @param className 类
     * @param <T>       不包含对象和集合的类
     * @return {@link List<CusObjectDifferent>}
     */
    public static <T> List<CusObjectDifferent> getDifferences(T oldT, T newT, Class<?> className) {
        // 存放处理结果
        List<CusObjectDifferent> differences = new ArrayList<>();
        // 获取当前类的所有字段
        Field[] fields = className.getDeclaredFields();
        for (Field f : fields) {
            // 过滤 static、 final、private static final字段
            if (f.getModifiers() == Modifier.FINAL || f.getModifiers() == Modifier.STATIC || f.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL)) {
                continue;
            }
            // 获取当前字段注解
            ColumnName annotationColumn = f.getAnnotation(ColumnName.class);
            if (annotationColumn == null) {
                continue;
            }
            // 反射获取当前老对象的字段值
            Object oldV = ReflectUtil.getFieldValue(oldT, f.getName());
            // 反射获取当前新对象的字段值
            Object newV = ReflectUtil.getFieldValue(newT, f.getName());
            //先不管集合和对象的
            // 检查新老对象的值是否一致 不一致记录
            if (!Objects.equals(newV, oldV)) {
                // 字段名字
                String fieldName = StrUtil.isNotEmpty(annotationColumn.value()) ? annotationColumn.value() : f.getName();
                // 老对象值
                String oldValue = null != oldV ? oldV.toString() : "";
                // 新对象值
                String newValue = null != newV ? newV.toString() : "";
                // 日期格式特殊处理
                if (oldV instanceof Date && newV instanceof Date) {
                    if (StrUtil.isNotEmpty(oldValue)) {
                        oldValue = DateUtil.format((Date) oldV, annotationColumn.dateFormat());
                    }
                    if (StrUtil.isNotEmpty(newValue)) {
                        newValue = DateUtil.format((Date) newV, annotationColumn.dateFormat());
                    }
                }
                // 添加处理结果中
                differences.add(new CusObjectDifferent(f.getName(), fieldName, oldValue, newValue));
            }
        }
        return differences;
    }
    //endregion

    public static JSONObject xml2Json(String xmlStr) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }
    private static void dom4j2Json(Element element, JSONObject json) {
        // 如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (CustomStringUtils.isNotEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        if (chdEl.isEmpty() && CustomStringUtils.isNotEmpty(element.getText())) {// 如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }
        for (Element e : chdEl) {// 有子元素
            if (!e.elements().isEmpty()) {// 子元素也有子元素
                JSONObject chdjson = new JSONObject();
                dom4j2Json(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    if (o instanceof JSONObject) {// 如果此元素已存在,则转为jsonArray
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }
            } else {// 子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (CustomStringUtils.isNotEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }
}

