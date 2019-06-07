package com.ssk.retailshop.screen.product.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.product.model.FragmentProductDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProductInteratorImpli implements FragmentProductInterator {
    @Override
    public void getListProductDTO(int page, int pagesize, final FragmentProductListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getProductList(s_Authorization, page, pagesize).enqueue(new Callback<ResultApi<List<FragmentProductDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<FragmentProductDTO>>> call, Response<ResultApi<List<FragmentProductDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<FragmentProductDTO>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<FragmentProductDTO> list = obj.data;
                        listener.onSuccess(list);

                    } else listener.onError("Không có dữ liệu");
                } else listener.onError("Lỗi API:");
            }

            @Override
            public void onFailure(Call<ResultApi<List<FragmentProductDTO>>> call, Throwable t) {
                listener.onError("Lỗi API:");
            }
        });
    }
}
