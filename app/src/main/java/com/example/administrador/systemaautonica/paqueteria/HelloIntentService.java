package com.example.administrador.systemaautonica.paqueteria;


import android.app.NotificationManager;
import android.app.Service;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.File;


public class HelloIntentService extends Service {

    private static final String TAG = "MyService";

    @Override
    public IBinder onBind(Intent i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                Log.d("Server", "EL servicio se a iniciado");

                NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder;
                try {

                    String carpeta_nueva = "catpeta_traslado_";

                    OtrasClases OC = new OtrasClases();

                    //new OtrasClases().crear_y_mover_fichero(getApplication(),carpeta_nueva);

                    String direccion_nueva = OC.ruta+carpeta_nueva+"/";
                    String direccion_actual = OC.ruta_fotos;

                    File dir = new File(direccion_actual);
                    File dir_nuevo = new File(direccion_nueva);

                    if(!dir_nuevo.exists()){
                        if(dir_nuevo.mkdirs()){
                            Toast.makeText(getApplicationContext(),"Directorio Creado", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"El directorio no se pudo Crear", Toast.LENGTH_SHORT).show();
                        }
                    }

                    File[] ficheros = dir.listFiles();

                    if(ficheros == null){
                        Toast.makeText(getApplicationContext(),"No tiene permiso de modificacion de archivo ", Toast.LENGTH_SHORT).show();
                    }else{
                        for (int x=0;x<ficheros.length;x++){
                            String g = ficheros[x].getName();
                            if(ficheros[x].length()>0){
                                Log.d("Nombre Archivo : ",g);
                                OC.CopiarArchivo(direccion_actual+g,direccion_nueva+g);
                            }
                            //CopiarArchivo(ruta_fotos+g,ruta+NuevaCarpeta+"/"+g);
                        }
                    }
                    Log.d("Accion","Finalizo accion");

                    builder = new NotificationCompat.Builder(
                            getBaseContext())
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("Guardado de datos")
                            .setContentText("Terminó el servicio!")
                            .setWhen(System.currentTimeMillis());

                    Log.d("Server", "sleep finished");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    builder = new NotificationCompat.Builder(
                            getBaseContext())
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("Error de Datos")
                            .setContentText("El Servicio se desconecto!")
                            .setWhen(System.currentTimeMillis());
                }

                nManager.notify(12345, builder.build());

                //conexion_base_de_datos dfg = new conexion_base_de_datos();

                //SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
                //String defaultValue = sharedPref.getString("Nombre","");

                //SharedPreferences sharedPref2 = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);



                /*String dato="insert into zAppointmentsRecepcionVehiculo values ("+
                        dfg.valores(sharedPref2.getBoolean("DOCCIR",false))+" ,"+
                        dfg.valores(sharedPref2.getBoolean("DOCSEG",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("DOCEMC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTPIS",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTVEL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTTAB",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTPVL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTAUD",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTCRA",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTPIT",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTPAR",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTLUC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTRTV",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTFRE",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTRTC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTENC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTCEN",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTGUA",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTCIN",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTFVE",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTPYS",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTAAC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTMOV",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTIAD",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTCRE",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTCAL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("INTALF",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSTCO",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSSLL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSLDR",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSHER",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSTRA",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSEXT",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSREM",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("POSCDS",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTPDA",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTFAL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTBDT",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTGFG",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTPTA",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTHAL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTFOC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTTYT",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTNLI",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTNAC",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTVDL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTEMB",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTRIE",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTPES",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTRDL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTTCN",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTCDL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTLOD",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTSTP",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTTAP",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTAPR",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTCAL",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTVID",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTATN",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTDEF",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTATV",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("EXTFRR",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("OTRBAT",false))+" ," +
                        dfg.valores(sharedPref2.getBoolean("OTRSUC",false))+" ," +
                        sharedPref2.getInt("OTRNCB",0)+" ," +
                        "'"+defaultValue+"' ,"+
                        "GETDATE() ," +
                        "'"+sharedPref2.getString("DDHOR1","00:00:00")+"' ," +
                        "'"+sharedPref2.getString("DDHOR2","00:00:00")+"' ," +
                        "'"+sharedPref2.getString("IDDMAT","")+"' ," +
                        sharedPref2.getString("CADKMT","0")+" ," +
                        dfg.valores(sharedPref2.getBoolean("AUTLL1",false))+" ," +
                        "'"+sharedPref2.getString("DETLL1","")+"' ," +
                        dfg.valores(sharedPref2.getBoolean("AUTLL2",false))+" ," +
                        "'"+sharedPref2.getString("DETLL2","")+"' ," +
                        dfg.valores(sharedPref2.getBoolean("AUTLL3",false))+" ," +
                        "'"+sharedPref2.getString("DETLL3","")+"' ," +
                        dfg.valores(sharedPref2.getBoolean("AUTLL4",false))+" ," +
                        "'"+sharedPref2.getString("DETLL4","")+"' ," +
                        "1 ," +
                        "'"+sharedPref2.getString("DDPARQ","")+"' ," +
                        dfg.valores(sharedPref2.getBoolean("AFMPMJ",false))+" ," +
                        "'"+sharedPref2.getString("COMENT","")+"' ," +
                        ""+sharedPref2.getString("IDAppointments","")+" ,NULL,'"+sharedPref2.getString("servicio","")+"',0,'')";

                String IDAppointments = sharedPref2.getString("IDAppointments","");

                if(dfg.Guardar(dato,IDAppointments)){
                    //Toast.makeText(getApplicationContext(),"Directorio no existe", Toast.LENGTH_SHORT).show();
                }
                dfg.guardarfotos();*/



                /*try {
                    Thread.sleep(10000);


                    Log.d("Server", "sleep finished");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
        }).start();

        this.stopSelf();

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "FirstService destroyed");
    }


    /*@Override
    protected void onHandleIntent(Intent intent) {
        //int iter = 10;
        int i = 1;

        do {

            i = i+1;


            Log.v("STATE","Ingreso al for "+i);
            Log.d("STATE","Ingreso al for "+i);
            new OtrasClases().notificaciones_sistema(getApplication(),"Prueba hilo","Ingreso al for "+i);
            tareaLarga();

            //Comunicamos el progreso
            Intent bcIntent = new Intent();
            bcIntent.setAction(ACTION_PROGRESO);
            bcIntent.putExtra("progreso", i*10);
            sendBroadcast(bcIntent);
        }while (getEstado());

        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);

    }*/

}
