package com.ssk.retailshop.screen.product.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.product.FragmentProductView;
import com.ssk.retailshop.screen.product.model.FragmentProductDTO;


import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class FragmentProductPresenter extends TiPresenter<FragmentProductView> implements FragmentProductListener {

    private FragmentProductView inView;
    private FragmentProductInterator interator;
    private Context context;


    public FragmentProductPresenter(Context ctx) {
        context = ctx;
        interator = new FragmentProductInteratorImpli();
    }

    public void getListProductDTO() {
        interator.getListProductDTO(1, 20, this);
    }


    @Override
    protected void onAttachView(@NonNull FragmentProductView view) {
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
    public void onSuccess(List<FragmentProductDTO> list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {
        inView.showMessage(msg);

    }


}
