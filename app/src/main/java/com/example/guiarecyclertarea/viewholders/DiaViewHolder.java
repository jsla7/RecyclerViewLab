package com.example.guiarecyclertarea.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.guiarecyclertarea.R;

public class DiaViewHolder extends RecyclerView.ViewHolder {

    private TextView mNombre;
    private TextView mNum;
    private TextView mMes;

    public DiaViewHolder(View itemView)
    {
        super(itemView);
        /*mNombre = (TextView) itemView.findViewById(R.id.dia_nombre);
        mNum = (TextView) itemView.findViewById(R.id.num_Mes);
        mMes = (TextView) itemView.findViewById(R.id.nom_Mes);*/
    }

    public TextView getmNombre() {
        return mNombre;
    }

    public TextView getmNum() {
        return mNum;
    }

    public TextView getmMes() {
        return mMes;
    }
}
