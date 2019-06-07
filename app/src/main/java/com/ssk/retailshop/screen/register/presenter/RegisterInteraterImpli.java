package com.ssk.retailshop.screen.register.presenter;

import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteraterImpli implements RegisterInterator{

    @Override
    public void Register(UserRegisterDTO user, final RegisterListener listenerRegister) {
        PathApi mApi = APIUtils.getService();
        mApi.registerShop(user).enqueue(new Callback<ResultApi<List<UserRegisterDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<UserRegisterDTO>>> call, Response<ResultApi<List<UserRegisterDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<UserRegisterDTO>> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listenerRegister.onRegisterSuccess("Đăng kí thành công");
                    } else listenerRegister.onRegisterError(response.message());
                } else listenerRegister.onRegisterError("Đăng kí thất bại vui lòng kiểm tra lại");
            }

            @Override
            public void onFailure(Call<ResultApi<List<UserRegisterDTO>>> call, Throwable t) {
                listenerRegister.onRegisterError("Lỗi kết nối vui lòng kiểm tra lại");
            }
        });
    }
}
