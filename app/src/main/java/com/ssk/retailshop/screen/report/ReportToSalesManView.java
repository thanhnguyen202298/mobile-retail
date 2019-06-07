package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToSalesManView extends TiView {
    void showData(List<ReportToSalesManDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
