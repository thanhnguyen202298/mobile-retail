package com.ssk.retailshop.screen.customer.model;

public class CreateCustomersDTO {
    private String ID;
    private String FullName;
    private String Phone;
    private String Address;
    private String SEX;
    private String TaxCode;
    private String Code;
    private String Email;
    private String Birthday;
    private String Type;
    private String ModifyBy;
    private String StoreID;
    private String CreatedBy;

    public CreateCustomersDTO() {
    }

    public CreateCustomersDTO(String ID, String fullName, String phone, String address, String SEX, String taxCode, String code, String email, String birthday, String type, String modifyBy, String storeID, String createdBy) {
        this.ID = ID;
        FullName = fullName;
        Phone = phone;
        Address = address;
        this.SEX = SEX;
        TaxCode = taxCode;
        Code = code;
        Email = email;
        Birthday = birthday;
        Type = type;
        ModifyBy = modifyBy;
        StoreID = storeID;
        CreatedBy = createdBy;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getTaxCode() {
        return TaxCode;
    }

    public void setTaxCode(String taxCode) {
        TaxCode = taxCode;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}
