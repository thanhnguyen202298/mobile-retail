package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.InventoryListDTO;

import java.util.List;

public interface InventoryListListener {
    void onSuccess(List<InventoryListDTO> list);
    void onError(String msg);
}
