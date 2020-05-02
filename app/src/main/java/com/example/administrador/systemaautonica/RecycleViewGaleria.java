package com.example.administrador.systemaautonica;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 24/2/2018.
 */

public class RecycleViewGaleria extends RecyclerView.Adapter<RecycleViewGaleria.ViewHolder> {

    GaleriaVerificarActivity mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView datos, detalle1, detalle2, detalle3;
        private ImageView imagen;
        private Button eliminar;

        public ViewHolder(View itemView, final GaleriaVerificarActivity mContext) {
            super(itemView);

            imagen = (ImageView) itemView.findViewById(R.id.imageView);
            datos = (TextView) itemView.findViewById(R.id.datosGaleria);
            eliminar = (Button) itemView.findViewById(R.id.btnEliminar);
            detalle1 = (TextView) itemView.findViewById(R.id.data_detalle1);
            detalle2 = (TextView) itemView.findViewById(R.id.data_detalle2);
            detalle3 = (TextView) itemView.findViewById(R.id.data_detalle3);


            int posicion = getPosition();

            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.accion_ejecuta(getPosition(),datos.getText().toString());
                }
            });
        }
    }

    public List<dataImagenes> contenido;

    public RecycleViewGaleria(List<dataImagenes> contenido, GaleriaVerificarActivity mContext) {
        this.mContext = mContext;
        this.contenido = contenido;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_galeria_fotos, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.datos.setText(contenido.get(position).getDatos());
        holder.imagen.setImageBitmap(contenido.get(position).getImage());
        holder.detalle1.setText("");
        holder.detalle2.setText("");
        holder.detalle3.setText("");
    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }


}
