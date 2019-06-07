package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

public interface ReportToTimeInterator {
    void GetListReportToTime(final ReportToTimeDTO reportToTimeDTO, final ReportToTimeListener listener);
}
