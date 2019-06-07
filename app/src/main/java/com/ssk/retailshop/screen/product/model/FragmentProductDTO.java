package com.ssk.retailshop.screen.product.model;

public class FragmentProductDTO {
    private boolean IsParent;
    private String ID;
    private String Title;
    private String Code;
    private String Created;
    private int Qty;
    private double Price;
    private String VendorName;
    private String CategoryName;
    private String ImageUrl;
    private String parentId;
    private String CreatedBy;
    private String Modify;
    private String ModifyBy;

    public FragmentProductDTO() {
    }

    public FragmentProductDTO(boolean isParent, String ID, String title, String code, String created, int qty, double price, String vendorName, String categoryName, String imageUrl, String parentId, String createdBy, String modify, String modifyBy) {
        IsParent = isParent;
        this.ID = ID;
        Title = title;
        Code = code;
        Created = created;
        Qty = qty;
        Price = price;
        VendorName = vendorName;
        CategoryName = categoryName;
        ImageUrl = imageUrl;
        this.parentId = parentId;
        CreatedBy = createdBy;
        Modify = modify;
        ModifyBy = modifyBy;
    }

    public boolean isParent() {
        return IsParent;
    }

    public void setParent(boolean parent) {
        IsParent = parent;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModify() {
        return Modify;
    }

    public void setModify(String modify) {
        Modify = modify;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }
}
