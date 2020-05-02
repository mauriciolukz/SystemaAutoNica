package com.example.administrador.systemaautonica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrador.systemaautonica.paqueteria.dataVehiculosRecepcionados;

public class MainVerDatos extends AppCompatActivity {

    private TextView Circulacion, Seguro, EMC;
    /**** Interior de Vehiculo ****/
    private TextView Panel_Instrumento, Velocimetro, Tablero, PideVia_y_Luces, SistemaAudio, ControRadio, Pito, Parabrisas, LucesInterna, Retrovisores,
            FrenoDeMano, Retroceso, EncendedorDeCigarro, Cenicero, Guantera, CinturonDeSeguridad, FuncionamientoVentana, PuertasySeguros,
            AireAcondicionado, MovilidadVolante, IndicadoresAuditivos, CamaraDeRetroceso, ControlDeAlarma, Alfombra;

    /**** Posterior de Vehiculo ****/
    private TextView TapaCombustible, SistemaDeEnllave, LlanteDeRepusto, Herramientas, Trangulo, Extintores, Remolque, CopaDeSeguridad;

    /**** Exterior de Vehiculo ****/
    private TextView PuertasDelanteraLH_RH, FalconLH_RH, BumberDelanteroTracero, GuardafangoLH_RH, PuertasTracerasLH_RH, HalogenoLH_RH, FocosDelanteros, TricosyTapones,
            NivelesLiquidos,NivelesAceites,VidrioDelantero,Emblema, RielTecho, Pescante, RinDeLujo, TechoCanastera, CopaDeLlanta, Lodera,
            Stop, TapaDeAceite, AperturaDeMaletero, Calcomania, VidrioTracero, Antena, Defensa, Antivuelco,Forros;

    private TextView Bateria, Suciedad, NivelCombustible, KilometrajeVehiculo, parqueo, pruebas_de_manejo,fecha;

    private TextView Llantas, DetalleLlantas;

    private TextView Comentario;

    private Button Galeria, RetiroV;

    private data d = new data();

    private dataVehiculosRecepcionados df = new dataVehiculosRecepcionados();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver_datos);

        Intent recibir = getIntent();

        d.setUniqueID(recibir.getStringExtra("getUniqueID"));
        d.setType(recibir.getStringExtra("getType"));
        d.setStartDate(recibir.getStringExtra("getStartDate"));
        d.setEndDate(recibir.getStringExtra("getEndDate"));
        d.setStartDateWorkshop(recibir.getStringExtra("getStartDateWorkshop"));
        d.setMatricula(recibir.getStringExtra("getMatricula"));
        d.setCITY(recibir.getStringExtra("getCITY"));
        d.setEMAIL(recibir.getStringExtra("getEMAIL"));
        d.setCHASIS(recibir.getStringExtra("getCHASIS"));
        d.setMODEL(recibir.getStringExtra("getMODEL"));
        d.setCOLOR(recibir.getStringExtra("getCOLOR"));
        d.setAno_vehiculo(recibir.getStringExtra("getAno_vehiculo"));
        d.setSLPRSNID(recibir.getStringExtra("getSLPRSNID"));
        d.setEXETIVE(recibir.getStringExtra("getEXETIVE"));
        d.setULTKM(recibir.getStringExtra("getULTKM"));
        d.setRecepcion(recibir.getStringExtra("getRecepcion"));
        d.setNombre_Cliente(recibir.getStringExtra("getNombre_Cliente"));
        d.setNumero_cliente(recibir.getStringExtra("getNumero_cliente"));
        d.setDescription(recibir.getStringExtra("getDescription"));
        d.setCUSTNMBR(recibir.getStringExtra("getCUSTNMBR"));

        df = new conexion_base_de_datos().ListaAutosBuscarDataAcion(this,d.getUniqueID());

        /**** Documentación de Vehiculo ****/
        Circulacion = (TextView) findViewById(R.id.DOCCIR);
        Seguro = (TextView) findViewById(R.id.DOCSEG);
        EMC = (TextView) findViewById(R.id.DOCEMC);

        /**** Interior de Vehiculo ****/
        Panel_Instrumento = (TextView) findViewById(R.id.INTPIS);
        Velocimetro = (TextView) findViewById(R.id.INTVEL);
        Tablero = (TextView) findViewById(R.id.INTTAB);
        PideVia_y_Luces = (TextView) findViewById(R.id.INTPVL);
        SistemaAudio = (TextView) findViewById(R.id.INTAUD);
        ControRadio = (TextView) findViewById(R.id.INTCRA);
        Pito = (TextView) findViewById(R.id.INTPIT);
        Parabrisas = (TextView) findViewById(R.id.INTPAR);
        LucesInterna = (TextView) findViewById(R.id.INTLUC);
        Retrovisores = (TextView) findViewById(R.id.INTRTV);
        FrenoDeMano = (TextView) findViewById(R.id.INTFRE);
        Retroceso = (TextView) findViewById(R.id.INTRTC);
        EncendedorDeCigarro = (TextView) findViewById(R.id.INTENC);
        Cenicero = (TextView) findViewById(R.id.INTCEN);
        Guantera = (TextView) findViewById(R.id.INTGUA);
        CinturonDeSeguridad = (TextView) findViewById(R.id.INTCIN);
        FuncionamientoVentana = (TextView) findViewById(R.id.INTFVE);
        PuertasySeguros = (TextView) findViewById(R.id.INTPYS);
        AireAcondicionado = (TextView) findViewById(R.id.INTAAC);
        MovilidadVolante = (TextView) findViewById(R.id.INTMOV);
        IndicadoresAuditivos = (TextView) findViewById(R.id.INTIAD);
        CamaraDeRetroceso = (TextView) findViewById(R.id.INTCRE);
        ControlDeAlarma = (TextView) findViewById(R.id.INTCAL);
        Alfombra = (TextView) findViewById(R.id.INTALF);

        /**** Posterior de Vehiculo ****/
        TapaCombustible = (TextView) findViewById(R.id.POSTCO);
        SistemaDeEnllave = (TextView) findViewById(R.id.POSSLL);
        LlanteDeRepusto = (TextView) findViewById(R.id.POSLDR);
        Herramientas = (TextView) findViewById(R.id.POSHER);
        Trangulo = (TextView) findViewById(R.id.POSTRA);
        Extintores = (TextView) findViewById(R.id.POSEXT);
        Remolque = (TextView) findViewById(R.id.POSREM);
        CopaDeSeguridad = (TextView) findViewById(R.id.POSCDS);

        /**** Exterior de Vehiculo ****/
        PuertasDelanteraLH_RH = (TextView) findViewById(R.id.EXTPDA);
        FalconLH_RH = (TextView) findViewById(R.id.EXTFAL);
        BumberDelanteroTracero = (TextView) findViewById(R.id.EXTBDT);
        GuardafangoLH_RH = (TextView) findViewById(R.id.EXTGFG);
        PuertasTracerasLH_RH = (TextView) findViewById(R.id.EXTPTA);
        HalogenoLH_RH = (TextView) findViewById(R.id.EXTHAL);
        FocosDelanteros = (TextView) findViewById(R.id.EXTFOC);
        TricosyTapones = (TextView) findViewById(R.id.EXTTYT);
        NivelesLiquidos = (TextView) findViewById(R.id.EXTNLI);
        NivelesAceites = (TextView) findViewById(R.id.EXTNAC);
        VidrioDelantero = (TextView) findViewById(R.id.EXTVDL);
        Emblema = (TextView) findViewById(R.id.EXTEMB);
        RielTecho = (TextView) findViewById(R.id.EXTRIE);
        Pescante = (TextView) findViewById(R.id.EXTPES);
        RinDeLujo = (TextView) findViewById(R.id.EXTRDL);
        TechoCanastera = (TextView) findViewById(R.id.EXTTCN);
        CopaDeLlanta = (TextView) findViewById(R.id.EXTCDL);
        Lodera = (TextView) findViewById(R.id.EXTLOD);
        Stop = (TextView) findViewById(R.id.EXTSTP);
        TapaDeAceite = (TextView) findViewById(R.id.EXTTAP);
        AperturaDeMaletero = (TextView) findViewById(R.id.EXTAPR);
        Calcomania = (TextView) findViewById(R.id.EXTCAL);
        VidrioTracero = (TextView) findViewById(R.id.EXTVID);
        Antena = (TextView) findViewById(R.id.EXTATN);
        Defensa = (TextView) findViewById(R.id.EXTDEF);
        Antivuelco = (TextView) findViewById(R.id.EXTATV);
        Forros = (TextView) findViewById(R.id.EXTFRR);
        Llantas = (TextView) findViewById(R.id.LantasTitulo);
        DetalleLlantas = (TextView) findViewById(R.id.LantasDescripcion);

        /**** Recepción de Vehiculo ****/
        Bateria = (TextView) findViewById(R.id.OTRBAT);
        Suciedad = (TextView) findViewById(R.id.OTRSUC);
        NivelCombustible = (TextView) findViewById(R.id.OTRNCB);
        KilometrajeVehiculo = (TextView) findViewById(R.id.CADKMT);
        parqueo = (TextView) findViewById(R.id.DDPARQ);
        pruebas_de_manejo = (TextView) findViewById(R.id.AFMPMJ);
        fecha = (TextView) findViewById(R.id.DDFECH);
        Comentario = (TextView) findViewById(R.id.COMENT);

        Galeria = (Button) findViewById(R.id.btnFotosGaleria);
        RetiroV = (Button) findViewById(R.id.btnGenerarRetiro);

        Galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainListaClientes dfg = new MainListaClientes();

                Intent recepcionar = new Intent(MainVerDatos.this, dfg.getClass());
                recepcionar.putExtra("getIDzRecepcionVehiculo",df.getIDzRecepcionVehiculo());
                startActivity(recepcionar);


            }
        });

        RetiroV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainEnvioFinal dfg = new MainEnvioFinal();
                Intent recepcionar = new Intent(MainVerDatos.this, dfg.getClass());

                recepcionar.putExtra("getIDzRecepcionVehiculo",df.getIDzRecepcionVehiculo());
                recepcionar.putExtra("getCUSTNMBR",d.getCUSTNMBR());
                recepcionar.putExtra("getMatricula",d.getMatricula());
                recepcionar.putExtra("getCHASIS",d.getCHASIS());
                recepcionar.putExtra("getMODEL",d.getMODEL());
                recepcionar.putExtra("getAno_vehiculo",d.getAno_vehiculo());
                recepcionar.putExtra("getNombre_Cliente",d.getNombre_Cliente());
                recepcionar.putExtra("getNumero_cliente",d.getNumero_cliente());
                recepcionar.putExtra("getCOLOR",d.getCOLOR());

                startActivity(recepcionar);
            }
        });

        /**** Documentación de Vehiculo ****/
        Circulacion.setText(valor_a_retornar(df.isCirculacion()));
        Seguro.setText(valor_a_retornar(df.isSeguro()));
        EMC.setText(valor_a_retornar(df.isEMC()));

        /**** Interior de Vehiculo ****/
        Panel_Instrumento.setText(valor_a_retornar(df.isPanel_Instrumento()));
        Velocimetro.setText(valor_a_retornar(df.isVelocimetro()));
        Tablero.setText(valor_a_retornar(df.isTablero()));
        PideVia_y_Luces.setText(valor_a_retornar(df.isPideVia_y_Luces()));
        SistemaAudio.setText(valor_a_retornar(df.isSistemaAudio()));
        ControRadio.setText(valor_a_retornar(df.isControRadio()));
        Pito.setText(valor_a_retornar(df.isPito()));
        Parabrisas.setText(valor_a_retornar(df.isParabrisas()));
        LucesInterna.setText(valor_a_retornar(df.isLucesInterna()));
        Retrovisores.setText(valor_a_retornar(df.isRetrovisores()));
        FrenoDeMano.setText(valor_a_retornar(df.isFrenoDeMano()));
        Retroceso.setText(valor_a_retornar(df.isRetroceso()));
        EncendedorDeCigarro.setText(valor_a_retornar(df.isEncendedorDeCigarro()));
        Cenicero.setText(valor_a_retornar(df.isCenicero()));
        Guantera.setText(valor_a_retornar(df.isGuantera()));
        CinturonDeSeguridad.setText(valor_a_retornar(df.isCinturonDeSeguridad()));
        FuncionamientoVentana.setText(valor_a_retornar(df.isFuncionamientoVentana()));
        PuertasySeguros.setText(valor_a_retornar(df.isPuertasySeguros()));
        AireAcondicionado.setText(valor_a_retornar(df.isAireAcondicionado()));
        MovilidadVolante.setText(valor_a_retornar(df.isMovilidadVolante()));
        IndicadoresAuditivos.setText(valor_a_retornar(df.isIndicadoresAuditivos()));
        CamaraDeRetroceso.setText(valor_a_retornar(df.isCamaraDeRetroceso()));
        ControlDeAlarma.setText(valor_a_retornar(df.isControlDeAlarma()));
        Alfombra.setText(valor_a_retornar(df.isAlfombra()));

        /**** Posterior de Vehiculo ****/
        TapaCombustible.setText(valor_a_retornar(df.isTapaCombustible()));
        SistemaDeEnllave.setText(valor_a_retornar(df.isSistemaDeEnllave()));
        LlanteDeRepusto.setText(valor_a_retornar(df.isLlanteDeRepusto()));
        Herramientas.setText(valor_a_retornar(df.isHerramientas()));
        Trangulo.setText(valor_a_retornar(df.isTrangulo()));
        Extintores.setText(valor_a_retornar(df.isExtintores()));
        Remolque.setText(valor_a_retornar(df.isRemolque()));
        CopaDeSeguridad.setText(valor_a_retornar(df.isCopaDeSeguridad()));

        /**** Exterior de Vehiculo ****/
        PuertasDelanteraLH_RH.setText(valor_a_retornar(df.isPuertasDelanteraLH_RH()));
        FalconLH_RH.setText(valor_a_retornar(df.isFalconLH_RH()));
        BumberDelanteroTracero.setText(valor_a_retornar(df.isBumberDelanteroTracero()));
        GuardafangoLH_RH.setText(valor_a_retornar(df.isGuardafangoLH_RH()));
        PuertasTracerasLH_RH.setText(valor_a_retornar(df.isPuertasTracerasLH_RH()));
        HalogenoLH_RH.setText(valor_a_retornar(df.isHalogenoLH_RH()));
        FocosDelanteros.setText(valor_a_retornar(df.isFocosDelanteros()));
        TricosyTapones.setText(valor_a_retornar(df.isTricosyTapones()));
        NivelesLiquidos.setText(valor_a_retornar(df.isNivelesLiquidos()));
        NivelesAceites.setText(valor_a_retornar(df.isNivelesAceites()));
        VidrioDelantero.setText(valor_a_retornar(df.isVidrioDelantero()));
        Emblema.setText(valor_a_retornar(df.isEmblema()));
        RielTecho.setText(valor_a_retornar(df.isRielTecho()));
        Pescante.setText(valor_a_retornar(df.isPescante()));
        RinDeLujo.setText(valor_a_retornar(df.isRinDeLujo()));
        TechoCanastera.setText(valor_a_retornar(df.isTechoCanastera()));
        CopaDeLlanta.setText(valor_a_retornar(df.isCopaDeLlanta()));
        Lodera.setText(valor_a_retornar(df.isLodera()));
        Stop.setText(valor_a_retornar(df.isStop()));
        TapaDeAceite.setText(valor_a_retornar(df.isTapaDeAceite()));
        AperturaDeMaletero.setText(valor_a_retornar(df.isAperturaDeMaletero()));
        Calcomania.setText(valor_a_retornar(df.isCalcomania()));
        VidrioTracero.setText(valor_a_retornar(df.isVidrioTracero()));
        Antena.setText(valor_a_retornar(df.isAntena()));
        Defensa.setText(valor_a_retornar(df.isDefensa()));
        Antivuelco.setText(valor_a_retornar(df.isAntivuelco()));
        Forros.setText(valor_a_retornar(df.isForros()));

        Llantas.setText(accion_llanta_realizar(df.isLlanta2(),df.isLlanta1(),df.isLlanta4(),df.isLlanta3()));
        DetalleLlantas.setText(accion_llanta_realizarDetalle(df.getLlanta_detalle2(),df.getLlanta_detalle1(),df.getLlanta_detalle4(),df.getLlanta_detalle3()));

        /**** Recepción de Vehiculo ****/
        Bateria.setText(valor_a_retornar(df.isBateria()));
        Suciedad.setText(valor_a_retornar2(df.isBateria()));
        NivelCombustible.setText(nivelCombustibleData(df.getNivelDeCombustible()));
        KilometrajeVehiculo.setText("Lectura del Kilometraje del vehiculo: "+df.getUltimo_Kilometraje());
        parqueo.setText("El vehiculo ingreso en el parqueo "+df.getParqueo());
        pruebas_de_manejo.setText(valor_a_retornar3(df.isPruebas_de_manejo()));
        fecha.setText("El vehiculo entro el "+df.getFecha());
        Comentario.setText(df.getComentario());


    }

    private String accion_llanta_realizar(boolean llantaDD, boolean llantaDI, boolean llantaTD, boolean llantaTI){

        String titulo="";

        if(llantaDD){ titulo = titulo+"Se encontro daño el Llanta Delatera Derechan\n"; }
        if(llantaDI){ titulo = titulo+"Se encontro daño el Llanta Delatera Izquierda\n"; }
        if(llantaTD){ titulo = titulo+"Se encontro daño el Llanta Tracera Derechan\n"; }
        if(llantaTI){ titulo = titulo+"Se encontro daño el Llanta Tracera Izquierda\n"; }
        if(titulo==""){ titulo = "No se ha encontrado daños en los neumaticos\n"; }

        return titulo;
    }

    private String accion_llanta_realizarDetalle(String llantaDD, String llantaDI, String llantaTD, String llantaTI){

        String detalle="";

        if(llantaDD == ""){ detalle = detalle+llantaDD+"\n"; }

        if(llantaDI == ""){ detalle = detalle+llantaDI+"\n"; }

        if(llantaTD == ""){ detalle = detalle+llantaTD+"\n"; }

        if(llantaTI == ""){ detalle = detalle+llantaTI+"\n"; }

        if(detalle==""){ detalle = "No hay detalle para ver\n"; }

        return detalle;
    }

    private String nivelCombustibleData(int cantidad){

        double valor = (cantidad*100)/180;

        return "El porcentaje del tanque era de: "+valor;
    }

    private String valor_a_retornar(boolean accion){

        if(accion){
            return "Se encuentra en buen estado";
        }else{
            return "Se encuentra en mal estado o no esta precente";
        }

    }

    private String valor_a_retornar2(boolean accion){

        if(accion){
            return "El vehiculo se encontraba realmente sucion, no se pudo confirmar todo los defectos en ese momento";
        }else{
            return "El vehiculo se encontraba limpio, no hubo problema en la inspeción";
        }

    }

    private String valor_a_retornar3(boolean accion){

        if(accion){
            return "Se entrego permiso para la prueba de manejo";
        }else{
            return "No se entrego permiso para la prueba de manejo";
        }

    }
}
