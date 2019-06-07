package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.InventoryDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface InventoryView extends TiView {

    void showData(List<InventoryDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
