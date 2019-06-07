package com.ssk.retailshop.screen.shop.model;

import android.support.annotation.NonNull;

public class ResponseShop extends Object {
    private String Code;
    private String Name;

    public ResponseShop(String code, String name) {
        Code = code;
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
