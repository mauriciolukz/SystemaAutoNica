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

import com.example.administrador.systemaautonica.paqueteria.dataVehiculosRecepcionados;

import java.util.List;

/**
 * Created by Administrador on 7/3/2018.
 */

public class RecycleViewVehiculos extends RecyclerView.Adapter<RecycleViewVehiculos.ViewHolder>{

    MainRetornoVehiculo mContext;

    public List<data> contenido;

    public RecycleViewVehiculos(MainRetornoVehiculo mContext, List<data> contenido) {
        this.mContext = mContext;
        this.contenido = contenido;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView texto1, texto2, titulo;
        private CardView Card_l;

        private static long LAST_CLICK_TIME = 0;
        private final int mDoubleClickInterval = 400; // Milliseconds

        public ViewHolder(View itemView, final Context mContext, final List<data> contenido) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.tvtTitulo_df);
            texto1 = (TextView) itemView.findViewById(R.id.tvtDatod1_df);
            texto2 = (TextView) itemView.findViewById(R.id.tvtDatod2_df);
            Card_l = (CardView) itemView.findViewById(R.id.data_card_listag);

            Card_l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    long currentClickTime = System.currentTimeMillis();
                    if (currentClickTime - LAST_CLICK_TIME <= mDoubleClickInterval)
                    {
                        int df = (int) getItemId();
                        data f = contenido.get(getPosition());
                        //Toast.makeText(mContext, "Double click, Posicion: "+df, Toast.LENGTH_SHORT).show();

                        MainVerDatos dfg = new MainVerDatos();
                        Intent recepcionar = new Intent(mContext, dfg.getClass());

                        recepcionar.putExtra("getUniqueID",f.getUniqueID());
                        recepcionar.putExtra("getType",f.getType());
                        recepcionar.putExtra("getStartDate",f.getStartDate());
                        recepcionar.putExtra("getEndDate",f.getEndDate());
                        recepcionar.putExtra("getStartDateWorkshop",f.getStartDateWorkshop());
                        recepcionar.putExtra("getMatricula",f.getMatricula());
                        recepcionar.putExtra("getCITY",f.getCITY());
                        recepcionar.putExtra("getEMAIL",f.getEMAIL());
                        recepcionar.putExtra("getCHASIS",f.getCHASIS());
                        recepcionar.putExtra("getMODEL",f.getMODEL());
                        recepcionar.putExtra("getCOLOR",f.getCOLOR());
                        recepcionar.putExtra("getAno_vehiculo",f.getAno_vehiculo());
                        recepcionar.putExtra("getSLPRSNID",f.getSLPRSNID());
                        recepcionar.putExtra("getEXETIVE",f.getEXETIVE());
                        recepcionar.putExtra("getULTKM",f.getULTKM());
                        recepcionar.putExtra("getRecepcion",f.getRecepcion());
                        recepcionar.putExtra("getNombre_Cliente",f.getNombre_Cliente());
                        recepcionar.putExtra("getNumero_cliente",f.getNumero_cliente());
                        recepcionar.putExtra("getDescription",f.getDescription());
                        recepcionar.putExtra("getCUSTNMBR",f.getCUSTNMBR());

                        mContext.startActivity(recepcionar);
                    }
                    else
                    {
                        LAST_CLICK_TIME = System.currentTimeMillis();
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista2, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mContext, contenido);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titulo.setText(contenido.get(position).getNombre_Cliente().trim()+" Proforma:"+contenido.get(position).getUniqueID());
        holder.texto1.setText("Informacion general del Vehiculo:\n"+
                "Codido del Chasis: "+contenido.get(position).getCHASIS().trim()+
                ", Año del Vehiculo: "+contenido.get(position).getAno_vehiculo().trim() +
                ", Numero de Placa: "+contenido.get(position).getMatricula().trim()+"; Color del Vehiculo"+contenido.get(position).getCOLOR().trim());
        holder.texto2.setText("Contacto al correo: "+contenido.get(position).getEMAIL().trim()+", y/o celular"+contenido.get(position).getNumero_cliente().trim());
    }


    @Override
    public int getItemCount() {
        return contenido.size();
    }
}
