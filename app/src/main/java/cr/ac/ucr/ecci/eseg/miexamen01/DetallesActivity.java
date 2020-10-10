package cr.ac.ucr.ecci.eseg.miexamen01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class DetallesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        // Recibo el objeto table top
        TableTop item = getIntent().getExtras().getParcelable("table_top");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Inicio el fragmento de detalles con el objeto table top
        ft.replace(R.id.fragment_placeholder,new DetallesFragment(item));
        ft.commit();
    }
}