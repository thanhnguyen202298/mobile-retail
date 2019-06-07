package com.ssk.retailshop.screen.stockwarehouse;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.screen.order.model.OrderItem;
import com.ssk.retailshop.screen.stockwarehouse.model.StockWarehouseItem;

import java.util.ArrayList;
import java.util.List;

public class StockWarehouseFragment extends Fragment {

    Context context;
    Spinner sp_type;
    RecyclerView recyclerview_list;

    MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stockwarehouse,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getContext();
        sp_type = view.findViewById(R.id.sp_type);

        LoadSpinner();

        recyclerview_list = view.findViewById(R.id.recyclerview_list);
        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerview_list.setLayoutManager(layoutManager);
        LoadData();

    }

    private void LoadSpinner(){
        String[] array = {"Tồn kho", "Tất cả", "Sắp hết hàng", "Hết hàng"};
        ArrayAdapter<String> adapter_spinner = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, array);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(adapter_spinner);
        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void LoadData() {

        List<StockWarehouseItem> items = new ArrayList<>();
        items.add(new StockWarehouseItem("P1904240018-2", "tieu 2", "100", "201"));
        items.add(new StockWarehouseItem("P1904240018-2", "tieu 2", "100", "201"));
        items.add(new StockWarehouseItem("P1904240018-2", "tieu 2", "100", "201"));


        myAdapter = new MyAdapter(context, R.layout.item_fragment_stockwarehouse, 4, BR.StockWarehouseItem, 0);
        myAdapter.setData((ArrayList)items);
        recyclerview_list.setAdapter(myAdapter);

    }
}
