package com.ssk.retailshop.screen.report;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;
import com.ssk.retailshop.screen.report.presenter.ReportToSalesManPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentReportToSalesMan extends TiFragment<ReportToSalesManPresenter, ReportToSalesManView> implements ReportToSalesManView {
    View view;
    MyAdapter myAdapter;
    Context context;
    RecyclerView recyclerview_list;
    ReportToSalesManDTO reportToSalesManDTO;
    onProductInteraction interaction;

    public FragmentReportToSalesMan() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //region Init and create view
        view = inflater.inflate(R.layout.layout_report_to_sales_man, container, false);
        context = getContext();
        reportToSalesManDTO = new ReportToSalesManDTO();
        recyclerview_list = view.findViewById(R.id.recycleViewReportToTime);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        getListReportToTime(reportToSalesManDTO);
        return view;
        //endregion

    }

    @Override
    public void showData(List<ReportToSalesManDTO> list) {
        //region Handle data show on recycle view
        if (list == null) {
            list = new ArrayList<>();

            list.add(new ReportToSalesManDTO("", 12222222, 2222222, 0, "", "Aloooooo1", "", 1, 1, 1));
            list.add(new ReportToSalesManDTO("", 22222222, 2222222, 02, "", "Aloooooo2", "", 1, 1, 1));
            list.add(new ReportToSalesManDTO("", 32222222, 2222222, 03, "", "Aloooooo2", "", 1, 1, 1));
        }

        myAdapter = new MyAdapter(context, R.layout.item_report_to_sales_man, 3, BR.ReportToSalesManDTO, 0);


        //region Call and send method click item in recycle view
        myAdapter.setOnClickFragment(interaction);
        //endregion
        myAdapter.setData((ArrayList) list);
        recyclerview_list.setAdapter(myAdapter);
        //endregion
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public ReportToSalesManPresenter providePresenter() {
        return new ReportToSalesManPresenter(context);
    }

    private void getListReportToTime(ReportToSalesManDTO reportToSalesManDTO) {
        getPresenter().getListReportToSalesMan(reportToSalesManDTO);
    }

    //region Set interator(context) for method click item
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onProductInteraction)
            interaction = (onProductInteraction) context;
    }
    //endregion
}
