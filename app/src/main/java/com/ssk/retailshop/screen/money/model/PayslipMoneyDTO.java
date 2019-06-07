package com.ssk.retailshop.screen.money.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

public class PayslipMoneyDTO extends BaseObservable {

    @SerializedName("Email")
    String stylePaySlip;
    @SerializedName("Password")
    String datePayment;
    @SerializedName("AccountName")
    String receiver;
    @SerializedName("Phone")
    String totalMoney;
    @SerializedName("Address")
    String address;
    @SerializedName("Number")
    String numberCast;

    public PayslipMoneyDTO(String stylePaySlip, String datePayment, String receiver, String totalMoney, String address, String numberCast) {
        this.stylePaySlip = stylePaySlip;
        this.datePayment = datePayment;
        this.receiver = receiver;
        this.totalMoney = totalMoney;
        this.address = address;
        this.numberCast = numberCast;
    }

    public String getStylePaySlip() {
        return stylePaySlip;
    }

    public void setStylePaySlip(String stylePaySlip) {
        this.stylePaySlip = stylePaySlip;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberCast() {
        return numberCast;
    }

    public void setNumberCast(String numberCast) {
        this.numberCast = numberCast;
    }

    @Override
    public String toString() {
        return "PayslipMoneyDTO{" +
                "stylePaySlip='" + stylePaySlip + '\'' +
                ", datePayment='" + datePayment + '\'' +
                ", receiver='" + receiver + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                ", address='" + address + '\'' +
                ", numberCast='" + numberCast + '\'' +
                '}';
    }
}
