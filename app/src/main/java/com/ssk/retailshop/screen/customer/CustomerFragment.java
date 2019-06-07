package com.ssk.retailshop.screen.customer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.screen.customer.model.CustomerItem;
import com.ssk.retailshop.screen.customer.presenter.CustomersPresenter;
import com.ssk.retailshop.screen.home.LoginView;
import com.ssk.retailshop.screen.login_qlnv.presenter.LoginPresenterQLnv;
import com.ssk.retailshop.screen.order.model.OrderItem;

import net.grandcentrix.thirtyinch.TiActivity;
import net.grandcentrix.thirtyinch.TiFragment;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class CustomerFragment extends TiFragment<CustomersPresenter, CustomersView> implements CustomersView {

    Context context;
    RecyclerView recyclerview_list;
    EditText edit_search;

    MyAdapter myAdapter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_customer, null);
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
        GetListustomer("");

        edit_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if ((actionId & EditorInfo.IME_MASK_ACTION) == EditorInfo.IME_ACTION_DONE) {
                    GetListustomer(edit_search.getText().toString());
                    return true;
                }
                return false;
            }
        });
        setHasOptionsMenu(true);

    }

    @NonNull
    @Override
    public CustomersPresenter providePresenter() {
        return new CustomersPresenter(context);
    }

    private void GetListustomer(String search){
        SwitchDialog();
        getPresenter().doGetListCustomer(1,10,search);
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


    @Override
    public void showData(List<CustomerItem> list) {
        /*List<CustomerItem> items = new ArrayList<>();
        items.add(new CustomerItem("123", "CTYTNHH", "0335767659", "---"));
        items.add(new CustomerItem("123", "CTYTNHH", "0908702453", "---"));
        items.add(new CustomerItem("123", "CTYTNHH", "0344321564", "---"));*/

        if(list == null) {
            list = new ArrayList<>();
        }

        myAdapter = new MyAdapter(context, R.layout.item_fragment_customer, 4, BR.CustomerItem, 0);
        myAdapter.setData((ArrayList) list);
        recyclerview_list.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        SwitchDialog();

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_button, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent createCus = new Intent(getActivity(), CreateCustomersActivity.class);
        startActivity(createCus);
        return super.onOptionsItemSelected(item);
    }
}
