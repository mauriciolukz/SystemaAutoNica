package com.example.administrador.systemaautonica;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecycleViewHistorial extends RecyclerView.Adapter<RecycleViewHistorial.ViewHolder> {

    Context mContext;
    public List<dataHistorial> contenido;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView factura, detalle1, detalle2, detalle3;
        private CardView VistaHistoria;

        private static long LAST_CLICK_TIME = 0;
        private final int mDoubleClickInterval = 400; // Milliseconds

        public ViewHolder(View itemView, final Context mContext) {
            super(itemView);

            factura = (TextView) itemView.findViewById(R.id.tvNFactura);
            detalle1 = (TextView) itemView.findViewById(R.id.tvDato_v1);
            detalle2 = (TextView) itemView.findViewById(R.id.tvDato_v2);
            detalle3 = (TextView) itemView.findViewById(R.id.tvDato_v3);

            VistaHistoria = (CardView) itemView.findViewById(R.id.cardVistaHistoria);

            VistaHistoria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    long currentClickTime = System.currentTimeMillis();
                    if (currentClickTime - LAST_CLICK_TIME <= mDoubleClickInterval)
                    {
                        MainDetalleHistorial dfg = new MainDetalleHistorial();
                        Intent recepcionar = new Intent(mContext, dfg.getClass());
                        recepcionar.putExtra("dato_recibo",factura.getText().toString().replace("Numero de Pedido ",""));
                        mContext.startActivity(recepcionar);
                    }
                    else {
                        LAST_CLICK_TIME = System.currentTimeMillis();
                    }
                }
            });

        }
    }

    public RecycleViewHistorial(Context mContext, List<dataHistorial> contenido) {
        this.mContext = mContext;
        this.contenido = contenido;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historia, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        float df1 = Float.parseFloat(contenido.get(position).getORSUBTOT());
        float df2 = Float.parseFloat(contenido.get(position).getORTAXAMT());

        float df3 = Float.parseFloat(contenido.get(position).getORDOCAMT());

        holder.factura.setText("Numero de Pedido "+contenido.get(position).getSOPNUMBE());
        holder.detalle1.setText("Fecha que genero factura: "+contenido.get(position).getDOCDATE());
        holder.detalle2.setText("Moto total de factura; SubTotal "+((int)df1)+", IVA "+((int)df2)+", Total "+((int)df3));
        holder.detalle3.setText("Detalle: "+contenido.get(position).getCMMTTEXT());

    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }
}
