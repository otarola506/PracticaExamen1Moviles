package cr.ac.ucr.ecci.eseg.miexamen01;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link TableTop}.
 */
// Adaptador de Recycler View que va a permitir utilizar la lista TableTop.
public class MyTableTopRecyclerViewAdapter extends RecyclerView.Adapter<MyTableTopRecyclerViewAdapter.ViewHolder> {

    private final List<TableTop> mValues;

    public MyTableTopRecyclerViewAdapter(List<TableTop> items) {
        mValues = items;
    }

    // Metodo que crea el recyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_table_top, parent, false);
        return new ViewHolder(view);
    }

    // Metódo que relaciona los text view de la lista con los de table top
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nombreJuego.setText(mValues.get(position).getName());
        holder.descripcionJuego.setText(mValues.get(position).getDescription());
    }

    // Método que devuelve el tamaño de la lista de TableTop
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Clase que representa a cada fila de la lista a cada se define el OnClick del elemento
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nombreJuego;
        public final TextView descripcionJuego;
        public TableTop mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombreJuego = (TextView) view.findViewById(R.id.nombre);
            descripcionJuego= (TextView) view.findViewById(R.id.descripcion) ;

            // Cuando se haga click en el elemento de la lista se va a redirigir a la actividad detalles pasando el objeto table top en el intent
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),mItem.getName(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mView.getContext(),DetallesActivity.class);
                    // En el intent se le pasa el objeto table top
                    intent.putExtra("table_top",mItem);
                    mView.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nombreJuego.getText() + "'";
        }
    }
}