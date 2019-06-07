package com.ssk.retailshop.screen.report.presenter;

public interface ProfitLossReportInterator {
    void GetListProfitLossReport(final String fromDate, final String toDate, final ProfitLossReportListener listener);
}
