package edu.uw.bartelsc.maps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    static final LatLng mgh = new LatLng(47.653804, -122.307804);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(mgh)
                .title("Drumheller Fountain")
                .snippet("The ducks are cool")
                .icon(BitmapDescriptorFactory.defaultMarker(268)));

        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(47.653898, -122.308054))
                .add(new LatLng(47.653690, -122.307923))
                .add(new LatLng(47.653827, -122.307802))
                .add(new LatLng(47.653713, -122.307673))
                .add(new LatLng(47.653895, -122.307550))
                .color(Color.rgb(51, 0, 111))
                .width(25);

// Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);
    }
}
