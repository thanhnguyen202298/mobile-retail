package com.ssk.retailshop.screen.order;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.screen.order.model.OrderItem;
import com.ssk.retailshop.screen.order.presenter.OrderListPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderListFragment extends TiFragment<OrderListPresenter, OrderListView> implements OrderListView {

    Context context;
    RecyclerView recyclerview_list;
    EditText edit_search;


    MyAdapter myAdapter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_order, null);
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
        GetListOrder();

        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void Search(String s){
        SwitchDialog(true);
        getPresenter().doSearch(s);
    }

    private void GetListOrder(){
        SwitchDialog(true);
        getPresenter().doGetListOrderList(1,20,"", "");
    }

    private void SwitchDialog(boolean ON){

        if(progressDialog == null){
            progressDialog = ProgressDialog.show(context,"", "Loading...", true, false);
        } else {

            if(ON){
                if(!progressDialog.isShowing())
                    progressDialog = ProgressDialog.show(context,"", "Loading...", true,false);
            } else {
                if(progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        }
    }

    @Override
    public void showData(List<OrderItem> list) {
        /*List<OrderItem> items = Arrays.asList(
                new OrderItem("B1903260028", "27/3/2019", "Bán hàng", "2,359,000"),
                new OrderItem("B1903260027", "21/3/2019", "Bán hàng", "2,237,000"),
                new OrderItem("B1903260026", "19/3/2019", "Trả hàng", "1,353,000"));*/

        if(list == null) {
            list = new ArrayList<>();
        }

        myAdapter = new MyAdapter(context, R.layout.item_fragment_order, 4, BR.OrderItem, 0);
        myAdapter.setData((ArrayList)list);
        recyclerview_list.setAdapter(myAdapter);

        SwitchDialog(false);
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public OrderListPresenter providePresenter() {
        return new OrderListPresenter(context);
    }
}
