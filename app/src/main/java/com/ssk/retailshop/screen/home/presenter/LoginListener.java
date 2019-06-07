package com.ssk.retailshop.screen.home.presenter;


import com.ssk.retailshop.model.UserInfo;

public interface LoginListener {
    void onLoginSuccess(UserInfo userInfo, String token);
    void onLoginError(String msg);
    boolean validUser(String user);
    boolean validPass(String pass);
}
