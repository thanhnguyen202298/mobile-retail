package com.ssk.retailshop.screen.report.presenter;


import com.ssk.retailshop.screen.report.model.ProfitReportItem;

import java.util.List;

public interface ProfitReportListener {
    void onGetDataSuccess(List<ProfitReportItem> list);
    void onGetDataError(String msg);
}
