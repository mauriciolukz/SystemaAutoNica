package com.example.administrador.systemaautonica;

import android.graphics.Bitmap;

/**
 * Created by Administrador on 24/2/2018.
 */

public class dataImagenes {

    String id;
    String datos;
    Bitmap image;


    public dataImagenes() {
    }

    public dataImagenes(String datos, Bitmap image) {
        this.datos = datos;
        this.image = image;
    }

    public dataImagenes(String id, String datos, Bitmap image) {
        this.id = id;
        this.datos = datos;
        this.image = image;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
