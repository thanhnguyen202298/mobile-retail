package com.ssk.retailshop.adapter;

import net.grandcentrix.thirtyinch.TiView;

public interface onProductInteraction extends TiView {
    void onProductInteraction(String obj, Class type);
    void onDialog(Object oj);
}