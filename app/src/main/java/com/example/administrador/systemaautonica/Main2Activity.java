package com.example.administrador.systemaautonica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button rececionare;
    private Button RetornoVehiculo;
    private Button lista;
    private Button cerrar;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rececionare = (Button) findViewById(R.id.btnEjecucion);
        lista = (Button) findViewById(R.id.btnLista);
        cerrar = (Button) findViewById(R.id.btnCloset);
        RetornoVehiculo = (Button) findViewById(R.id.btnRetornoVehiculo);
        text = (TextView) findViewById(R.id.textView39);

        finishActivity(R.layout.activity_main_firma);
        finishActivity(R.layout.activity_main_comentario);
        finishActivity(R.layout.activity_main_llanta);
        finishActivity(R.layout.activity_galeria_verificar);
        finishActivity(R.layout.activity_citas);

        SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String defaultValue1 = sharedPref.getString("Nombre","");
        String defaultValue2 = sharedPref.getString("permiso","");
        String defaultValue3 = sharedPref.getString("lugar","");
        String correo = sharedPref.getString("correo","");


        rececionare.setVisibility(View.INVISIBLE);

        text.setText("\n"+defaultValue1+"\n\nUbicacion del sistema: "+defaultValue3+"\nTipo de personal: "+defaultValue2);

        rececionare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recepcionar = new Intent(Main2Activity.this, citas.class);
                startActivity(recepcionar);
            }
        });

        RetornoVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recepcionar = new Intent(Main2Activity.this, MainRetornoVehiculo.class);
                startActivity(recepcionar);
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear().commit();
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

    }
}

