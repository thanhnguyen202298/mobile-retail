package com.ssk.retailshop.screen.report.model;

public class ReportToProductDTO {
    private String StoreID;
    private double DoanhSo;
    private int SLbill;
    private double Tientrahang;
    private String Code;
    private String Title;
    private String productId;
    private int SLTra;

    public ReportToProductDTO() {
    }

    public ReportToProductDTO(String storeID, double doanhSo, int SLbill, double tientrahang, String code, String title, String productId, int SLTra) {
        StoreID = storeID;
        DoanhSo = doanhSo;
        this.SLbill = SLbill;
        Tientrahang = tientrahang;
        Code = code;
        Title = title;
        this.productId = productId;
        this.SLTra = SLTra;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public double getDoanhSo() {
        return DoanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        DoanhSo = doanhSo;
    }

    public int getSLbill() {
        return SLbill;
    }

    public void setSLbill(int SLbill) {
        this.SLbill = SLbill;
    }

    public double getTientrahang() {
        return Tientrahang;
    }

    public void setTientrahang(double tientrahang) {
        Tientrahang = tientrahang;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getSLTra() {
        return SLTra;
    }

    public void setSLTra(int SLTra) {
        this.SLTra = SLTra;
    }

    @Override
    public String toString() {
        return "ReportToProductDTO{" +
                "StoreID='" + StoreID + '\'' +
                ", DoanhSo=" + DoanhSo +
                ", SLbill=" + SLbill +
                ", Tientrahang=" + Tientrahang +
                ", Code='" + Code + '\'' +
                ", Title='" + Title + '\'' +
                ", productId='" + productId + '\'' +
                ", SLTra=" + SLTra +
                '}';
    }
}
