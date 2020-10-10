package cr.ac.ucr.ecci.eseg.miexamen01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Clase del Fragmento Detalles además maneja una instancia de TableTop
public class DetallesFragment extends Fragment {

    private static final String ARG_TABLE_TOP ="table_top";

    private TableTop tableTop;

    public DetallesFragment() {
        // Required empty public constructor
    }
    public DetallesFragment(TableTop tableTop) {
        this.tableTop = tableTop;
    }


    public static DetallesFragment newInstance(TableTop tableTop) {
        DetallesFragment fragment = new DetallesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TABLE_TOP, tableTop);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tableTop = getArguments().getParcelable(ARG_TABLE_TOP);

        }
    }
    // Se crea la vista y muestran los datos en los text view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalles, container, false);
        if(tableTop != null) {
            TextView textID = (TextView) v.findViewById(R.id.textID);
            textID.setText(tableTop.getId());

            TextView textName = (TextView) v.findViewById(R.id.textName);
            textName.setText(tableTop.getName());

            TextView textDescription = (TextView) v.findViewById(R.id.textDescription);
            textDescription.setText(tableTop.getDescription());

            TextView textYear = (TextView) v.findViewById(R.id.textYear);
            textYear.setText(Integer.toString(tableTop.getYear()));

            TextView textPublisher = (TextView) v.findViewById(R.id.textPublisher);
            textPublisher.setText(tableTop.getPublisher());

            TextView textCountry = (TextView) v.findViewById(R.id.textCountry);
            textCountry.setText(tableTop.getCountry());

            TextView textNumPlayers = (TextView) v.findViewById(R.id.textNumPlayers);
            textNumPlayers.setText(tableTop.getNumPlayers());

            TextView textAges = (TextView) v.findViewById(R.id.textAges);
            textAges.setText(tableTop.getAges());

            TextView textPlayingTime = (TextView) v.findViewById(R.id.textPlayingTime);
            textPlayingTime.setText(tableTop.getPlayingTime());





        }
        return v;
    }
}