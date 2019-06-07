package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportToTimeInteratorImpli implements ReportToTimeInterator {
    @Override
    public void GetListReportToTime(ReportToTimeDTO reportToTimeDTO, final ReportToTimeListener listener) {
        PathApi mApi = APIUtils.getService();
        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getListReportToTime(s_Authorization, 1, 100,"","",0, "").enqueue(new Callback<ResultApi<List<ReportToTimeDTO>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ReportToTimeDTO>>> call, Response<ResultApi<List<ReportToTimeDTO>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ReportToTimeDTO>> usinfo = response.body();
                    if (usinfo.getStatus() > 0) {
                        listener.onSuccess(usinfo.getData());
                    } else listener.onError(response.message());
                } else listener.onError(response.message());
            }

            @Override
            public void onFailure(Call<ResultApi<List<ReportToTimeDTO>>> call, Throwable t) {

            }
        });

    }
}
