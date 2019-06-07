package com.ssk.retailshop.screen.money.presenter;

public interface PayslipMoneyInterator {
    void GetListPayslipMoney(final int page, final int pagesize, final String search, final PayslipMoneyListener listener);
}
