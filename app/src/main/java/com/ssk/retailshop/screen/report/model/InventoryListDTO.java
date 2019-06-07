package com.ssk.retailshop.screen.report.model;

public class InventoryListDTO {
    private String TransDate;
    private String Code;
    private int NhapKho;
    private int XuatKho;
    private int TonHienTai;

    public InventoryListDTO() {
    }

    public InventoryListDTO(String transDate, String code, int nhapKho, int xuatKho, int tonHienTai) {
        TransDate = transDate;
        Code = code;
        NhapKho = nhapKho;
        XuatKho = xuatKho;
        TonHienTai = tonHienTai;
    }

    public String getTransDate() {
        return TransDate;
    }

    public void setTransDate(String transDate) {
        TransDate = transDate;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getNhapKho() {
        return NhapKho;
    }

    public void setNhapKho(int nhapKho) {
        NhapKho = nhapKho;
    }

    public int getXuatKho() {
        return XuatKho;
    }

    public void setXuatKho(int xuatKho) {
        XuatKho = xuatKho;
    }

    public int getTonHienTai() {
        return TonHienTai;
    }

    public void setTonHienTai(int tonHienTai) {
        TonHienTai = tonHienTai;
    }
}
