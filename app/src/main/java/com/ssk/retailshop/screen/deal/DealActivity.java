package com.ssk.retailshop.screen.deal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.R;
import com.ssk.retailshop.screen.report.FragmentReportToProduct;
import com.ssk.retailshop.screen.report.FragmentReportToSalesMan;
import com.ssk.retailshop.screen.report.FragmentReportToStore;
import com.ssk.retailshop.screen.report.FragmentReportToTime;
import com.ssk.retailshop.screen.report.ViewPageReportAdapter;

public class DealActivity extends Fragment {
    View view;
    private TabLayout tabLayout;
//    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_deal, container, false);

        // Inflate the layout for this fragment
        tabLayout = view.findViewById(R.id.tabLayoutDeal);
//        appBarLayout =  view.findViewById(R.id.appBarID);
        viewPager =  view.findViewById(R.id.viewPageDeal);

        setupViewPager(viewPager);

        return view;

    }
    private void setupViewPager(ViewPager viewPager) {


        ViewPageReportAdapter adapter = new ViewPageReportAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentReportToTime(), "Theo Thời Gian");
        adapter.addFragment(new FragmentReportToStore(), "Theo Cửa Hàng");
        adapter.addFragment(new FragmentReportToSalesMan(), "Theo Người Bán");
        adapter.addFragment(new FragmentReportToProduct(), "Theo Hàng Hóa");
        adapter.addFragment(new FragmentCustomerReturn(), "");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}
