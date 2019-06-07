package com.ssk.retailshop.screen.order.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.order.model.OrderItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListInteraterImpli implements OrderListInterator {

    @Override
    public void GetListOrderList(int page, int pagesize, String fromdate, String todate, final OrderListListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getBills(s_Authorization, page, pagesize, fromdate, todate).enqueue(new Callback<ResultApi<List<OrderItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<OrderItem>>> call, Response<ResultApi<List<OrderItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<OrderItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<OrderItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getBills");
            }

            @Override
            public void onFailure(Call<ResultApi<List<OrderItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
