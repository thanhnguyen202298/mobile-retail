package com.ssk.retailshop.screen.register.presenter;

import net.grandcentrix.thirtyinch.TiView;

public interface RegisterListener extends TiView {
    void onRegisterSuccess(String user);
    void onRegisterError(String msg);
    boolean valid();
}
