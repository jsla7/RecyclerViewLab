package com.example.guiarecyclertarea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.guiarecyclertarea.SharedPref.SharedManager;
import com.example.guiarecyclertarea.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        configSharedPreference();

        binding.btnIniciarSesion.setOnClickListener(view1 -> {
            showLoading();
        });
    }

    private boolean verificarCredenciales(String email, String pass)
    {
        boolean esValido = false;
        SharedPreferences sharedPreferences = getSharedPreferences("MISDATOS",
                Context.MODE_PRIVATE);
        // extrayendo valores del sharedpreference
        String _email = sharedPreferences.getString("email","default");
        String _pass = sharedPreferences.getString("pass", "default");
        if (email.equals(_email) && pass.equals(_pass)){
            esValido = true;
        }
        return esValido;
    }

    private void configSharedPreference(){
        SharedPreferences sharedPreferences = getSharedPreferences("MISDATOS",
                Context.MODE_PRIVATE);
        // Guardando cadenas en el shared preference
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", "jsla@uso.com");
        editor.putString("pass","123");
        editor.apply();
    }

    private void showLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);

        View progressBar = getLayoutInflater().inflate(R.layout.progressbar,null);
        // Agregar el ProgressBar al diseño del AlertDialog.
        builder.setView(progressBar);
        // Creacion del alertdialog
        final AlertDialog dialog = builder.create();
        // Mostrar alerta
        dialog.show();
        new Handler().postDelayed(() -> {
            try {
                if (dialog.isShowing()) {
                    // Aca programar que debe hacer despues de pasados 3 segundos
                    if(verificarCredenciales(binding.edtEmail.getText().toString(),
                            binding.edtPassword.getText().toString())){

                        SharedManager rec = new SharedManager(this);
                        rec.eliminiarSharedP();
                        startActivity(new Intent(LoginActivity.this,
                                MainActivity.class));
                        dialog.dismiss();
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Credenciales no validas",
                                Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 3000);
    }

}

