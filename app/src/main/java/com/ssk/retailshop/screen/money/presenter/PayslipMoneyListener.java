package com.ssk.retailshop.screen.money.presenter;


import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import java.util.List;

public interface PayslipMoneyListener {
    void onGetDataSuccess(List<PayslipMoneyItem> list);
    void onGetDataError(String msg);
}
