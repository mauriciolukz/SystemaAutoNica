package com.example.administrador.systemaautonica;

/**
 * Created by Administrador on 14/2/2018.
 */

public class dataParqueo {

    private int id;
    private String nombre;

    public dataParqueo() {
    }

    public dataParqueo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
