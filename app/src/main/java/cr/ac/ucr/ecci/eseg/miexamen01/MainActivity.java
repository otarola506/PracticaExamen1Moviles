package cr.ac.ucr.ecci.eseg.miexamen01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listaJuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaJuegos = findViewById(R.id.listaJuegos);
        insertarBaseDatos();
        TableTop juegos = new TableTop();
        List<TableTop> baseJuegos = new ArrayList<>();
        baseJuegos = juegos.consultar(getApplicationContext());
        ArrayAdapter<TableTop> textoJuegos = new ArrayAdapter<>(this,R.layout.list_item,baseJuegos);
        listaJuegos.setAdapter(textoJuegos);




    }

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
        catan.insertar(getApplicationContext());

        TableTop monopoly = new TableTop("TT002","Monopoly",1935,"Hasbro","United States",41.883736,-71.352259,
                "The thrill of bankrupting an opponent, but it\n" +
                        "pays to play nice, because fortunes could\n" +
                        "change with the roll of the dice. Experience\n" +
                        "the ups and downs by collecting property\n" +
                        "colors sets to build houses, and maybe even\n" +
                        "upgrading to a hotel!","2-8","8+","20-180minutes");
        monopoly.insertar(getApplicationContext());

    }

}