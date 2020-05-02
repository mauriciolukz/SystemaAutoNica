package com.example.administrador.systemaautonica.paqueteria;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Administrador on 3/3/2018.
 */

public class Email_Autherticator  extends Authenticator {

    String username = "christian.gurdian@autonica.com";
    String password = "sabiene29";

    public Email_Autherticator() {
        super();
    }

    public Email_Autherticator(String user,String pwd){
        super();
        username = user;
        password = pwd;
    }

    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username,password);
    }

}
