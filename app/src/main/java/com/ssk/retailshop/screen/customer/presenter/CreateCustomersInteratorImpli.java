package com.ssk.retailshop.screen.customer.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.customer.model.CreateCustomersDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateCustomersInteratorImpli implements CreateCustomersInterator {
    @Override
    public void createCustomers(CreateCustomersDTO customerItem, final CreateCustomersListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.registerCustomers(s_Authorization, customerItem).enqueue(new Callback<ResultApi>() {
            @Override
            public void onResponse(Call<ResultApi> call, Response<ResultApi> response) {
                if (response.body() != null) {
                    ResultApi<CreateCustomersDTO> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listener.onRegisterCustomersSuccess(usinfo.sms);
                    } else listener.onRegisterCustomersError(usinfo.sms);
                } else listener.onRegisterCustomersError("Không có dữ liệu");
            }

            @Override
            public void onFailure(Call<ResultApi> call, Throwable t) {
                listener.onRegisterCustomersError(t.getMessage());
            }
        });
    }
}
