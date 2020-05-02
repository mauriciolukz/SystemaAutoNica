package com.example.administrador.systemaautonica.paqueteria;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.adapters.Converters;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.NotificationCompat;
import android.util.Base64;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.administrador.systemaautonica.R;
import com.github.gcacace.signaturepad.views.SignaturePad;

import junit.framework.Assert;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrador on 26/2/2018.
 */

public class OtrasClases {

    public final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/FotosAutos/";
    public final String ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/";

    public Intent accion_camara(Context ct, String nombre){

        String file = ruta_fotos + nombre + ".jpg";
        File mi_foto = new File( file );

        try {
            if (!mi_foto.isFile()) {
                mi_foto.createNewFile(); // Exception here
            } else {
                mi_foto.setLastModified(System.currentTimeMillis());
            }
        } catch (IOException ex) {
            Log.e("ERROR ", "Error:" + ex);
        }

        Uri uri = FileProvider.getUriForFile(ct,ct.getApplicationContext().getPackageName()+".provider",mi_foto);

        Intent cameraIntent;

        try {
            cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } catch (Exception e) {
            Log.e("ERROR ", "Error:" + e);
            cameraIntent = null;
        }

        return cameraIntent;
    }

    public void eliminar_archivo(String nombre, Context df){
        File fichero = new File(ruta_fotos+nombre);
        if (fichero.isFile()){
            if(fichero.delete()){
                Toast.makeText(df.getApplicationContext(),"Se a eliminado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(df.getApplicationContext(),"No se encontro direccion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void eliminar_fichero(Context df){
        File dir = new File(ruta_fotos);

        if(dir.exists()){

            File[] ficheros = dir.listFiles();

            if(ficheros == null){
                Toast.makeText(df.getApplicationContext(),"No tiene permiso de modificacion de archivo ", Toast.LENGTH_SHORT).show();
            }else{
                for (int x=0;x<ficheros.length;x++){
                    String g = ficheros[x].getName();
                    eliminar_archivo(g,df);
                }
            }

        }else {
            Toast.makeText(df.getApplicationContext(),"Directorio no existe", Toast.LENGTH_SHORT).show();
            if(dir.mkdirs()){
                Toast.makeText(df.getApplicationContext(),"Directorio Creado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(df.getApplicationContext(),"El directorio no se pudo Crear", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /*public void crear_y_mover_fichero(Context df, String NuevaCarpeta){
        File dir = new File(ruta_fotos);
        File dir_nuevo = new File(ruta+NuevaCarpeta+"/");

        if(!dir_nuevo.exists()){
            if(dir_nuevo.mkdirs()){
                Toast.makeText(df.getApplicationContext(),"Directorio Creado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(df.getApplicationContext(),"El directorio no se pudo Crear", Toast.LENGTH_SHORT).show();
            }
        }

        File[] ficheros = dir.listFiles();

        if(ficheros == null){
            Toast.makeText(df.getApplicationContext(),"No tiene permiso de modificacion de archivo ", Toast.LENGTH_SHORT).show();
        }else{
            for (int x=0;x<ficheros.length;x++){
                String g = ficheros[x].getName();
                CopiarArchivo(ruta_fotos+g,ruta+NuevaCarpeta+"/"+g);
            }
        }
        Log.d("Accion","Finalizo accion");
    }*/

    public void CopiarArchivo(String sourceFile, String destinationFile) {

        Log.d("COPY","Desde: " + sourceFile);
        Log.d("COPY","Hacia: " + destinationFile);

        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];

            int c;
            while( (c = in.read(buffer) ) != -1)
                out.write(c);

            out.flush();
            in.close();
            out.close();
        } catch(IOException e) {
            Log.d("COPY","Hubo un error de entrada/salida!!!");
        }
    }

    public int leer_fichero(Context df, String nombre){
        File dir = new File(ruta_fotos);

        int cont = 0;

        if (dir.exists()){
            File[] ficheros = dir.listFiles();
            for (int x=0;x<ficheros.length;x++){

                String g = ficheros[x].getName();

                if(ficheros[x].length()>0){
                    boolean retval = g.contains(nombre);

                    if(retval){
                        cont = cont + 1;
                    }
                }
            }

            return cont;
        }
        else {
            Toast.makeText(df.getApplicationContext(),"Directorio no existe", Toast.LENGTH_SHORT).show();

            return 0;
        }
    }

    public int getDrawable(Context c, String name) {
        Assert.assertNotNull(name);
        return c.getResources().getIdentifier(name,
                "drawable", c.getPackageName());
    }

    public void animar(boolean mostrar, GridLayout layoutAnimado)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else
        {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);
    }

    public void create_firma(SignaturePad valor, String nombre){
        Bitmap signatureBitmap = valor.getSignatureBitmap();
        addJpgSignatureToGallery(signatureBitmap, nombre);
    }

    private boolean addJpgSignatureToGallery(Bitmap signature, String nombre){

        String file = ruta_fotos + nombre +".jpg";
        File mi_foto = new File( file );

        boolean retorno = false;

        try {
            mi_foto.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }

        Bitmap newBitmap = Bitmap.createBitmap(signature.getWidth(), signature.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(signature, 0, 0, null);
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(mi_foto);
            newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
            stream.close();

            retorno = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public String base64(String nombreImagen){
        File mi_foto = new File(ruta_fotos+nombreImagen);

        InputStream stream = null;
        byte[] bytes;
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            stream = new FileInputStream(mi_foto);
            while ((bytesRead = stream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bytes = output.toByteArray();
        String encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);

        return encodedString;
    }



    public byte[] Bytes_archivo(String nombreImagen){
        File mi_foto = new File(ruta_fotos+nombreImagen);

        InputStream stream = null;
        byte[] bytes;
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            stream = new FileInputStream(mi_foto);
            while ((bytesRead = stream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bytes = output.toByteArray();

        return bytes;
    }

    public void convertBitmapToFile(Bitmap bitmap, String nombre){
        File filesDir =  new File(ruta_fotos);
        File imageFile = new File(filesDir, nombre + ".jpg");

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
        }
    }

    public String titulo(Context df){

        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String defaultValue3 = sharedPref.getString("lugar","");

        String[] letra = {"CA","DEPALCO","SUBURBANA"};

        String resultado = "";

        if(defaultValue3 == "CA"){
            resultado = "Taller Centroamerica AutoNica";
        }

        if(defaultValue3 == "DEPALCO"){
            resultado = "rapicambio";
        }


        if(defaultValue3 == "SUBURBANA"){
            resultado = "Taller Sub Urbana AutoNica";
        }

        return resultado;
    }

    public void notificaciones_sistema(Context context, String Titulo, String Contenido){

        MediaPlayer df = MediaPlayer.create(context, R.raw.sonido_2);
        df.start();

        NotificationCompat.Builder mBuilder;
        NotificationManager mNotifyMgr =(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(context, context.getClass());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,intent, 0);




        mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.drawable.logo_aplicacion);
        mBuilder.setContentTitle(Titulo);
        mBuilder.setContentText(Contenido);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setVibrate(new long[] {100, 250, 100, 500});
        mNotifyMgr.notify(1, mBuilder.build());


    }

}
