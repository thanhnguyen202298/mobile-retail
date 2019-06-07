package com.ssk.retailshop.screen.report.presenter;


import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;

import java.util.List;

public interface ProfitLossReportListener {
    void onGetDataSuccess(List<ProfitLossReportItem> list);
    void onGetDataError(String msg);
}
