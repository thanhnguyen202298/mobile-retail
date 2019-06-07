package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.ReportToProductView;
import com.ssk.retailshop.screen.report.ReportToTimeView;
import com.ssk.retailshop.screen.report.model.ReportToProductDTO;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class ReportToProductPresenter extends TiPresenter<ReportToProductView> implements ReportToProductListener {

    private ReportToProductView inView;
    private ReportToProductInterator interator;
    private Context context;

    public ReportToProductPresenter(Context ctx) {
        context = ctx;
        interator = new ReportToProductInteratorImpli();
    }

    public void getListReportToProduct() {
        interator.GetListReportToProduct(1, 100, this);
    }

    @Override
    public void onSuccess(List<ReportToProductDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void onAttachView(@NonNull ReportToProductView view) {
        super.onAttachView(view);
        inView = view;
        Log.e("<<<PRESSENTER : ", "ATTACH: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("<<<PRESSENTER : ", "destroy");
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
        Log.e("<<<PRESSENTER : ", "DDETACH");
    }
}
