package com.example.guiarecyclertarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guiarecyclertarea.SharedPref.SharedManager;

public class MainActivity extends AppCompatActivity {


    Button btnAgg, btnLista, btnAcerca, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgg = findViewById(R.id.btnAgregarTrab);
        btnLista = findViewById(R.id.btnMostlst);
        btnAcerca = findViewById(R.id.btnAcercaDe);

        btnSalir = findViewById(R.id.btnSalir);

        btnAgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SelecTrab.class));
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,listaTrab.class));
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Acercade.class));
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salir();
            }
        });

    }


    private void Salir()
    {
        SharedManager rec = new SharedManager(this);
        rec.eliminiarSharedP();
        finish();

    }

    @Override
    protected void onPause(){
        super.onPause();

    }
}