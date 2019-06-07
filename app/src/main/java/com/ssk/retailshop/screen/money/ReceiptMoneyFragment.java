package com.ssk.retailshop.screen.money;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;
import com.ssk.retailshop.screen.money.presenter.ReceiptMoneyPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class ReceiptMoneyFragment extends TiFragment<ReceiptMoneyPresenter, ReceiptMoneyView> implements ReceiptMoneyView {

    Context context;
    RecyclerView recyclerview_list;
    EditText edit_search;

    MyAdapter myAdapter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_receiptmoney, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getContext();
        edit_search = view.findViewById(R.id.edit_search);
        recyclerview_list = view.findViewById(R.id.recyclerview_list);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        GetListReceiptMoney("");

        edit_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_MASK_ACTION) == EditorInfo.IME_ACTION_DONE) {
                    GetListReceiptMoney(edit_search.getText().toString());
                    return true;
                }
                return false;

            }
        });

    }

    @Override
    public void showData(List<ReceiptMoneyItem> list) {

        if(list == null) {
            list = new ArrayList<>();

            list.add(new ReceiptMoneyItem("111", "12/01/2019", "Đàm công", "6,000"));
            list.add(new ReceiptMoneyItem("112", "13/01/2019", "Đàm phụ", "6,000"));
            list.add(new ReceiptMoneyItem("113", "14/01/2019", "Đàm nhân", "6,000"));

        }

        myAdapter = new MyAdapter(context, R.layout.item_fragment_receiptmoney, 4, BR.ReceiptMoneyItem, 0);
        myAdapter.setData((ArrayList)list);
        recyclerview_list.setAdapter(myAdapter);

        SwitchDialog();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public ReceiptMoneyPresenter providePresenter() {
        return new ReceiptMoneyPresenter(context);
    }

    private void GetListReceiptMoney(String search){
        SwitchDialog();
        getPresenter().doGetReceiptMoney(1,10,search);
    }

    private void SwitchDialog(){

        if(progressDialog == null){
            progressDialog = ProgressDialog.show(context,"", "Loading...", true, false);
        } else {
            if(!progressDialog.isShowing()){
                progressDialog = ProgressDialog.show(context,"", "Loading...", true,false);
            } else {
                progressDialog.dismiss();
            }
        }
    }
}
