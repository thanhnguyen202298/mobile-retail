package com.ssk.retailshop.screen.homenavigation.model;

public class MenuModel {
    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int menuId) {
        MenuId = menuId;
    }

    public String getWebscreen() {
        return Webscreen;
    }

    public void setWebscreen(String webscreen) {
        Webscreen = webscreen;
    }

    public String getWebscreenName() {
        return WebscreenName;
    }

    public void setWebscreenName(String webscreenName) {
        WebscreenName = webscreenName;
    }

    public Integer getIconMenu() {
        return IconMenu;
    }

    public void setIconMenu(int iconMenu) {
        IconMenu = iconMenu;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    private int MenuId;
    private String Webscreen;
    private String WebscreenName;
    private int IconMenu;
    private int ParentID;
    private int Level;
}
