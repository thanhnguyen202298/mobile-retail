package com.ssk.retailshop.screen.register.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

public class UserRegisterDTO extends BaseObservable {
    @SerializedName("Email")
    String mailName;
    @SerializedName("Password")
    String passWord;
    @SerializedName("AccountName")
    String storeName;
    @SerializedName("Phone")
    String phoneNumber;
    @SerializedName("Address")
    String address;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String mail, String passWord, String storeName, String phoneNumber, String address) {
        this.mailName = mail;
        this.passWord = passWord;
        this.storeName = storeName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mail) {
        this.mailName = mail;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
