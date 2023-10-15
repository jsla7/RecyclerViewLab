package com.example.guiarecyclertarea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class SelecTrab extends AppCompatActivity {

    RadioButton tbTrabH,tbTrabComp;
    Button btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_trab);

        tbTrabH = findViewById(R.id.tbTrabH);
        tbTrabComp = findViewById(R.id.tbTrabComp);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        tbTrabH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(SelecTrab.this, "Evento checked change cambio", Toast.LENGTH_SHORT).show();
                if (tbTrabH.isChecked())
                {
                    tbTrabComp.setChecked(false);
                }
            }
        });

        tbTrabComp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tbTrabComp.isChecked())
                {
                    tbTrabH.setChecked(false);
                }


            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tbTrabH.isChecked())
                {
                    startActivity(new Intent(SelecTrab.this,TrabHora.class));
                }
                else if (tbTrabComp.isChecked())
                {
                    startActivity(new Intent(SelecTrab.this, TrabajadorTC.class));
                }
                else
                {
                    mostrarAlertDialog("Alerta","Seleccione un tipo de trabajador");
                }
            }
        });


    }

    private void mostrarAlertDialog(String titulo, String msj) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(msj);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




}