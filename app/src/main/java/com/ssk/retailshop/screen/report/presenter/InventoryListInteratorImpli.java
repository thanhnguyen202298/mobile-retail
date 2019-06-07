package com.ssk.retailshop.screen.report.presenter;

import android.widget.Toast;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.InventoryListDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InventoryListInteratorImpli implements InventoryListInterator{

    @Override
    public void getInventoryList(int page, int pagesize, final InventoryListListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getInventoryListDetail(s_Authorization, page, pagesize).enqueue(new Callback<ResultApi<List<InventoryListDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<InventoryListDTO>>> call, Response<ResultApi<List<InventoryListDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<InventoryListDTO>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<InventoryListDTO> list = obj.data;
                        listener.onSuccess(list);

                    } else listener.onError("Không có dữ liệu");
                } else listener.onError("Lỗi API:");
            }

            @Override
            public void onFailure(Call<ResultApi<List<InventoryListDTO>>> call, Throwable t) {
                listener.onError("Lỗi API:");
            }
        });
    }
}
