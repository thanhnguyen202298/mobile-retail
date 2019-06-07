package com.ssk.retailshop.screen.report;


import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToTimeView extends TiView {

    void showData(List<ReportToTimeDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
