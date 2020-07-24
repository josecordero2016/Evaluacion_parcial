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




    public class ViewHolder_dts extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView lblPais;
        ImageView imgFoto;
        OnNoteListener onNoteListener;

        public ViewHolder_dts(@NonNull View itemView, OnNoteListener onNoteListener)
        {
            super(itemView);
            lblPais = (TextView) itemView.findViewById(R.id.lblPais);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.onNoteListener=onNoteListener;
        }

        public void asignando(Pais p)
        {
            lblPais.setText(p.getName());
            String url = "http://www.geognos.com/api/en/countries/flag/"+p.getAlpha2Code()+".png";
            Glide.with(itemView).load(url)
                    .centerCrop()
                    .into(imgFoto);
            //Para poder seleccionar cada item
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

}
