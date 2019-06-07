package com.ssk.retailshop.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssk.retailshop.model.product.Brandy;
import com.ssk.retailshop.model.product.Product;
import com.ssk.retailshop.model.product.Promotion;
import com.ssk.retailshop.screen.customer.model.CustomerItem;
import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;
import com.ssk.retailshop.screen.order.model.OrderItem;
import com.ssk.retailshop.screen.product.model.FragmentProductDTO;
import com.ssk.retailshop.screen.report.model.InventoryListDTO;
import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;
import com.ssk.retailshop.screen.report.model.ProfitReportItem;
import com.ssk.retailshop.screen.report.model.ReportFragmentDTO;
import com.ssk.retailshop.screen.report.model.ReportToProductDTO;
import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;
import com.ssk.retailshop.screen.stockwarehouse.model.StockWarehouseItem;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemHolder> implements MyBindingAdapter<List<Object>> {

    private List mylist;
    private static Context base;
    private GridLayoutManager managerlayout;
    private int resLayout;
    private int idVar;
    private onProductInteraction onClickFragment;

    public MyAdapter(Context context, int resIdlayout, int column, int varBinding, int orient) {
        mylist = new ArrayList<>();
        base = context;
        resLayout = resIdlayout;
        managerlayout = new GridLayoutManager(context, column, orient, false);
        idVar = varBinding;
    }

    public void setOnClickFragment(onProductInteraction onClickFragment) {
        this.onClickFragment = onClickFragment;
    }

    public GridLayoutManager getLayoutManager() {
        return managerlayout;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater lif = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding vdata = DataBindingUtil.inflate(lif, resLayout, viewGroup, false);
        return new ItemHolder(vdata);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Object oj = mylist.get(i);
        ItemBindingType(itemHolder, oj);
//        itemHolder.v.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if()
//                Toast.makeText(base, "Test thu", Toast.LENGTH_SHORT).show();
//
//            }

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    @Override
    public void setData(List<Object> data) {
        mylist = data;
        notifyDataSetChanged();
    }

    void ItemBindingType(ItemHolder itemHolder, Object oj) {
        Brandy br = null;
        Product pr = null;
        Promotion prom = null;

        if (oj instanceof Brandy) {
            br = (Brandy) oj;
        }
        if (oj instanceof Product) {
            pr = (Product) oj;
        }
        if (oj instanceof Promotion) {
            prom = (Promotion) oj;
        }
        // LocND
        if (oj instanceof OrderItem) {
            final OrderItem orderItem = (OrderItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, orderItem);
        }
        if (oj instanceof CustomerItem) {
            final CustomerItem customerItem = (CustomerItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, customerItem);
        }
        if (oj instanceof StockWarehouseItem) {
            final StockWarehouseItem stockWarehouseItem = (StockWarehouseItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, stockWarehouseItem);
        }
        if (oj instanceof ProfitReportItem) {
            final ProfitReportItem profitReportItem = (ProfitReportItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, profitReportItem);
        }
        if (oj instanceof ProfitLossReportItem) {
            final ProfitLossReportItem profitLossReportItem = (ProfitLossReportItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, profitLossReportItem);
        }
        if (oj instanceof ReceiptMoneyItem) {
            final ReceiptMoneyItem receiptMoneyItem = (ReceiptMoneyItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, receiptMoneyItem);
        }
        if (oj instanceof PayslipMoneyItem) {
            final PayslipMoneyItem payslipMoneyItem = (PayslipMoneyItem) oj;
            itemHolder.getLayoutBind().setVariable(idVar, payslipMoneyItem);
        }
        //Tiến
        //region Tiến create show date for Oject and event Click item
        if (oj instanceof ReportToTimeDTO) {
            final ReportToTimeDTO reportToTime = (ReportToTimeDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, reportToTime);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(reportToTime);

                }
            });
        }
        if (oj instanceof ReportToProductDTO) {
            final ReportToProductDTO reportToProduct = (ReportToProductDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, reportToProduct);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(reportToProduct);

                }
            });
        }
        if (oj instanceof ReportToStoreDTO) {
            final ReportToStoreDTO reportToStoreDTO = (ReportToStoreDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, reportToStoreDTO);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(reportToStoreDTO);

                }
            });
        }

        if (oj instanceof ReportToSalesManDTO) {
            final ReportToSalesManDTO reportToSalesManDTO = (ReportToSalesManDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, reportToSalesManDTO);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(reportToSalesManDTO);

                }
            });
        }
        if (oj instanceof InventoryListDTO) {
            final InventoryListDTO inventoryListDTO = (InventoryListDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, inventoryListDTO);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(inventoryListDTO);

                }
            });
        }
        if (oj instanceof FragmentProductDTO) {
            final FragmentProductDTO fragmentProductDTO = (FragmentProductDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, fragmentProductDTO);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(fragmentProductDTO);

                }
            });
        }
        if (oj instanceof ReportFragmentDTO) {
            final ReportFragmentDTO reportFragmentDTO = (ReportFragmentDTO) oj;
            itemHolder.getLayoutBind().setVariable(idVar, reportFragmentDTO);
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickFragment.onDialog(reportFragmentDTO);

                }
            });
        }
        //endregion

        if (br != null)
            itemHolder.getLayoutBind().setVariable(idVar, br);
        if (pr != null)
            itemHolder.getLayoutBind().setVariable(idVar, pr);
        if (prom != null)
            itemHolder.getLayoutBind().setVariable(idVar, prom);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ViewDataBinding v;

        public ItemHolder(ViewDataBinding view) {
            super(view.getRoot());
            v = view;
        }

        public ViewDataBinding getLayoutBind() {

            return v;
        }
    }
}