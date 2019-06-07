package com.ssk.retailshop.screen.report;
import com.ssk.retailshop.screen.report.model.ProfitReportItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ProfitReportView extends TiView {
    void showData(List<ProfitReportItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
