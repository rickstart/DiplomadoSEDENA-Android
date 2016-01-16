package com.mobintum.slideshowcities;

import android.graphics.drawable.Drawable;

/**
 * Created by Rick on 16/01/16.
 */
public class City {
    private String name;
    private String population;
    private String description;
    private Drawable photo;

    public City(String name, String population, String description, Drawable photo) {
        this.name = name;
        this.population = population;
        this.description = description;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }
}
