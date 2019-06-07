package com.ssk.retailshop.screen.login_qlnv;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.ssk.retailshop.R;
import com.ssk.retailshop.model.UserInfo;
import com.ssk.retailshop.screen.home.LoginView;
import com.ssk.retailshop.screen.home.model.ViewLoginModel;
import com.ssk.retailshop.screen.homenavigation.HomeNavigationActivity;
import com.ssk.retailshop.screen.login_qlnv.presenter.LoginPresenterQLnv;
import com.ssk.retailshop.screen.register.RegisterActivity;
import com.ssk.retailshop.service.WakeServiceSSk;

import net.grandcentrix.thirtyinch.TiActivity;


public class LoginQLNV extends TiActivity<LoginPresenterQLnv, LoginView> implements LoginView {
    ViewLoginModel vm;

    ViewDataBinding viewBind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBind=DataBindingUtil.setContentView(this,R.layout.login_qlnv);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        vm=new ViewLoginModel();
        viewBind.setVariable(com.ssk.retailshop.BR.UserDoLogin,vm);
//        viewBind.setVariable(,vm);
    }




    @NonNull
    @Override
    public LoginPresenterQLnv providePresenter() {
        return new LoginPresenterQLnv(this);
    }

    public void onClickLogin(View view) {

//        getPresenter().doLogin(vm.Username, vm.Password);
        getPresenter().doLogin("trungnd@gmail.com", "123");
//        Toast.makeText(this, vm.username, Toast.LENGTH_SHORT).show();

    }

    public void onClickGoRegister(View view){
        Intent navigateToAdminPage = new Intent(LoginQLNV.this, RegisterActivity.class);
        startActivity(navigateToAdminPage);
    }

    private void navigationUserScreen(UserInfo usn) {
        WakeServiceSSk.onWWake(LoginQLNV.this, usn.UserID);
//        Intent navigateToUser = new Intent(LoginQLNV.this, MainActivity.class);
//        navigateToUser.putExtra("Name", usn.EmployeeName);
//        navigateToUser.putExtra("Depart", usn.DivisionName);
//        navigateToUser.putExtra("Empcode", usn.EmployeeCode);
//        navigateToUser.putExtra("Role", "" + usn.GroupID);
//        startActivity(navigateToUser);
        finish();
    }

    private void navigationAdminScreen(UserInfo usn) {
//        Intent navigateToAdminPage = new Intent(LoginQLNV.this, MainActivity.class);
//        navigateToAdminPage.putExtra("Name", usn.EmployeeName);
//        navigateToAdminPage.putExtra("Depart", usn.DivisionName);
//        navigateToAdminPage.putExtra("Empcode", usn.EmployeeCode);
//        startActivity(navigateToAdminPage);
        finish();
    }

    @Override
    public void navigateToHome(UserInfo userInfo) {
        Intent homeIntent = new Intent(LoginQLNV.this, HomeNavigationActivity.class);
        startActivity(homeIntent);
//        if (userInfo.GroupID == 1 || userInfo.GroupID == 2)
//            navigationAdminScreen(userInfo);
//        else navigationUserScreen(userInfo);
    }

    @Override
    public void navigateToLogin() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {

    }

}
