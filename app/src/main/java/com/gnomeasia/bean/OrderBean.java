package com.gnomeasia.bean;

import java.util.List;

/**
 * Created by 13002 on 2017/10/11.
 */

public class OrderBean {

    private String ticket_id;//5
    private String ticket_code;//17239285
    private String ticket_order_id;//141105
    private String ticket_ticket_id;//10847
    private String ticket_event_id;//1390
    private String ticket_status;//null
    private List<CustomField> customFieldList;
    private String ticket_remark;//
    private String ticket_email;//87649669@qq.com
    private String ticket_phone;//15354617571
    private String ticket_user_nickname;//猫爪捏起来很软
    private String ticket_user_avatar;//http://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo6A
    private String ticket_quantity;//1
    private String ticket_used_quantity;//0
    private String ticket_refunded_quantity;//0
    private String ticket_total_amount;//0
    private String ticket_paid_amount;//0
    private String ticket_discount_amount;//0
    private String ticket_refunded_amount;//0
    private String ticket_created_at;//2017-09-11 11:05:12
    private String ticket_updated_at;//2017-09-11 11:05:12
    private String ticket_external;//null
    private String ticket_created_at_gnome;//2017-09-11 19:05:13


    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_code() {
        return ticket_code;
    }

    public void setTicket_code(String ticket_code) {
        this.ticket_code = ticket_code;
    }

    public String getTicket_order_id() {
        return ticket_order_id;
    }

    public void setTicket_order_id(String ticket_order_id) {
        this.ticket_order_id = ticket_order_id;
    }

    public String getTicket_ticket_id() {
        return ticket_ticket_id;
    }

    public void setTicket_ticket_id(String ticket_ticket_id) {
        this.ticket_ticket_id = ticket_ticket_id;
    }

    public String getTicket_event_id() {
        return ticket_event_id;
    }

    public void setTicket_event_id(String ticket_event_id) {
        this.ticket_event_id = ticket_event_id;
    }

    public String getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(String ticket_status) {
        this.ticket_status = ticket_status;
    }

    public List<CustomField> getCustomFieldList() {
        return customFieldList;
    }

    public void setCustomFieldList(List<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    public String getTicket_remark() {
        return ticket_remark;
    }

    public void setTicket_remark(String ticket_remark) {
        this.ticket_remark = ticket_remark;
    }

    public String getTicket_email() {
        return ticket_email;
    }

    public void setTicket_email(String ticket_email) {
        this.ticket_email = ticket_email;
    }

    public String getTicket_phone() {
        return ticket_phone;
    }

    public void setTicket_phone(String ticket_phone) {
        this.ticket_phone = ticket_phone;
    }

    public String getTicket_user_nickname() {
        return ticket_user_nickname;
    }

    public void setTicket_user_nickname(String ticket_user_nickname) {
        this.ticket_user_nickname = ticket_user_nickname;
    }

    public String getTicket_user_avatar() {
        return ticket_user_avatar;
    }

    public void setTicket_user_avatar(String ticket_user_avatar) {
        this.ticket_user_avatar = ticket_user_avatar;
    }

    public String getTicket_quantity() {
        return ticket_quantity;
    }

    public void setTicket_quantity(String ticket_quantity) {
        this.ticket_quantity = ticket_quantity;
    }

    public String getTicket_used_quantity() {
        return ticket_used_quantity;
    }

    public void setTicket_used_quantity(String ticket_used_quantity) {
        this.ticket_used_quantity = ticket_used_quantity;
    }

    public String getTicket_refunded_quantity() {
        return ticket_refunded_quantity;
    }

    public void setTicket_refunded_quantity(String ticket_refunded_quantity) {
        this.ticket_refunded_quantity = ticket_refunded_quantity;
    }

    public String getTicket_total_amount() {
        return ticket_total_amount;
    }

    public void setTicket_total_amount(String ticket_total_amount) {
        this.ticket_total_amount = ticket_total_amount;
    }

    public String getTicket_paid_amount() {
        return ticket_paid_amount;
    }

    public void setTicket_paid_amount(String ticket_paid_amount) {
        this.ticket_paid_amount = ticket_paid_amount;
    }

    public String getTicket_discount_amount() {
        return ticket_discount_amount;
    }

    public void setTicket_discount_amount(String ticket_discount_amount) {
        this.ticket_discount_amount = ticket_discount_amount;
    }

    public String getTicket_refunded_amount() {
        return ticket_refunded_amount;
    }

    public void setTicket_refunded_amount(String ticket_refunded_amount) {
        this.ticket_refunded_amount = ticket_refunded_amount;
    }

    public String getTicket_created_at() {
        return ticket_created_at;
    }

    public void setTicket_created_at(String ticket_created_at) {
        this.ticket_created_at = ticket_created_at;
    }

    public String getTicket_updated_at() {
        return ticket_updated_at;
    }

    public void setTicket_updated_at(String ticket_updated_at) {
        this.ticket_updated_at = ticket_updated_at;
    }

    public String getTicket_external() {
        return ticket_external;
    }

    public void setTicket_external(String ticket_external) {
        this.ticket_external = ticket_external;
    }

    public String getTicket_created_at_gnome() {
        return ticket_created_at_gnome;
    }

    public void setTicket_created_at_gnome(String ticket_created_at_gnome) {
        this.ticket_created_at_gnome = ticket_created_at_gnome;
    }

    public class CustomField{
        String key;
        String value;

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

}
