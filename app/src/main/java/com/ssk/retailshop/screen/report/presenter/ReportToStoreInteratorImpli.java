package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportToStoreInteratorImpli implements ReportToStoreInterator{

    @Override
    public void getListReportToStore(int page, int pagesize, final ReportToStoreListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getListReportToStore(s_Authorization, 1, 100,"","").enqueue(new Callback<ResultApi<List<ReportToStoreDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ReportToStoreDTO>>> call, Response<ResultApi<List<ReportToStoreDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ReportToStoreDTO>> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listener.onSuccess(usinfo.getData());
                    } else listener.onError(response.message());
                } else listener.onError(response.message());
            }

            @Override
            public void onFailure(Call<ResultApi<List<ReportToStoreDTO>>> call, Throwable t) {

            }
        });
    }
}
