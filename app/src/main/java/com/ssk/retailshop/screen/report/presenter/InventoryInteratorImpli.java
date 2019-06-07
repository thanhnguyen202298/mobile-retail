package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.InventoryDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InventoryInteratorImpli implements InventoryInterator {
    @Override
    public void getInventory(String fromDate, String toDate, final InventoryListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getInventory(s_Authorization, fromDate, toDate).enqueue(new Callback<ResultApi<List<InventoryDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<InventoryDTO>>> call, Response<ResultApi<List<InventoryDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<InventoryDTO>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<InventoryDTO> list = obj.data;
                        listener.onSuccess(list);

                    } else listener.onError("Không có dữ liệu");
                } else listener.onError("Lỗi API:");
            }

            @Override
            public void onFailure(Call<ResultApi<List<InventoryDTO>>> call, Throwable t) {

            }
        });
    }
}
