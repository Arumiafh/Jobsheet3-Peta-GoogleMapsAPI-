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

    static final CameraPosition JAKARTA = CameraPosition.builder()
            .target(new LatLng(-6.21462, 106.84513))
            .zoom(5)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions bandung;
    MarkerOptions makassar;
    MarkerOptions malang;
    MarkerOptions bali;
    MarkerOptions manado;
    MarkerOptions aceh;
    MarkerOptions palu;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bandung = new MarkerOptions()
                .position(new LatLng(-6.90389, 107.61861))
                .title("Bandung")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        makassar = new MarkerOptions()
                .position(new LatLng(-5.14, 119.4221))
                .title("Makassar")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        malang = new MarkerOptions()
                .position(new LatLng(-7.9797, 112.6304))
                .title("Malang")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        bali = new MarkerOptions()
                .position(new LatLng(-8.65, 115.21667))
                .title("Denpasar")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        manado = new MarkerOptions()
                .position(new LatLng(1.48218, 124.84892))
                .title("Manado")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        aceh = new MarkerOptions()
                .position(new LatLng(5.5577, 95.3222))
                .title("Aceh")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        palu = new MarkerOptions()
                .position(new LatLng(-0.8917, 119.8707))
                .title("Palu")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(bandung);
        m_map.addMarker(makassar);
        m_map.addMarker(malang);
        m_map.addMarker(bali);
        m_map.addMarker(manado);
        m_map.addMarker(aceh);
        m_map.addMarker(palu);
        flyTo(JAKARTA);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}

