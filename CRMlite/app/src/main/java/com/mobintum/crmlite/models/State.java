package com.mobintum.crmlite.models;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class State {

    private int stateId;
    private String name;
    private int countryId;

    public State(int stateId, String name, int countryId) {
        this.stateId = stateId;
        this.name = name;
        this.countryId = countryId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
