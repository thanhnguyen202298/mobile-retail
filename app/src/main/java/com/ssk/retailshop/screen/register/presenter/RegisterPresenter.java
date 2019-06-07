package com.ssk.retailshop.screen.register.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

public class RegisterPresenter extends TiPresenter<RegisterListener> implements RegisterListener {

    RegisterListener registerView;
    private Context context;
    private RegisterInterator interator;
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
    protected void onAttachView(@NonNull RegisterListener view) {
        super.onAttachView(view);
        interator = new RegisterInteraterImpli();
        registerView = view;
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
    }

    public void doRegister(UserRegisterDTO usn) {
        interator.Register(usn, this);
    }
}
