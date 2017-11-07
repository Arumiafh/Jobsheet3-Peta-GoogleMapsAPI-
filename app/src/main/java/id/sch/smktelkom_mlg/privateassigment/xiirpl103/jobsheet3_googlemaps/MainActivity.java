package id.sch.smktelkom_mlg.privateassigment.xiirpl103.jobsheet3_googlemaps;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition INDONESIA = CameraPosition.builder()
            .target(new LatLng(-6.21462, 106.84513))
            .zoom(2)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition AUSTRALIA = CameraPosition.builder()
            .target(new LatLng(-33.856820, 151.215279))
            .zoom(2)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition MALAYSIA = CameraPosition.builder()
            .target(new LatLng(3.1412, 101.68653))
            .zoom(2)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions aust;
    MarkerOptions malay;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aust = new MarkerOptions()
                .position(new LatLng(-33.856820, 151.215279))
                .title("Sydney")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        malay = new MarkerOptions()
                .position(new LatLng(3.1412, 101.68653))
                .title("Kuala Lumpur")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(aust);
        m_map.addMarker(malay);
        flyTo(INDONESIA);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}

