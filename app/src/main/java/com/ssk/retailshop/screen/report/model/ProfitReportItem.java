package com.ssk.retailshop.screen.report.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfitReportItem extends Object {
    @SerializedName("ProductTitle")
    @Expose
    private String productTitle;
    @SerializedName("CategoryId")
    @Expose
    private String categoryId;
    @SerializedName("StoreID")
    @Expose
    private String storeID;
    @SerializedName("TienHang")
    @Expose
    private Integer tienHang;
    @SerializedName("KhuyenMai")
    @Expose
    private Integer khuyenMai;
    @SerializedName("DoanhSo")
    @Expose
    private Integer doanhSo;
    @SerializedName("TraHang")
    @Expose
    private Integer traHang;
    @SerializedName("TienVon")
    @Expose
    private Integer tienVon;
    @SerializedName("LaiGop")
    @Expose
    private Integer laiGop;

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Integer getTienHang() {
        return tienHang;
    }

    public void setTienHang(Integer tienHang) {
        this.tienHang = tienHang;
    }

    public Integer getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Integer khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public Integer getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(Integer doanhSo) {
        this.doanhSo = doanhSo;
    }

    public Integer getTraHang() {
        return traHang;
    }

    public void setTraHang(Integer traHang) {
        this.traHang = traHang;
    }

    public Integer getTienVon() {
        return tienVon;
    }

    public void setTienVon(Integer tienVon) {
        this.tienVon = tienVon;
    }

    public Integer getLaiGop() {
        return laiGop;
    }

    public void setLaiGop(Integer laiGop) {
        this.laiGop = laiGop;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
