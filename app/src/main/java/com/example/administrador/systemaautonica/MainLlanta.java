package com.example.administrador.systemaautonica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.GridLayout;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.example.administrador.systemaautonica.paqueteria.OtrasClases;

public class MainLlanta extends AppCompatActivity {

    OtrasClases o = new OtrasClases();

    private ImageView imageVista;
    public ToggleButton btn1, btn2, btn3, btn4;
    private Button continuar;
    private GridLayout layout1;
    private GridLayout layout2;
    private GridLayout layout3;
    private GridLayout layout4;
    private EditText TLlanta1, TLlanta2, TLlanta3, TLlanta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_llanta);

        btn1 = (ToggleButton) findViewById(R.id.tBt_F_izquierda);
        btn2 = (ToggleButton) findViewById(R.id.tBt_F_derecha);
        btn3 = (ToggleButton) findViewById(R.id.tBt_T_izquierda);
        btn4 = (ToggleButton) findViewById(R.id.tBt_T_derecha);
        continuar = (Button) findViewById(R.id.btnContinuar);
        imageVista = (ImageView) findViewById(R.id.imageViewLlantas);
        layout1 = (GridLayout) findViewById(R.id.ID_llanta1);
        layout2 = (GridLayout) findViewById(R.id.ID_llanta2);
        layout3 = (GridLayout) findViewById(R.id.ID_llanta3);
        layout4 = (GridLayout) findViewById(R.id.ID_llanta4);
        TLlanta1 = (EditText) findViewById(R.id.TextLlanta1);
        TLlanta2 = (EditText) findViewById(R.id.TextLlanta2);
        TLlanta3 = (EditText) findViewById(R.id.TextLlanta3);
        TLlanta4 = (EditText) findViewById(R.id.TextLlanta4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_imagen();
                if(btn1.isChecked()){
                    o.animar(true, layout1);
                    layout1.setVisibility(View.VISIBLE);
                }else{
                    o.animar(false, layout1);
                    layout1.setVisibility(View.GONE);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_imagen();
                if(btn2.isChecked()){
                    o.animar(true, layout2);
                    layout2.setVisibility(View.VISIBLE);
                }else{
                    o.animar(false, layout2);
                    layout2.setVisibility(View.GONE);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_imagen();
                if(btn3.isChecked()){
                    o.animar(true, layout3);
                    layout3.setVisibility(View.VISIBLE);
                }else{
                    o.animar(false, layout3);
                    layout3.setVisibility(View.GONE);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_imagen();
                if(btn4.isChecked()){
                    o.animar(true, layout4);
                    layout4.setVisibility(View.VISIBLE);
                }else{
                    o.animar(false, layout4);
                    layout4.setVisibility(View.GONE);
                }
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                /**** Documento de Vehiculo ****/
                editor.putBoolean("AUTLL1",btn1.isChecked());
                editor.putBoolean("AUTLL2",btn2.isChecked());
                editor.putBoolean("AUTLL3",btn3.isChecked());
                editor.putBoolean("AUTLL4",btn3.isChecked());

                editor.putString("DETLL1",TLlanta1.getText().toString());
                editor.putString("DETLL2",TLlanta2.getText().toString());
                editor.putString("DETLL3",TLlanta3.getText().toString());
                editor.putString("DETLL4",TLlanta4.getText().toString());

                editor.commit();

                Intent Aplicacio = new Intent(MainLlanta.this, MainComentario.class);
                startActivity(Aplicacio);

            }
        });

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
    }

    private void accion_imagen(){

        String FI = "0", FD = "0", TI = "0", TD = "0";

        if(btn1.isChecked()){
            FI = "1";
        }
        if(btn2.isChecked()){
            FD = "1";
        }
        if(btn3.isChecked()){
            TI = "1";
        }
        if(btn4.isChecked()){
            TD = "1";
        }

        String nombre = "accion"+TD+TI+FD+FI;
        imageVista.setImageResource(o.getDrawable(this,nombre));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}
