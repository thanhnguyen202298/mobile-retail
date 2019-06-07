package com.ssk.retailshop.screen.shop;
import net.grandcentrix.thirtyinch.TiView;

public interface ShopView extends TiView {
    void showMessage(String msg);
    void showProgress(boolean show);
    boolean valid();
}
