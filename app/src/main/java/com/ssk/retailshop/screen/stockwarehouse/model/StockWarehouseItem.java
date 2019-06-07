package com.ssk.retailshop.screen.stockwarehouse.model;

import android.support.annotation.NonNull;

public class StockWarehouseItem extends Object {
    private String ItemCode;
    private String ItemName;
    private String GoodsIssue;
    private String Stock;

    public StockWarehouseItem(String itemCode, String itemName, String goodsIssue, String stock) {
        ItemCode = itemCode;
        ItemName = itemName;
        GoodsIssue = goodsIssue;
        Stock = stock;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getGoodsIssue() {
        return GoodsIssue;
    }

    public void setGoodsIssue(String goodsIssue) {
        GoodsIssue = goodsIssue;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
