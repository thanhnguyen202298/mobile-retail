package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.ReportToProductDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToProductView extends TiView {
    void showData(List<ReportToProductDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
