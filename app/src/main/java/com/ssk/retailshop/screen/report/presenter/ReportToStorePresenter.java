package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.ReportToStoreView;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class ReportToStorePresenter extends TiPresenter<ReportToStoreView> implements ReportToStoreListener{
    private ReportToStoreView inView;
    private ReportToStoreInteratorImpli interator;
    private Context context;

    @Override
    protected void onAttachView(@NonNull ReportToStoreView view) {
        super.onAttachView(view);
        inView = view;
        Log.e("<<<PRESSENTER : ", "ATTACH: ");
    }

    public ReportToStorePresenter(Context ctx) {
        context = ctx;
        interator = new ReportToStoreInteratorImpli();
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

    @Override
    public void onSuccess(List<ReportToStoreDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {

    }

    public void getListReportToStore() {
        interator.getListReportToStore(1, 100, this);
    }
}
