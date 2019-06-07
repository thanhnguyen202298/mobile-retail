package com.ssk.retailshop.screen.report;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.ssk.retailshop.screen.report.model.ProfitReportItem;
import com.ssk.retailshop.screen.report.presenter.ProfitReportPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class ProfitReportFragment extends TiFragment<ProfitReportPresenter, ProfitReportView> implements ProfitReportView {

    Context context;
    RecyclerView recyclerview_list;
    EditText edit_search;

    MyAdapter myAdapter;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_profitreport, null);
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
        GetListProfitReport("");

        edit_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_MASK_ACTION) == EditorInfo.IME_ACTION_DONE) {
                    GetListProfitReport(edit_search.getText().toString());
                    return true;
                }
                return false;

            }
        });

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
        SwitchDialog();
        getPresenter().doSearch(s);
    }

    @Override
    public void showData(List<ProfitReportItem> list) {

        if(list == null) {
            list = new ArrayList<>();

            /*list.add(new ProfitReportItem("Bánh bông lan kem", "72,000", "72,000", "6,000"));
            list.add(new ProfitReportItem("Bánh bông lan kem", "72,000", "72,000", "6,000"));
            list.add(new ProfitReportItem("Bánh bông lan kem", "72,000", "72,000", "6,000"));*/
        }

        myAdapter = new MyAdapter(context, R.layout.item_fragment_profitreport, 4, BR.ProfitReportItem, 0);
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
    public ProfitReportPresenter providePresenter() {
        return new ProfitReportPresenter(context);
    }

    private void GetListProfitReport(String search){
        SwitchDialog();
        getPresenter().doGetListProfitReport(1,10, "", "");
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
