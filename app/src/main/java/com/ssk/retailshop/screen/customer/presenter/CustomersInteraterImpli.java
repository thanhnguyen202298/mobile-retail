package com.ssk.retailshop.screen.customer.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.customer.model.CustomerItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomersInteraterImpli implements CustomersInterator {

    @Override
    public void GetListCustomer(int page, int pagesize, String search, final CustomersListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getListCustomers(s_Authorization, page, pagesize, search).enqueue(new Callback<ResultApi<List<CustomerItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<CustomerItem>>> call, Response<ResultApi<List<CustomerItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<CustomerItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<CustomerItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getListCustomers");
            }

            @Override
            public void onFailure(Call<ResultApi<List<CustomerItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
