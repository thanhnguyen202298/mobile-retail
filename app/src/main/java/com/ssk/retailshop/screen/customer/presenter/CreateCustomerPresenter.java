package com.ssk.retailshop.screen.customer.presenter;

import android.content.Context;
import android.support.annotation.NonNull;


import com.ssk.retailshop.screen.customer.CreateCustomersView;
import com.ssk.retailshop.screen.customer.model.CreateCustomersDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

public class CreateCustomerPresenter extends TiPresenter<CreateCustomersView> implements CreateCustomersListener {

    CreateCustomersView registerView;
    private Context context;
    private CreateCustomersInterator interator;

    public CreateCustomerPresenter(Context ctx) {
        context = ctx;
        interator = new CreateCustomersInteratorImpli();
    }

    @Override
    public void onRegisterCustomersSuccess(String user) {
        registerView.onRegisterCustomersSuccess(user);
    }

    @Override
    public void onRegisterCustomersError(String msg) {
        registerView.onRegisterCustomersError(msg);
    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    protected void onAttachView(@NonNull CreateCustomersView view) {
        super.onAttachView(view);
        interator = new CreateCustomersInteratorImpli();
        registerView = view;
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
    }

    public void doRegisterCustomer(CreateCustomersDTO customerItem) {
        interator.createCustomers(customerItem, this);
    }
}
