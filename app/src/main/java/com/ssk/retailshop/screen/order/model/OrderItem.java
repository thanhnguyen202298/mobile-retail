package com.ssk.retailshop.screen.order.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem extends Object {
    @SerializedName("BillID")
    @Expose
    private String billID;
    @SerializedName("BillStatus")
    @Expose
    private Integer billStatus;
    @SerializedName("BillBarCode")
    @Expose
    private String billBarCode;
    @SerializedName("BillCreated")
    @Expose
    private String billCreated;
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
    @SerializedName("CusID")
    @Expose
    private Object cusID;
    @SerializedName("TotalPrice")
    @Expose
    private Integer totalPrice;
    @SerializedName("IsDebit")
    @Expose
    private Boolean isDebit;
    @SerializedName("AmountVat")
    @Expose
    private Integer amountVat;
    @SerializedName("DiscPercent")
    @Expose
    private Integer discPercent;
    @SerializedName("DebtMoney")
    @Expose
    private Integer debtMoney;
    @SerializedName("PaymentedMoney")
    @Expose
    private Integer paymentedMoney;
    @SerializedName("StatusName")
    @Expose
    private String statusName;
    @SerializedName("CusName")
    @Expose
    private String cusName;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Created")
    @Expose
    private Object created;
    @SerializedName("CreatedBy")
    @Expose
    private Object createdBy;
    @SerializedName("Modify")
    @Expose
    private Object modify;
    @SerializedName("ModifyBy")
    @Expose
    private Object modifyBy;

    public String getColor() {
        return color = color == null ? "#B21F39" : "#FFFFFF";
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillBarCode() {
        return billBarCode;
    }

    public void setBillBarCode(String billBarCode) {
        this.billBarCode = billBarCode;
    }

    public String getBillCreated() {
        return billCreated;
    }

    public void setBillCreated(String billCreated) {
        this.billCreated = billCreated;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Object getCusID() {
        return cusID;
    }

    public void setCusID(Object cusID) {
        this.cusID = cusID;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getIsDebit() {
        return isDebit;
    }

    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }

    public Integer getAmountVat() {
        return amountVat;
    }

    public void setAmountVat(Integer amountVat) {
        this.amountVat = amountVat;
    }

    public Integer getDiscPercent() {
        return discPercent;
    }

    public void setDiscPercent(Integer discPercent) {
        this.discPercent = discPercent;
    }

    public Integer getDebtMoney() {
        return debtMoney;
    }

    public void setDebtMoney(Integer debtMoney) {
        this.debtMoney = debtMoney;
    }

    public Integer getPaymentedMoney() {
        return paymentedMoney;
    }

    public void setPaymentedMoney(Integer paymentedMoney) {
        this.paymentedMoney = paymentedMoney;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getModify() {
        return modify;
    }

    public void setModify(Object modify) {
        this.modify = modify;
    }

    public Object getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Object modifyBy) {
        this.modifyBy = modifyBy;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
