package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.ProfitReportView;
import com.ssk.retailshop.screen.report.model.ProfitReportItem;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProfitReportPresenter extends TiPresenter<ProfitReportView> implements ProfitReportListener {

    private ProfitReportView inView;
    private ProfitReportInterator interator;
    private Context context;
    private List<ProfitReportItem> glist = new ArrayList<>();

    public ProfitReportPresenter(Context ctx) {
        context = ctx;
        interator = new ProfitReportInteraterImpli();
    }

    public void doGetListProfitReport(int page, int pagesize, String fromdate, String todate) {
        interator.GetListProfitReport(page, pagesize, fromdate, todate, this);
    }

    public void doSearch(String s){
        List<ProfitReportItem> list_search = new ArrayList<>();

        if(!s.trim().equals("")) {

            for (ProfitReportItem item : glist
            ) {
                if (item.getProductTitle().toLowerCase().trim().contains(s.toLowerCase())) {
                    list_search.add(item);
                }
            }

            inView.showData(list_search);
        } else {
            inView.showData(glist);
        }
    }

    @Override
    protected void onAttachView(@NonNull ProfitReportView view) {
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

    @Override
    public void onGetDataSuccess(List<ProfitReportItem> list) {
        glist = list;
        inView.showData(list);
    }

    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}