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
    private String genero;
    private String situacion;
    private String cargo;
    private Date FechaInicio;
    private Date FechaFin;
    private String urlImag;
    private String ImagAvatar;
    private String Area;

    public Usuario() {
    }

    public Usuario( String nombres, String urlImag, String imagAvatar, String area) {
        this.nombres = nombres;
        this.urlImag = urlImag;
        ImagAvatar = imagAvatar;
        Area = area;
    }

    public Usuario(String nombres, String genero, String situacion, String cargo, Date fechaInicio, Date fechaFin, String urlImag, String imagAvatar) {
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

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
            usuarios.add(new Usuario(user.getString("nombres"),
                    user.getString("imgJPG"),
                    user.getString("imgjpg"),
                    user.getString("area")));
        }
        return usuarios;
    }
}
