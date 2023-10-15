package com.example.guiarecyclertarea.models;

import androidx.annotation.NonNull;

public class Trabajador
{
    private String idTrabajador;
    private String Nombre;

    private String tipo;

    private String sueldo;

    private String valorHora;
    private String horas;
    private String edad;

    public Trabajador() {
        this.idTrabajador = "";
        this.Nombre = "";
        this.tipo = "";
        this.sueldo = "";
        this.valorHora = "";
        this.horas = "";
        this.edad = "";
    }
    public Trabajador(String idTrabajador, String Nombre, String tipo, String valorHora, String horas, String sueldo) {
        this.idTrabajador = idTrabajador;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.valorHora = valorHora;
        this.horas = horas;
        this.sueldo = sueldo;
    }


    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }


    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getValorHora() {
        return valorHora;
    }

    public void setValorHora(String valorHora) {
        this.valorHora = valorHora;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @NonNull
    @Override
    public String toString()
    {
        return  idTrabajador + Nombre + tipo + sueldo + valorHora + horas;
    }
}
