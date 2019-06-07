package com.ssk.retailshop.screen.money.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.money.ReceiptMoneyView;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class ReceiptMoneyPresenter extends TiPresenter<ReceiptMoneyView> implements ReceiptMoneyListener {

    private ReceiptMoneyView inView;
    private ReceiptMoneyInterator interator;
    private Context context;

    public ReceiptMoneyPresenter(Context ctx) {
        context = ctx;
        interator = new ReceiptMoneyInteraterImpli();
    }

    public void doGetReceiptMoney(int page, int pagesize, String search) {
        interator.GetListReceiptMoney(page, pagesize, search, this);
    }


    @Override
    protected void onAttachView(@NonNull ReceiptMoneyView view) {
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
    public void onGetDataSuccess(List<ReceiptMoneyItem> list) {
        inView.showData(list);
    }

    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}