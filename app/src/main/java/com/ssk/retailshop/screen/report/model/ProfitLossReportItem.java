package com.ssk.retailshop.screen.report.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfitLossReportItem extends Object {
    @SerializedName("StoreID")
    @Expose
    private String storeID;
    @SerializedName("DoanhThu")
    @Expose
    private Integer doanhThu;
    @SerializedName("TienGiamGia")
    @Expose
    private Integer tienGiamGia;
    @SerializedName("TienQuyDoi")
    @Expose
    private Integer tienQuyDoi;
    @SerializedName("TienTraHang")
    @Expose
    private Integer tienTraHang;
    @SerializedName("DoanhThuThuan")
    @Expose
    private Integer doanhThuThuan;
    @SerializedName("VonMuaHang")
    @Expose
    private Integer vonMuaHang;
    @SerializedName("LaiGop")
    @Expose
    private Integer laiGop;
    @SerializedName("ChiPhi")
    @Expose
    private Integer chiPhi;
    @SerializedName("LaiRong")
    @Expose
    private Integer laiRong;
    @SerializedName("TienGiamGiaDoanhThu")
    @Expose
    private Integer tienGiamGiaDoanhThu;
    @SerializedName("TienTraHangDoanhThu")
    @Expose
    private Integer tienTraHangDoanhThu;
    @SerializedName("LaiGopDoanhThu")
    @Expose
    private Integer laiGopDoanhThu;
    @SerializedName("LaiRongDoanhThu")
    @Expose
    private Integer laiRongDoanhThu;

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Integer getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(Integer doanhThu) {
        this.doanhThu = doanhThu;
    }

    public Integer getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(Integer tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

    public Integer getTienQuyDoi() {
        return tienQuyDoi;
    }

    public void setTienQuyDoi(Integer tienQuyDoi) {
        this.tienQuyDoi = tienQuyDoi;
    }

    public Integer getTienTraHang() {
        return tienTraHang;
    }

    public void setTienTraHang(Integer tienTraHang) {
        this.tienTraHang = tienTraHang;
    }

    public Integer getDoanhThuThuan() {
        return doanhThuThuan;
    }

    public void setDoanhThuThuan(Integer doanhThuThuan) {
        this.doanhThuThuan = doanhThuThuan;
    }

    public Integer getVonMuaHang() {
        return vonMuaHang;
    }

    public void setVonMuaHang(Integer vonMuaHang) {
        this.vonMuaHang = vonMuaHang;
    }

    public Integer getLaiGop() {
        return laiGop;
    }

    public void setLaiGop(Integer laiGop) {
        this.laiGop = laiGop;
    }

    public Integer getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Integer chiPhi) {
        this.chiPhi = chiPhi;
    }

    public Integer getLaiRong() {
        return laiRong;
    }

    public void setLaiRong(Integer laiRong) {
        this.laiRong = laiRong;
    }

    public Integer getTienGiamGiaDoanhThu() {
        return tienGiamGiaDoanhThu;
    }

    public void setTienGiamGiaDoanhThu(Integer tienGiamGiaDoanhThu) {
        this.tienGiamGiaDoanhThu = tienGiamGiaDoanhThu;
    }

    public Integer getTienTraHangDoanhThu() {
        return tienTraHangDoanhThu;
    }

    public void setTienTraHangDoanhThu(Integer tienTraHangDoanhThu) {
        this.tienTraHangDoanhThu = tienTraHangDoanhThu;
    }

    public Integer getLaiGopDoanhThu() {
        return laiGopDoanhThu;
    }

    public void setLaiGopDoanhThu(Integer laiGopDoanhThu) {
        this.laiGopDoanhThu = laiGopDoanhThu;
    }

    public Integer getLaiRongDoanhThu() {
        return laiRongDoanhThu;
    }

    public void setLaiRongDoanhThu(Integer laiRongDoanhThu) {
        this.laiRongDoanhThu = laiRongDoanhThu;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
