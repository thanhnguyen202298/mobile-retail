package com.ssk.retailshop.screen.money.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.money.CreatePayslipMoneyView;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

import net.grandcentrix.thirtyinch.TiPresenter;

public class CreatePayslipMoneyPresenter extends TiPresenter<CreatePayslipMoneyView> implements CreatePayslipMoneyListener {

    private CreatePayslipMoneyView inView;
    private CreatePayslipMoneyInterater interator;
    private Context context;

    public CreatePayslipMoneyPresenter(Context context) {

        this.context = context;
        interator = new CreatePayslipMoneyInteraterImpli();
    }


    public void createPayslipMoney(UserRegisterDTO userRegisterDTO) {
        interator.CreatePayslipMoneyInterater(userRegisterDTO, this);
    }

    @Override
    protected void onAttachView(@NonNull CreatePayslipMoneyView view) {
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
    public void onSuccess(String list) {
        inView.showData(list);
    }

    @Override
    public void onError(String msg) {
        inView.showMessage(msg);
    }
}
