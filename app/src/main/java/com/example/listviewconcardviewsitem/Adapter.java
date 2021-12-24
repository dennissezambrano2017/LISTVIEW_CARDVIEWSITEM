package com.example.listviewconcardviewsitem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context econtext;
    private ArrayList<Usuario> elista;
    public Adapter (Context contex, ArrayList<Usuario> lusuario){
        econtext = contex;
       this.elista = lusuario;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(econtext);
        View v = inflater.inflate(R.layout.elements,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario actual = elista.get(position);

        String desconocido = "https://www.prensalibre.com/wp-content/uploads/2019/05/1467646262_522853_1467646344_noticia_normal.jpg?quality=82&w=664";
        int Cedula = actual.getIdevaluado();
        String Nombre = actual.getNombres();
        String Area = actual.getArea();

        holder.mCedula.setText("CEDULA: "+Cedula);
        holder.mNombre.setText("NOMBRES: "+Nombre);
        holder.mArea.setText("CARGO: "+Area);

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView eImagen;
        public TextView mNombre,mArea, mCedula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eImagen =itemView.findViewById(R.id.imagen_vista);
            mNombre =itemView.findViewById(R.id.text_Nombre);
            mArea =itemView.findViewById(R.id.text_Area);
            mCedula = itemView.findViewById(R.id.text_Cedula);
        }
    }


}
