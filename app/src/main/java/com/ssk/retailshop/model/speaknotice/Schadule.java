package com.ssk.retailshop.model.speaknotice;


import com.ssk.retailshop.customview.ItemVariable;

public class Schadule extends ItemVariable {
    public String SchaduleId;
    public String FromUser;
    public String ToUser;
    public String ContentMsg;
    public String CreateOn;
    public String DateOnSchadule;
    public String SchaduleName;

    @Override
    public String getIdItem() {
        return SchaduleId;
    }

    @Override
    public String getLabel() {
        return SchaduleName;
    }

    @Override
    public String getIdDrawer() {
        return null;
    }
}
