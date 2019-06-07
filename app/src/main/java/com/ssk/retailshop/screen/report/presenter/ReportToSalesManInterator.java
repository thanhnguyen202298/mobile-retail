package com.ssk.retailshop.screen.report.presenter;

public interface ReportToSalesManInterator {
    void getListReportToSalesMan(final int page, final int pagesize, final String from, final String to, final ReportToSalesManListener listener);
}
