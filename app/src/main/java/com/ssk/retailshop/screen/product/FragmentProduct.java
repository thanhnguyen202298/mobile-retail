package com.ssk.retailshop.screen.product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.product.model.FragmentProductDTO;
import com.ssk.retailshop.screen.product.presenter.FragmentProductPresenter;

import net.grandcentrix.thirtyinch.TiFragment;
import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.ArrayList;
import java.util.List;

public class FragmentProduct extends TiFragment<FragmentProductPresenter, FragmentProductView> implements FragmentProductView {

    View view;
    MyAdapter myAdapter;
    Context context;
    RecyclerView recyclerView;
    FragmentProductDTO productDTO;
    onProductInteraction interaction;


    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @NonNull
    @Override
    public FragmentProductPresenter providePresenter() {
        return new FragmentProductPresenter(context);
    }

    private void getListProductDTO() {
        getPresenter().getListProductDTO();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //region Init and create view
        view = inflater.inflate(R.layout.layout_product, container, false);
        context = getContext();
        productDTO = new FragmentProductDTO();
        recyclerView = view.findViewById(R.id.recyclerViewProductList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        getListProductDTO();

        return view;
        //endregion
    }

    @Override
    public void showData(List<FragmentProductDTO> list) {

        //region Handle data show on recycle view
        myAdapter = new MyAdapter(context, R.layout.rv_product_item, 3, BR.FragmentProductDTO, 0);
        //region Call and send method click item in recycle view
        myAdapter.setOnClickFragment(interaction);
        //endregion
        myAdapter.setData((ArrayList) list);
        recyclerView.setAdapter(myAdapter);

    }

    //region Set interator(context) for method click item
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onProductInteraction)
            interaction = (onProductInteraction) context;
    }
    //endregion
}
