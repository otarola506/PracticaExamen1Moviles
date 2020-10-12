package cr.ac.ucr.ecci.eseg.miexamen01;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
// Actividad de tipo Maps Actividad de Google Maps

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TableTop tableTop;
    private static final String ARG_TABLE_TOP ="table_top";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Recupero el objeto table top que me pasa el fragmento de detalles
       Bundle b = getIntent().getExtras();
       if(b != null){
           tableTop = b.getParcelable(ARG_TABLE_TOP);
       }

    }

   // Método que localiza la ubicación del publisher en el mapa
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Añadir un marcador en donde esta ubicado el publisher del juego
        LatLng publisher= new LatLng(tableTop.getLatitude(), tableTop.getLongitude());
        mMap.addMarker(new MarkerOptions().position(publisher).title(tableTop.getPublisher()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(publisher));
    }
}