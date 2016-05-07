package com.mobintum.crmlite.models;

/**
 * Created by Rick on 07/05/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Address {

    private int addressId;
    private String street;
    private String number;
    private String numberInterior;
    private String building;
    private String neightborhood;
    private String city;
    private String telephone;
    private String mobile;
    private String zipcode;
    private double latitude;
    private double logitude;
    private String state;
    private int fk_countryId;
    private int fk_stateId;

    public Address(int addressId, String street, String number, String numberInterior, String building, String neightborhood, String city, String telephone, String mobile, String zipcode, double latitude, double logitude, String state, int fk_countryId, int fk_stateId) {
        this.addressId = addressId;
        this.street = street;
        this.number = number;
        this.numberInterior = numberInterior;
        this.building = building;
        this.neightborhood = neightborhood;
        this.city = city;
        this.telephone = telephone;
        this.mobile = mobile;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.logitude = logitude;
        this.state = state;
        this.fk_countryId = fk_countryId;
        this.fk_stateId = fk_stateId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberInterior() {
        return numberInterior;
    }

    public void setNumberInterior(String numberInterior) {
        this.numberInterior = numberInterior;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getNeightborhood() {
        return neightborhood;
    }

    public void setNeightborhood(String neightborhood) {
        this.neightborhood = neightborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLogitude() {
        return logitude;
    }

    public void setLogitude(double logitude) {
        this.logitude = logitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getFk_countryId() {
        return fk_countryId;
    }

    public void setFk_countryId(int fk_countryId) {
        this.fk_countryId = fk_countryId;
    }

    public int getFk_stateId() {
        return fk_stateId;
    }

    public void setFk_stateId(int fk_stateId) {
        this.fk_stateId = fk_stateId;
    }
}
