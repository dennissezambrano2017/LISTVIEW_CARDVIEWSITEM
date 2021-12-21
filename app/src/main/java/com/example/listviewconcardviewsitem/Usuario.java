package com.example.listviewconcardviewsitem;

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

    public Usuario() {
    }

    public Usuario(String nombres, String cargo, String urlImag) {
        this.nombres = nombres;
        this.cargo = cargo;
        this.urlImag = urlImag;
    }

    public Usuario(int idevaluado, String nombres, String genero, String situacion, String cargo, Date fechaInicio, Date fechaFin, String urlImag) {
        this.idevaluado = idevaluado;
        this.nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        this.urlImag = urlImag;
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
}
