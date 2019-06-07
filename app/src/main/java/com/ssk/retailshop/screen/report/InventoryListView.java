package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.InventoryListDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface InventoryListView extends TiView {

    void showData(List<InventoryListDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
