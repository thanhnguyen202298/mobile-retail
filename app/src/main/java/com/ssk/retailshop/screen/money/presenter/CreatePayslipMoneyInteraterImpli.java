package com.ssk.retailshop.screen.money.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePayslipMoneyInteraterImpli implements CreatePayslipMoneyInterater {

    @Override
    public void CreatePayslipMoneyInterater(UserRegisterDTO userDTO, final CreatePayslipMoneyListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.createPaySlipMoney(s_Authorization, userDTO).enqueue(new Callback<ResultApi<List<UserRegisterDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<UserRegisterDTO>>> call, Response<ResultApi<List<UserRegisterDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<UserRegisterDTO>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<UserRegisterDTO> list = obj.data;
                        listener.onSuccess(obj.sms);

                    } else listener.onError("không có dữ liệu");
                } else listener.onError("Lỗi API: getpayslipmoney");
            }

            @Override
            public void onFailure(Call<ResultApi<List<UserRegisterDTO>>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
