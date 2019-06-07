package com.ssk.retailshop.screen.money;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface ReceiptMoneyView extends TiView {
    void showData(List<ReceiptMoneyItem> list);
    void showMessage(String msg);
    void showProgress(boolean show);
}
