package com.example.administrador.systemaautonica;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;
import com.goodiebag.protractorview.ProtractorView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainEjecutarRecepcionAuto2 extends AppCompatActivity {

    private Spinner spinner;
    private TextView Nombre, Kilometro, Modelo, Color, Comentario;

    private EditText Matricula, Chasis;

    private Button ejecuarFotos_,actualizarFotos_, tomarFotosMedidor_, servicios;
    private Date date = new Date();
    private DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"), dateFormat = new SimpleDateFormat("dd/MM/yyyy"),  dateFormat_server = new SimpleDateFormat("yyyy-MM-dd");
    private String fecha_entrada, hora_entrada;

    private ImageButton image1, image2;

    /**** Documentación de Vehiculo ****/
    private ToggleButton Circulacion, Seguro, EMC;
    /**** Interior de Vehiculo ****/
    private ToggleButton Panel_Instrumento, Velocimetro, Tablero, PideVia_y_Luces, SistemaAudio, ControRadio, Pito, Parabrisas, LucesInterna, Retrovisores,
            FrenoDeMano, Retroceso, EncendedorDeCigarro, Cenicero, Guantera, CinturonDeSeguridad, FuncionamientoVentana, PuertasySeguros,
            AireAcondicionado, MovilidadVolante, IndicadoresAuditivos, CamaraDeRetroceso, ControlDeAlarma, Alfombra;

    /**** Posterior de Vehiculo ****/
    private ToggleButton TapaCombustible, SistemaDeEnllave, LlanteDeRepusto, Herramientas, Trangulo, Extintores, Remolque, CopaDeSeguridad;

    /**** Exterior de Vehiculo ****/
    private ToggleButton PuertasDelanteraLH_RH, FalconLH_RH, BumberDelanteroTracero, GuardafangoLH_RH, PuertasTracerasLH_RH, HalogenoLH_RH, FocosDelanteros, TricosyTapones,
            NivelesLiquidos,NivelesAceites,VidrioDelantero,Emblema, RielTecho, Pescante, RinDeLujo, TechoCanastera, CopaDeLlanta, Lodera,
            Stop, TapaDeAceite, AperturaDeMaletero, Calcomania, VidrioTracero, Antena, Defensa, Antivuelco,Forros;

    private ToggleButton Bateria, Suciedad;

    private ProtractorView NivelCombustible;

    private TextView KilometrajeVehiculo;

    private int cantidadNivelCombustible;

    private String servicio, motor_cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ejecutar_recepcion_auto2);

        spinner = (Spinner) findViewById(R.id.spinner);
        Nombre = (TextView) findViewById(R.id.dataNombre);
        Kilometro = (TextView) findViewById(R.id.dataKilometro);
        Matricula = (EditText) findViewById(R.id.dataMatricula);
        Chasis = (EditText) findViewById(R.id.dataChasis);
        Modelo = (TextView) findViewById(R.id.dataModelo);
        Color = (TextView) findViewById(R.id.dataColor);
        Comentario = (TextView) findViewById(R.id.dataComentario);
        actualizarFotos_ = (Button) findViewById(R.id.actualizarFotos);
        ejecuarFotos_ = (Button) findViewById(R.id.ejecuarFotos);
        servicios = (Button) findViewById(R.id.ejecuarServicios);
        tomarFotosMedidor_ = (Button) findViewById(R.id.tomarFotosMedidor);
        KilometrajeVehiculo = (TextView) findViewById(R.id.txtKilometrajeVehiculo);

        image1 = (ImageButton) findViewById(R.id.imageButton);
        image2 = (ImageButton) findViewById(R.id.imageButton2);

        ejecuarFotos_.setVisibility(View.INVISIBLE);
        actualizarFotos_.setVisibility(View.INVISIBLE);

        /**** Documentación de Vehiculo ****/
        Circulacion = (ToggleButton) findViewById(R.id.tBtCirculacion);
        Seguro = (ToggleButton) findViewById(R.id.tBtSeguro);
        EMC = (ToggleButton) findViewById(R.id.tBtEMC);

        /**** Interior de Vehiculo ****/
        Panel_Instrumento = (ToggleButton) findViewById(R.id.tBtPanel_Instrumento);
        Velocimetro = (ToggleButton) findViewById(R.id.tBtVelocimetro);
        Tablero = (ToggleButton) findViewById(R.id.tBtTablero);
        PideVia_y_Luces = (ToggleButton) findViewById(R.id.tBtPideVia_y_Luces);
        SistemaAudio = (ToggleButton) findViewById(R.id.tBtSistemaAudio);
        ControRadio = (ToggleButton) findViewById(R.id.tBtControRadio);
        Pito = (ToggleButton) findViewById(R.id.tBtPito);
        Parabrisas = (ToggleButton) findViewById(R.id.tBtParabrisas);
        LucesInterna = (ToggleButton) findViewById(R.id.tBtLucesInterna);
        Retrovisores = (ToggleButton) findViewById(R.id.tBtRetrovisores);
        FrenoDeMano = (ToggleButton) findViewById(R.id.tBtFrenoDeMano);
        Retroceso = (ToggleButton) findViewById(R.id.tBtRetroceso);
        EncendedorDeCigarro = (ToggleButton) findViewById(R.id.tBtEncendedorDeCigarro);
        Cenicero = (ToggleButton) findViewById(R.id.tBtCenicero);
        Guantera = (ToggleButton) findViewById(R.id.tBtGuantera);
        CinturonDeSeguridad = (ToggleButton) findViewById(R.id.tBtCinturonDeSeguridad);
        FuncionamientoVentana = (ToggleButton) findViewById(R.id.tBtFuncionamientoVentana);
        PuertasySeguros = (ToggleButton) findViewById(R.id.tBtPuertasySeguros);
        AireAcondicionado = (ToggleButton) findViewById(R.id.tBtAireAcondicionado);
        MovilidadVolante = (ToggleButton) findViewById(R.id.tBtMovilidadVolante);
        IndicadoresAuditivos = (ToggleButton) findViewById(R.id.tBtIndicadoresAuditivos);
        CamaraDeRetroceso = (ToggleButton) findViewById(R.id.tBtCamaraDeRetroceso);
        ControlDeAlarma = (ToggleButton) findViewById(R.id.tBtControlDeAlarma);
        Alfombra = (ToggleButton) findViewById(R.id.tBtAlfombra);

        /**** Posterior de Vehiculo ****/
        TapaCombustible = (ToggleButton) findViewById(R.id.tBtTapaCombustible);
        SistemaDeEnllave = (ToggleButton) findViewById(R.id.tBtSistemaDeEnllave);
        LlanteDeRepusto = (ToggleButton) findViewById(R.id.tBtLlanteDeRepusto);
        Herramientas = (ToggleButton) findViewById(R.id.tBtHerramientas);
        Trangulo = (ToggleButton) findViewById(R.id.tBtTrangulo);
        Extintores = (ToggleButton) findViewById(R.id.tBtExtintores);
        Remolque = (ToggleButton) findViewById(R.id.tBtRemolque);
        CopaDeSeguridad = (ToggleButton) findViewById(R.id.tBtCopaDeSeguridad);

        /**** Exterior de Vehiculo ****/
        PuertasDelanteraLH_RH = (ToggleButton) findViewById(R.id.tBtPuertasDelanteraLH_RH);
        FalconLH_RH = (ToggleButton) findViewById(R.id.tBtFalconLH_RH);
        BumberDelanteroTracero = (ToggleButton) findViewById(R.id.tBtBumberDelanteroTracero);
        GuardafangoLH_RH = (ToggleButton) findViewById(R.id.tBtGuardafangoLH_RH);
        PuertasTracerasLH_RH = (ToggleButton) findViewById(R.id.tBtPuertasTracerasLH_RH);
        HalogenoLH_RH = (ToggleButton) findViewById(R.id.tBtHalogenoLH_RH);
        FocosDelanteros = (ToggleButton) findViewById(R.id.tBtFocosDelanteros);
        TricosyTapones = (ToggleButton) findViewById(R.id.tBtTricosyTapones);
        NivelesLiquidos = (ToggleButton) findViewById(R.id.tBtNivelesLiquidos);
        NivelesAceites = (ToggleButton) findViewById(R.id.tBtNivelesAceites);
        VidrioDelantero = (ToggleButton) findViewById(R.id.tBtVidrioDelantero);
        Emblema = (ToggleButton) findViewById(R.id.tBtEmblema);
        RielTecho = (ToggleButton) findViewById(R.id.tBtRielTecho);
        Pescante = (ToggleButton) findViewById(R.id.tBtPescante);
        RinDeLujo = (ToggleButton) findViewById(R.id.tBtRinDeLujo);
        TechoCanastera = (ToggleButton) findViewById(R.id.tBtTechoCanastera);
        CopaDeLlanta = (ToggleButton) findViewById(R.id.tBtCopaDeLlanta);
        Lodera = (ToggleButton) findViewById(R.id.tBtLodera);
        Stop = (ToggleButton) findViewById(R.id.tBtStop);
        TapaDeAceite = (ToggleButton) findViewById(R.id.tBtTapaDeAceite);
        AperturaDeMaletero = (ToggleButton) findViewById(R.id.tBtAperturaDeMaletero);
        Calcomania = (ToggleButton) findViewById(R.id.tBtCalcomania);
        VidrioTracero = (ToggleButton) findViewById(R.id.tBtVidrioTracero);
        Antena = (ToggleButton) findViewById(R.id.tBtAntena);
        Defensa = (ToggleButton) findViewById(R.id.tBtDefensa);
        Antivuelco = (ToggleButton) findViewById(R.id.tBtAntivuelco);
        Forros = (ToggleButton) findViewById(R.id.tBtForros);


        /**** Otros de Vehiculo ****/
        Bateria = (ToggleButton) findViewById(R.id.tBtBateria);
        Suciedad = (ToggleButton) findViewById(R.id.tBtSuciedad);
        NivelCombustible = (ProtractorView) findViewById(R.id.IDNivelCombustible);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                new conexion_base_de_datos().parqueo(this));
        spinner.setAdapter(adapter);

        //spinner.setAdapter((SpinnerAdapter) new conexion_base_de_datos().parqueo(null));

        fecha_entrada = dateFormat.format(date);
        hora_entrada = hourFormat.format(date);

        ejecuarFotos_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aplicacio = new Intent(MainEjecutarRecepcionAuto2.this, Main4Activity.class);
                startActivity(Aplicacio);
            }
        });

        servicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contructot_dialigo();
            }
        });

        actualizarFotos_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((""+KilometrajeVehiculo.getText().toString())==""){
                    Toast.makeText(getApplicationContext(),"No se puede avanzar almenos que haya digitalizado el kilometraje", Toast.LENGTH_SHORT).show();
                }else{

                    SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();

                    /**** Documento de Vehiculo ****/
                    editor.putBoolean("DOCCIR",Circulacion.isChecked());
                    editor.putBoolean("DOCSEG",Seguro.isChecked());
                    editor.putBoolean("DOCEMC",EMC.isChecked());

                    /**** Interior de Vehiculo ****/
                    editor.putBoolean("INTPIS",Panel_Instrumento.isChecked());
                    editor.putBoolean("INTVEL",Velocimetro.isChecked());
                    editor.putBoolean("INTTAB",Tablero.isChecked());
                    editor.putBoolean("INTPVL",PideVia_y_Luces.isChecked());
                    editor.putBoolean("INTAUD",SistemaAudio.isChecked());
                    editor.putBoolean("INTCRA",ControRadio.isChecked());

                    editor.putBoolean("INTPIT",Pito.isChecked());
                    editor.putBoolean("INTPAR",Parabrisas.isChecked());
                    editor.putBoolean("INTLUC",LucesInterna.isChecked());
                    editor.putBoolean("INTRTV",Retrovisores.isChecked());
                    editor.putBoolean("INTFRE",FrenoDeMano.isChecked());
                    editor.putBoolean("INTRTC",Retroceso.isChecked());
                    editor.putBoolean("INTENC",EncendedorDeCigarro.isChecked());
                    editor.putBoolean("INTCEN",Cenicero.isChecked());
                    editor.putBoolean("INTGUA",Guantera.isChecked());
                    editor.putBoolean("INTCIN",CinturonDeSeguridad.isChecked());
                    editor.putBoolean("INTFVE",FuncionamientoVentana.isChecked());
                    editor.putBoolean("INTPYS",PuertasySeguros.isChecked());
                    editor.putBoolean("INTAAC",AireAcondicionado.isChecked());
                    editor.putBoolean("INTMOV",MovilidadVolante.isChecked());
                    editor.putBoolean("INTIAD",IndicadoresAuditivos.isChecked());
                    editor.putBoolean("INTCRE",CamaraDeRetroceso.isChecked());
                    editor.putBoolean("INTCAL",ControlDeAlarma.isChecked());
                    editor.putBoolean("INTALF",Alfombra.isChecked());

                    /**** Posterior de Vehiculo ****/
                    editor.putBoolean("POSTCO",TapaCombustible.isChecked());
                    editor.putBoolean("POSSLL",SistemaDeEnllave.isChecked());
                    editor.putBoolean("POSLDR",LlanteDeRepusto.isChecked());
                    editor.putBoolean("POSHER",Herramientas.isChecked());
                    editor.putBoolean("POSTRA",Trangulo.isChecked());
                    editor.putBoolean("POSEXT",Extintores.isChecked());
                    editor.putBoolean("POSREM",Remolque.isChecked());
                    editor.putBoolean("POSCDS",CopaDeSeguridad.isChecked());

                    /**** Exterior de Vehiculo ****/
                    editor.putBoolean("EXTPDA",PuertasDelanteraLH_RH.isChecked());
                    editor.putBoolean("EXTFAL",FalconLH_RH.isChecked());
                    editor.putBoolean("EXTBDT",BumberDelanteroTracero.isChecked());
                    editor.putBoolean("EXTGFG",GuardafangoLH_RH.isChecked());
                    editor.putBoolean("EXTPTA",PuertasTracerasLH_RH.isChecked());
                    editor.putBoolean("EXTHAL",HalogenoLH_RH.isChecked());
                    editor.putBoolean("EXTFOC",FocosDelanteros.isChecked());
                    editor.putBoolean("EXTTYT",TricosyTapones.isChecked());
                    editor.putBoolean("EXTNLI",NivelesLiquidos.isChecked());
                    editor.putBoolean("EXTNAC",NivelesAceites.isChecked());
                    editor.putBoolean("EXTVDL",VidrioDelantero.isChecked());
                    editor.putBoolean("EXTEMB",Emblema.isChecked());
                    editor.putBoolean("EXTRIE",RielTecho.isChecked());
                    editor.putBoolean("EXTPES",Pescante.isChecked());
                    editor.putBoolean("EXTRDL",RinDeLujo.isChecked());
                    editor.putBoolean("EXTTCN",TechoCanastera.isChecked());
                    editor.putBoolean("EXTCDL",CopaDeLlanta.isChecked());
                    editor.putBoolean("EXTLOD",Lodera.isChecked());
                    editor.putBoolean("EXTSTP",Stop.isChecked());
                    editor.putBoolean("EXTTAP",TapaDeAceite.isChecked());
                    editor.putBoolean("EXTAPR",AperturaDeMaletero.isChecked());
                    editor.putBoolean("EXTCAL",Calcomania.isChecked());
                    editor.putBoolean("EXTVID",VidrioTracero.isChecked());
                    editor.putBoolean("EXTATN",Antena.isChecked());
                    editor.putBoolean("EXTDEF",Defensa.isChecked());
                    editor.putBoolean("EXTATV",Antivuelco.isChecked());
                    editor.putBoolean("EXTFRR",Forros.isChecked());

                    /**** Otros de Vehiculo ****/
                    editor.putBoolean("OTRBAT",Bateria.isChecked());
                    editor.putBoolean("OTRSUC",Suciedad.isChecked());
                    editor.putInt("OTRNCB",cantidadNivelCombustible);
                    Date date2 = new Date();
                    editor.putString("DDHOR1",hora_entrada);
                    editor.putString("DDHOR2",hourFormat.format(date2));
                    editor.putString("IDDMAT",Matricula.getText().toString());
                    editor.putString("CADKMT",KilometrajeVehiculo.getText().toString());
                    editor.putString("DDPARQ",spinner.getSelectedItem().toString());

                    editor.putString("IDAppointments","(select max(UniqueID) from [dbo].[Appointments])");
                    editor.putString("servicio",servicio);


                    editor.commit();


                    Intent Aplicacio = new Intent(MainEjecutarRecepcionAuto2.this, GaleriaVerificarActivity.class);
                    startActivity(Aplicacio);
                }

            }
        });

        tomarFotosMedidor_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String file = new OtrasClases().ruta_fotos + "medidorDeCombustible.jpg";
                File mi_foto = new File( file );
                try {
                    mi_foto.createNewFile();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                Uri uri = Uri.fromFile( mi_foto );
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(cameraIntent, 0);
            }
        });

        NivelCombustible.setOnProtractorViewChangeListener(new ProtractorView.OnProtractorViewChangeListener() {
            @Override
            public void onProgressChanged(ProtractorView protractorView, int i, boolean b) {
                cantidadNivelCombustible = i;
            }

            @Override
            public void onStartTrackingTouch(ProtractorView protractorView) {
                Toast.makeText(getApplicationContext(),"Inicio", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(ProtractorView protractorView) {
                Toast.makeText(getApplicationContext(),"Detener, valor de progreso, "+cantidadNivelCombustible, Toast.LENGTH_SHORT).show();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contructot_cliente();
            }
        });

    }

    private void contructot_cliente(){

        //final List<CharSequence> charSequences = new conexion_base_de_datos().ObtenerDatosCliente(this,""+Matricula.getText(),""+Chasis.getText());

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        //LayoutInflater inflater = this.getLayoutInflater();
        LayoutInflater inflater = LayoutInflater.from(this);

        dialogBuilder.setTitle("Prueba");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setIcon(R.drawable.user);

        //inflater.inflate(R.layout.layout_lista_usuario, null);

        RecyclerView recyclerViewListaUsuario = new RecyclerView(this);

        //recyclerViewListaUsuario.setLayoutManager(new LinearLayoutManager(this));

        //recyclerViewListaUsuario.setHasFixedSize(true);



        List<String> df = new ArrayList<>();



        //RecycleViewUsuarios lista_ = new RecycleViewUsuarios(df, this);

        //recyclerViewListaUsuario.setAdapter(lista_);

        dialogBuilder.setView(recyclerViewListaUsuario);

        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        dialogBuilder.create();
        dialogBuilder.show();

        /*CharSequence[] charSequenceArray = charSequences.toArray(new
                CharSequence[charSequences.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Verificar datos");

        builder.setItems(charSequenceArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String df = charSequences.get(i).toString();
                String[] array = df.split("\n");
                motor_cliente = array[2].replace("N. Matricula: ","");
                Toast.makeText(getApplicationContext(),"valor "+motor_cliente, Toast.LENGTH_SHORT).show();
            }
        });

        Dialog dialogo = builder.create();
        dialogo.show();*/
    }

    private void contructot_dialigo(){

        final List<CharSequence> charSequences = new conexion_base_de_datos().ObtenerBusquedaListaModelosTaller(this);
        charSequences.add(new String("Rapicambio"));
        CharSequence[] charSequenceArray = charSequences.toArray(new
                CharSequence[charSequences.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecionar el servicio");

        builder.setItems(charSequenceArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String df = charSequences.get(i).toString();

                String kilometraje = KilometrajeVehiculo.getText().toString();

                int km = Integer.parseInt(kilometraje)/1000 ;
                double km2 = (Double.parseDouble(kilometraje)/1000);
                if((km2-km)>0){
                    km = km + 1;
                }

                boolean accion = true;

                do {
                    if(km == 1){
                        accion = false;
                    }else{

                        double act = Double.parseDouble(String.valueOf(km)) / 5;
                        int act2 = km / 5;
                        double act3 = act-act2;

                        if(act3 == 0){
                            accion = false;
                        }else{
                            km--;
                        }
                    }
                }while (accion);

                List<Integer> charKilometraje = new conexion_base_de_datos().ObtenerBusquedaListaModelosTaller2(MainEjecutarRecepcionAuto2.this,df);

                if(charKilometraje.contains(km)){
                    //Toast.makeText(getApplicationContext(),"El valor existe ", Toast.LENGTH_SHORT).show();
                    contructot_dialigo_selecion(df,""+km);
                }else{
                    AlertDialog.Builder infor = new AlertDialog.Builder(MainEjecutarRecepcionAuto2.this);
                    infor.setMessage("No existe servicio para este kilometraje, por favor verifique.");
                    infor.setTitle("Información");
                    infor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    Dialog dialogo2 = infor.create();
                    dialogo2.show();
                }
            }
        });

        Dialog dialogo = builder.create();
        dialogo.show();
    }

    private void contructot_dialigo_selecion(final String nomb, final String tipo){

        final List<String> ItemsTemporal = new ArrayList();

        final List<CharSequence> charSequences3 = new conexion_base_de_datos().ObtenerBusquedaListaModelosTaller3(this,nomb,tipo);
        CharSequence[] charSequenceArray3 = charSequences3.toArray(new
                CharSequence[charSequences3.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Servicios para los "+tipo+",000 Kilometros");

        builder.setItems(charSequenceArray3,null);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                servicio = nomb+"_"+tipo+"K";
                ejecuarFotos_.setVisibility(View.VISIBLE);
                actualizarFotos_.setVisibility(View.VISIBLE);
            }
        });

        builder.setNegativeButton("Cerra",null);

        Dialog dialogo = builder.create();
        dialogo.show();

    }



}
