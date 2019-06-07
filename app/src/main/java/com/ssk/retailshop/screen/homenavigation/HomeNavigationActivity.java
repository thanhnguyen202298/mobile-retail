package com.ssk.retailshop.screen.homenavigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.ssk.retailshop.R;
import com.ssk.retailshop.adapter.onProductInteraction;
import com.ssk.retailshop.screen.customer.CreateCustomerFragment;
import com.ssk.retailshop.screen.customer.CustomerFragment;
import com.ssk.retailshop.screen.homenavigation.adapter.Menu_Main_Drawer_ExpandableListview_Adapter;
import com.ssk.retailshop.screen.homenavigation.model.BackFragemnt;
import com.ssk.retailshop.screen.homenavigation.model.MenuModel;
import com.ssk.retailshop.screen.homenavigation.presenter.HomeListener;
import com.ssk.retailshop.screen.homenavigation.presenter.HomePresenter;
import com.ssk.retailshop.screen.money.PayslipMoneyFragment;
import com.ssk.retailshop.screen.money.ReceiptMoneyFragment;
import com.ssk.retailshop.screen.order.OrderListFragment;
import com.ssk.retailshop.screen.pointsetting.PointSettingFragment;
import com.ssk.retailshop.screen.product.FragmentProduct;
import com.ssk.retailshop.screen.report.InventoryFragment;
import com.ssk.retailshop.screen.report.ReportFragment;

import com.ssk.retailshop.screen.settingsell.FragmentSettingSell;

import com.ssk.retailshop.screen.report.ProfitLossReportFragment;
import com.ssk.retailshop.screen.report.ProfitReportFragment;
import com.ssk.retailshop.screen.shop.ShopFragment;
import com.ssk.retailshop.screen.stock.StockFragment;
import com.ssk.retailshop.screen.stockwarehouse.StockWarehouseFragment;

import net.grandcentrix.thirtyinch.TiActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeNavigationActivity extends TiActivity<HomePresenter, HomeListener> implements HomeListener, NavigationView.OnNavigationItemSelectedListener, onProductInteraction {

    Context context = this;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ExpandableListView expandableListViewmenu;
    BottomNavigationView bottomNavigationView;
    ActionBar actionBar;
    TextView gtitle;
    Dialog dialog;

    Menu_Main_Drawer_ExpandableListview_Adapter menu_main_drawer_expandableListview_adapter;
    List<MenuModel> gListParentMenu = new ArrayList<>();
    Map<Integer, List<MenuModel>> gListChildMenu = new HashMap<Integer, List<MenuModel>>();


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<BackFragemnt> listBackFragment = new ArrayList<>();
    Fragment fm_active, fm_ProfitLossReport, fm_ReceiptMoney, fm_ProfitReport, fm_PayslipMoney, fm_Order, fm_Stock, fm_StockWarehouse, fm_PointSetting, fm_Customer, fm_Shop, fm_Iventory, fm_SettingSell, fm_ReportQuantity;
    Fragment fm_ProductManager, fm_CreateCustomers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        Toolbar toolbar = findViewById(R.id.actionBar);
        gtitle = findViewById(R.id.action_bar_title);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        /*actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.main_actionbar);*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_manager_menu);
        expandableListViewmenu = findViewById(R.id.expandablelistview_menu);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        // cấp phát đối tượng cho variable từng fragment
        InitFragment();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_Home:

                                LoadFragment(fm_ProfitLossReport, "Home");
                                //listBackFragment.add(new BackFragemnt("Home", 0));
                                break;

                            case R.id.item_money:

                                LoadFragment(fm_ProfitReport, "Thu");
                                //listBackFragment.add(new BackFragemnt("Tiền Bạc", 1));
                                break;

                            case R.id.item_report:

                                LoadFragment(fm_ReportQuantity, "Report");
                                //listBackFragment.add(new BackFragemnt("Report", 2));
                                break;

                            case R.id.item_logout:

                                LoadFragment(fm_ReceiptMoney, "Chi");
                                //listBackFragment.add(new BackFragemnt("Đăng xuất", 3));
                                break;

                        }
                        return true;
                    }
                });

        initNavigationMennusNew();

    }

    private void InitFragment(){


        fm_active = new Fragment();

        //region Left Menu
        //region Quản lý
        fm_Order = new OrderListFragment();
        AddFragment(fm_Order);

        fm_Stock = new StockFragment();
        AddFragment(fm_Stock);

        fm_StockWarehouse = new StockWarehouseFragment();
        AddFragment(fm_StockWarehouse);

        fm_ProductManager = new FragmentProduct();
        AddFragment(fm_ProductManager);
        //endregion

        //region Khách hàng

        fm_PointSetting = new PointSettingFragment();
        AddFragment(fm_PointSetting);

        fm_Customer = new CustomerFragment();
        AddFragment(fm_Customer);

        fm_CreateCustomers = new CreateCustomerFragment();
        AddFragment(fm_CreateCustomers);

        //endregion

        //region Tiền bạc
        fm_ReceiptMoney = new ReceiptMoneyFragment();
        AddFragment(fm_ReceiptMoney);

        fm_PayslipMoney = new PayslipMoneyFragment();
        AddFragment(fm_PayslipMoney);
        //endregion

        //region Báo cáo
        fm_ProfitLossReport = new ProfitLossReportFragment();
        AddFragment(fm_ProfitLossReport);

        fm_ProfitReport = new ProfitReportFragment();
        AddFragment(fm_ProfitReport);

        fm_Iventory = new InventoryFragment();
        AddFragment(fm_Iventory);

        fm_ReportQuantity = new ReportFragment();
        AddFragment(fm_ReportQuantity);



        //endregion

        //region Bán hàng

        //endregion

        //region Thiết lập

        fm_Shop = new ShopFragment();
        AddFragment(fm_Shop);

//        //Bán hàng
        fm_SettingSell = new FragmentSettingSell();
        AddFragment(fm_SettingSell);
        //endregion

        //endregion

        //region Bottom Menu

        //endregion

        // Default
        LoadFragment(fm_ProfitLossReport,"Home");


    }

    private void AddFragment(Fragment fragment){

        fragmentManager.beginTransaction()
                .addToBackStack(fragment.getTag())
                .add(R.id.fragment_container_menu_manager, fragment)
                .hide(fragment)
                .commit();
    }

    private boolean LoadFragment(final Fragment fragment, final String title)
    {

        if (fragment != null)
        {
            if(fragment instanceof ProfitLossReportFragment){
                toggle.setDrawerIndicatorEnabled(true);

            } else {
                toggle.setDrawerIndicatorEnabled(false);
                actionBar.setHomeButtonEnabled(true);
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
       
            gtitle.setText(title);

            if (fm_active != fragment) {

                FragmentTransaction transaction = fragmentManager.beginTransaction().hide(fm_active).show(fragment);
                /*transaction.detach(fragment);
                transaction.attach(fragment);*/
                transaction.commit();

                //fragmentManager.beginTransaction().hide(fm_active).show(fragment).commit();
                //fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).hide(fm_active).show(fragment).commit();

                fm_active = fragment;
            }

            /*getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(fragment.getTag())
                    .replace(R.id.fragment_container_menu_manager, fragment)
                    .commit();*/

            return true;
        }
        return false;

    }

    private void onBackFragement() {

        if (listBackFragment.size() > 1) {
            listBackFragment.remove(listBackFragment.size() - 1);
            gtitle.setText(listBackFragment.get(listBackFragment.size() - 1).getTitle());
            bottomNavigationView.getMenu().getItem(listBackFragment.get(listBackFragment.size() - 1).getIdBottom()).setChecked(true);
        }

    }

    private int GetIDResource_Leftmenu(String webscreen) {
        int id = 0;
        switch (webscreen) {
            case "mPos":
                id = R.drawable.ic_leftmenu_pos;
                break;
            case "mManage":
                id = R.drawable.ic_leftmenu_management;
                break;
            case "mCustomer":
                id = R.drawable.ic_leftmenu_customer;
                break;
            case "mMoney":
                id = R.drawable.ic_leftmenu_money;
                break;
            case "mSell":
                id = R.drawable.ic_leftmenu_sell;
                break;
            case "mReport":
                id = R.drawable.ic_leftmenu_report;
                break;
            case "mSetting":
                id = R.drawable.ic_leftmenu_setting;
                break;

            default:
                id = 0;
        }
        return id;
    }

    private void AddListParentChildMenu() {

        // Parent Menu
        MenuModel item_pos = new MenuModel();
        item_pos.setMenuId(1);
        item_pos.setWebscreen("mPos");
        item_pos.setWebscreenName("POS");
        item_pos.setIconMenu(GetIDResource_Leftmenu(item_pos.getWebscreen()));
        item_pos.setLevel(1);
        item_pos.setParentID(0);
        gListParentMenu.add(item_pos);

        MenuModel item_manage = new MenuModel();
        item_manage.setMenuId(2);
        item_manage.setWebscreen("mManage");
        item_manage.setWebscreenName("Quản lý");
        item_manage.setIconMenu(GetIDResource_Leftmenu(item_manage.getWebscreen()));
        item_manage.setLevel(1);
        item_manage.setParentID(0);
        gListParentMenu.add(item_manage);

        MenuModel item_customer = new MenuModel();
        item_customer.setMenuId(3);
        item_customer.setWebscreen("mCustomer");
        item_customer.setWebscreenName("Khách hàng");
        item_customer.setIconMenu(GetIDResource_Leftmenu(item_customer.getWebscreen()));
        item_customer.setLevel(1);
        item_customer.setParentID(0);
        gListParentMenu.add(item_customer);

        MenuModel item_money = new MenuModel();
        item_money.setMenuId(4);
        item_money.setWebscreen("mMoney");
        item_money.setWebscreenName("Tiền bạc");
        item_money.setIconMenu(GetIDResource_Leftmenu(item_money.getWebscreen()));
        item_money.setLevel(1);
        item_money.setParentID(0);
        gListParentMenu.add(item_money);

        MenuModel item_report = new MenuModel();
        item_report.setMenuId(5);
        item_report.setWebscreen("mReport");
        item_report.setWebscreenName("Báo cáo");
        item_report.setIconMenu(GetIDResource_Leftmenu(item_report.getWebscreen()));
        item_report.setLevel(1);
        item_report.setParentID(0);
        gListParentMenu.add(item_report);

        MenuModel item_sell = new MenuModel();
        item_sell.setMenuId(6);
        item_sell.setWebscreen("mSell");
        item_sell.setWebscreenName("Bán hàng");
        item_sell.setIconMenu(GetIDResource_Leftmenu(item_sell.getWebscreen()));
        item_sell.setLevel(1);
        item_sell.setParentID(0);
        gListParentMenu.add(item_sell);

        MenuModel item_setting = new MenuModel();
        item_setting.setMenuId(7);
        item_setting.setWebscreen("mSetting");
        item_setting.setWebscreenName("Thiết lập");
        item_setting.setIconMenu(GetIDResource_Leftmenu(item_setting.getWebscreen()));
        item_setting.setLevel(1);
        item_setting.setParentID(0);
        gListParentMenu.add(item_setting);


        // Chill Menu
        // Pos

        // Quản lý
        List<MenuModel> listchild_manage = new ArrayList<>();
        // -- Tổng quan

        MenuModel item_overview = new MenuModel();
        item_overview.setMenuId(21);
        item_overview.setWebscreen("mManage_Overview");
        item_overview.setWebscreenName("Tổng Quan");
        item_overview.setIconMenu(GetIDResource_Leftmenu(item_overview.getWebscreen()));
        item_overview.setLevel(2);
        item_overview.setParentID(2);
        listchild_manage.add(item_overview);

        // -- Đơn hàng
        MenuModel item_orderid = new MenuModel();
        item_orderid.setMenuId(22);
        item_orderid.setWebscreen("mManage_Orderid");
        item_orderid.setWebscreenName("Đơn hàng");
        item_orderid.setIconMenu(GetIDResource_Leftmenu(item_orderid.getWebscreen()));
        item_orderid.setLevel(2);
        item_orderid.setParentID(2);
        listchild_manage.add(item_orderid);

        // -- Hàng hóa
        MenuModel item_stock = new MenuModel();
        item_stock.setMenuId(23);
        item_stock.setWebscreen("mManage_Stock");
        item_stock.setWebscreenName("Hàng hóa");
        item_stock.setIconMenu(GetIDResource_Leftmenu(item_stock.getWebscreen()));
        item_stock.setLevel(2);
        item_stock.setParentID(2);
        listchild_manage.add(item_stock);

        // -- Nhập hàng
        MenuModel item_goodsreceipt = new MenuModel();
        item_goodsreceipt.setMenuId(24);
        item_goodsreceipt.setWebscreen("mManage_Goodsreceipt");
        item_goodsreceipt.setWebscreenName("Nhập hàng");
        item_goodsreceipt.setIconMenu(GetIDResource_Leftmenu(item_goodsreceipt.getWebscreen()));
        item_goodsreceipt.setLevel(2);
        item_goodsreceipt.setParentID(2);
        listchild_manage.add(item_goodsreceipt);

        // -- Kho hàng
        MenuModel item_manage_warehouse = new MenuModel();
        item_manage_warehouse.setMenuId(25);
        item_manage_warehouse.setWebscreen("mManage_Warehouse");
        item_manage_warehouse.setWebscreenName("Kho hàng");
        item_manage_warehouse.setIconMenu(GetIDResource_Leftmenu(item_manage_warehouse.getWebscreen()));
        item_manage_warehouse.setLevel(2);
        item_manage_warehouse.setParentID(2);
        listchild_manage.add(item_manage_warehouse);

        // -- Khuyến mãi
        MenuModel item_promotion = new MenuModel();
        item_promotion.setMenuId(26);
        item_promotion.setWebscreen("mManage_Promotion");
        item_promotion.setWebscreenName("Khuyến mãi");
        item_promotion.setIconMenu(GetIDResource_Leftmenu(item_promotion.getWebscreen()));
        item_promotion.setLevel(2);
        item_promotion.setParentID(2);
        listchild_manage.add(item_promotion);

        gListChildMenu.put(listchild_manage.get(0).getParentID(), listchild_manage);

        // Khách hàng
        List<MenuModel> listchild_customer = new ArrayList<>();
        // -- Thiết lập point
        MenuModel item_point = new MenuModel();
        item_point.setMenuId(31);
        item_point.setWebscreen("mCustomer_Point");
        item_point.setWebscreenName("Thiết lập Point");
        item_point.setIconMenu(GetIDResource_Leftmenu(item_point.getWebscreen()));
        item_point.setLevel(2);
        item_point.setParentID(3);
        listchild_customer.add(item_point);

        // -- Khách hàng
        MenuModel item_customer_customer = new MenuModel();
        item_customer_customer.setMenuId(32);
        item_customer_customer.setWebscreen("mCustomer_Customer");
        item_customer_customer.setWebscreenName("Khách hàng");
        item_customer_customer.setIconMenu(GetIDResource_Leftmenu(item_customer_customer.getWebscreen()));
        item_customer_customer.setLevel(2);
        item_customer_customer.setParentID(3);
        listchild_customer.add(item_customer_customer);

        // -- NCC
        MenuModel item_manufacture = new MenuModel();
        item_manufacture.setMenuId(33);
        item_manufacture.setWebscreen("mCustomer_Manuf");
        item_manufacture.setWebscreenName("Khuyến mãi");
        item_manufacture.setIconMenu(GetIDResource_Leftmenu(item_manufacture.getWebscreen()));
        item_manufacture.setLevel(2);
        item_manufacture.setParentID(3);
        listchild_customer.add(item_manufacture);

        // -- Nhóm KH
        MenuModel item_customergroup = new MenuModel();
        item_customergroup.setMenuId(34);
        item_customergroup.setWebscreen("mCustomer_Group");
        item_customergroup.setWebscreenName("Nhóm KH");
        item_customergroup.setIconMenu(GetIDResource_Leftmenu(item_customergroup.getWebscreen()));
        item_customergroup.setLevel(2);
        item_customergroup.setParentID(3);
        listchild_customer.add(item_customergroup);

        gListChildMenu.put(listchild_customer.get(0).getParentID(), listchild_customer);

        // Tiền bạc
        List<MenuModel> listchild_money = new ArrayList<>();
        // -- Tổng quan
        MenuModel item_money_general = new MenuModel();
        item_money_general.setMenuId(41);
        item_money_general.setWebscreen("mMoney_General");
        item_money_general.setWebscreenName("Tổng quan");
        item_money_general.setIconMenu(GetIDResource_Leftmenu(item_money_general.getWebscreen()));
        item_money_general.setLevel(2);
        item_money_general.setParentID(4);
        listchild_money.add(item_money_general);

        // -- Thu
        MenuModel item_receipts = new MenuModel();
        item_receipts.setMenuId(42);
        item_receipts.setWebscreen("mMoney_Receipts");
        item_receipts.setWebscreenName("Thu");
        item_receipts.setIconMenu(GetIDResource_Leftmenu(item_receipts.getWebscreen()));
        item_receipts.setLevel(2);
        item_receipts.setParentID(4);
        listchild_money.add(item_receipts);

        // -- Chi
        MenuModel item_payslip = new MenuModel();
        item_payslip.setMenuId(43);
        item_payslip.setWebscreen("mMoney_Payslip");
        item_payslip.setWebscreenName("Chi");
        item_payslip.setIconMenu(GetIDResource_Leftmenu(item_payslip.getWebscreen()));
        item_payslip.setLevel(2);
        item_payslip.setParentID(4);
        listchild_money.add(item_payslip);

        // -- Sổ quỹ
        MenuModel item_cashbooks = new MenuModel();
        item_cashbooks.setMenuId(44);
        item_cashbooks.setWebscreen("mMoney_Cashbook");
        item_cashbooks.setWebscreenName("Sổ quỹ");
        item_cashbooks.setIconMenu(GetIDResource_Leftmenu(item_cashbooks.getWebscreen()));
        item_cashbooks.setLevel(2);
        item_cashbooks.setParentID(4);
        listchild_money.add(item_cashbooks);

        gListChildMenu.put(listchild_money.get(0).getParentID(), listchild_money);

        // Báo cáo
        List<MenuModel> listchild_report = new ArrayList<>();
        // -- Doanh số
        MenuModel item_turnover = new MenuModel();
        item_turnover.setMenuId(51);
        item_turnover.setWebscreen("mReport_Turnover");
        item_turnover.setWebscreenName("Doanh số");
        item_turnover.setIconMenu(GetIDResource_Leftmenu(item_turnover.getWebscreen()));
        item_turnover.setLevel(2);
        item_turnover.setParentID(5);
        listchild_report.add(item_turnover);

        // -- Tồn kho
        MenuModel item_inventory = new MenuModel();
        item_inventory.setMenuId(52);
        item_inventory.setWebscreen("mReport_Inventory");
        item_inventory.setWebscreenName("Tồn kho");
        item_inventory.setIconMenu(GetIDResource_Leftmenu(item_inventory.getWebscreen()));
        item_inventory.setLevel(2);
        item_inventory.setParentID(5);
        listchild_report.add(item_inventory);

        // -- Lợi nhuận
        MenuModel item_profit = new MenuModel();
        item_profit.setMenuId(53);
        item_profit.setWebscreen("mReport_Profit");
        item_profit.setWebscreenName("Lợi nhuận");
        item_profit.setIconMenu(GetIDResource_Leftmenu(item_profit.getWebscreen()));
        item_profit.setLevel(2);
        item_profit.setParentID(5);
        listchild_report.add(item_profit);

        // -- Lãi lỗ
        MenuModel item_profit_loss = new MenuModel();
        item_profit_loss.setMenuId(54);
        item_profit_loss.setWebscreen("mReport_ProfitLoss");
        item_profit_loss.setWebscreenName("Lãi lỗ");
        item_profit_loss.setIconMenu(GetIDResource_Leftmenu(item_profit_loss.getWebscreen()));
        item_profit_loss.setLevel(2);
        item_profit_loss.setParentID(5);
        listchild_report.add(item_profit_loss);

        gListChildMenu.put(listchild_report.get(0).getParentID(), listchild_report);

        // Bán hàng

        // Thiết lập
        List<MenuModel> listchild_setting = new ArrayList<>();
        // -- Cửa hàng
        MenuModel item_shop = new MenuModel();
        item_shop.setMenuId(71);
        item_shop.setWebscreen("mSetting_Shop");
        item_shop.setWebscreenName("Cửa hàng");
        item_shop.setIconMenu(GetIDResource_Leftmenu(item_shop.getWebscreen()));
        item_shop.setLevel(2);
        item_shop.setParentID(7);
        listchild_setting.add(item_shop);

        // -- Bán hàng
        MenuModel item_manage_warehouse_sell = new MenuModel();
        item_manage_warehouse_sell.setMenuId(62);
        item_manage_warehouse_sell.setWebscreen("mSetting_Sell");
        item_manage_warehouse_sell.setWebscreenName("Bán hàng");
        item_manage_warehouse_sell.setIconMenu(GetIDResource_Leftmenu(item_manage_warehouse_sell.getWebscreen()));
        item_manage_warehouse_sell.setLevel(2);
        item_manage_warehouse_sell.setParentID(7);
        listchild_setting.add(item_manage_warehouse_sell);

        // -- Nhân viên
        MenuModel item_employee = new MenuModel();
        item_employee.setMenuId(73);
        item_employee.setWebscreen("mSetting_Employee");
        item_employee.setWebscreenName("Nhân viên");
        item_employee.setIconMenu(GetIDResource_Leftmenu(item_employee.getWebscreen()));
        item_employee.setLevel(2);
        item_employee.setParentID(7);
        listchild_setting.add(item_employee);

        gListChildMenu.put(listchild_setting.get(0).getParentID(), listchild_setting);

    }

    private void initNavigationMennusNew() {

        AddListParentChildMenu();

        menu_main_drawer_expandableListview_adapter = new Menu_Main_Drawer_ExpandableListview_Adapter(this, gListParentMenu, gListChildMenu);
        expandableListViewmenu.setAdapter(menu_main_drawer_expandableListview_adapter);
        expandableListViewmenu.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                MenuModel nodeclick = (MenuModel) menu_main_drawer_expandableListview_adapter.getChild(groupPosition, childPosition);
                if (nodeclick != null) {
                    if (nodeclick.getLevel() == 2) {
                        StartActivityfromButton(nodeclick.getWebscreen());

                        drawer.closeDrawers();
                    }
                }
                return false;
            }
        });
        expandableListViewmenu.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                MenuModel nodeclick = (MenuModel) menu_main_drawer_expandableListview_adapter.getGroup(groupPosition);
                if (nodeclick != null && nodeclick.getMenuId() == -1) {
                    //StartActivityfromButton(nodeclick.getWebscreen());
                }
                return false;
            }
        });

    }

    private void StartActivityfromButton(String menucode) {
        boolean isMenuBottom = false;
        switch (menucode) {
////////////////////////////////////////// Quản lý
            case "mManage_Overview":

                break;

            case "mManage_Orderid":
                LoadFragment(fm_Order, "Đơn hàng");
                break;

            case "mManage_Stock":
                LoadFragment(fm_ProductManager, "Hàng hóa");
                break;

            case "mManage_Goodsreceipt":

                break;

            case "mManage_Warehouse":
                LoadFragment(fm_StockWarehouse, "Kho hàng");
                break;

            case "mManage_Promotion":
                break;

////////////////////////////////////////// Khách hàng
            case "mCustomer_Point":
                LoadFragment(fm_PointSetting, "Thiết lập Point");
                break;

            case "mCustomer_Customer":
                LoadFragment(fm_Customer, "Khách hàng");
                break;

            case "mCustomer_Manuf":
                LoadFragment(fm_CreateCustomers, "Add");
                break;

            case "mCustomer_Group":
                break;

////////////////////////////////////////// Tiền bạc
            case "mMoney_General": // Tổng quan
                break;

            case "mMoney_Receipts": // Thu
                LoadFragment(fm_ReceiptMoney, "Thu");
                break;

            case "mMoney_Payslip": // Chi
                LoadFragment(fm_PayslipMoney, "Chi");
                break;

            case "mMoney_Cashbook": // Sổ quỹ
                break;

////////////////////////////////////////// Báo cáo
            case "mReport_Turnover": // Doanh số
                LoadFragment(fm_ReportQuantity, "Báo cáo doanh số");
                break;

            case "mReport_Inventory": // Tồn kho
                LoadFragment(fm_Iventory, "Báo cáo tồn kho");
                break;

            case "mReport_Profit": // Lợi nhuận
                LoadFragment(fm_ProfitReport, "Báo cáo lợi nhuận");
                break;

            case "mReport_ProfitLoss": //Lãi lỗ
                LoadFragment(fm_ProfitLossReport, "Báo cáo lãi lỗ");
                break;

/////////////////////////////////////////// Thiết lập
            case "mSetting_Shop":
                LoadFragment(fm_Shop, "Cửa hàng");
                break;

            case "mSetting_Sell":
                LoadFragment(fm_SettingSell, "Thiết lập bán hàng");

                break;

            case "mSetting_Employee":
                break;

        }
    }

    @Override
    public void onBackPressed() {
        /*if (sendBackPressToDrawer()) {
            return;
        }*/

        /*if (sendBackPressToFragmentOnTop()) {
            return;
        }*/

        //getSupportFragmentManager().popBackStack(null, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);

        gtitle.setText("");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(false);
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        bottomNavigationView.setSelectedItemId(R.id.item_Home);

        /*if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();

            if(getSupportFragmentManager().getBackStackEntryCount() == 0){
                //actionBar.setTitle("");
                gtitle.setText("");
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(false);
                toggle.setDrawerIndicatorEnabled(true);
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            } else {

                onBackFragement();
            }

        } else {
            getSupportFragmentManager().popBackStack();
        }*/
    }

    @Override
    public boolean onSupportNavigateUp() {

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(new View(context).getWindowToken(), 0);
//        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        if (!toggle.isDrawerIndicatorEnabled()) { // show arrow icon
            onBackPressed();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == android.R.id.home) {

            if (toggle.isDrawerIndicatorEnabled()) { // show humberger icon
                if (drawer.isDrawerOpen(Gravity.START)) {
                    drawer.closeDrawer(Gravity.START);
                } else {
                    drawer.openDrawer(Gravity.START);
                }
            } else { // show arrow icon
                //Toast.makeText(context, "arrow icon", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onRegisterSuccess(String user) {

    }

    @Override
    public void onRegisterError(String msg) {

    }

    @Override
    public boolean valid() {
        return false;
    }

    @NonNull
    @Override
    public HomePresenter providePresenter() {
        return new HomePresenter();
    }


    @Override
    public void onProductInteraction(String obj, Class type) {

    }

    @Override
    public void onDialog(Object obj) {

        //<editor-fold desc="Show dialog test">
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Có cập nhật mới! Vui lòng cập nhật để tiếp tục sử dụng");

        builder.setPositiveButton("Cập nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("market://details?id=com.sskey.knguyen.hrmkimnguyen")));
                dialog.dismiss();
            }
        });
        builder.setCancelable(true);
        dialog = builder.show();
        //</editor-fold>
    }

}
