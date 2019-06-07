package com.ssk.retailshop.customview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

public class ContentVarible extends BaseObservable {

    @Bindable
    public String name;
    @Bindable
    public List content;

    public ContentVarible(){
        content = new ArrayList();
    }

    public void setContent(List content) {
        this.content.addAll(content);
//        notifyPropertyChanged();
    }
}
