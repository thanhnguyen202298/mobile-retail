package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportToProductDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToProductListener extends TiView {
    void onSuccess(List<ReportToProductDTO> list);

    void onError(String msg);
}
