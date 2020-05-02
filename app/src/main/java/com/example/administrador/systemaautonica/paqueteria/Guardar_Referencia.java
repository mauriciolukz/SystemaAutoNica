package com.example.administrador.systemaautonica.paqueteria;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Administrador on 27/3/2018.
 */

public class Guardar_Referencia extends AsyncTask<Guardar_Referencia.contructor,Void,Void> {

    private final Context df;

    public Guardar_Referencia(Context df) {
        super();
        this.df = df;
    }

    @Override
    protected Void doInBackground(contructor... contructors) {
        return null;
    }

    public static class contructor{
        private final String subject;
        private final String content;

        public contructor(String subject, String content){
            this.subject=subject;
            this.content=content;
        }
    }

}
