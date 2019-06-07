package com.ssk.retailshop.screen.product;

import com.ssk.retailshop.screen.product.model.FragmentProductDTO;

import net.grandcentrix.thirtyinch.TiView;

import java.util.List;

public interface FragmentProductView extends TiView {
    void showData(List<FragmentProductDTO> list);

    void showMessage(String msg);

    void showProgress(boolean show);
}
