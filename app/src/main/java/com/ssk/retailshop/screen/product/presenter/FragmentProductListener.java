package com.ssk.retailshop.screen.product.presenter;

import com.ssk.retailshop.screen.product.model.FragmentProductDTO;

import java.util.List;

public interface FragmentProductListener {
    void onSuccess(List<FragmentProductDTO> list);
    void onError(String msg);
}
