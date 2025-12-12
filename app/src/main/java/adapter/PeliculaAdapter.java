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

import com.example.filmoteca_andrerm.DetallePeliculaActivity;
import com.example.filmoteca_andrerm.R;

import java.util.ArrayList;

import model.Pelicula;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {

    ArrayList<Pelicula> lista;
    Context context;

    public PeliculaAdapter(ArrayList<Pelicula> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int tipoVista) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pelicula, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula p = lista.get(position);

        holder.titulo.setText(p.getTitulo());
        holder.poster.setImageResource(p.getPosterResId());

        //Parte para navegar desde la película a la pantalla detalles
        holder.itemView.setOnClickListener(v-> {
            Intent intent = new Intent(context, DetallePeliculaActivity.class);

            intent.putExtra("titulo", p.getTitulo());
            intent.putExtra("poster", p.getPosterResId());
            intent.putExtra("sinopsis",p.getSinopsis());

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.imgPoster);
            titulo = itemView.findViewById(R.id.textTituloPelicula);
        }
    }
}
