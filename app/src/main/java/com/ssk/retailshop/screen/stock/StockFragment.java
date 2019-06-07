package com.ssk.retailshop.screen.stock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.ssk.retailshop.R;
import com.ssk.retailshop.screen.stock.AttributeDetail.AttributeDetailActivity;

public class StockFragment extends Fragment {

    Context context;
    Switch sw_warehousemanage;
    LinearLayout lay_attribute;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stock,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getContext();
        sw_warehousemanage = view.findViewById(R.id.sw_warehousemanage);
        lay_attribute = view.findViewById(R.id.lay_attribute);

        sw_warehousemanage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    lay_attribute.setVisibility(View.VISIBLE);

                    Intent intent = new Intent(context, AttributeDetailActivity.class);
                    startActivity(intent);

                } else {
                    lay_attribute.setVisibility(View.GONE);
                }
            }
        });

    }
}
