package com.ssk.retailshop.customview;

public class ItemVariable {
    public String IdDrawer;
    public String Label;

    public String getIdItem() {
        return IdItem;
    }

    public String IdItem;

    public String Amount = "";

    public String getLabel() {
        if(Amount==null)
            return Label;
        return Label + "\n" + Amount;
    }

    public String getIdDrawer() {
        return IdDrawer;
    }
}
