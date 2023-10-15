package com.example.guiarecyclertarea.models;

public class Dia {
    private String NombreDia;
    private String numMes;

    private String Mes;

    public Dia()
    {
        NombreDia = "";
        numMes = "";
        Mes = "";

    }

    public Dia(String dia,String num, String mes) {
        NombreDia = dia;
        numMes = num;
        Mes = mes;
    }


    public String getNombreDia() {
        return NombreDia;
    }

    public void setNombreDia(String nombreDia) {
        NombreDia = nombreDia;
    }

    public String getNumMes() {
        return numMes;
    }

    public void setNumMes(String numMes) {
        this.numMes = numMes;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }
}
