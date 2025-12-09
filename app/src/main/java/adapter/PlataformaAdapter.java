package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmoteca_andrerm.ListaPeliculasActivity;
import com.example.filmoteca_andrerm.R;

import java.util.ArrayList;

import model.Plataformas;

public class PlataformaAdapter extends RecyclerView.Adapter<PlataformaAdapter.ViewHolder>{
    ArrayList<Plataformas> lista;
    Context context;

    public PlataformaAdapter(ArrayList<Plataformas> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_plataformas_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Plataformas p = lista.get(position);

        holder.textNombre.setText(p.getNombre());
        holder.imgLogo.setImageResource(p.getLogoResId());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, ListaPeliculasActivity.class);
            i.putExtra("plataforma", p.getNombre());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView textNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            textNombre = itemView.findViewById(R.id.textNombrePlataforma);
        }
    }
}
