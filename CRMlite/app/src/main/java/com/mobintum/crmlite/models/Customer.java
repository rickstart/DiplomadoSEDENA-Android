package com.mobintum.crmlite.models;

import android.content.ContentValues;
import android.content.Context;

import com.mobintum.crmlite.database.DatabaseAdapter;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Customer {
    public static final String TABLE_NAME = "Customer";

    public static final String CUSTOMER_ID = "customerId";
    public static final String NAME = "name";
    public static final String BUSINESS_NAME = "businessName";
    public static final String RFC = "rfc";
    public static final String NOTES = "notes";
    public static final String FK_ADDRESS_ID = "fk_addressId";

    private int customerId;
    private String name;
    private String businessName;
    private String rfc;
    private String notes;
    private int fk_addressId;

    public static long insert(Context context,Customer customer){
        ContentValues cv = new ContentValues();
        cv.put(NAME, customer.getName());
        cv.put(BUSINESS_NAME, customer.getBusinessName());
        cv.put(RFC, customer.getRfc());
        cv.put(NOTES,customer.getNotes());
        cv.put(FK_ADDRESS_ID, customer.getFk_addressId());
        return DatabaseAdapter.getDB(context).insert(TABLE_NAME,null,cv);
    }

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
