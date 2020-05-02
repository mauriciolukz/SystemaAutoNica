package com.example.administrador.systemaautonica;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrador.systemaautonica.paqueteria.MailJob;
import com.example.administrador.systemaautonica.paqueteria.OtrasClases;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainFirma extends AppCompatActivity {

    private Button finalizar, limpiar1, limpiar2;
    private SignaturePad SignatureEmpleado, SignatureCliente;
    private ToggleButton Prueba;
    private TextView valor;
    private EditText Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_firma);

        finalizar = (Button) findViewById(R.id.button2);

        limpiar1 = (Button) findViewById(R.id.btnLimpiar1);
        limpiar2 = (Button) findViewById(R.id.btnLimpiar2);

        Prueba = (ToggleButton) findViewById(R.id.tBtPrueba);
        SignatureEmpleado = (SignaturePad) findViewById(R.id.signature_pad);
        SignatureCliente = (SignaturePad) findViewById(R.id.signature_pad2);
        valor = (TextView) findViewById(R.id.textView23);

        Correo = (EditText) findViewById(R.id.txtCorreo);

        SharedPreferences sharedPref3 = getSharedPreferences("Systema_data_archivo_cliente", Context.MODE_PRIVATE);

        data d = new data();

        d.setUniqueID(sharedPref3.getString("getUniqueID",""));
        d.setType(sharedPref3.getString("getType",""));
        d.setStartDate(sharedPref3.getString("getStartDate",""));
        d.setEndDate(sharedPref3.getString("getEndDate",""));
        d.setStartDateWorkshop(sharedPref3.getString("getStartDateWorkshop",""));
        d.setMatricula(sharedPref3.getString("getMatricula",""));
        d.setCITY(sharedPref3.getString("getCITY",""));
        d.setEMAIL(sharedPref3.getString("getEMAIL",""));

        d.setCHASIS(sharedPref3.getString("getCHASIS",""));
        d.setMODEL(sharedPref3.getString("getMODEL",""));
        d.setCOLOR(sharedPref3.getString("getCOLOR",""));
        d.setAno_vehiculo(sharedPref3.getString("getAno_vehicul",""));
        d.setEMAIL(sharedPref3.getString("getEMAIL",""));
        d.setSLPRSNID(sharedPref3.getString("getSLPRSNID",""));
        d.setEXETIVE(sharedPref3.getString("getEXETIVE",""));
        d.setULTKM(sharedPref3.getString("getULTKM",""));
        d.setRecepcion(sharedPref3.getString("getRecepcion",""));
        d.setNombre_Cliente(sharedPref3.getString("getNombre_Cliente",""));
        d.setNumero_cliente(sharedPref3.getString("getNumero_cliente",""));
        d.setDescription(sharedPref3.getString("getDescription",""));
        d.setCUSTNMBR(sharedPref3.getString("getCUSTNMBR",""));

        SharedPreferences sharedPref_datos = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);

        Correo.setText(d.getEMAIL().replaceAll("\\s","").trim().toLowerCase());

        final String mensaje =
                "\t\t\t<div class=\"titulo\">\n" +
                "\t\t\t\t<h1>Envio de información de recepción de autos, "+new OtrasClases().titulo(this)+"</h1>\n" +
                "\t\t\t\t<p>Estimado señor "+d.getNombre_Cliente()+"</p>\n" +
                "\t\t\t\t<p>Numero de Matriula "+d.getMatricula()+",con este medio se le informa de los siguientes parametros encontrado en su vehiculo</p>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Documentación de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Circulacion</td>\n" +
                "\t\t\t\t\t\t<td data-label=\"Circulacion\">"+valores2(sharedPref_datos.getBoolean("DOCCIR",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Seguro</td> \n" +
                "\t\t\t\t\t\t<td data-label=\"Seguro\">"+valores2(sharedPref_datos.getBoolean("DOCSEG",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Documentacion EMC</td> \n" +
                "\t\t\t\t\t\t<td data-label=\"Documentacion EMC\">"+valores2(sharedPref_datos.getBoolean("DOCEMC",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Interior de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Panel de Instrumento</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Panel de Instrumento\">"+valores2(sharedPref_datos.getBoolean("INTPIS",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Velocimetro</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Velocimetro\">"+valores2(sharedPref_datos.getBoolean("INTVEL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Tablero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Tablero\">"+valores2(sharedPref_datos.getBoolean("INTTAB",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Pide Via y Luces</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Pide Via y Luces\">"+valores2(sharedPref_datos.getBoolean("INTPVL",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Sistema de Audio</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Sistema de Audio\">"+valores2(sharedPref_datos.getBoolean("INTAUD",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Contro Radio</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Contro Radio\">"+valores2(sharedPref_datos.getBoolean("INTCRA",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Pito</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Pito\">"+valores2(sharedPref_datos.getBoolean("INTPIT",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Parabrisas</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Parabrisas\">"+valores2(sharedPref_datos.getBoolean("INTPAR",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Luces Interna</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Luces Interna\">"+valores2(sharedPref_datos.getBoolean("INTLUC",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Retrovisores</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Retrovisores\">"+valores2(sharedPref_datos.getBoolean("INTRTV",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Freno de Mano</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Freno de Mano\">"+valores2(sharedPref_datos.getBoolean("INTFRE",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Retroceso</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Retroceso\">"+valores2(sharedPref_datos.getBoolean("INTRTC",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Encendedor de Cigarro</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Encendedor de Cigarro\">"+valores2(sharedPref_datos.getBoolean("INTENC",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Cenicero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Cenicero\">"+valores2(sharedPref_datos.getBoolean("INTCEN",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Guantera</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Guantera\">"+valores2(sharedPref_datos.getBoolean("INTGUA",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Cinturon de Seguridad</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Cinturon de Seguridad\">"+valores2(sharedPref_datos.getBoolean("INTCIN",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Funcionamiento Ventana</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Funcionamiento Ventana\">"+valores2(sharedPref_datos.getBoolean("INTFVE",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Puertas y Seguros</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Puertas y Seguros\">"+valores2(sharedPref_datos.getBoolean("INTPYS",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Aire Acondicionado</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Aire Acondicionado\">"+valores2(sharedPref_datos.getBoolean("INTAAC",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Movilidad Volante</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Movilidad Volante\">"+valores2(sharedPref_datos.getBoolean("INTMOV",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Indicadores Auditivos</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Indicadores Auditivos\">"+valores2(sharedPref_datos.getBoolean("INTIAD",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Camara de Retroceso</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Camara de Retroceso\">"+valores2(sharedPref_datos.getBoolean("INTCRE",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Control de Alarma</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Control de Alarma\">"+valores2(sharedPref_datos.getBoolean("INTCAL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Alfombra</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Alfombra\">"+valores2(sharedPref_datos.getBoolean("INTALF",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Posterior de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Tapa de Combustible</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Tapa de Combustible\">"+valores2(sharedPref_datos.getBoolean("POSTCO",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Sistema de Enllave</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Sistema de Enllave\">"+valores2(sharedPref_datos.getBoolean("POSSLL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Llanta de Repuesto</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Llanta de Repuesto\">"+valores2(sharedPref_datos.getBoolean("POSLDR",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Herramientas</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Herramientas\">"+valores2(sharedPref_datos.getBoolean("POSHER",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Triangulo</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Triangulo\">"+valores2(sharedPref_datos.getBoolean("POSTRA",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Extintores</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Extintores\">"+valores2(sharedPref_datos.getBoolean("POSEXT",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Remolque</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Remolque\">"+valores2(sharedPref_datos.getBoolean("POSREM",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Copa de Seguridad</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Copa de Seguridad\">"+valores2(sharedPref_datos.getBoolean("POSCDS",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Exterior de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Puertas Delanteras</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Puertas Delanteras\">"+valores2(sharedPref_datos.getBoolean("EXTPDA",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Faldon</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Faldon\">"+valores2(sharedPref_datos.getBoolean("EXTFAL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Bomper delantero y trasero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Bomper delantero y trasero\">"+valores2(sharedPref_datos.getBoolean("EXTBDT",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Guardafangos</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Guardafangos\">"+valores2(sharedPref_datos.getBoolean("EXTGFG",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Puertas Traceras</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Puertas Traceras\">"+valores2(sharedPref_datos.getBoolean("EXTPTA",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Halogeno</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Halogeno\">"+valores2(sharedPref_datos.getBoolean("EXTHAL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Focos Delanteros</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Focos Delanteros\">"+valores2(sharedPref_datos.getBoolean("EXTFOC",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Tricosy Tapones</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Tricosy Tapones\">"+valores2(sharedPref_datos.getBoolean("EXTTYT",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Niveles Liquidos</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Niveles Liquidos\">"+valores2(sharedPref_datos.getBoolean("EXTNLI",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Niveles de Aceites</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Niveles de Aceites\">"+valores2(sharedPref_datos.getBoolean("EXTNAC",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Vidrio Delantero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Vidrio Delantero\">"+valores2(sharedPref_datos.getBoolean("EXTVDL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Emblema</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Emblema\">"+valores2(sharedPref_datos.getBoolean("EXTEMB",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Riel de Techo</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Riel de Techo\">"+valores2(sharedPref_datos.getBoolean("EXTRIE",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Pescante</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Pescante\">"+valores2(sharedPref_datos.getBoolean("EXTPES",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Rin de Lujo</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Rin de Lujo\">"+valores2(sharedPref_datos.getBoolean("EXTRDL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Techo de Canastera</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Techo de Canastera\">"+valores2(sharedPref_datos.getBoolean("EXTTCN",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Copa de Llanta</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Copa de Llanta\">"+valores2(sharedPref_datos.getBoolean("EXTCDL",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Lodera</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Lodera\">"+valores2(sharedPref_datos.getBoolean("EXTLOD",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Stop</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Stop\">"+valores2(sharedPref_datos.getBoolean("EXTSTP",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Tapa de Aceite</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Tapa de Aceite\">"+valores2(sharedPref_datos.getBoolean("EXTTAP",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Apertura de Maletero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Apertura de Maletero\">"+valores2(sharedPref_datos.getBoolean("EXTAPR",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Calcomania</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Calcomania\">"+valores2(sharedPref_datos.getBoolean("EXTCAL",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Vidrio Trasero</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Vidrio Trasero\">"+valores2(sharedPref_datos.getBoolean("EXTVID",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Antena</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Antena\">"+valores2(sharedPref_datos.getBoolean("EXTATN",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Defensa</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Defensa\">"+valores2(sharedPref_datos.getBoolean("EXTDEF",false))+"</td> \n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Antivuelco</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Antivuelco\">"+valores2(sharedPref_datos.getBoolean("EXTATV",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Forros</td> \n" +
                "\t\t\t\t\t\t<td  data-label=\"Forros\">"+valores2(sharedPref_datos.getBoolean("EXTFRR",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Datos adicionales de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Bateria</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Bateria\">"+valores2(sharedPref_datos.getBoolean("OTRBAT",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Suciedad</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Suciedad\">"+valores2(sharedPref_datos.getBoolean("OTRSUC",false))+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Nivel de Combustible</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Nivel de Combustible\">"+sharedPref_datos.getInt("OTRNCB",0)+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Ultimo Kilometraje</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Ultimo Kilometraje\">"+sharedPref_datos.getString("CADKMT","0")+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<h4>Descripsion</h4>\n" +
                "\t\t\t<p>"+d.getDescription()+"</p>\n" +
                "\t\t\t<h4>Comentario</h4>\n" +
                "\t\t\t<p>"+sharedPref_datos.getString("COMENT","")+"</p>\n";

        limpiar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignatureEmpleado.clear();
            }
        });

        limpiar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignatureCliente.clear();
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Correo.getText().equals("")){

                    contructot_dialigo();

                    SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putBoolean("AFMPMJ",Prueba.isChecked());
                    editor.commit();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new MailJob("mauricio.palacios@autonica.com", "palacios2014", getApplication()).execute(
                                    new MailJob.Mail("Recepcion del Vehiculo AUTONICA",mensaje,"taller.autonica@autonica.com",Correo.getText().toString())
                            );
                        }
                    });

                    new Thread(new Runnable() {
                        public void run() {

                            conexion_base_de_datos dfg = new conexion_base_de_datos();
                            OtrasClases o = new OtrasClases();

                            o.create_firma(SignatureEmpleado,"firmaEmpleado");
                            o.create_firma(SignatureCliente,"firmaCliente");

                            SharedPreferences sharedPref = getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
                            String defaultValue = sharedPref.getString("Nombre","");

                            SharedPreferences sharedPref2 = getSharedPreferences("Systema_data_archivo_DATOS_FUNCIONES", Context.MODE_PRIVATE);

                            String dato="insert into zAppointmentsRecepcionVehiculo values ("+
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
                            dfg.guardarfotos();

                            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }).start();

                }else{
                    Toast.makeText(getApplicationContext(),"Ingrese un correo Electronico", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void contructot_dialigo(){
        AlertDialog.Builder infor = new AlertDialog.Builder(MainFirma.this);
        infor.setMessage("Espere porfavor asta que termine el proceso\n\nLa ventana se cerrara luego que finalize el tiempo...");
        infor.setTitle("Guardando");

        Dialog dialogo2 = infor.create();
        dialogo2.show();
    }

    private String valores2(boolean d) {
        if(d){
            return "<img src=\"http://www.autonica.com/image/dfg2.png\" class=\"image_data_index\"/>";
        }else{
            return "<img src=\"http://www.autonica.com/image/dfg1.png\" class=\"image_data_index\"/>";
        }
    }
}


