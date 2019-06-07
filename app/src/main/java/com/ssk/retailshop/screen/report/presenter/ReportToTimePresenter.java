package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.register.RegisterView;
import com.ssk.retailshop.screen.report.ReportToTimeView;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class ReportToTimePresenter  extends TiPresenter<ReportToTimeView> implements ReportToTimeListener {

    private ReportToTimeView inView;
    private ReportToTimeInteratorImpli interator;
    private Context context;

    public ReportToTimePresenter(Context ctx) {
        context = ctx;
        interator = new ReportToTimeInteratorImpli();
    }

    public void getListReportToTime(ReportToTimeDTO reportToTimeDTO) {
        interator.GetListReportToTime(reportToTimeDTO, this);
    }


    @Override
    protected void onAttachView(@NonNull ReportToTimeView view) {
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
    public void onSuccess(List<ReportToTimeDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {

    }
}
