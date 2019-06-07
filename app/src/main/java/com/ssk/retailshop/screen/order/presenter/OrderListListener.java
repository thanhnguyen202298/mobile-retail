package com.ssk.retailshop.screen.order.presenter;


import com.ssk.retailshop.screen.order.model.OrderItem;

import java.util.List;

public interface OrderListListener {
    void onGetDataSuccess(List<OrderItem> list);
    void onGetDataError(String msg);
}
