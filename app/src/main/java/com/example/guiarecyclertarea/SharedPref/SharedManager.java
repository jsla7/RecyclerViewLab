package com.example.guiarecyclertarea.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.guiarecyclertarea.models.Trabajador;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SharedManager {
    private static final String TRABAJORES_PREFS_KEY = "trabajadores_list";
    private SharedPreferences sharedPreferences;

    public SharedManager(Context context) {
        sharedPreferences = context.getSharedPreferences("TrabPrefs", Context.MODE_PRIVATE);
    }


    public void guardarTrabajadores(ArrayList<Trabajador> lst) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(lst);
        editor.putString(TRABAJORES_PREFS_KEY, json);
        editor.apply();
    }


    public ArrayList<Trabajador> obtenerTrabajadores() {
        String json = sharedPreferences.getString(TRABAJORES_PREFS_KEY, null);
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        if (json != null) {
            Gson gson = new Gson();
            Trabajador[] trabArray = gson.fromJson(json, Trabajador[].class);

            for (Trabajador trab : trabArray) {
                trabajadores.add(trab);
            }
        }

        return trabajadores;
    }

    public void eliminiarSharedP()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
