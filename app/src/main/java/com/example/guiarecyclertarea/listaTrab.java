package com.example.guiarecyclertarea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.example.guiarecyclertarea.SharedPref.SharedManager;
import com.example.guiarecyclertarea.adapters.TrabajadorAdapter;

import com.example.guiarecyclertarea.models.Trabajador;

import java.util.ArrayList;

public class listaTrab extends AppCompatActivity implements TrabajadorAdapter.OnItemClickListener{

    //private TrabajadorAdapter personaAdapter;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager layoutManager;

    public static ArrayList<Trabajador> lstPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_trab);

        SharedManager rec = new SharedManager(this);
        lstPersonas = rec.obtenerTrabajadores();
        if (lstPersonas.size() > 0)
        {
            most(lstPersonas);
        }
        else{
            mostrarAlertDialog("Mensaje", "NO se encontraron registros");
        }
        /*lstPersonas.add(new Trabajador(Integer.toString(lstPersonas.size() + 1), "Josue Lopez",Integer.toString(1),Integer.toString(0),Integer.toString(0),Integer.toString(500)));
        lstPersonas.add(new Trabajador(Integer.toString(lstPersonas.size() + 1), "Josue Lopez",Integer.toString(1),Integer.toString(0),Integer.toString(0),Integer.toString(500)));
        lstPersonas.add(new Trabajador(Integer.toString(lstPersonas.size() + 1), "Josue Lopez",Integer.toString(1),Integer.toString(0),Integer.toString(0),Integer.toString(500)));

        mostrarAlertDialog("Msj",lstPersonas.get(0).getNombre() + "| "+ lstPersonas.get(0).getSueldo() + "| " + lstPersonas.get(0).getTipo());
        //Toast.makeText(this, "DATOS: " + lstPersonas, Toast.LENGTH_SHORT).show();
        // Configurando adaptador
        personaAdapter = new TrabajadorAdapter(lstPersonas, listaTrab.this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.rcvTrabajadores);
        recyclerView.setAdapter(personaAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);*/
    }


    private void most(ArrayList<Trabajador> lst)
    {
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rcvTrab);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new TrabajadorAdapter(lst,listaTrab.this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void mostrarAlertDialog(String titulo, String msj) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(msj);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ok();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void ok()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onItemClick(Trabajador persona) {
        Toast.makeText(this, "Esta es un prueba: " + persona.getNombre(), Toast.LENGTH_SHORT).show();
    }
}