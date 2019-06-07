package com.ssk.retailshop.screen.homenavigation.presenter;

import net.grandcentrix.thirtyinch.TiView;

public interface HomeListener extends TiView {
    void onRegisterSuccess(String user);
    void onRegisterError(String msg);
    boolean valid();
}
