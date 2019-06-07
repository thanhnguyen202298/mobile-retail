package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.screen.report.model.ReportFragmentDTO;

import java.util.List;

public interface ReportFragmentListener {
    void onSuccess(List<ReportFragmentDTO> list);
    void onError(String msg);
}
