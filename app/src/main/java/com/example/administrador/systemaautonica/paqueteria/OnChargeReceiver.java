package com.example.administrador.systemaautonica.paqueteria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OnChargeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent i) {
        Toast.makeText(ctx, "Ha conectado el cargador.", Toast.LENGTH_SHORT).show();
    }
}
