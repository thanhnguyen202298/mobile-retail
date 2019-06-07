package com.ssk.retailshop.screen.report.model;

public class ReportToSalesManDTO {
    private String EmployeeId;
    private double DoanhSo;
    private double CusPayment;
    private int SLDonHang;
    private String Code;
    private String FullName;
    private String StoreID;
    private int SLHang;
    private int SLTra;
    private int SLHangTra;

    public ReportToSalesManDTO() {
    }

    public ReportToSalesManDTO(String employeeId, double doanhSo, double cusPayment, int SLDonHang, String code, String fullName, String storeID, int SLHang, int SLTra, int SLHangTra) {
        EmployeeId = employeeId;
        DoanhSo = doanhSo;
        CusPayment = cusPayment;
        this.SLDonHang = SLDonHang;
        Code = code;
        FullName = fullName;
        StoreID = storeID;
        this.SLHang = SLHang;
        this.SLTra = SLTra;
        this.SLHangTra = SLHangTra;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
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

    public int getSLDonHang() {
        return SLDonHang;
    }

    public void setSLDonHang(int SLDonHang) {
        this.SLDonHang = SLDonHang;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public int getSLHang() {
        return SLHang;
    }

    public void setSLHang(int SLHang) {
        this.SLHang = SLHang;
    }

    public int getSLTra() {
        return SLTra;
    }

    public void setSLTra(int SLTra) {
        this.SLTra = SLTra;
    }

    public int getSLHangTra() {
        return SLHangTra;
    }

    public void setSLHangTra(int SLHangTra) {
        this.SLHangTra = SLHangTra;
    }
}
