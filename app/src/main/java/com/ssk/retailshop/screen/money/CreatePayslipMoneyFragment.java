package com.ssk.retailshop.screen.money;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.R;
import com.ssk.retailshop.screen.money.presenter.CreatePayslipMoneyPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

public class CreatePayslipMoneyFragment extends TiFragment<CreatePayslipMoneyPresenter, CreatePayslipMoneyView> implements CreatePayslipMoneyView{

    Context context;
    Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context = getContext();
        return inflater.inflate(R.layout.activity_pay_ment, null);
    }

    @Override
    public void showData(String list) {
        showUpdateDialogNotCancel(list);

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public CreatePayslipMoneyPresenter providePresenter() {
        return null;
    }

    private void showUpdateDialogNotCancel(String lst) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(lst);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        dialog = builder.show();
    }
}
