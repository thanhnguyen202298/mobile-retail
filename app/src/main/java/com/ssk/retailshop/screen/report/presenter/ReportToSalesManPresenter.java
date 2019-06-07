package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.ReportToSalesManView;
import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class ReportToSalesManPresenter extends TiPresenter<ReportToSalesManView> implements ReportToSalesManListener {
    private ReportToSalesManView inView;
    private ReportToSalesManInterator interator;
    private Context context;

    public ReportToSalesManPresenter(Context ctx) {
        context = ctx;
        interator = new ReportToSalesManInteratorImpli();
    }

    public void getListReportToSalesMan(ReportToSalesManDTO reportToSalesManDTO) {

        //region Call method get date from api
        interator.getListReportToSalesMan(1, 100, "", "", this);
        //endregion
    }


    @Override
    protected void onAttachView(@NonNull ReportToSalesManView view) {
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
    public void onSuccess(List<ReportToSalesManDTO> list) {

        //region Set data show for view (UI)
        inView.showData(list);
        //endregion
    }

    @Override
    public void onError(String msg) {
        //region Set data show for view (UI)
        inView.showMessage(msg);
        //endregion
    }

}
