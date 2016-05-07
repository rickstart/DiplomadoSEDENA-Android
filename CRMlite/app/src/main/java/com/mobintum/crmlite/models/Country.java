package com.mobintum.crmlite.models;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Country {

    private int countryId;
    private String name;

    public Country(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
