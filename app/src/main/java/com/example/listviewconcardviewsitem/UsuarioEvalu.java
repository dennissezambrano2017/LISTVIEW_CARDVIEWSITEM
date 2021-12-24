package com.example.listviewconcardviewsitem;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UsuarioEvalu {

    private int idevaluado;
    private String nombres;
    private String genero;
    private String situacion;
    private String cargo;
    private String FechaInicio;
    private String FechaFin;
    private String urlImag;
    private String ImagAvatar;

    public UsuarioEvalu() {
    }

    public UsuarioEvalu(int idevaluado, String nombres, String genero, String situacion, String cargo, String fechaInicio, String fechaFin, String urlImag, String imagAvatar) {
        this.idevaluado = idevaluado;
        this.nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        this.urlImag = urlImag;
        ImagAvatar = imagAvatar;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
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

    public static ArrayList<UsuarioEvalu> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<UsuarioEvalu> usuarios = new ArrayList<>();
        ArrayList <String> lis = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            JSONObject user=  datos.getJSONObject(i);
            Log.d("DATOS", user.toString());
            usuarios.add(new UsuarioEvalu(user.getInt("idevaluado"),
                    user.getString("Nombres"),
                    user.getString("genero"),
                    user.getString("situacion"),
                    user.getString("cargo"),
                    user.getString("fechainicio"),
                    user.getString("fechainfin"),
                    user.getString("imgJPG"),
                    user.getString("imgjpg")));
        }
        return usuarios;
    }
}
