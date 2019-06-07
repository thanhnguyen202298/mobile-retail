package com.ssk.retailshop.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("UserID")
    public String UserID;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("StoreID")
    public String StoreID;

    @SerializedName("StoreParentID")
    public String StoreParentID;


    @SerializedName("StoreCode")
    public String StoreCode;

    @SerializedName("Phone")
    public String Phone;
    @SerializedName("Fax")
    public String Fax;

    @SerializedName("StoreAddress")
    public String StoreAddress;

    @SerializedName("BusinessType")
    public String BussinessType;

    @SerializedName("StoreCreated")
    public String StoreCreated;

    @SerializedName("StoreCreatedBy")
    public String StoreCreatedBy;


    @SerializedName("GroupID")
    public String GroupID;

    @SerializedName("GroupParentID")
    public String GroupParentID;

    @SerializedName("GroupCode")
    public String GroupCode;

    @SerializedName("GroupTitle")
    public String GroupTitle;


    public String password;
    public String LoginToken;

    public boolean isAdmin() {
//        return GroupID == 1;
        return false;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private boolean isAdmin;

    public UserInfo(String userID, String sms, String groupID, String groupName, String employeeCode, String employeeName, String divisionName) {
        UserID = userID;
        this.UserName = sms;
        GroupID = groupID;
    }

    public UserInfo() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSms() {
        return UserName;
    }

    public void setSms(String sms) {
        this.UserName = sms;
    }

    public String getGroupID() {
        return GroupID;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }

}
