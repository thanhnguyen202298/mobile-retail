package com.ssk.retailshop.screen.report;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.databinding.ItemInventoryBinding;
import com.ssk.retailshop.screen.report.model.InventoryDTO;
import com.ssk.retailshop.screen.report.model.InventoryListDTO;
import com.ssk.retailshop.screen.report.presenter.InventoryListPresenter;
import com.ssk.retailshop.screen.report.presenter.InventoryPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentInventoryList extends TiFragment<InventoryListPresenter, InventoryListView> implements InventoryListView {
    View view;
    Context context;
    private ViewPager viewPager;
    InventoryListDTO inventoryListDTO;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    onProductInteraction interaction;
    ItemInventoryBinding itemInventoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.layout_inventory_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        inventoryListDTO = new InventoryListDTO();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        getListInventoryList();
    }

    @Override
    public void showData(List<InventoryListDTO> list) {
        //region Handle data show on recycle view
        if (list != null) {
            if (list.size() < 1) {
                list = new ArrayList<>();

                list.add(new InventoryListDTO("2", "123123", 1, 1, 1));
                list.add(new InventoryListDTO("3", "12312", 1, 1, 1));
                list.add(new InventoryListDTO("4", "1233345566", 1, 1, 1));
            }
        }

        myAdapter = new MyAdapter(context, R.layout.item_inventory, 3, BR.InventoryListDTO, 0);


        //region Call and send method click item in recycle view
        myAdapter.setOnClickFragment(interaction);
        //endregion
        myAdapter.setData((ArrayList) list);
        recyclerView.setAdapter(myAdapter);
        //endregion
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public InventoryListPresenter providePresenter() {
        return new InventoryListPresenter(context);
    }

    private void getListInventoryList() {
        getPresenter().getListInventoryList();
    }
}
