package com.ssk.retailshop.screen.homenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ssk.retailshop.R;
import com.ssk.retailshop.screen.homenavigation.model.MenuModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_Main_Drawer_ExpandableListview_Adapter extends BaseExpandableListAdapter {

    private Context context;
    private List<MenuModel> listitemheader = new ArrayList<>();
    private Map<Integer, List<MenuModel>> listitemchild = new HashMap<Integer, List<MenuModel>>();

    public Menu_Main_Drawer_ExpandableListview_Adapter(Context context, List<MenuModel> listgroup, Map<Integer, List<MenuModel>> listchild) {
        this.context = context;
        this.listitemheader = listgroup;
        this.listitemchild = listchild;
    }

    @Override
    public int getGroupCount() {
        if (listitemheader != null) {
            return listitemheader.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<MenuModel> listChildByGroup = listitemchild.get(listitemheader.get(groupPosition).getMenuId());
        if (listChildByGroup != null) {
            if (listChildByGroup.size() > 0) {
                return listChildByGroup.size();
            }
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        if (listitemheader != null) {
            return listitemheader.get(groupPosition);
        }
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (listitemchild != null) {
            MenuModel menuModel = listitemchild.get(listitemheader.get(groupPosition).getMenuId()).get(childPosition);
            if (menuModel != null) {
                return menuModel;
            }
        }
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ImageView imageViewiconmenu;
        TextView textViewnamemenu;
        ImageView imageViewiconindicator;
        try {
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.menu_main_drawer_item_parentgroup, parent, false);

            }
            imageViewiconmenu = (ImageView) convertView.findViewById(R.id.menu_main_drawer_item_parentgroup_iconmenu);
            textViewnamemenu = (TextView) convertView.findViewById(R.id.menu_main_drawer_item_parentgroup_namemenu);
            imageViewiconindicator = (ImageView) convertView.findViewById(R.id.menu_main_drawer_item_parentgroup_iconindicator);
            MenuModel parentitem = (MenuModel) getGroup(groupPosition);
            if (parentitem != null) {
                textViewnamemenu.setText(parentitem.getWebscreenName());
                imageViewiconmenu.setImageResource(parentitem.getIconMenu());

            }
            if (getChildrenCount(groupPosition) > 0) {
                imageViewiconindicator.setVisibility(View.VISIBLE);
                if (isExpanded)
                    imageViewiconindicator.setImageResource(R.drawable.icnew_expandablelistview_arrow_down);
                else
                    imageViewiconindicator.setImageResource(R.drawable.icnew_expandablelistview_arrow_up);
            } else {
                imageViewiconindicator.setVisibility(View.GONE);
            }
        } catch (Exception ex) {
            Toast.makeText(context, "Lỗi khi khởi tạo giao diện menu cha: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ImageView imageViewiconmenu;
        TextView textViewnamemenu;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_main_drawer_item_childgroup, parent, false);

        }
        imageViewiconmenu = (ImageView) convertView.findViewById(R.id.menu_main_drawer_item_childgroup_iconmenu);
        textViewnamemenu = (TextView) convertView.findViewById(R.id.menu_main_drawer_item_childgroup_namemenu);
        MenuModel childmenu = (MenuModel) getChild(groupPosition, childPosition);
        if (childmenu != null) {
            textViewnamemenu.setText(childmenu.getWebscreenName());
            imageViewiconmenu.setImageResource(childmenu.getIconMenu());
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ParentHolder {
        ImageView imageViewiconmenu;
        TextView textViewnamemenu;
    }

    static class ChildHolder {
        ImageView imageViewiconmenu;
        TextView textViewnamemenu;
    }
}
