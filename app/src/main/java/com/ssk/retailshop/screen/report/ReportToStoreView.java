package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToStoreView extends TiView {
    void showData(List<ReportToStoreDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
