package id.sch.smktelkom_mlg.privateassigment.xiirpl103.jobsheet3_googlemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition SINGAPORE = CameraPosition.builder()
            .target(new LatLng(1.28967, 103.85007))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition BANGKOK = CameraPosition.builder()
            .target(new LatLng(13.75398, 100.50144))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition BRUNEI = CameraPosition.builder()
            .target(new LatLng(4.94029, 114.94806))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition MANILA = CameraPosition.builder()
            .target(new LatLng(14.6042, 120.9822))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBangkok = (Button) findViewById(R.id.btnBangkok);
        btnBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(BANGKOK);
            }
        });

        Button btnBrunei = (Button) findViewById(R.id.btnBrunei);
        btnBrunei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(BRUNEI);
            }
        });

        Button btnManila = (Button) findViewById(R.id.btnManila);
        btnManila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(MANILA);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        flyTo(SINGAPORE);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}

