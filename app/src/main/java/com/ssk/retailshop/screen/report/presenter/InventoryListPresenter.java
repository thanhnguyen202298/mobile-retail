package com.ssk.retailshop.screen.report.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.report.InventoryListView;
import com.ssk.retailshop.screen.report.model.InventoryListDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class InventoryListPresenter extends TiPresenter<InventoryListView> implements InventoryListListener{

    private InventoryListView inView;
    private InventoryListInterator interator;
    private Context context;


    public InventoryListPresenter(Context ctx) {
        context = ctx;
        interator = new InventoryListInteratorImpli();
    }

    public void getListInventoryList() {
        interator.getInventoryList(1, 20, this);
    }


    @Override
    protected void onAttachView(@NonNull InventoryListView view) {
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
    public void onSuccess(List<InventoryListDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {

    }
}
