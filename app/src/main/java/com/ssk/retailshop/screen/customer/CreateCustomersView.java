package com.ssk.retailshop.screen.customer;

import net.grandcentrix.thirtyinch.TiView;

public interface CreateCustomersView extends TiView {
    void onRegisterCustomersSuccess(String user);
    void onRegisterCustomersError(String msg);
    boolean valid();
}
