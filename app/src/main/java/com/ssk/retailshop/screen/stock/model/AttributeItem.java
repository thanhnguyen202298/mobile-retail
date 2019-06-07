package com.ssk.retailshop.screen.stock.model;

import android.support.annotation.NonNull;

import java.util.List;

public class AttributeItem extends Object {
    private Integer Index;
    private String NameAtribute;
    private List<String> Childs;

    public AttributeItem(Integer index, String nameAtribute, List<String> childs) {
        Index = index;
        NameAtribute = nameAtribute;
        Childs = childs;
    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        Index = index;
    }

    public String getNameAtribute() {
        return NameAtribute;
    }

    public void setNameAtribute(String nameAtribute) {
        NameAtribute = nameAtribute;
    }

    public List<String> getChilds() {
        return Childs;
    }

    public void setChilds(List<String> childs) {
        Childs = childs;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
