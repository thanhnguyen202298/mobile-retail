package com.ssk.retailshop.screen.money.presenter;

import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import java.util.List;

public interface CreatePayslipMoneyListener {
    void onSuccess(String list);
    void onError(String msg);
}
