package com.example.administrador.systemaautonica.paqueteria;

/**
 * Created by Administrador on 9/4/2018.
 */

public class dataImage {

    String Nombre;
    String Fecha;
    String Image;

    public dataImage() {
    }

    public dataImage(String nombre, String fecha, String image) {
        Nombre = nombre;
        Fecha = fecha;
        Image = image;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

