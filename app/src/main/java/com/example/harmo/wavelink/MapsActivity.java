package com.example.harmo.wavelink;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

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
        mMap.setOnInfoWindowClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//             TODO: Consider calling
//                ActivityCompat#requestPermissions
//             here to request the missing permissions, and then overriding
//               public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                                      int[] grantResults)
//             to handle the case where the user grants the permission. See the documentation
//             for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {

            LatLng target = new LatLng(location.getLatitude(), location.getLongitude());
            CameraPosition position = this.mMap.getCameraPosition();

            CameraPosition.Builder builder = new CameraPosition.Builder();
            builder.zoom(15);
            builder.target(target);

            this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
            //Marker our_marker = mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Local Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        }

        // Add a marker in Sydney and move the camera
        LatLng netherlands = new LatLng(40.715613, -73.604853);
        LatLng studentcenter1 = new LatLng(40.715946, -73.602037);
        LatLng studentcenter2 = new LatLng(40.716231, -73.601007);
        LatLng bits = new LatLng(40.713889, -73.601651);
        LatLng playhouse = new LatLng(40.713043, -73.600707);
        LatLng calkins = new LatLng(40.713303, -73.599977);
        LatLng axinn = new LatLng(40.714824, -73.600492);
        LatLng library = new LatLng(40.714609, -73.601116);
        LatLng alliance = new LatLng(40.716502, -73.602183);
        //mMap.addMarker(new MarkerOptions().position(New_york).title("Welcome to the city!!"));
        Marker alliance_marker = mMap.addMarker(new MarkerOptions().position(alliance).title("Alliance Hall's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker library_marker = mMap.addMarker(new MarkerOptions().position(library).title("Axinn Library's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker Hammer_marker = mMap.addMarker(new MarkerOptions().position(axinn).title("Hammer Lab's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker calkins_marker = mMap.addMarker(new MarkerOptions().position(calkins).title("Calkins Hall's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker playhouse_marker = mMap.addMarker(new MarkerOptions().position(playhouse).title("Playhouse's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker bits_marker = mMap.addMarker(new MarkerOptions().position(bits).title("Bits and Bite's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker studentcenter2_marker = mMap.addMarker(new MarkerOptions().position(studentcenter2).title("Game Room's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker studentcenter1_marker = mMap.addMarker(new MarkerOptions().position(studentcenter1).title("Student Center's Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        Marker netherlands_marker = mMap.addMarker(new MarkerOptions().position(netherlands).title("Netherland's Birthday Bash").snippet("Tap for more information").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        //Marker our_marker = mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Local Bathroom").snippet("Tap for Rating").icon(BitmapDescriptorFactory.fromResource(R.drawable.disco)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(New_york));

    }
    @Override
    public void onInfoWindowClick(Marker marker)
    {
        switch (marker.getTitle())
        {
            case "Axinn Library's Bathroom":
                //startActivity(new Intent(MapsActivity.this,libraryinfoActivity.class));
                break;
            case "Hammer Lab's Bathroom":
                //startActivity(new Intent(MapsActivity.this,axinninfoActivity.class));
                break;
            case "Calkins Hall's Bathroom":
                break;
            case "Playhouse's Bathroom":
                break;
            case "Bits and Bite's Bathroom":
                break;
            case "Game Room's Bathroom":
                //startActivity(new Intent(MapsActivity.this,gameroominfoActivity.class));
                break;
            case "Student Center's Bathroom":
                //startActivity(new Intent(MapsActivity.this,studinfoActivity.class));
                break;
            case "Netherland's Birthday Bash":
                startActivity(new Intent(MapsActivity.this,nethiesinfo.class));

                break;
            default:
                //startActivity(new Intent(MapsActivity.this,InfoActivity.class));
                break;

        }
    }
}
