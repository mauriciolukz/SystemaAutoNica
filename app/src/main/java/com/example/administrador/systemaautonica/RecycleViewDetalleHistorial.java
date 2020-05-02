package com.example.administrador.systemaautonica;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleViewDetalleHistorial extends RecyclerView.Adapter<RecycleViewDetalleHistorial.ViewHolder> {

    Context mContext;
    public List<dataDetalleHistorial> contenido;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView detalle1, detalle2, detalle3, detalle4;
        private ImageView image;

        public ViewHolder(View itemView, final Context mContext) {
            super(itemView);

            detalle1 = (TextView) itemView.findViewById(R.id.tvd_valor1);
            detalle2 = (TextView) itemView.findViewById(R.id.tvd_valor2);
            detalle3 = (TextView) itemView.findViewById(R.id.tvd_valor3);
            detalle4 = (TextView) itemView.findViewById(R.id.tvd_valor4);
            image = (ImageView) itemView.findViewById(R.id.imageViewData);

        }

    }

    public RecycleViewDetalleHistorial(Context mContext, List<dataDetalleHistorial> contenido) {
        this.mContext = mContext;
        this.contenido = contenido;
    }

    //onCreateViewHolder


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle_historial, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.detalle1.setText(contenido.get(position).getITEMNMBR());
        holder.detalle2.setText(contenido.get(position).getITEMDESC());
        holder.detalle3.setText(contenido.get(position).getUOFM());

        if(contenido.get(position).getUOFM().trim().equals("Horas")){
            holder.detalle4.setText("");
        }else{
            holder.detalle4.setText(contenido.get(position).getQUANTITY());
            holder.image.setImageResource(R.drawable.producto_list);
        }

    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }
}
