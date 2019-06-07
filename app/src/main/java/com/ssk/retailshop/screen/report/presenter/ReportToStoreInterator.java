package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.ReportToStoreView;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;

public interface ReportToStoreInterator {
    void getListReportToStore(final int page, final int pagesize, final ReportToStoreListener listener);
}
