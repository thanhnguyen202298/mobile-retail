package com.ssk.retailshop.screen.report.model;

public class InventoryDTO {
    private int NhapHang;
    private int XuatHang;
    private int TonDau;
    private int TonHang;

    public InventoryDTO() {
    }

    public InventoryDTO(int nhapHang, int xuatHang, int tonDau, int tonHang) {
        NhapHang = nhapHang;
        XuatHang = xuatHang;
        TonDau = tonDau;
        TonHang = tonHang;
    }

    public int getNhapHang() {
        return NhapHang;
    }

    public void setNhapHang(int nhapHang) {
        NhapHang = nhapHang;
    }

    public int getXuatHang() {
        return XuatHang;
    }

    public void setXuatHang(int xuatHang) {
        XuatHang = xuatHang;
    }

    public int getTonDau() {
        return TonDau;
    }

    public void setTonDau(int tonDau) {
        TonDau = tonDau;
    }

    public int getTonHang() {
        return TonHang;
    }

    public void setTonHang(int tonHang) {
        TonHang = tonHang;
    }

}
