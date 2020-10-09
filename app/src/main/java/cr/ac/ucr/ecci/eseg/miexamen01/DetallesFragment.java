package cr.ac.ucr.ecci.eseg.miexamen01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
            textYear.findViewById(tableTop.getYear());



        }
        return v;
    }
}