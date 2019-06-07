package com.ssk.retailshop.screen.money.presenter;

public interface ReceiptMoneyInterator {
    void GetListReceiptMoney(final int page, final int pagesize, final String search, final ReceiptMoneyListener listener);
}
