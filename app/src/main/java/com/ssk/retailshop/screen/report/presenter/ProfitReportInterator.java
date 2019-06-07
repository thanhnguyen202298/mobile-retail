package com.ssk.retailshop.screen.report.presenter;

public interface ProfitReportInterator {
    void GetListProfitReport(final int page, final int pagesize, final String fromdate, final String todate, final ProfitReportListener listener);
}
