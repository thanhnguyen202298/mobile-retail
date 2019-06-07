package com.ssk.retailshop.screen.stock.AttributeDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.MyAdapter;
import com.ssk.retailshop.screen.stock.model.AttributeItem;

import java.util.ArrayList;
import java.util.List;

public class AttributeDetailActivity extends AppCompatActivity {

    Context context;

    ImageView img_add;
    EditText edit_add;
    RecyclerView recyclerview_list;

    List<AttributeItem> glistAttributeItem =  new ArrayList<>();
    MyAdapter main_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_detail);

        context = this;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.customtoolbar);
        TextView tv = actionBar.getCustomView().findViewById(R.id.action_bar_title);
        tv.setText("Thuộc tính");

        edit_add = findViewById(R.id.edit_add);
        img_add = findViewById(R.id.img_add);
        recyclerview_list = findViewById(R.id.recyclerview_list);

        recyclerview_list.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview_list.setLayoutManager(layoutManager);

        main_adapter = new MyAdapter(context, R.layout.item_attribute_detail, 3, BR.AttributeItem, 0);
        main_adapter.setData((ArrayList)glistAttributeItem);
        recyclerview_list.setAdapter(main_adapter);

        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glistAttributeItem.add(new AttributeItem(glistAttributeItem.size() + 1, edit_add.getText().toString(), new ArrayList<String>()));
                main_adapter.notifyDataSetChanged();
            }
        });

    }
}
