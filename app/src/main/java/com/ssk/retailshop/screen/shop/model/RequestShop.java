package com.ssk.retailshop.screen.shop.model;

import android.databinding.BaseObservable;

public class RequestShop extends BaseObservable {

    private String shopname;
    private String shopcode;
    private String person;
    private String email;
    private Integer productgroup;
    private String vatnumber;
    private String website;

    public RequestShop() {
    }

    public RequestShop(String shopname, String shopcode, String person, String email, Integer productgroup, String vatnumber, String website) {
        this.shopname = shopname;
        this.shopcode = shopcode;
        this.person = person;
        this.email = email;
        this.productgroup = productgroup;
        this.vatnumber = vatnumber;
        this.website = website;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopcode() {
        return shopcode;
    }

    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProductgroup() {
        return productgroup;
    }

    public void setProductgroup(Integer productgroup) {
        this.productgroup = productgroup;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
