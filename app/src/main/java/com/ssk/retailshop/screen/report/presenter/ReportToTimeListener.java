package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToTimeListener extends TiView {
    void onSuccess(List<ReportToTimeDTO> list);
    void onError(String msg);
}
