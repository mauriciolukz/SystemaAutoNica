package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainDetalleHistorial extends AppCompatActivity {

    private RecyclerView DetalleHistorial;

    private RecycleViewDetalleHistorial lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_historial);

        DetalleHistorial = (RecyclerView) findViewById(R.id.RecyclerDetalleHistorial);

        Intent recibir = getIntent();

        String factura = recibir.getStringExtra("dato_recibo");

        List<dataDetalleHistorial> lista_ = new conexion_base_de_datos().ListaDetalleHistorial(this,factura.trim());

        DetalleHistorial.setLayoutManager(new LinearLayoutManager(this));

        lista = new RecycleViewDetalleHistorial(this,lista_);

        DetalleHistorial.setAdapter(lista);

    }
}
