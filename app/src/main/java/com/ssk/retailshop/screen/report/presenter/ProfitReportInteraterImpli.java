package com.ssk.retailshop.screen.report.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.report.model.ProfitReportItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfitReportInteraterImpli implements ProfitReportInterator {


    @Override
    public void GetListProfitReport(int page, int pagesize, final String fromdate, final String todate, final ProfitReportListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getReportProfit(s_Authorization, page, pagesize, fromdate, todate).enqueue(new Callback<ResultApi<List<ProfitReportItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ProfitReportItem>>> call, Response<ResultApi<List<ProfitReportItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ProfitReportItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<ProfitReportItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getReportProfit");
            }

            @Override
            public void onFailure(Call<ResultApi<List<ProfitReportItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
