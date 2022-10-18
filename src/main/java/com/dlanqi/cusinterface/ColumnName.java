package com.dlanqi.cusinterface;

import java.lang.annotation.*;


/**
 * 属性名称注解
 *
 * @author dh
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnName {

    /**
     * 字段名
     */
    String value() default "";

    /**
     * 对象类型
     */
    Class<?> classType() default void.class;

    /**
     * 是否集合
     */
    boolean isList() default false;

    String onlyMark() default "";

    /**
     * 日期格式化
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}
