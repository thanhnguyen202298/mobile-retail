package com.ssk.retailshop.screen.money.model;

import android.support.annotation.NonNull;

public class ReceiptMoneyItem extends Object {
    private String Id;
    private String Date;
    private String User;
    private String Total;

    public ReceiptMoneyItem(String id, String date, String user, String total) {
        Id = id;
        Date = date;
        User = user;
        Total = total;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
