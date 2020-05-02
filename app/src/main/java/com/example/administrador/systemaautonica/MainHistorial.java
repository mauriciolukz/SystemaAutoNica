package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainHistorial extends AppCompatActivity {

    private RecyclerView History;

    private RecycleViewHistorial lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_historial);

        Intent recibir = getIntent();

        String motor = recibir.getStringExtra("getCUSTNMBR");

        Toast.makeText(this, "Valor: "+motor, Toast.LENGTH_SHORT).show();

        History = (RecyclerView) findViewById(R.id.recyleHistorial);

        List<dataHistorial> lista_ = new conexion_base_de_datos().ObtenerDatosHistorial(this,motor);

        History.setLayoutManager(new LinearLayoutManager(this));

        lista = new RecycleViewHistorial(this,lista_);

        History.setAdapter(lista);
    }
}
