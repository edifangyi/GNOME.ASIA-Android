package com.gnomeasia.bean;

/**
 * Created by FANGYI on 2017/9/24.
 */

public class TicketCustomFields {
    @Override
    public String toString() {
        return "TicketCustomFields{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     * key : 姓名
     * value : [1].房一
     */

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
