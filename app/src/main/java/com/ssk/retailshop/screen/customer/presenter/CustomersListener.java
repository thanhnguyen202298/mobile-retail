package com.ssk.retailshop.screen.customer.presenter;


import com.ssk.retailshop.screen.customer.model.CustomerItem;

import java.util.List;

public interface CustomersListener {
    void onGetDataSuccess(List<CustomerItem> list);
    void onGetDataError(String msg);
}
