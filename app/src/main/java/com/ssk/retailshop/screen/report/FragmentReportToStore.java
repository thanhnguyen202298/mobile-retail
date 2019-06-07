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

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;
import com.ssk.retailshop.screen.report.presenter.ReportToStorePresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentReportToStore extends TiFragment<ReportToStorePresenter, ReportToStoreView> implements ReportToStoreView {
    View view;
    Context context;
    MyAdapter myAdapter;
    RecyclerView recyclerview_list;
    ReportToStoreDTO reportToStoreDTO;
    onProductInteraction interaction;

    public FragmentReportToStore() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.layout_report_to_store, container, false);
        //region Init and create view
        context = getContext();
        reportToStoreDTO = new ReportToStoreDTO();
        recyclerview_list = view.findViewById(R.id.recycleViewReportToStore);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        getListReportToStore(reportToStoreDTO);
        return view;
        //endregion
    }

    @NonNull
    @Override
    public ReportToStorePresenter providePresenter() {
        return new ReportToStorePresenter(context);
    }

    void getListReportToStore(ReportToStoreDTO reportToStoreDTO) {
        getPresenter().getListReportToStore();
    }

    @Override
    public void showData(List<ReportToStoreDTO> list) {
        //<editor-fold desc="Get data for RecycleView">
        if (list == null) {
            list = new ArrayList<>();

            list.add(new ReportToStoreDTO("", 111, 200000, 1, 0, 0, 100000, "Tiến", "alo", "", 0));
            list.add(new ReportToStoreDTO("", 111, 2200000, 1, 0, 0, 100000, "Tiến", "alo", "", 0));
            list.add(new ReportToStoreDTO("", 111, 1200000, 1, 0, 0, 100000, "Tiến", "alo", "", 0));
        }

        myAdapter = new MyAdapter(context, R.layout.item_report_to_store, 3, BR.ReportToStoreDTO, 0);
        myAdapter.setOnClickFragment(interaction);
        myAdapter.setData((ArrayList) list);
        recyclerview_list.setAdapter(myAdapter);
        //</editor-fold>
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    //<editor-fold desc="Set interator(context) for method click item">
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onProductInteraction)
            interaction = (onProductInteraction) context;
    }
    //</editor-fold>
}
