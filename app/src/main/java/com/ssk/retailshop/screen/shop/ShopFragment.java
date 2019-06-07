package com.ssk.retailshop.screen.shop;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.databinding.FragmentShopBinding;
import com.ssk.retailshop.screen.shop.model.ProductGroupItem;
import com.ssk.retailshop.screen.shop.model.RequestShop;
import com.ssk.retailshop.screen.shop.model.SpinnerAdapter;
import com.ssk.retailshop.screen.shop.presenter.ShopPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends TiFragment<ShopPresenter, ShopView> implements ShopView {

    Context context;
    Spinner sp_product;
    Button btn_save;

    FragmentShopBinding binding;
    RequestShop requestShop;
    List<ProductGroupItem> listproductgroup = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);
        requestShop = new RequestShop();
        binding.setVariable(BR.RequestShop, requestShop);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //this.getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        context = getContext();

        sp_product = view.findViewById(R.id.sp_product);
        btn_save = view.findViewById(R.id.btn_save);

        LoadProduct();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSave();
            }
        });

    }

    private void LoadProduct() {

        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, array);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        listproductgroup = new ArrayList<>();
        listproductgroup.add(new ProductGroupItem("1","Thời trang"));
        listproductgroup.add(new ProductGroupItem("2","Cafe - Nhà hàng"));
        listproductgroup.add(new ProductGroupItem("3","Mẹ và bé"));
        listproductgroup.add(new ProductGroupItem("4","Mỹ phẩm"));
        listproductgroup.add(new ProductGroupItem("5","Nhà thuốc"));

        SpinnerAdapter myAdapter = new SpinnerAdapter(context, listproductgroup);
        sp_product.setAdapter(myAdapter);
        sp_product.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onClickSave(){
        if(valid()){

            getPresenter().doSave(requestShop);

            return;
        }
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public boolean valid() {

        boolean valid = true;

        String Shopname = requestShop.getShopname();
        String Shopcode = requestShop.getShopcode();
        String person = requestShop.getPerson();
        String email = requestShop.getEmail();
        String productgroup = listproductgroup.get(requestShop.getProductgroup()).getCode();
        String vatnumber = requestShop.getVatnumber();
        String website = requestShop.getWebsite();


        return valid;
    }

    @NonNull
    @Override
    public ShopPresenter providePresenter() {
        return new ShopPresenter(context);
    }
}
