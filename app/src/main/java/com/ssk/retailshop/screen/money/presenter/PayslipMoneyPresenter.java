package com.ssk.retailshop.screen.money.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.money.PayslipMoneyView;
import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class PayslipMoneyPresenter extends TiPresenter<PayslipMoneyView> implements PayslipMoneyListener {

    private PayslipMoneyView inView;
    private PayslipMoneyInterator interator;
    private Context context;

    public PayslipMoneyPresenter(Context ctx) {
        context = ctx;
        interator = new PayslipMoneyInteraterImpli();
    }

    public void doGetPayslipMoney(int page, int pagesize, String search) {
        interator.GetListPayslipMoney(page, pagesize, search, this);
    }


    @Override
    protected void onAttachView(@NonNull PayslipMoneyView view) {
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
    public void onGetDataSuccess(List<PayslipMoneyItem> list) {
        inView.showData(list);
    }

    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}