package com.mobintum.chicasapp;

import android.graphics.drawable.Drawable;

/**
 * Created by Rick on 17/12/15.
 */
public class Chica {
    private String name;
    private Drawable imagen;

    public Chica(String name, Drawable imagen) {
        this.name = name;
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
