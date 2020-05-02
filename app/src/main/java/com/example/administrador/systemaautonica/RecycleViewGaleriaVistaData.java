package com.example.administrador.systemaautonica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrador.systemaautonica.paqueteria.dataImage;

import java.util.List;

/**
 * Created by Administrador on 9/4/2018.
 */

public class RecycleViewGaleriaVistaData  extends RecyclerView.Adapter<RecycleViewGaleriaVistaData.ViewHolder> {

    GaleriaVerificarActivity mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        /*private TextView datos, detalle1, detalle2, detalle3;
        private ImageView imagen;
        private Button eliminar;*/

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public List<dataImage> contenido;

    public RecycleViewGaleriaVistaData(List<dataImage> contenido) {
        this.mContext = mContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_galeria_foto_actual, parent, false);
        RecycleViewGaleriaVistaData.ViewHolder viewHolder = new RecycleViewGaleriaVistaData.ViewHolder(view);
        return viewHolder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        /*holder.detalle1.setText("");
        holder.detalle2.setText("");
        holder.detalle3.setText("");*/
    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }
}
