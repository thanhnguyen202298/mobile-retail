package com.ssk.retailshop.screen.homenavigation.model;

public class BackFragemnt {

    private String Title;
    private int IdBottom;

    public BackFragemnt(String title, int idBottom) {
        Title = title;
        IdBottom = idBottom;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getIdBottom() {
        return IdBottom;
    }

    public void setIdBottom(int idBottom) {
        IdBottom = idBottom;
    }
}
