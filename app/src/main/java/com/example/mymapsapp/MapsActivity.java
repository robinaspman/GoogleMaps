package com.example.mymapsapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymapsapp.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String TAG = "Maps";
    private GoogleMap mMap;
    private final LatLng mountEverest = new LatLng(28.001377, 86.928129);
    private final LatLng mountKilimanjaro = new LatLng(-3.075558, 37.344363);
    private final LatLng theAlps = new LatLng(47.368955, 9.702579);
    private ActivityMapsBinding binding;

    private Marker everestMarker;
    private Marker kelimanjaroMarker;
    private Marker theAlpsMarker;

    private MarkerOptions everestOptions;
    private MarkerOptions theAlpsOptions;

    private List<MarkerOptions> markerOptionsList;

    private ArrayList<Marker> markerArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        markerArrayList = new ArrayList<>();

        markerOptionsList = new ArrayList<MarkerOptions>();


        everestOptions = new MarkerOptions().position(mountEverest)
                .title("Everest")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        markerOptionsList.add(everestOptions);
        theAlpsOptions = new MarkerOptions().position(theAlps)
                .title("Mt. Everest")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        markerOptionsList.add(theAlpsOptions);

        for (MarkerOptions options : markerOptionsList) {
            LatLng latLng = new LatLng(options.getPosition().latitude, options.getPosition().longitude);
            mMap.addMarker(options);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 3)); // 1 - 20
        }

        // Add a marker in Sydney and move the camera
//        LatLng binga = new LatLng(-19.7766666, 33.061944);
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(binga).title("Marker in binga")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
//                .alpha(0.8f));
//        //mMap.moveCamera(CameraUpdateFactory.newLatLng(binga));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(binga, 12)); // 1 - 20
    }
}