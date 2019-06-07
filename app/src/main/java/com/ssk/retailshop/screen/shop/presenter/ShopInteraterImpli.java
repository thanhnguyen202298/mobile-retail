package com.ssk.retailshop.screen.shop.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.shop.model.RequestShop;
import com.ssk.retailshop.screen.shop.model.ResponseShop;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopInteraterImpli implements ShopInterator {

    @Override
    public void Save(RequestShop obj, final ShopListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.saveshop(s_Authorization, obj).enqueue(new Callback<ResultApi<List<ResponseShop>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ResponseShop>>> call, Response<ResultApi<List<ResponseShop>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ResponseShop>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<ResponseShop> list = obj.data;
                        listener.onGetDataSuccess(list.get(0).getName());

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: saveshop");
            }

            @Override
            public void onFailure(Call<ResultApi<List<ResponseShop>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
