package com.example.listviewconcardviewsitem;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

    private int idevaluado;
    private String nombres;
    private String urlImag;
    private String ImagAvatar;
    private String Area;

    public Usuario() {
    }

    public Usuario( int idevaluado, String nombres, String urlImag, String imagAvatar, String area) {
        this.idevaluado = idevaluado;
        this.nombres = nombres;
        this.urlImag = urlImag;
        ImagAvatar = imagAvatar;
        Area = area;
    }

    public int getIdevaluado() {
        return idevaluado;
    }

    public void setIdevaluado(int idevaluado) {
        this.idevaluado = idevaluado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUrlImag() {
        return urlImag;
    }

    public void setUrlImag(String urlImag) {
        this.urlImag = urlImag;
    }

    public String getImagAvatar() {
        return ImagAvatar;
    }

    public void setImagAvatar(String imagAvatar) {
        ImagAvatar = imagAvatar;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList <String> lis = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            JSONObject user=  datos.getJSONObject(i);
            Log.d("DATOS", user.toString());
            usuarios.add(new Usuario(user.getInt("idevaluador"),
                    user.getString("nombres"),
                    user.getString("imgJPG"),
                    user.getString("imgjpg"),
                    user.getString("area")));
        }
        return usuarios;
    }


}
