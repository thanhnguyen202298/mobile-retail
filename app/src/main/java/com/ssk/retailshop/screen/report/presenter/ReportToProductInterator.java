package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportToProductDTO;

public interface ReportToProductInterator  {

    void GetListReportToProduct(final int page, final int pagesize, final ReportToProductListener listener);
}
