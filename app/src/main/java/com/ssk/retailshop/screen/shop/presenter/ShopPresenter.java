package com.ssk.retailshop.screen.shop.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.shop.ShopView;
import com.ssk.retailshop.screen.shop.model.RequestShop;

import net.grandcentrix.thirtyinch.TiPresenter;

public class ShopPresenter extends TiPresenter<ShopView> implements ShopListener {

    private ShopView inView;
    private ShopInterator interator;
    private Context context;

    public ShopPresenter(Context ctx) {
        context = ctx;
        interator = new ShopInteraterImpli();
    }

    public void doSave(RequestShop obj) {
        interator.Save(obj, this);
    }


    @Override
    protected void onAttachView(@NonNull ShopView view) {
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
    public void onGetDataSuccess(String msg) {
        inView.showMessage(msg);
    }

    @Override
    public void onGetDataError(String msg) {

    }
}