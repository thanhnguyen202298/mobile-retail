package com.ssk.retailshop.screen.money.presenter;


import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;

import java.util.List;

public interface ReceiptMoneyListener {
    void onGetDataSuccess(List<ReceiptMoneyItem> list);
    void onGetDataError(String msg);
}
