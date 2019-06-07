package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ReportToProductDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportToProductInteratorImpli implements ReportToProductInterator {
    @Override
    public void GetListReportToProduct(int page, int pagesize, final ReportToProductListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getListReportToProduct(s_Authorization, 1, 100).enqueue(new Callback<ResultApi<List<ReportToProductDTO>>>() {

            @Override
            public void onResponse(Call<ResultApi<List<ReportToProductDTO>>> call, Response<ResultApi<List<ReportToProductDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ReportToProductDTO>> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listener.onSuccess(usinfo.getData());
                    } else listener.onError(response.message());
                } else listener.onError(response.message());
            }

            @Override
            public void onFailure(Call<ResultApi<List<ReportToProductDTO>>> call, Throwable t) {

            }
        });
    }
}
