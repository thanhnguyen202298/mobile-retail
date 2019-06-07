package com.ssk.retailshop.screen.home.presenter;

import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteraterImpli implements LoginInterator {
    @Override
    public void Login(final String User, final String pass, final LoginListener listener) {
        PathApi mApi = APIUtils.getService();
        mApi.getStatusLogin(User, pass).enqueue(new Callback<ResultApi<List<UserInfo>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<UserInfo>>> call, Response<ResultApi<List<UserInfo>>> response) {

                if (response.body() != null) {
                    ResultApi<List<UserInfo>> usinfo = response.body();
                    if (usinfo.getStatus() > 0 && usinfo.data.size() > 0) {
                        UserInfo m = usinfo.data.get(0);
                        m.password = pass;
                        m.UserName = User;
                        listener.onLoginSuccess(m, usinfo.token);
                    } else listener.onLoginError("Không có dữ liệu");
                } else listener.onLoginError("Không có thông tin đăng nhập");
            }

            @Override
            public void onFailure(Call<ResultApi<List<UserInfo>>> call, Throwable t) {
                listener.onLoginError(t.getMessage());
            }
        });
    }
}
