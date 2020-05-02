package com.example.administrador.systemaautonica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.systemaautonica.paqueteria.OtrasClases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrador on 28/3/2018.
 */

public class RecycleViewUsuarios extends RecyclerView.Adapter<RecycleViewUsuarios.ViewHolder> {

    Context mContext;

    public List<dataImagenes> contenido;

    public RecycleViewUsuarios(List<dataImagenes> contenido, Context mContext) {
        this.mContext = mContext;
        this.contenido = contenido;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView texto1, texto2, titulo, textoID;
        private CardView Card;
        private ImageView imageView;
        private Button ver, enviar;

        public ViewHolder(View itemView, final Context mContext, final List<dataImagenes> contenido) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.textView21);
            texto1 = (TextView) itemView.findViewById(R.id.textView28);
            texto2 = (TextView) itemView.findViewById(R.id.textView29);
            textoID = (TextView) itemView.findViewById(R.id.textViewID);

            Card = (CardView)  itemView.findViewById(R.id.car_usuasrio);
            imageView = (ImageView) itemView.findViewById(R.id.imageView3);

            ver = (Button) itemView.findViewById(R.id.button7);
            enviar = (Button) itemView.findViewById(R.id.button8);

            ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainGestionarImage dfg = new MainGestionarImage();
                    Intent recepcionar = new Intent(mContext, dfg.getClass());
                    recepcionar.putExtra("ID",textoID.getText().toString());
                    mContext.startActivity(recepcionar);
                }
            });

            enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bitmap valor = imageView.getDrawingCache();

                    new OtrasClases().convertBitmapToFile(valor, "enviar");

                    String[] TO = {""};
                    String[] CC = {""};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("image/jpg");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Envio de imagenes, AUTONICA");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "");

                    Uri uri = Uri.parse(new OtrasClases().ruta_fotos + "enviar.jpg");
                    emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    try {
                        mContext.startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(mContext,"No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lista_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mContext, contenido);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String [] vect = contenido.get(position).getDatos().split("_");

        if(vect.length>1){
            holder.titulo.setText("Fotos Exterios");
            holder.imageView.setImageBitmap(contenido.get(position).getImage());
            holder.texto1.setText(vect[0]);
            holder.texto2.setText(vect[1]);
        }else{
            holder.titulo.setText("Otras fotos");
            holder.imageView.setImageBitmap(contenido.get(position).getImage());
            holder.texto1.setText("");
            holder.texto2.setText("Medidor de Combustible");
        }
        holder.textoID.setText(contenido.get(position).id);
        holder.imageView.setImageBitmap(contenido.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }

}
