package com.mobintum.crmlite.models;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Customer {
    private int customerId;
    private String name;
    private String businessName;
    private String rfc;
    private String notes;
    private int fk_addressId;

    public Customer(int customerId, String name, String businessName, String rfc, String notes, int fk_addressId) {
        this.customerId = customerId;
        this.name = name;
        this.businessName = businessName;
        this.rfc = rfc;
        this.notes = notes;
        this.fk_addressId = fk_addressId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getFk_addressId() {
        return fk_addressId;
    }

    public void setFk_addressId(int fk_addressId) {
        this.fk_addressId = fk_addressId;
    }
}
