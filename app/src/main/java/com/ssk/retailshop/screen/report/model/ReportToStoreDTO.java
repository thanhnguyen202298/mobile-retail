package com.ssk.retailshop.screen.report.model;

public class ReportToStoreDTO {
    private String StoreID;
    private double DoanhSo;
    private double CusPayment;
    private int SLHang;
    private int SLDonHang;
    private int SLHangTra;
    private double Tientrahang;
    private String FullName;
    private String Title;
    private String UserID;
    private int SLTra;

    public ReportToStoreDTO() {
    }

    public ReportToStoreDTO(String storeID, double doanhSo, double cusPayment, int SLHang, int SLDonHang, int SLHangTra, double tientrahang, String fullName, String title, String userID, int SLTra) {
        StoreID = storeID;
        DoanhSo = doanhSo;
        CusPayment = cusPayment;
        this.SLHang = SLHang;
        this.SLDonHang = SLDonHang;
        this.SLHangTra = SLHangTra;
        Tientrahang = tientrahang;
        FullName = fullName;
        Title = title;
        UserID = userID;
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

    public double getCusPayment() {
        return CusPayment;
    }

    public void setCusPayment(double cusPayment) {
        CusPayment = cusPayment;
    }

    public int getSLHang() {
        return SLHang;
    }

    public void setSLHang(int SLHang) {
        this.SLHang = SLHang;
    }

    public int getSLDonHang() {
        return SLDonHang;
    }

    public void setSLDonHang(int SLDonHang) {
        this.SLDonHang = SLDonHang;
    }

    public int getSLHangTra() {
        return SLHangTra;
    }

    public void setSLHangTra(int SLHangTra) {
        this.SLHangTra = SLHangTra;
    }

    public double getTientrahang() {
        return Tientrahang;
    }

    public void setTientrahang(double tientrahang) {
        Tientrahang = tientrahang;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public int getSLTra() {
        return SLTra;
    }

    public void setSLTra(int SLTra) {
        this.SLTra = SLTra;
    }
}
