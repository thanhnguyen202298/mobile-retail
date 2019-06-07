package com.ssk.retailshop.screen.report.presenter;

public interface InventoryListInterator {
    void getInventoryList(int page, int pagesize, InventoryListListener listener);
}
