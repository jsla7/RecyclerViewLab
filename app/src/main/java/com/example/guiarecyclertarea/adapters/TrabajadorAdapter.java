package com.example.guiarecyclertarea.adapters;

import static com.example.guiarecyclertarea.listaTrab.lstPersonas;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiarecyclertarea.R;
import com.example.guiarecyclertarea.models.Trabajador;
import com.example.guiarecyclertarea.viewholders.ViewHolderPersona;

import java.util.ArrayList;

public class TrabajadorAdapter extends RecyclerView.Adapter<ViewHolderPersona>{
    private final ArrayList<Trabajador> datos;
    private final OnItemClickListener onItemClickListener;


    public TrabajadorAdapter(ArrayList<Trabajador> datos, OnItemClickListener itemClickListener) {
        this.datos = datos;
        this.onItemClickListener = itemClickListener;

    }


    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_trabajadores,parent,false);
        return new ViewHolderPersona(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position) {
        final Trabajador personaItem = datos.get(position);

        holder.getIdTrab().setText(datos.get(position).getIdTrabajador());
        holder.getNombre().setText(datos.get(position).getNombre());
        holder.getTipo().setText(String.valueOf(datos.get(position).getTipo()));
        holder.getSalario().setText(String.valueOf(datos.get(position).getSueldo()));

        holder.itemView.setOnClickListener(view -> {
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(personaItem);
            }
        });
    }


    @Override
    public int getItemCount() {
        return lstPersonas.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Trabajador persona);
    }

}
