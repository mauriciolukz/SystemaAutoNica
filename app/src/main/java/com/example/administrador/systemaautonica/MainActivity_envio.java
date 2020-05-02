package com.example.administrador.systemaautonica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toolbar;

public class MainActivity_envio extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private EditText subject;
    private EditText body;
    private EditText recipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_envio);

    }


}
