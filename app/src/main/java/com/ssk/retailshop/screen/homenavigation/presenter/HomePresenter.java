package com.ssk.retailshop.screen.homenavigation.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;
import com.ssk.retailshop.screen.register.presenter.RegisterInteraterImpli;
import com.ssk.retailshop.screen.register.presenter.RegisterInterator;
import com.ssk.retailshop.screen.register.presenter.RegisterListener;

import net.grandcentrix.thirtyinch.TiPresenter;

public class HomePresenter extends TiPresenter<HomeListener> implements HomeListener {

    HomeListener registerView;
    private Context context;
    private HomeInterator interator;
    @Override
    public void onRegisterSuccess(String user) {
        registerView.onRegisterSuccess(user);

    }

    @Override
    public void onRegisterError(String msg) {

    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    protected void onAttachView(@NonNull HomeListener view) {
        super.onAttachView(view);
        interator = new HomeInteraterImpli();
        registerView = view;
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
    }

    public void doRegister(String usn) {
        interator = new HomeInteraterImpli();
        interator.Home(usn, this);
    }
}
