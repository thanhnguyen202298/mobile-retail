package com.ssk.retailshop.screen.shop.presenter;

import com.ssk.retailshop.screen.shop.model.RequestShop;

public interface ShopInterator {
    void Save(final RequestShop obj, final ShopListener listener);
}
