package com.ssk.retailshop.screen.shop.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ssk.retailshop.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    Context context;
    List<ProductGroupItem> list = new ArrayList<>();

    public SpinnerAdapter(Context context, List<ProductGroupItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =  inflater.inflate(R.layout.item_adapter_spinner, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.txt_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ProductGroupItem item = list.get(position);

        viewHolder.txtName.setText(item.getName());

        return convertView;
    }

    static class ViewHolder{
        TextView txtName;
    }
}
