package com.ssk.retailshop.screen.order;

import com.ssk.retailshop.screen.order.model.OrderItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface OrderListView extends TiView {
    void showData(List<OrderItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
