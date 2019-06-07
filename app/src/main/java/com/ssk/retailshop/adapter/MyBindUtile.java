package com.ssk.retailshop.adapter;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.AdapterViewBindingAdapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ssk.retailshop.R;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.utilities.UtilBasic;

public class MyBindUtile {
    @BindingAdapter("android:data")
    public static void setListDataRV(RecyclerView v, Object newitems) {
        if (v.getAdapter() instanceof MyBindingAdapter) {
            ((MyBindingAdapter) v.getAdapter()).setData(newitems);
        }
    }

    @BindingAdapter("android:image")
    public static void setImgData(ImageView v, String url) {
        if (url != null && url.equals(""))
            if (!url.contains("http://"))
                url = APIUtils.BASE_PRIVATE + url;
        Picasso.get().load(url).placeholder(R.drawable.ic_satellite_black_24dp).into(v);
    }

    @BindingAdapter("android:textColor")
    public static void setTextColor(TextView view, String color) {
        view.setTextColor(Color.parseColor(color));
    }

    @BindingAdapter("android:selectedItemPosition")
    public static void setSelectedItemPosition(AdapterView view, int position) {
        if (view.getSelectedItemPosition() != position) {
            view.setSelection(position);
        }
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, Object content) {
        if (content instanceof String) {
            view.setText((String) content);
            return;
        }
        else if(content instanceof Number)
        {
            Number d = (Number) content;
            view.setText(UtilBasic.getNumberFormat().format(d));
        }
    }

    @BindingAdapter(value = {"android:onItemSelected", "android:onNothingSelected",
            "android:selectedItemPositionAttrChanged"}, requireAll = false)
    public static void setOnItemSelectedListener(AdapterView view, final AdapterViewBindingAdapter.OnItemSelected selected,
                                                 final AdapterViewBindingAdapter.OnNothingSelected nothingSelected, final InverseBindingListener attrChanged) {
        if (selected == null && nothingSelected == null && attrChanged == null) {
            view.setOnItemSelectedListener(null);
        } else {
            view.setOnItemSelectedListener(
                    new AdapterViewBindingAdapter.OnItemSelectedComponentListener(selected, nothingSelected, attrChanged));
        }
    }

}