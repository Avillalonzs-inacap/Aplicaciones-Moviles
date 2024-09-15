package com.example.cultiva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CultivoAdapter extends RecyclerView.Adapter<CultivoAdapter.CultivoViewHolder> {

    private final ArrayList<Cultivo> cultivos;

    public CultivoAdapter(ArrayList<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    @NonNull
    @Override
    public CultivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cultivo, parent, false);
        return new CultivoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultivoViewHolder holder, int position) {
        Cultivo cultivo = cultivos.get(position);
        holder.tvCultivoNombre.setText(cultivo.getNombre());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String fechaCosecha = dateFormat.format(cultivo.getFechaCosecha().getTime());
        holder.tvFechaCosecha.setText(fechaCosecha);

        holder.ivCultivo.setImageResource(R.drawable.ic_cultivo);
    }

    @Override
    public int getItemCount() {
        return cultivos.size();
    }

    public static class CultivoViewHolder extends RecyclerView.ViewHolder {

        TextView tvCultivoNombre, tvFechaCosecha;
        ImageView ivCultivo;

        public CultivoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCultivoNombre = itemView.findViewById(R.id.tv_cultivo_nombre);
            tvFechaCosecha = itemView.findViewById(R.id.tv_fecha_cosecha);
            ivCultivo = itemView.findViewById(R.id.iv_cultivo);
        }
    }
}
