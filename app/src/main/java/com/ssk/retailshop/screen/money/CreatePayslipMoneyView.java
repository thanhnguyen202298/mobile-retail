package com.ssk.retailshop.screen.money;

import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface CreatePayslipMoneyView extends TiView {
    void showData(String list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
