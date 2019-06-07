package com.ssk.retailshop.screen.register;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

import net.grandcentrix.thirtyinch.TiView;

public interface RegisterView extends TiView {
    void onRegisterSuccess();
    void onRegisterError();
    boolean valid();
}
