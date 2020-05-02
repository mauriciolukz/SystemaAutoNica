package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainGestionarImage extends AppCompatActivity {

    ImageView imageView;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gestionar_image);
        Intent recibir = getIntent();

        String image = recibir.getStringExtra("ID");

        Toast.makeText(this,"Codigo: "+image, Toast.LENGTH_SHORT).show();

        imageView = (ImageView) findViewById(R.id.imageView8);

        imageView.setImageBitmap(new conexion_base_de_datos().FotoImagenes(this,image));

        photoViewAttacher = new PhotoViewAttacher(imageView);


    }
}
