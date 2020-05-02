package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GaleriaVerificarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewGaleria galeria;
    private Button siguiente;

    private List<dataImagenes> datos_completos;

    OtrasClases o = new OtrasClases();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_verificar);

        recyclerView = (RecyclerView) findViewById(R.id.IDGaleriaImagen);

        datos_completos = obtenerDatos();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        galeria = new RecycleViewGaleria(datos_completos, this);
        recyclerView.setAdapter(galeria);

        siguiente = (Button) findViewById(R.id.btSiguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aplicacio = new Intent(GaleriaVerificarActivity.this, MainLlanta.class);
                startActivity(Aplicacio);
            }
        });
    }

    public void accion_ejecuta(int i, String nombre){
        Toast.makeText(getApplicationContext(),"Entro, archivo "+nombre, Toast.LENGTH_SHORT).show();

        datos_completos.remove(i);
        galeria = new RecycleViewGaleria(datos_completos, this);
        recyclerView.getAdapter().notifyItemRemoved(i);
        recyclerView.clearOnScrollListeners();

        o.eliminar_archivo(nombre,this);

    }

    public List<dataImagenes> obtenerDatos(){
        List<dataImagenes> datos = new ArrayList<>();

        BitmapFactory.Options opts = new BitmapFactory.Options ();
        opts.inSampleSize = 2;   // for 1/2 the image to be loaded

        File dir = new File(o.ruta_fotos);

        if (dir.exists()){
            File[] ficheros = dir.listFiles();
            for (int x=0;x<ficheros.length;x++){

                if(ficheros[x].length()>0){
                    Bitmap imagen = BitmapFactory.decodeFile(o.ruta_fotos+ficheros[x].getName(), opts);
                    Bitmap reduce = Bitmap.createScaledBitmap (imagen, 209, 144, false);

                    datos.add(new dataImagenes(ficheros[x].getName(),reduce));
                }

            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Directorio no existe", Toast.LENGTH_SHORT).show();
        }

        return datos;
    }
}
