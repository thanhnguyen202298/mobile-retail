package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.InventoryDTO;

import java.util.List;

public interface InventoryListener {
    void onSuccess(List<InventoryDTO> list);
    void onError(String msg);
}
