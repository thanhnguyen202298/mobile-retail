package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.report.InventoryView;
import com.ssk.retailshop.screen.report.model.InventoryDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class InventoryPresenter extends TiPresenter<InventoryView> implements InventoryListener {

    private InventoryView inView;
    private InventoryInterator interator;
    private Context context;

    public InventoryPresenter(Context ctx) {
        context = ctx;
        interator = new InventoryInteratorImpli();
    }

    public void getInventory(String fromDate, String toDate) {
        interator.getInventory(fromDate, toDate, this);
    }


    @Override
    protected void onAttachView(@NonNull InventoryView view) {
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
    public void onSuccess(List<InventoryDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {

    }
}
