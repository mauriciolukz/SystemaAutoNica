package com.example.administrador.systemaautonica;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.systemaautonica.paqueteria.HelloIntentService;
import com.example.administrador.systemaautonica.paqueteria.OtrasClases;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    public Button Ingresar;
    public Button Cerrar;
    public EditText usuario;
    public EditText clave;
    public Button prueba;
    public TextView lista;

    private int df = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ingresar = (Button) findViewById(R.id.btnIngresar);
        Cerrar = (Button) findViewById(R.id.btnCerrar);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        clave = (EditText) findViewById(R.id.txtPassword);
        prueba = (Button) findViewById(R.id.button);
        lista = (TextView) findViewById(R.id.textView7);

        /*HelloIntentService d = new HelloIntentService();
        d.onDestroy();*/

        SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String ID = sharedPref.getString("ID","");

        if(ID != ""){
            Intent Aplicacio = new Intent(MainActivity.this, Main2Activity.class);
            Aplicacio.putExtra("informacionUsuario",ID);
            startActivity(Aplicacio);
        }

        new OtrasClases().eliminar_fichero(this);

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contructot_dialigo();
            }
        });

        prueba.setVisibility(View.INVISIBLE);

        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new OtrasClases().crear_y_mover_fichero(getApplication(),"archivo_prueba");
                activarServicio(view);
            }
        });

        Cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            }
        });

        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = ""+usuario.getText().toString();
                String pasw = ""+clave.getText().toString();

                if(user == ""){
                    Toast.makeText(getApplicationContext(), "Es necesario Un usuario", Toast.LENGTH_LONG).show();
                }else{
                    if(pasw==""){
                        Toast.makeText(getApplicationContext(), "Es necesario una cotraseña", Toast.LENGTH_LONG).show();
                    }else{

                        dataUsuario df = new dataUsuario();

                        df.setUsuario(usuario.getText().toString());
                        df.setPassw(clave.getText().toString());

                        String lugar = lista.getText().toString();

                        String id_usuario = new conexion_base_de_datos().ObtenerVerificacion(MainActivity.this,df, lugar);

                        if(id_usuario != ""){
                            Intent Aplicacio = new Intent(MainActivity.this, Main2Activity.class);
                            Aplicacio.putExtra("informacionUsuario",id_usuario);
                            startActivity(Aplicacio);
                        }
                    }
                }
            }
        });
    }


    private void contructot_dialigo(){

            final List<CharSequence> charSequences = new ArrayList<>();
            charSequences.add(new String("CA"));
            charSequences.add(new String("DEPALCO"));
            charSequences.add(new String("SUBURBANA"));
            CharSequence[] charSequenceArray = charSequences.toArray(new
                    CharSequence[charSequences.size()]);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Selecionar la ubicación");

            builder.setItems(charSequenceArray, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String df = charSequences.get(i).toString();
                    lista.setText(df);

                }
            });

            Dialog dialogo = builder.create();
            dialogo.show();

    }

    public void activarServicio(View v) {
        Intent service = new Intent(this, HelloIntentService.class);
        startService(service);
    }


}
