package com.example.evaluacion_parcial.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.evaluacion_parcial.Modelos.Pais;
import com.example.evaluacion_parcial.R;

import java.util.List;

public class adt_paises extends RecyclerView.Adapter<adt_paises.ViewHolder_dts>
{
    private  List<Pais> dts;
    public  adt_paises(List<Pais> dts){this.dts = dts;}

    @NonNull
    @Override
    public adt_paises.ViewHolder_dts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_items, null, false);
        return new ViewHolder_dts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adt_paises.ViewHolder_dts holder, int position) {
        try{holder.asignando(dts.get(position));}catch (Exception e){}
    }

    @Override
    public int getItemCount() {
        return dts.size();
    }

    public class ViewHolder_dts extends RecyclerView.ViewHolder {

        TextView lblPais;
        ImageView imgFoto;

        public ViewHolder_dts(@NonNull View itemView)
        {
            super(itemView);
            lblPais = (TextView) itemView.findViewById(R.id.lblPais);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
        }

        public void asignando(Pais p)
        {
            lblPais.setText(p.getName());
            Glide.with(itemView).load(p.getFlag())
                    .centerCrop()
                    .into(imgFoto);
        }
    }
}
