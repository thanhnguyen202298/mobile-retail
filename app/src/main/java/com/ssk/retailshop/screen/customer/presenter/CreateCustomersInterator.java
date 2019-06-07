package com.ssk.retailshop.screen.customer.presenter;

import com.ssk.retailshop.screen.customer.model.CreateCustomersDTO;

public interface CreateCustomersInterator {
    void createCustomers(final CreateCustomersDTO customerItem, final CreateCustomersListener listener);
}
