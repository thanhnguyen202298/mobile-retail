package com.ssk.retailshop.screen.customer.presenter;

import net.grandcentrix.thirtyinch.TiView;

public interface CreateCustomersListener extends TiView {
    void onRegisterCustomersSuccess(String user);
    void onRegisterCustomersError(String msg);
    boolean valid();
}
