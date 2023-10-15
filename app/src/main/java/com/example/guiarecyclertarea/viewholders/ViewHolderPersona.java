package com.example.guiarecyclertarea.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiarecyclertarea.R;

public class ViewHolderPersona extends RecyclerView.ViewHolder{


    private TextView IdTrab;
    private TextView Nombre;
    private TextView tipo;
    private TextView salario;

    public ViewHolderPersona(View itemView) {
        super(itemView);
        this.IdTrab = itemView.findViewById(R.id.idTrab);
        this.Nombre = itemView.findViewById(R.id.nombreTrab);
        this.tipo = itemView.findViewById(R.id.tipoTrab);
        this.salario = itemView.findViewById(R.id.sueldo);
    }

    public TextView getIdTrab() {
        return IdTrab;
    }

    public TextView getNombre() {
        return Nombre;
    }

    public TextView getTipo() {
        return tipo;
    }

    public TextView getSalario() {
        return salario;
    }
}
