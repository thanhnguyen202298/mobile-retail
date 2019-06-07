package com.ssk.retailshop.screen.homenavigation;

import net.grandcentrix.thirtyinch.TiView;

public interface HomeView extends TiView {
    void onRegisterSuccess();
    void onRegisterError();
    boolean valid();
}
