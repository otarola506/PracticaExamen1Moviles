package cr.ac.ucr.ecci.eseg.miexamen01;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



// Fragmento Table Top que va mostrar la lista de juegos
public class TableTopFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;


    public TableTopFragment() {
    }

    public static TableTopFragment newInstance(int columnCount) {
        TableTopFragment fragment = new TableTopFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    // Método que crea el fragmento al final de este inserto en la base de datos y consulto
    //  Esto me devuelve una lista de TableTop que se la paso al Recycler Adapter para que la
    // procese y la muestre
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table_top_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // Inserto las instancias en la base de datos
            insertarBaseDatos();
            // Consulta a la base de datos para mostrar la lista de juegos
            TableTop juegos = new TableTop();
            List<TableTop> baseJuegos = juegos.consultar(getContext());
            recyclerView.setAdapter(new MyTableTopRecyclerViewAdapter(baseJuegos));
        }
        return view;
    }


    // Método que inserta instancias de TableTop en la base de datos
    public void insertarBaseDatos (){
        TableTop catan = new TableTop("TT001","Catan",1995,"Kosmos","Germany",48.774538,9.188467,
                "Picture yourself in the era of discoveries:\n" +
                        "after a long voyage of great deprivation,\n" +
                        "your ships have finally reached the coast of\n" +
                        "an uncharted island. Its name shall be Catan!\n" +
                        "But you are not the only discoverer. Other\n" +
                        "fearless seafarers have also landed on the\n" +
                        "shores of Catan: the race to settle the\n" +
                        "island has begun!","3-4","10+","1-2 hours");
        catan.insertar(getContext());

        TableTop monopoly = new TableTop("TT002","Monopoly",1935,"Hasbro","United States",41.883736,-71.352259,
                "The thrill of bankrupting an opponent, but it\n" +
                        "pays to play nice, because fortunes could\n" +
                        "change with the roll of the dice. Experience\n" +
                        "the ups and downs by collecting property\n" +
                        "colors sets to build houses, and maybe even\n" +
                        "upgrading to a hotel!","2-8","8+","20-180 minutes");
        monopoly.insertar(getContext());

        TableTop eldritchHorror = new TableTop("TT003","Eldritch Horror",2013,"Fantasy Flight Games",
                "United States",45.015417,-93.183995,
                "An ancient evil is stirring. You are part of\n" +
                        "a team of unlikely heroes engaged in an\n" +
                        "international struggle to stop the gathering\n" +
                        "darkness. To do so, you’ll have to defeat\n" +
                        "foul monsters, travel to Other Worlds, and\n" +
                        "solve obscure mysteries surrounding this\n" +
                        "unspeakable horror.","1-8","14+","2-4 hours");
        eldritchHorror.insertar(getContext());

        TableTop magic = new TableTop("TT004","Magic: the Gathering",1993,"Hasbro",
                "United States",41.883736,-71.352259,
                "Magic: The Gathering is a collectible and\n" +
                        "digital collectible card game created by\n" +
                        "Richard Garfield. Each game of Magic\n" +
                        "represents a battle between wizards known as\n" +
                        "planeswalkers who cast spells, use artifacts,\n" +
                        "and summon creatures.","2+","13+","Varies");
        magic.insertar(getContext());

        TableTop hanabi = new TableTop("TT005","Hanabi",2010,"Asmodee",
                "France",48.761629,2.065296,
                "Hanabi—named for the Japanese word for\n" +
                        "\"fireworks\"—is a cooperative game in which\n" +
                        "players try to create the perfect fireworks\n" +
                        "show by placing the cards on the table in the\n" +
                        "right order.","2-5","8+","25 minutes");
        hanabi.insertar(getContext());





    }
}