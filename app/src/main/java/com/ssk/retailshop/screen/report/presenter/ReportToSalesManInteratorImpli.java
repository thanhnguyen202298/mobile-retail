package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportToSalesManInteratorImpli implements ReportToSalesManInterator {

    @Override
    public void getListReportToSalesMan(int page, int pagesize, String from, String to, final ReportToSalesManListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getListReportToSalesMan(s_Authorization, page, pagesize,"","").enqueue(new Callback<ResultApi<List<ReportToSalesManDTO>>>() {

            @Override
            public void onResponse(Call<ResultApi<List<ReportToSalesManDTO>>> call, Response<ResultApi<List<ReportToSalesManDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ReportToSalesManDTO>> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listener.onSuccess(usinfo.getData());
                    } else listener.onError(response.message());
                } else listener.onError(response.message());
            }

            @Override
            public void onFailure(Call<ResultApi<List<ReportToSalesManDTO>>> call, Throwable t) {

            }
        });
    }
}
