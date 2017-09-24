package com.gnomeasia.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by FANGYI on 2017/9/23.
 */

public class UserBean implements Parcelable {

    protected UserBean(Parcel in) {
        ticket_id = in.readString();
        ticket_code = in.readString();
        ticket_order_id = in.readString();
        ticket_ticket_id = in.readString();
        ticket_event_id = in.readString();
        ticket_status = in.readString();
        ticket_custom_fields = in.readString();
        ticket_remark = in.readString();
        ticket_email = in.readString();
        ticket_phone = in.readString();
        ticket_user_nickname = in.readString();
        ticket_user_avatar = in.readString();
        ticket_quantity = in.readString();
        ticket_used_quantity = in.readString();
        ticket_refunded_quantity = in.readString();
        ticket_total_amount = in.readString();
        ticket_paid_amount = in.readString();
        ticket_discount_amount = in.readString();
        ticket_refunded_amount = in.readString();
        ticket_created_at = in.readString();
        ticket_updated_at = in.readString();
        ticket_external = in.readString();
        ticket_created_at_gnome = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    @Override
    public String toString() {
        return "UserBean{" +
                "ticket_id='" + ticket_id + '\'' +
                ", ticket_code='" + ticket_code + '\'' +
                ", ticket_order_id='" + ticket_order_id + '\'' +
                ", ticket_ticket_id='" + ticket_ticket_id + '\'' +
                ", ticket_event_id='" + ticket_event_id + '\'' +
                ", ticket_status='" + ticket_status + '\'' +
                ", ticket_custom_fields='" + ticket_custom_fields + '\'' +
                ", ticket_remark='" + ticket_remark + '\'' +
                ", ticket_email='" + ticket_email + '\'' +
                ", ticket_phone='" + ticket_phone + '\'' +
                ", ticket_user_nickname='" + ticket_user_nickname + '\'' +
                ", ticket_user_avatar='" + ticket_user_avatar + '\'' +
                ", ticket_quantity='" + ticket_quantity + '\'' +
                ", ticket_used_quantity='" + ticket_used_quantity + '\'' +
                ", ticket_refunded_quantity='" + ticket_refunded_quantity + '\'' +
                ", ticket_total_amount='" + ticket_total_amount + '\'' +
                ", ticket_paid_amount='" + ticket_paid_amount + '\'' +
                ", ticket_discount_amount='" + ticket_discount_amount + '\'' +
                ", ticket_refunded_amount='" + ticket_refunded_amount + '\'' +
                ", ticket_created_at='" + ticket_created_at + '\'' +
                ", ticket_updated_at='" + ticket_updated_at + '\'' +
                ", ticket_external='" + ticket_external + '\'' +
                ", ticket_created_at_gnome='" + ticket_created_at_gnome + '\'' +
                '}';
    }

    /**
     * ticket_id : 1
     * ticket_code : 6688888
     * ticket_order_id : 863
     * ticket_ticket_id : 1053
     * ticket_event_id : 668
     * ticket_status : null
     * ticket_custom_fields : [{"key":"\u662f\u5426\u5b66\u751f","value":["1.true"]},{"key":"\u59d3\u540d","value":["1.\u6881\u5b88\u9e4f"]},{"key":"\u6240\u5728\u5b66\u6821\u6216\u5355\u4f4d\/\u516c\u53f8\u540d\u79f0","value":["1.\u897f\u5b89\u79d1\u6280\u5927\u5b66"]}]
     * ticket_remark : 测试
     * ticket_email : test@tinyticket.co
     * ticket_phone : 18673673161
     * ticket_user_nickname : null
     * ticket_user_avatar : https://duohui.co/images/default-avatar.png
     * ticket_quantity : 2
     * ticket_used_quantity : 0
     * ticket_refunded_quantity : 0
     * ticket_total_amount : 200
     * ticket_paid_amount : 200
     * ticket_discount_amount : 0
     * ticket_refunded_amount : 0
     * ticket_created_at : 2017-08-28 10:02:36
     * ticket_updated_at : 2017-08-28 10:02:36
     * ticket_external : null
     * ticket_created_at_gnome : 2017-09-11 18:51:07
     */

    private String ticket_id;
    private String ticket_code;
    private String ticket_order_id;
    private String ticket_ticket_id;
    private String ticket_event_id;
    private String ticket_status;
    private String ticket_custom_fields;
    private String ticket_remark;
    private String ticket_email;
    private String ticket_phone;
    private String ticket_user_nickname;
    private String ticket_user_avatar;
    private String ticket_quantity;
    private String ticket_used_quantity;
    private String ticket_refunded_quantity;
    private String ticket_total_amount;
    private String ticket_paid_amount;
    private String ticket_discount_amount;
    private String ticket_refunded_amount;
    private String ticket_created_at;
    private String ticket_updated_at;
    private String ticket_external;
    private String ticket_created_at_gnome;

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

    public String getTicket_custom_fields() {
        return ticket_custom_fields;
    }

    public void setTicket_custom_fields(String ticket_custom_fields) {
        this.ticket_custom_fields = ticket_custom_fields;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ticket_id);
        parcel.writeString(ticket_code);
        parcel.writeString(ticket_order_id);
        parcel.writeString(ticket_ticket_id);
        parcel.writeString(ticket_event_id);
        parcel.writeString(ticket_status);
        parcel.writeString(ticket_custom_fields);
        parcel.writeString(ticket_remark);
        parcel.writeString(ticket_email);
        parcel.writeString(ticket_phone);
        parcel.writeString(ticket_user_nickname);
        parcel.writeString(ticket_user_avatar);
        parcel.writeString(ticket_quantity);
        parcel.writeString(ticket_used_quantity);
        parcel.writeString(ticket_refunded_quantity);
        parcel.writeString(ticket_total_amount);
        parcel.writeString(ticket_paid_amount);
        parcel.writeString(ticket_discount_amount);
        parcel.writeString(ticket_refunded_amount);
        parcel.writeString(ticket_created_at);
        parcel.writeString(ticket_updated_at);
        parcel.writeString(ticket_external);
        parcel.writeString(ticket_created_at_gnome);
    }
}
