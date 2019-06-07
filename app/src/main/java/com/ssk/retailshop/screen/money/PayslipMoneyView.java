package com.ssk.retailshop.screen.money;
import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface PayslipMoneyView extends TiView {
    void showData(List<PayslipMoneyItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
