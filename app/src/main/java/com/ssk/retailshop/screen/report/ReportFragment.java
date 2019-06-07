package com.ssk.retailshop.screen.report;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.ssk.retailshop.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class ReportFragment extends Fragment {
    View view;
    //    private TabLayout tabLayout;
    //    private AppBarLayout appBarLayout;
    private FrameLayout viewPager;
    private Spinner spinner;

    //region Tab layout
    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_report);
//        tabLayout = findViewById(R.id.tabLayoutReport);
//        appBarLayout = findViewById(R.id.appBarID);
//        viewPager = findViewById(R.id.viewPageReport);
//
//
//        ViewPageReportAdapter adapter = new ViewPageReportAdapter(getSupportFragmentManager());
//        adapter.addFragment(new FragmentReportToTime(), "Theo Thời Gian" );
//        adapter.addFragment(new FragmentReportToStore(), "Theo Cửa Hàng" );
//        adapter.addFragment(new FragmentReportToSalesMan(), "Theo Người Bán" );
//        adapter.addFragment(new FragmentReportToProduct(), "Theo Hàng Hóa");
//
//        viewPager.setAdapter(adapter);
//
//        tabLayout.setupWithViewPager(viewPager);
//    }
    //endregion

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_report, container, false);

        // Inflate the layout for this fragment
//        tabLayout = view.findViewById(R.id.tabLayoutReport);
//        appBarLayout =  view.findViewById(R.id.appBarID);
        viewPager = view.findViewById(R.id.viewPageReport);
        spinner = view.findViewById(R.id.spn_LoaiDoanhSo);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getListItem());

        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setupViewPager(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;

    }

    private void setupViewPager(int position) {

        //region Tab layout
        //        ViewPageReportAdapter adapter = new ViewPageReportAdapter(getChildFragmentManager());
//        adapter.addFragment(new FragmentReportToTime(), "Theo Thời Gian");
//        adapter.addFragment(new FragmentReportToStore(), "Theo Cửa Hàng");
//        adapter.addFragment(new FragmentReportToSalesMan(), "Theo Người Bán");
//        adapter.addFragment(new FragmentReportToProduct(), "Theo Hàng Hóa");
//        viewPager.setAdapter(adapter);
//        Fragment childFragment = new ChildFragment();
        //endregion
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();


        switch (position) {
            ////////////////////////// Doanh số
            case 0:
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.viewPageReport, new FragmentReportToTime()).commit();
                break;
            case 1:
                transaction.replace(R.id.viewPageReport, new FragmentReportToStore()).commit();
                break;
            case 2:
                transaction.replace(R.id.viewPageReport, new FragmentReportToSalesMan()).commit();
                break;
            case 3:
                transaction.replace(R.id.viewPageReport, new FragmentReportToProduct()).commit();
                break;
        }


        //region Tab layout
        //            ViewPageReportAdapter adapter = new ViewPageReportAdapter(getChildFragmentManager());
//            adapter.addFragment(new FragmentReportToTime(), "Theo Thời Gian");
//            viewPager.setAdapter(adapter);


//        tabLayout.setupWithViewPager(viewPager);
        //endregion
    }

    List<String> getListItem() {
        List<String> list = new ArrayList<>();
        list.add("Theo Thời Gian");
        list.add("Theo Cửa Hàng");
        list.add("Theo Người Bán");
        list.add("Theo Hàng Hóa");

        return list;
    }
}
