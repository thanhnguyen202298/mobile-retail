package com.ssk.retailshop.screen.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.ssk.retailshop.R;
import com.ssk.retailshop.databinding.ActivityRegisterBinding;
import com.ssk.retailshop.screen.home.HomeActivity;
import com.ssk.retailshop.screen.homenavigation.HomeNavigationActivity;
import com.ssk.retailshop.screen.login_qlnv.LoginQLNV;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;
import com.ssk.retailshop.screen.register.presenter.RegisterListener;
import com.ssk.retailshop.screen.register.presenter.RegisterPresenter;

import net.grandcentrix.thirtyinch.TiActivity;

public class RegisterActivity extends TiActivity<RegisterPresenter, RegisterListener> implements RegisterListener {
    UserRegisterDTO userRegisterDTO;
    ActivityRegisterBinding viewBind;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBind = DataBindingUtil.setContentView(this, R.layout.activity_register);
        userRegisterDTO = new UserRegisterDTO();
        viewBind.setUserDoRegister(userRegisterDTO);

        viewBind.linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getBaseContext(), LoginQLNV.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }



//    @Override
//    public void onRegisterSuccess() {
//        viewBind.btnSignup.setEnabled(true);
//        setResult(RESULT_OK, null);
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//        finish();
//
//    }
//
//    @Override
//    public void onRegisterError() {
//        Toast.makeText(this, "Vui lòng điền đúng cách trường", Toast.LENGTH_SHORT).show();
//        viewBind.btnSignup.setEnabled(true);
//
//    }

    @Override
    public void onRegisterSuccess(String user) {
        Toast.makeText(this, "Bạn đã đăng kí thành công với email: " + user, Toast.LENGTH_SHORT).show();
        viewBind.btnSignup.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent intent = new Intent(this, LoginQLNV.class);
        startActivity(intent);
        finish();
        progressDialog.dismiss();
    }

    @Override
    public void onRegisterError(String msg) {
        Toast.makeText(this, "Vui lòng điền đúng các trường", Toast.LENGTH_SHORT).show();
        viewBind.btnSignup.setEnabled(true);
    }

    @Override
    public boolean valid() {
        return false;
    }

    @NonNull
    @Override
    public RegisterPresenter providePresenter() {
        return new RegisterPresenter();
    }

    public void onClickRegister(View view) {
        signUp();
    }

    void signUp() {
        if (!validate()) {
            onRegisterError("");
            return;
        }
        viewBind.btnSignup.setEnabled(false);

        progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Đang tạo tài khoản...");
        progressDialog.show();

        getPresenter().doRegister(userRegisterDTO);
//        Toast.makeText(this, vm.username, Toast.LENGTH_SHORT).show();
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onSignupSuccess or onSignupFailed
//                        // depending on success
//                        onRegisterSuccess(userRegisterDTO.getMailName());
//                        // onSignupFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
    }


    public boolean validate() {
        boolean valid = true;

        String name = userRegisterDTO.getStoreName();
        String address = userRegisterDTO.getAddress();
        String email = userRegisterDTO.getMailName();
        String mobile = userRegisterDTO.getPhoneNumber();
        String password = userRegisterDTO.getPassWord();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3 || name == null) {
            viewBind.inputTenCuaHang.setError("Vui lòng phải nhiều hơn 3 kí tự");
            valid = false;
        } else {
            viewBind.inputTenCuaHang.setError(null);
        }

        if (address.isEmpty()|| address == null) {
            viewBind.inputDiaChi.setError("Vui lòng nhập địa chỉ");
            valid = false;
        } else {
            viewBind.inputDiaChi.setError(null);
        }


        if (email == null || email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            viewBind.inputEMail.setError("Vui lòng nhập một địa chỉ Email hợp lệ");
            valid = false;
        } else {
            viewBind.inputEMail.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() != 10 || mobile ==null) {
            viewBind.inputSoDienThoai.setError("Vui lòng nhập một số điện thoại hợp lệ");
            valid = false;
        } else {
            viewBind.inputSoDienThoai.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10 || password == null) {
            viewBind.inputPassword.setError("Vui lòng nhập mật khẩu lớn hơn 4 và nhỏ hơn 10 ký tự");
            valid = false;
        } else {
            viewBind.inputPassword.setError(null);
        }
        return valid;
    }
}
