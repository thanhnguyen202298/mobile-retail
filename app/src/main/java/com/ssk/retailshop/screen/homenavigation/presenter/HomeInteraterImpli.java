package com.ssk.retailshop.screen.homenavigation.presenter;

import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;
import com.ssk.retailshop.screen.register.presenter.RegisterInterator;
import com.ssk.retailshop.screen.register.presenter.RegisterListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteraterImpli implements HomeInterator{


    @Override
    public void Home(String user, HomeListener listener) {
        if (user.equals("")) {
            listener.onRegisterSuccess("Đăng kí thành công");
        } else listener.onRegisterError("fail");


    }
}
