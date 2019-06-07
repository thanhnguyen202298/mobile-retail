package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;

import java.util.List;

public interface ReportToSalesManListener {
    void onSuccess(List<ReportToSalesManDTO> list);
    void onError(String msg);
}
