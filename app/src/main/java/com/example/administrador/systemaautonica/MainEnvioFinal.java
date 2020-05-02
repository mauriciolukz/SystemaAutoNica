package com.example.administrador.systemaautonica;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class MainEnvioFinal extends AppCompatActivity {

    private Button finalizar, limpiar2, enviar,cerrar;
    private SignaturePad SignatureCliente;
    private ToggleButton Prueba;
    private EditText valor;
    private TextView Correo;

    conexion_base_de_datos dfg = new conexion_base_de_datos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_envio_final);

        finalizar = (Button) findViewById(R.id.button2);
        limpiar2 = (Button) findViewById(R.id.btnLimpiar2);
        enviar = (Button) findViewById(R.id.button3);
        cerrar = (Button) findViewById(R.id.button4);

        enviar.setVisibility(View.INVISIBLE);
        cerrar.setVisibility(View.INVISIBLE);

        Prueba = (ToggleButton) findViewById(R.id.tBtPrueba);
        SignatureCliente = (SignaturePad) findViewById(R.id.signature_pad2);
        valor = (EditText) findViewById(R.id.txtContenido);
        Correo = (TextView) findViewById(R.id.editText2);

        Intent recibir = getIntent();

        final int id = recibir.getIntExtra("getIDzRecepcionVehiculo",0);
        String motor = recibir.getStringExtra("getCUSTNMBR");

        String matricula = recibir.getStringExtra("getMatricula");
        String chasis = recibir.getStringExtra("getCHASIS");
        String modelo = recibir.getStringExtra("getMODEL");
        String ano = recibir.getStringExtra("getAno_vehiculo");
        String nombre = recibir.getStringExtra("getNombre_Cliente");
        String numero = recibir.getStringExtra("getNumero_cliente");
        String color = recibir.getStringExtra("getCOLOR");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final String d =
                "\t\t\t<div class=\"titulo\">\n" +
                "\t\t\t\t<h1>Envio de información de recepción de autos, "+new OtrasClases().titulo(this)+"</h1>\n" +
                "\t\t\t\t<p>Estimado señor "+nombre+"</p>\n" +
                "\t\t\t\t<p></p>\n" +
                "\t\t\t\t<p></p>\n" +
                "\t\t\t\t<p>Numero de Matriula "+matricula+",con este medio se le informa que entregamos en tiempo y forma su vehiculo</p>\n" +
                "\t\t\t\t<p></p>\n" +
                "\t\t\t\t<p>Fecha de Entrega del vehiculo: "+dateFormat.format(date)+"</p>" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"sub_titulo\"><h4>Documentación de Vehiculo</h4></div>\n" +
                "\t\t\t<table>\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Numero de Matricuka</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Numero de Matricuka\">"+matricula+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Numero de Chasis</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Numero de Chasis\">"+chasis+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Modelo del Vehiculo</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Modelo del Vehiculo\">"+modelo+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Año del Vehiculo</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"Año del Vehiculo\">"+ano+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"esconder\">Color del Vehiculo</td>\n" +
                "\t\t\t\t\t\t<td  data-label=\"\">"+color+"</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n";

        Correo.setText(dfg.correo(this,motor).replaceAll("\\s","").trim().toLowerCase());

        limpiar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignatureCliente.clear();
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Correo.getText().equals("")){

                    int a = 0;
                    String Buscar = Correo.getText().toString();

                    if(Buscar.length() != Buscar.replace("@","").length()){
                        a = a+1;
                        Toast.makeText(getApplicationContext(),"Entro @", Toast.LENGTH_SHORT).show();
                    }
                    if(Buscar.length() != Buscar.replace(".com","").length()){
                        a = a+1;
                        Toast.makeText(getApplicationContext(),"Entro .com", Toast.LENGTH_SHORT).show();
                    }

                    if(a == 2){
                        if(dfg.Guardar2(id, valor.getText().toString(), Prueba.isChecked())) {

                            OtrasClases o = new OtrasClases();

                            o.create_firma(SignatureCliente,"firmaClienteSalida");

                            contructot_dialigo();

                            dfg.guardar_imagen_firma_entrega("firmaClienteSalida", id);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    new MailJob("mauricio.palacios@autonica.com", "palacios2014", getApplication()).execute(
                                            new MailJob.Mail("Recepcion del Vehiculo AUTONICA",d,"taller.autonica@autonica.com",Correo.getText().toString())
                                    );
                                }
                            });
                            Intent intent = new Intent(getApplicationContext(), MainRetornoVehiculo.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }

                    }else{
                        Toast.makeText(getApplicationContext(),"No es un Correo Electronico", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"No tiene Correo Electronico", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void contructot_dialigo(){
        AlertDialog.Builder infor = new AlertDialog.Builder(this);
        infor.setMessage("Espere porfavor asta que termine el proceso\n\nLa ventana se cerrara luego que finalize el tiempo...");
        infor.setTitle("Guardando");

        Dialog dialogo2 = infor.create();
        dialogo2.show();
    }
}
