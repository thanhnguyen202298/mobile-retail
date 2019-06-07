package com.ssk.retailshop.screen.money.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.datahelper.webapi.ResultApi;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiptMoneyInteraterImpli implements ReceiptMoneyInterator {

    @Override
    public void GetListReceiptMoney(int page, int pagesize, String search, final ReceiptMoneyListener listener) {
        PathApi mApi = APIUtils.getService();

        String s_Authorization = "Bearer " + PreferenceUtils.getToken();
        mApi.getreceiptmoney(s_Authorization, page, pagesize, search).enqueue(new Callback<ResultApi<List<ReceiptMoneyItem>>>() {
            @Override
            public void onResponse(Call<ResultApi<List<ReceiptMoneyItem>>> call, Response<ResultApi<List<ReceiptMoneyItem>>> response) {
                if (response.body() != null) {
                    ResultApi<List<ReceiptMoneyItem>> obj = response.body();
                    if (obj.getStatus() > 0 && obj.data.size() > 0) {
                        List<ReceiptMoneyItem> list = obj.data;
                        listener.onGetDataSuccess(list);

                    } else listener.onGetDataError("không có dữ liệu");
                } else listener.onGetDataError("Lỗi API: getreceiptmoney");
            }

            @Override
            public void onFailure(Call<ResultApi<List<ReceiptMoneyItem>>> call, Throwable t) {
                listener.onGetDataError(t.getMessage());
            }
        });
    }
}
