package com.example.administrador.systemaautonica;

/**
 * Created by Administrador on 6/2/2018.
 */

public class dataUsuario {

    String passw;
    String usuario;
    int permiso;

    public dataUsuario(){}

    public dataUsuario(String passw, String usuario, int permiso) {
        this.passw = passw;
        this.usuario = usuario;
        this.permiso = permiso;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
}
