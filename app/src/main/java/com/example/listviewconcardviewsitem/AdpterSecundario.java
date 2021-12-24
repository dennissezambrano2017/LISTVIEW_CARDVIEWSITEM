package com.example.listviewconcardviewsitem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdpterSecundario extends RecyclerView.Adapter<AdpterSecundario.ViewHolderData> {
    private Context econtext;
    private ArrayList<UsuarioEvalu> elista;

    public AdpterSecundario(Context contex, ArrayList<UsuarioEvalu> lusuario){
        econtext = contex;
        this.elista = lusuario;
    }

    @NonNull
    @Override
    public AdpterSecundario.ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elements_evaluados,null,false);
        return new AdpterSecundario.ViewHolderData(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        UsuarioEvalu actual = elista.get(position);

        String desconocido = "https://www.prensalibre.com/wp-content/uploads/2019/05/1467646262_522853_1467646344_noticia_normal.jpg?quality=82&w=664";

        holder.tvNombre.setText(actual.getNombres());
        holder.tvCargo.setText(actual.getCargo());
        holder.tvSitu.setText(actual.getSituacion());
        holder.tvInicio.setText(actual.getFechaInicio());
        holder.tvFin.setText(actual.getFechaFin());

        try{
            Glide.with(econtext)
                    .load(actual.getImagAvatar())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(Glide.with(econtext)
                            .load(actual.getUrlImag())
                            .error(Glide.with(econtext)
                                    .load(desconocido)))
                    .into(holder.eImagen);
            Log.d("UrlImag:",actual.getUrlImag());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return elista.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder{

        ImageView eImagen;
        TextView tvNombre, tvCargo, tvSitu, tvInicio, tvFin;

        public ViewHolderData(View itemView) {
            super(itemView);

            tvNombre= itemView.findViewById(R.id.Nombres_text);
            tvCargo= itemView.findViewById(R.id.txt_cargo);
            tvSitu = itemView.findViewById(R.id.txt_situacion);
            tvInicio = itemView.findViewById(R.id.txt_Fecha_inicio);
            tvFin = itemView.findViewById(R.id.txt_Fecha_fin);
            eImagen = itemView.findViewById(R.id.imagen_eva);
        }
    }
}
