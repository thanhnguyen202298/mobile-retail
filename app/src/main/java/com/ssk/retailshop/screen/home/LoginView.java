package com.ssk.retailshop.screen.home;

import com.ssk.retailshop.model.UserInfo;

import net.grandcentrix.thirtyinch.TiView;

public interface LoginView extends TiView {
    void navigateToHome(UserInfo userInfo);
    void navigateToLogin();
    void showMessage(String msg);
    void showProgress(boolean show);
}
