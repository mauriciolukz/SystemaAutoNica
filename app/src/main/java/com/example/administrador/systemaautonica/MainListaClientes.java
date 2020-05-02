package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainListaClientes extends AppCompatActivity {

    private RecyclerView recyclerViewUsuario;
    private RecycleViewUsuarios lista;


    private int catidad_datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_clientes);

        Intent recibir = getIntent();

        int dfg = recibir.getIntExtra("getIDzRecepcionVehiculo",0);

        Toast.makeText(getApplicationContext(),"Valor de Entrada: "+dfg, Toast.LENGTH_SHORT).show();

        recyclerViewUsuario = (RecyclerView) findViewById(R.id.recyleUsarios);
        recyclerViewUsuario.setLayoutManager(new LinearLayoutManager(this));

        List<dataImagenes> df = new conexion_base_de_datos().ListaImagenes(this,""+dfg);

        lista = new RecycleViewUsuarios(df, this);

        recyclerViewUsuario.setAdapter(lista);

        catidad_datos = lista.getItemCount();


    }
}

