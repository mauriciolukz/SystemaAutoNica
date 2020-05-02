package com.example.administrador.systemaautonica;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainRetornoVehiculo extends AppCompatActivity {

    private RecyclerView RecyclerViewRecepcion;
    private RecycleViewVehiculos lista;
    private int catidad_datos = 0;

    private EditText BusqPlacaVehiculo, BusqNumVehiculo, BusqCliente, BusqChasis, BusqMotor;
    private TextView FechaR, FechaSelecionada;

    private int dia, mes, ano;

    private Calendar mCalendar;

    private Button fotosGaleria, retorno;

    final Handler handler = new Handler();
    Timer timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        accion_veficicaion_lista();
                    } catch (Exception e) {
                        Log.e("error", e.getMessage());
                    }
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_retorno_vehiculo);

        RecyclerViewRecepcion = (RecyclerView) findViewById(R.id.recyleCitas2);

        BusqCliente = (EditText) findViewById(R.id.txtNombreCliente);
        BusqChasis = (EditText) findViewById(R.id.txtNumeroChasis);
        BusqMotor = (EditText) findViewById(R.id.txtNumeroMotor);
        BusqPlacaVehiculo = (EditText) findViewById(R.id.txtPlacaVehiculo);
        BusqNumVehiculo = (EditText) findViewById(R.id.txtYearVehiculo);

        FechaR = (TextView) findViewById(R.id.idFechaR);
        FechaSelecionada = (TextView) findViewById(R.id.idFechaSelecionada);

        timer.schedule(task, 0, 3000);

        mCalendar = Calendar.getInstance();

        dia = mCalendar.get(Calendar.DAY_OF_MONTH);
        mes = mCalendar.get(Calendar.MONTH);
        ano = mCalendar.get(Calendar.YEAR);

        String d_dia, d_mes;

        mes = mes+1;

        if(dia<10){ d_dia = "0"+dia;
        }else{ d_dia = ""+dia; }

        if(mes<10){ d_mes = "0"+mes;
        }else{ d_mes = ""+mes; }

        FechaR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainRetornoVehiculo.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                        String d_dia, d_mes;

                        if(dayOfMonth<10){
                            d_dia = "0"+dayOfMonth;
                        }else{
                            d_dia = ""+dayOfMonth;
                        }

                        if(monthOfYear<10){
                            d_mes = "0"+monthOfYear;
                        }else{
                            d_mes = ""+monthOfYear;
                        }

                        FechaSelecionada.setText(year+"/"+d_mes+"/"+d_dia);
                    }



                },ano,mes,dia);

                datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Limpiar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_NEGATIVE) {
                            FechaSelecionada.setText("");
                        }
                    }
                });

                datePickerDialog.show();
            }
        });

        RecyclerViewRecepcion.setLayoutManager(new LinearLayoutManager(this));

        dataBusqueda dB = new dataBusqueda();

        dB.setBusqPlacaVehiculo("");
        dB.setBusqNumVehiculo("");
        dB.setBusqFechaRecp("");
        dB.setBusqCliente("");
        dB.setBusqChasis("");
        dB.setBusqMotor("");

        List<data> list_ = new conexion_base_de_datos().ListaAutosIngresados(this,dB);

        lista = new RecycleViewVehiculos(this,list_);
        RecyclerViewRecepcion.setAdapter(lista);
    }

    private void accion_veficicaion_lista(){
        dataBusqueda dB = new dataBusqueda();

        dB.setBusqPlacaVehiculo(""+BusqPlacaVehiculo.getText().toString());
        dB.setBusqNumVehiculo(""+BusqNumVehiculo.getText().toString());
        dB.setBusqFechaRecp(""+FechaSelecionada.getText().toString());
        dB.setBusqCliente(""+BusqCliente.getText().toString());
        dB.setBusqChasis(""+BusqChasis.getText().toString());
        dB.setBusqMotor(""+BusqMotor.getText().toString());

        List<data> list_ = new conexion_base_de_datos().ListaAutosIngresados(this,dB);
        lista = new RecycleViewVehiculos(this,list_);
        int catidad = lista.getItemCount();

        if(catidad != catidad_datos){
            RecyclerViewRecepcion.setAdapter(lista);
            catidad_datos = catidad;
        }
    }
}
