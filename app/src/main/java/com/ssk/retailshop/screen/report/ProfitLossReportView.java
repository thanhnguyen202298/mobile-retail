package com.ssk.retailshop.screen.report;

import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ProfitLossReportView extends TiView {
    void showData(List<ProfitLossReportItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
