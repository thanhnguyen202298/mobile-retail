package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfitLossReportInteraterImpli implements ProfitLossReportInterator {

    @Override
    public void GetListProfitLossReport(String fromdate, String todate, final ProfitLossReportListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getReportIncomeStatement(s_Authorization, fromdate, todate).enqueue(new Callback<ResultApi<List<ProfitLossReportItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ProfitLossReportItem>>> call, Response<ResultApi<List<ProfitLossReportItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ProfitLossReportItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<ProfitLossReportItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getReportIncomeStatement");
            }

            @Override
            public void onFailure(Call<ResultApi<List<ProfitLossReportItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
