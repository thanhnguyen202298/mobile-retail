package com.ssk.retailshop.screen.order.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ssk.retailshop.screen.order.OrderListView;
import com.ssk.retailshop.screen.order.model.OrderItem;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderListPresenter extends TiPresenter<OrderListView> implements OrderListListener {

    private OrderListView inView;
    private OrderListInterator interator;
    private Context context;
    private List<OrderItem> glist = new ArrayList<>();

    public OrderListPresenter(Context ctx) {
        context = ctx;
        interator = new OrderListInteraterImpli();
    }

    public void doGetListOrderList(int page, int pagesize, String fromDate, String toDate) {
        interator.GetListOrderList(page, pagesize, fromDate, toDate, this);
    }

    public void doSearch(String s){
        if(inView != null) {
            if(glist.size() > 0) {
                List<OrderItem> list_search = new ArrayList<>();

                if (!s.trim().equals("")) {

                    for (OrderItem item : glist
                    ) {
                        if (item.getBillBarCode().toLowerCase().trim().contains(s.toLowerCase())) {
                            list_search.add(item);
                        }
                    }

                    inView.showData(list_search);
                } else {
                    inView.showData(glist);
                }
            }
        }
    }

    @Override
    protected void onAttachView(@NonNull OrderListView view) {
        super.onAttachView(view);
        inView = view;
        Log.e("<<<PRESSENTER : ", "ATTACH: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("<<<PRESSENTER : ", "destroy");
    }

    @Override
    protected void onDetachView() {
        super.onDetachView();
        Log.e("<<<PRESSENTER : ", "DDETACH");
    }

    @Override
    public void onGetDataSuccess(List<OrderItem> list) {
        glist = list;
        inView.showData(list);
    }


    @Override
    public void onGetDataError(String msg) {
        inView.showData(null);
    }
}