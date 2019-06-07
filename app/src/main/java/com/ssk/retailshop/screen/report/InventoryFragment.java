package com.ssk.retailshop.screen.report;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.databinding.FragmentInventoryBinding;
import com.ssk.retailshop.screen.report.model.InventoryDTO;
import com.ssk.retailshop.screen.report.presenter.InventoryPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.List;


public class InventoryFragment extends TiFragment<InventoryPresenter, InventoryView> implements InventoryView {
    private View view;
    Context context;
    private ViewPager viewPager;
    InventoryDTO inventoryDTO;
    FragmentInventoryBinding fragmentInventoryBinding;


    public InventoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        inventoryDTO = new InventoryDTO();
        fragmentInventoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_inventory, container, false);
        fragmentInventoryBinding.setVariable(BR.InventoryDTO, inventoryDTO);

        return fragmentInventoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inflate the layout for this fragment
        context = getContext();
        viewPager = view.findViewById(R.id.viewPageInventory);
        setupViewPager(viewPager);
        getInventory();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPageReportAdapter adapter = new ViewPageReportAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentInventoryList(), "Tồn kho");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void showData(List<InventoryDTO> list) {
        fragmentInventoryBinding.setInventoryDTO(list.get(0));
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public InventoryPresenter providePresenter() {
        return new InventoryPresenter(context);
    }


    private void getInventory() {
        getPresenter().getInventory("", "");
    }
}
