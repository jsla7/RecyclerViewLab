package com.example.guiarecyclertarea.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiarecyclertarea.R;
import com.example.guiarecyclertarea.adapters.TrabajadorAdapter;
import com.example.guiarecyclertarea.models.Dia;
import com.example.guiarecyclertarea.viewholders.DiaViewHolder;

import java.util.List;

public class DiaAdapter extends RecyclerView.Adapter<DiaViewHolder>
{

    private  String[] mDias;
    private List<Dia> lstDia;

    private OnItemClickListener onItemClickListener;
    public DiaAdapter(List<Dia> lst, OnItemClickListener itemClickListener)
    {
        //this.mDias = mDIas;
        this.lstDia = lst;
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public DiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View mView = mInflater.inflate(R.layout.item_trabajadores,parent,false);

        return new DiaViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaViewHolder holder, int position) {
        holder.getmNombre().setText(lstDia.get(position).getNombreDia());
        holder.getmNum().setText(lstDia.get(position).getNumMes());
        holder.getmMes().setText(lstDia.get(position).getMes());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick("a");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstDia.size();
    }

    public interface OnItemClickListener
    {
            void onItemClick(String a);
    }

}
