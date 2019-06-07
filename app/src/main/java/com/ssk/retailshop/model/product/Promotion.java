package com.ssk.retailshop.model.product;

import com.google.gson.annotations.SerializedName;
import com.ssk.retailshop.customview.ItemVariable;

public class Promotion extends ItemVariable {
    public String PromotionCode;
    @SerializedName("Name")
    public String NamePro;
    public String ProductRange;
    public double Quantity;
    public double Discount;
    public double DiscountPercent;
    public String ProductMustBuy;
    public String ProductAllowBuy;
    public String ImgUrl;
    public String ModifyBy;
    public String ModifyOn;
    public String CreateOn;
    public String FromDate;
    public String ToDate;

    @Override
    public String getIdDrawer() {
        return ImgUrl;
    }

    @Override
    public String getLabel() {
        return NamePro;
    }

    @Override
    public String getIdItem() {
        return PromotionCode;
    }
}
