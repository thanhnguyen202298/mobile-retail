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
import android.widget.EditText;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;
import com.ssk.retailshop.screen.report.presenter.ReportToTimePresenter;
import com.ssk.retailshop.utilities.OnClickFragment;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentReportToTime extends TiFragment<ReportToTimePresenter, ReportToTimeView> implements ReportToTimeView {
    View view;
    MyAdapter myAdapter;
    Context context;
    RecyclerView recyclerview_list;
    ReportToTimeDTO reportToTimeDTO;
    onProductInteraction interaction;

    public FragmentReportToTime() {
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if(context instanceof onProductInteraction)
//            interaction= (onProductInteraction)context;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //region Init and create view
        view = inflater.inflate(R.layout.layout_report_to_time, container, false);
        context = getContext();
        reportToTimeDTO = new ReportToTimeDTO();
        recyclerview_list = view.findViewById(R.id.recycleViewReportToTime);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        getListReportToTime(reportToTimeDTO);

        return view;
        //endregion
    }

    @Override
    public void showData(List<ReportToTimeDTO> list) {

        //region Handle data show on recycle view
        if (list == null) {
            list = new ArrayList<>();

            list.add(new ReportToTimeDTO("1", "", "", 2, 1111, "", "", "", 200000, 200000, 200000));
            list.add(new ReportToTimeDTO("2", "", "", 3, 1111, "", "", "", 200000, 200000, 200000));
            list.add(new ReportToTimeDTO("3", "", "", 4, 1111, "", "", "", 200000, 200000, 200000));
        }

        myAdapter = new MyAdapter(context, R.layout.item_report_to_time, 3, BR.ReportToTimeDTO, 0);
        //region Call and send method click item in recycle view
        myAdapter.setOnClickFragment(interaction);
        //endregion
        myAdapter.setData((ArrayList) list);
        recyclerview_list.setAdapter(myAdapter);

    }

    //region Set interator(context) for method click item
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onProductInteraction)
            interaction = (onProductInteraction) context;
    }
    //endregion


    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public ReportToTimePresenter providePresenter() {

        return new ReportToTimePresenter(context);
    }

    private void getListReportToTime(ReportToTimeDTO reportToTimeDTO) {
        getPresenter().getListReportToTime(reportToTimeDTO);
    }

}
