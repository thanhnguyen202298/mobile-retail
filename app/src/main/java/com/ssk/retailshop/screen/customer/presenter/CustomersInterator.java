package com.ssk.retailshop.screen.customer.presenter;

public interface CustomersInterator {
    void GetListCustomer(final int page, final int pagesize, final String search, final CustomersListener listener);
}
