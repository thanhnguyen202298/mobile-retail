package com.ssk.retailshop.screen.report;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.ssk.retailshop.screen.report.model.ReportToProductDTO;
import com.ssk.retailshop.screen.report.presenter.ReportToProductPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentReportToProduct extends TiFragment<ReportToProductPresenter, ReportToProductView> implements ReportToProductView {
    View view;
    MyAdapter myAdapter;
    Context context;
    RecyclerView recyclerview_list;
    ReportToProductDTO reportToProductDTO;
    onProductInteraction interaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.layout_report_to_product, container, false);

        context = getContext();
        reportToProductDTO = new ReportToProductDTO();
        recyclerview_list = view.findViewById(R.id.recycleViewReportToProduct);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        getListReportToProduct(reportToProductDTO);

        return view;

    }

    @Override
    public void showData(List<ReportToProductDTO> list) {
        if(list == null) {
            list = new ArrayList<>();

            list.add(new ReportToProductDTO("", 111, 2, 22000000, "", "Alo", "", 1));
            list.add(new ReportToProductDTO("", 111, 2, 23000000, "", "Alo2", "", 1));
            list.add(new ReportToProductDTO("", 111, 2, 50000000, "", "Alo3", "", 1));
        }

        myAdapter = new MyAdapter(context, R.layout.item_report_to_product, 3, BR.ReportToProductDTO, 0);
        myAdapter.setOnClickFragment(interaction);
        myAdapter.setData((ArrayList)list);
        recyclerview_list.setAdapter(myAdapter);
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public ReportToProductPresenter providePresenter() {
        return new ReportToProductPresenter(context);
    }

    private void getListReportToProduct(ReportToProductDTO reportToProductDTO){
        getPresenter().getListReportToProduct();
    }
    //region Set interator(context) for method click item
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  onProductInteraction)
            interaction = (onProductInteraction) context;
    }
    //endregion

}
