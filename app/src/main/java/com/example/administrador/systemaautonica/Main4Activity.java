package com.example.administrador.systemaautonica;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Main4Activity extends AppCompatActivity {

    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/FotosAutos/";
    private File file = new File(ruta_fotos);
    private ImageView foto, foto1;

    private String nombre = "izquierda_", nombre2 ="choque_", accion = "Lado Izquierdo", accion2 = "Choque de Vehiculo";

    private TextView Datos1, Datos2, Datos3, Titulo, Datos1_2, Datos2_2, Datos3_2;

    private DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    private String hora;

    private LinearLayout columanInfor, columanInfor2;

    private Button galeria;

    private String mCurrentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    CarouselPicker carrucel3, carrucel2;

    OtrasClases o = new OtrasClases();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        foto = (ImageView) findViewById(R.id.btFoto);
        foto1 = (ImageView) findViewById(R.id.btFoto1);
        Datos1 = (TextView) findViewById(R.id.textDatos1);
        Datos2 = (TextView) findViewById(R.id.textDatos2);
        Datos3 = (TextView) findViewById(R.id.textDatos3);
        Datos1_2 = (TextView) findViewById(R.id.textDatos1_2);
        Datos2_2 = (TextView) findViewById(R.id.textDatos2_2);
        Datos3_2 = (TextView) findViewById(R.id.textDatos3_2);

        galeria = (Button) findViewById(R.id.idContinuar);

        Titulo = (TextView) findViewById(R.id.TituloView);

        carrucel3 = (CarouselPicker) findViewById(R.id.carrucelPicke3);
        carrucel2 = (CarouselPicker) findViewById(R.id.carrucelPicke2);

        columanInfor = (LinearLayout) findViewById(R.id.columanInforamcion);
        columanInfor2 = (LinearLayout) findViewById(R.id.columanInforamcion2);

        final List<CarouselPicker.PickerItem> items = new ArrayList<>();
        items.add(new CarouselPicker.DrawableItem(R.drawable.cart1_min));
        items.add(new CarouselPicker.DrawableItem(R.drawable.cart2_min));
        items.add(new CarouselPicker.DrawableItem(R.drawable.cart3_min));
        items.add(new CarouselPicker.DrawableItem(R.drawable.cart4_min));

        final List<CarouselPicker.PickerItem> items2 = new ArrayList<>();
        items2.add(new CarouselPicker.DrawableItem(R.drawable.choque));
        items2.add(new CarouselPicker.DrawableItem(R.drawable.rallones));

        accion();

        CarouselPicker.CarouselViewAdapter ImagenAdapter3 = new CarouselPicker.CarouselViewAdapter(this,items,0);
        carrucel3.setAdapter(ImagenAdapter3);

        CarouselPicker.CarouselViewAdapter ImagenAdapter2 = new CarouselPicker.CarouselViewAdapter(this,items2,0);
        carrucel2.setAdapter(ImagenAdapter2);

        if (getRotation() == "horizontal") {
            columanInfor.setVisibility(View.INVISIBLE);
            columanInfor2.setVisibility(View.VISIBLE);
            foto1.setVisibility(View.VISIBLE);
            foto.setVisibility(View.INVISIBLE);
            Titulo.setVisibility(View.INVISIBLE);
        } else if (getRotation() == "vertical"){
            columanInfor.setVisibility(View.VISIBLE);
            columanInfor2.setVisibility(View.INVISIBLE);
            foto1.setVisibility(View.INVISIBLE);
            foto.setVisibility(View.VISIBLE);
            Titulo.setVisibility(View.VISIBLE);
        }


        carrucel3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == 0){
                    nombre = "izquierda_";
                    accion = "Lado Izquierdo";
                }
                if(position == 1){
                    nombre = "derecha_";
                    accion = "Lado Derecho";
                }
                if(position == 2){
                    nombre = "Atras_";
                    accion = "Parte Tracera";
                }
                if(position == 3){
                    nombre = "Frente_";
                    accion = "Parte Fronta";
                }
                if(position == 4){
                    nombre = "Techo_";
                    accion = "Parte del techo";
                }

                accion();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        carrucel2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                if(position == 0){
                    nombre2 = "choque_";
                    accion2 = "Choque de Vehiculo";
                }
                if(position == 1){
                    nombre2 = "rallones_";
                    accion2 = "Daño por rallones";
                }

                accion();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aplicacio = new Intent(getApplicationContext(), GaleriaVerificarActivity.class);
                startActivity(Aplicacio);
            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_foto();
            }
        });

        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accion_foto();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        accion();
    }

    private void accion_foto(){
        hora = hourFormat.format(new Date());
        String g = nombre + nombre2 + hora;
        startActivityForResult(new OtrasClases().accion_camara(getApplication(),g), REQUEST_IMAGE_CAPTURE);
    }

    private void accion(){
        Datos1.setText("Tomar fotos del: "+accion);
        Datos2.setText(accion2);

        Datos1_2.setText("Tomar fotos del: "+accion);
        Datos2_2.setText(accion2);

        String g = nombre + nombre2;
        int f = o.leer_fichero(this,g);

        Datos3.setText("Cantidad de Imagenes en el sistema: "+f);
        Datos3_2.setText("Cantidad de Imagenes en el sistema: "+f);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columanInfor.setVisibility(View.INVISIBLE);
            columanInfor2.setVisibility(View.VISIBLE);
            foto1.setVisibility(View.VISIBLE);
            foto.setVisibility(View.INVISIBLE);
            Titulo.setVisibility(View.INVISIBLE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            //Toast.makeText(getApplicationContext(), " portrait: ", Toast.LENGTH_LONG).show();
            columanInfor.setVisibility(View.VISIBLE);
            columanInfor2.setVisibility(View.INVISIBLE);
            foto1.setVisibility(View.INVISIBLE);
            foto.setVisibility(View.VISIBLE);
            Titulo.setVisibility(View.VISIBLE);
        }

    }

    public String getRotation(){
        final int rotation = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                return "vertical";
            case Surface.ROTATION_90:
            default:
                return "horizontal";
        }
    }

}
