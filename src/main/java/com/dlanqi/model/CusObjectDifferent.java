package com.dlanqi.model;

import java.io.Serializable;

/**
 * 项目管理实体
 * Copyright: Copyright (C) 2022 DLANGEL, Inc. All rights reserved.
 * Company: 大连安琪科技有限公司
 *
 * @author dh
 * @since 2022-05-24 14:40:24
 */
public class CusObjectDifferent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 字段
     */
    private String field;
    /**
     * 对应的字段提示 eg: 姓名
     */
    private String fieldName;
    /**
     * 变更前的值
     */
    private String oldData;
    /**
     * 变更后的值
     */
    private String newData;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    @Override
    public String toString() {
        return fieldName + ":" + "由【" + oldData + "】变更为【" + newData + "】";
    }

    /**
     * 构造
     */
    public CusObjectDifferent(String field, String fieldName, String oldData, String newData) {
        this.field = field;
        this.fieldName = fieldName;
        this.oldData = oldData;
        this.newData = newData;
    }
}
