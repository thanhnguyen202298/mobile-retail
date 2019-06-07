package com.ssk.retailshop.screen.customer.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerItem extends Object {
    @SerializedName("CusID")
    @Expose
    private String cusID;
    @SerializedName("StoreID")
    @Expose
    private String storeID;
    @SerializedName("CusCode")
    @Expose
    private String cusCode;
    @SerializedName("CusName")
    @Expose
    private String cusName;
    @SerializedName("CusBirthday")
    @Expose
    private String cusBirthday;
    @SerializedName("Phone")
    @Expose
    private Object phone;
    @SerializedName("CellPhone")
    @Expose
    private Object cellPhone;
    @SerializedName("Email")
    @Expose
    private Object email;
    @SerializedName("SEX")
    @Expose
    private Integer sEX;
    @SerializedName("Address")
    @Expose
    private Object address;
    @SerializedName("CusType")
    @Expose
    private Integer cusType;
    @SerializedName("CusCreated")
    @Expose
    private String cusCreated;
    @SerializedName("GroupCusID")
    @Expose
    private Integer groupCusID;
    @SerializedName("GroupCusTitle")
    @Expose
    private Object groupCusTitle;
    @SerializedName("GroupCusParentID")
    @Expose
    private Integer groupCusParentID;
    @SerializedName("PaymentDate")
    @Expose
    private Object paymentDate;
    @SerializedName("TotalPrice")
    @Expose
    private Integer totalPrice;
    @SerializedName("CusPayment")
    @Expose
    private Integer cusPayment;
    @SerializedName("Debt")
    @Expose
    private Integer debt;

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(String cusBirthday) {
        this.cusBirthday = cusBirthday;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Object cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Integer getSEX() {
        return sEX;
    }

    public void setSEX(Integer sEX) {
        this.sEX = sEX;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Integer getCusType() {
        return cusType;
    }

    public void setCusType(Integer cusType) {
        this.cusType = cusType;
    }

    public String getCusCreated() {
        return cusCreated;
    }

    public void setCusCreated(String cusCreated) {
        this.cusCreated = cusCreated;
    }

    public Integer getGroupCusID() {
        return groupCusID;
    }

    public void setGroupCusID(Integer groupCusID) {
        this.groupCusID = groupCusID;
    }

    public Object getGroupCusTitle() {
        return groupCusTitle;
    }

    public void setGroupCusTitle(Object groupCusTitle) {
        this.groupCusTitle = groupCusTitle;
    }

    public Integer getGroupCusParentID() {
        return groupCusParentID;
    }

    public void setGroupCusParentID(Integer groupCusParentID) {
        this.groupCusParentID = groupCusParentID;
    }

    public Object getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Object paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCusPayment() {
        return cusPayment;
    }

    public void setCusPayment(Integer cusPayment) {
        this.cusPayment = cusPayment;
    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
