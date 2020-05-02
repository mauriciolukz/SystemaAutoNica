package com.example.administrador.systemaautonica;

/**
 * Created by Administrador on 2/4/2018.
 */

public class dataCliente {

    private String Descripcion;
    private String Grupo;
    private String Area;
    private String Cedula;
    private String Rol;
    private String Nombre;

    public dataCliente() { }

    public dataCliente(String descripcion, String grupo, String area, String cedula, String rol, String nombre) {
        Descripcion = descripcion;
        Grupo = grupo;
        Area = area;
        Cedula = cedula;
        Rol = rol;
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
