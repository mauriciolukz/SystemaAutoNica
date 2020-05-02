package com.example.administrador.systemaautonica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainComentario extends AppCompatActivity {

    private Button siguiente;
    public EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comentario);

        siguiente = (Button) findViewById(R.id.BtnSiquienteHoja);
        comentario = (EditText) findViewById(R.id.editText5);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                /**** Documento de Vehiculo ****/
                editor.putString("COMENT",comentario.getText().toString());

                editor.commit();

                Intent recepcionar = new Intent(MainComentario.this, MainFirma.class);
                startActivity(recepcionar);
            }
        });
    }
}
