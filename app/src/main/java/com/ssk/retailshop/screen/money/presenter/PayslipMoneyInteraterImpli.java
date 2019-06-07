package com.ssk.retailshop.screen.money.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayslipMoneyInteraterImpli implements PayslipMoneyInterator {

    @Override
    public void GetListPayslipMoney(int page, int pagesize, String search, final PayslipMoneyListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getpayslipmoney(s_Authorization, page, pagesize, search).enqueue(new Callback<ResultApi<List<PayslipMoneyItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<PayslipMoneyItem>>> call, Response<ResultApi<List<PayslipMoneyItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<PayslipMoneyItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<PayslipMoneyItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getpayslipmoney");
            }

            @Override
            public void onFailure(Call<ResultApi<List<PayslipMoneyItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
