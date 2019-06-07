package com.ssk.retailshop.screen.customer;

import com.ssk.retailshop.screen.customer.model.CustomerItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface CustomersView extends TiView {
    void showData(List<CustomerItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
