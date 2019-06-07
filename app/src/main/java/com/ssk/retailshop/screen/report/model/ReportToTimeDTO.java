package com.ssk.retailshop.screen.report.model;

public class ReportToTimeDTO {

    private String BillId;
    private String ReceiptID;
    private String BCreated;
    private int Qty;
    private double Price;
    private String Customername;
    private String ID;
    private String StoreID;
    private double DoanhSo;
    private double ThucThu;
    private double TienTra;

    public ReportToTimeDTO() {
    }

    public ReportToTimeDTO(String billId, String receiptID, String BCreated, int qty, double price, String customername, String ID, String storeID, double doanhSo, double thucThu, double tienTra) {
        BillId = billId;
        ReceiptID = receiptID;
        this.BCreated = BCreated;
        Qty = qty;
        Price = price;
        Customername = customername;
        this.ID = ID;
        StoreID = storeID;
        DoanhSo = doanhSo;
        ThucThu = thucThu;
        TienTra = tienTra;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public String getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(String receiptID) {
        ReceiptID = receiptID;
    }

    public String getBCreated() {
        return BCreated;
    }

    public void setBCreated(String BCreated) {
        this.BCreated = BCreated;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public double getThucThu() {
        return ThucThu;
    }

    public void setThucThu(double thucThu) {
        ThucThu = thucThu;
    }

    public double getTienTra() {
        return TienTra;
    }

    public void setTienTra(double tienTra) {
        TienTra = tienTra;
    }

    @Override
    public String toString() {
        return "ReportToTimeDTO{" +
                "BillId='" + BillId + '\'' +
                ", ReceiptID='" + ReceiptID + '\'' +
                ", BCreated='" + BCreated + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", Customername='" + Customername + '\'' +
                ", ID='" + ID + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", DoanhSo=" + DoanhSo +
                ", ThucThu=" + ThucThu +
                ", TienTra=" + TienTra +
                '}';
    }
}
