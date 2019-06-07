package com.ssk.retailshop.screen.report.presenter;

public interface InventoryInterator {
    void getInventory(String fromDate, String toDate, InventoryListener listener);
}
