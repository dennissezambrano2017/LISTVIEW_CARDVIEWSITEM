package com.example.listviewconcardviewsitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context econtext;
    private ArrayList<Usuario> elista;

    public Adapter() {
    }

    public Adapter (Context contex, ArrayList<Usuario> lusuario){
        econtext = contex;
        elista = lusuario;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(econtext).inflate(R.layout.elements,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario actual = elista.get(position);

        String urlImag = actual.getUrlImag();
        String Nombre = actual.getNombres();
        String Cargo = actual.getCargo();

        holder.mNombre.setText("Nombre: "+Nombre);
        holder.mCargo.setText("Cargo: "+Cargo);

        Picasso.with(econtext).load(urlImag).fit().centerInside().into(holder.eImagen);

    }

    @Override
    public int getItemCount() {
        return elista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView eImagen;
        public TextView mNombre;
        public TextView mCargo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eImagen =itemView.findViewById(R.id.imagen_vista);
            mNombre =itemView.findViewById(R.id.text_Nombre);
            mCargo =itemView.findViewById(R.id.text_Area);
        }
    }

}
