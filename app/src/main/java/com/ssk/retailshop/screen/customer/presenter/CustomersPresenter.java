package com.ssk.retailshop.screen.customer.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.model.UserInfo;
import com.ssk.retailshop.screen.customer.CustomersView;
import com.ssk.retailshop.screen.customer.model.CustomerItem;
import com.ssk.retailshop.screen.home.LoginView;
import com.ssk.retailshop.screen.home.model.UserInPrefs;
import com.ssk.retailshop.screen.home.model.UserLogin;
import com.ssk.retailshop.screen.home.presenter.LoginInteraterImpli;
import com.ssk.retailshop.screen.home.presenter.LoginInterator;
import com.ssk.retailshop.screen.home.presenter.LoginListener;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.List;

public class CustomersPresenter extends TiPresenter<CustomersView> implements CustomersListener {

    private CustomersView inView;
    private CustomersInterator interator;
    private Context context;

    public CustomersPresenter(Context ctx) {
        context = ctx;
        interator = new CustomersInteraterImpli();
    }

    public void doGetListCustomer(int page, int pagesize, String search) {
        interator.GetListCustomer(page, pagesize, search, this);
    }


    @Override
    protected void onAttachView(@NonNull CustomersView view) {
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
    public void onGetDataSuccess(List<CustomerItem> list) {
        inView.showData(list);
    }

    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}