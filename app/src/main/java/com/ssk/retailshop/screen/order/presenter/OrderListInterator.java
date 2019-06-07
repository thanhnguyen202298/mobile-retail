package com.ssk.retailshop.screen.order.presenter;

public interface OrderListInterator {
    void GetListOrderList(final int page, final int pageSize,final String fromDate, final String toDate, final OrderListListener listener);
}
