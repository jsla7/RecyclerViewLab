package com.example.guiarecyclertarea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guiarecyclertarea.SharedPref.SharedManager;
import com.example.guiarecyclertarea.models.Trabajador;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorTC extends AppCompatActivity {

    EditText txtID,txtNombre,txtApe,txtEdad,txtSalario;
    Button btnAg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador_tc);
        AsignarControles();

        btnAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarTrabajador();
            }
        });



    }

    private boolean validarForm(String id, String nom, String edad, String sueldo)
    {
        boolean v = true;

        if(id.isEmpty() || id == null)
        {
            v = false;
        }

        if(nom.isEmpty() || nom == null)
        {
            v = false;
        }

        if(edad.isEmpty() || edad == null)
        {
            v = false;
        }

        if(sueldo.isEmpty() || sueldo == null)
        {
            v = false;
        }

        return  v;
    }


    private void guardarTrabajador()
    {
        String id = txtID.getText().toString();
        String nom = txtNombre.getText().toString();
        String ape = txtApe.getText().toString();
        String edad = txtEdad.getText().toString();
        String sueldo = txtSalario.getText().toString();



        if(validarForm(id,nom,edad,sueldo))
        {
            ArrayList<Trabajador> nList = new ArrayList<>();


            SharedManager rec = new SharedManager(this);
            nList = rec.obtenerTrabajadores();

            Trabajador t = new Trabajador();
            t.setIdTrabajador(id);
            t.setNombre(nom + " " + ape);
            t.setTipo("TC");
            t.setEdad(edad);
            t.setSueldo(sueldo);
            nList.add(t);

            SharedManager sm = new SharedManager(this);
            sm.guardarTrabajadores(nList);
            mostrarAlertDialog("¡Registrado!","Registro con éxito");


        }
        else
        {
            mostrarAlertDialog2("Mensaje","Verifique que los datos sean correctos");
        }


    }

    private void AsignarControles()
    {
        txtID = findViewById(R.id.txtID);
        txtNombre = findViewById(R.id.txtNombre);
        txtApe = findViewById(R.id.txtApe);
        txtEdad = findViewById(R.id.txtEdad);
        txtSalario = findViewById(R.id.txtSalario);
        btnAg = findViewById(R.id.btnAgregar);

    }
    private void ok()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private Boolean mostrarAlertDialog(String titulo, String msj) {

        boolean v = true;
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

        return v;
    }
    private Boolean mostrarAlertDialog2(String titulo, String msj) {

        boolean v = true;
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

        return v;
    }

}