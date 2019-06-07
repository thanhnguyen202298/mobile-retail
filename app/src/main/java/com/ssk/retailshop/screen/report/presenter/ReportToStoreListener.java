package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReportToStoreListener extends TiView {
    void onSuccess(List<ReportToStoreDTO> list);
    void onError(String msg);
}
