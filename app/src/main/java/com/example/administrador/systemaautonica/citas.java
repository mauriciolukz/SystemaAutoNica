package com.example.administrador.systemaautonica;

import android.app.DatePickerDialog;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class citas extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    private RecycleViewLista lista;

    private EditText BusqPlacaVehiculo, BusqNumVehiculo, BusqCliente, BusqChasis, BusqMotor;

    private TextView fechaRecepcion, fecha;

    private Calendar mCalendar;

    private int dia, mes, ano, catidad_datos = 0;

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
        setContentView(R.layout.activity_citas);

        fechaRecepcion = (TextView) findViewById(R.id.idFechaRecepcion);
        fecha = (TextView) findViewById(R.id.idFecha);

        recyclerViewLista = (RecyclerView) findViewById(R.id.recyleCitas);

        BusqPlacaVehiculo = (EditText) findViewById(R.id.txtBusqPlacaVehiculo);
        BusqNumVehiculo = (EditText) findViewById(R.id.txtBusqNumVehiculo);

        BusqCliente = (EditText) findViewById(R.id.txtBusqCliente);
        BusqChasis = (EditText) findViewById(R.id.txtBusqChasis);
        BusqMotor = (EditText) findViewById(R.id.txtBusqMotor);

        recyclerViewLista.setLayoutManager(new LinearLayoutManager(this));

        dataBusqueda dB = new dataBusqueda();

        dB.setBusqPlacaVehiculo("");
        dB.setBusqNumVehiculo("");
        dB.setBusqFechaRecp("");
        dB.setBusqCliente("");
        dB.setBusqChasis("");
        dB.setBusqMotor("");

        List<data> list_ = new conexion_base_de_datos().contenercitas(getApplication(), dB);

        lista = new RecycleViewLista(list_,this);
        recyclerViewLista.setAdapter(lista);



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

        fecha.setText(ano+"/"+d_mes+"/"+d_dia);

        timer.schedule(task, 0, 3000);

        fechaRecepcion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Entro", Toast.LENGTH_SHORT).show();

                DatePickerDialog datePickerDialog = new DatePickerDialog(citas.this, R.style.datepicker, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                        String d_dia, d_mes;

                        if(dayOfMonth<10){
                            d_dia = "0"+dayOfMonth;
                        }else{
                            d_dia = ""+dayOfMonth;
                        }

                        monthOfYear = monthOfYear + 1;

                        if(monthOfYear<10){
                            d_mes = "0"+monthOfYear;
                        }else{
                            d_mes = ""+monthOfYear;
                        }

                        fecha.setText(year+"/"+d_mes+"/"+d_dia);
                    }
                },ano,(mes-1),dia);

                datePickerDialog.show();
            }
        });


    }

    private void accion_veficicaion_lista(){
        dataBusqueda dB = new dataBusqueda();

        dB.setBusqPlacaVehiculo(""+BusqPlacaVehiculo.getText().toString());
        dB.setBusqNumVehiculo(""+BusqNumVehiculo.getText().toString());
        dB.setBusqFechaRecp(""+fecha.getText().toString().replace("/","-"));
        dB.setBusqCliente(""+BusqCliente.getText().toString());
        dB.setBusqChasis(""+BusqChasis.getText().toString());
        dB.setBusqMotor(""+BusqMotor.getText().toString());

        lista = new RecycleViewLista(new conexion_base_de_datos().contenercitas(this, dB),citas.this);

        int catidad = lista.getItemCount();

        if(catidad != catidad_datos){
            recyclerViewLista.setAdapter(lista);
            catidad_datos = catidad;
        }
    }

}