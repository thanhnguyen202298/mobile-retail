package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.ProfitLossReportView;
import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProfitLossReportPresenter extends TiPresenter<ProfitLossReportView> implements ProfitLossReportListener {

    private ProfitLossReportView inView;
    private ProfitLossReportInterator interator;
    private Context context;
    private List<ProfitLossReportItem> glist = new ArrayList<>();

    public ProfitLossReportPresenter(Context ctx) {
        context = ctx;
        interator = new ProfitLossReportInteraterImpli();
    }

    public void doGetListProfitLossReport(String fromDate, String toDate) {
        interator.GetListProfitLossReport(fromDate, toDate, this);
    }

    public void doSearch(String s){
        if(inView != null) {
            if(glist.size() > 0) {
                List<ProfitLossReportItem> list_search = new ArrayList<>();

                if (!s.trim().equals("")) {

                    for (ProfitLossReportItem item : glist
                    ) {
                        if (item.getStoreID().toLowerCase().trim().contains(s.toLowerCase())) {
                            list_search.add(item);
                        }
                    }

                    inView.showData(list_search);
                } else {
                    inView.showData(glist);
                }
            }
        }
    }

    @Override
    protected void onAttachView(@NonNull ProfitLossReportView view) {
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
    public void onGetDataSuccess(List<ProfitLossReportItem> list) {
        inView.showData(list);
    }


    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}