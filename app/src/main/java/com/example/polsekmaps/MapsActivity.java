package com.example.polsekmaps;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng rumah = new LatLng(-7.616967, 111.895966);
        mMap.addMarker(new MarkerOptions().position(rumah).title("Marker in rumah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumah));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        inflater.inflate(R.menu.map_polsek, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case R.id.Pilihan_Map:
                Toast.makeText(this, "Pilihan", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;


            case R.id.Pilihan_Tempat:
                Toast.makeText(this, "Silahkan Pilih", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ngk:
                LatLng ngk = new LatLng(-7.601732, 111.900647);
                mMap.addMarker(new MarkerOptions().position(ngk).title("Marker in Polsek Nganjuk"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ngk));
                return true;

            case R.id.skmr:
                LatLng skmr = new LatLng(-7.602000, 111.937070);
                mMap.addMarker(new MarkerOptions().position(skmr).title("Marker in Polsek Sukomoro"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(skmr));
                return true;

            case R.id.bgr:
                LatLng bgr = new LatLng(-7.568084, 111.849486);
                mMap.addMarker(new MarkerOptions().position(bgr).title("Marker in Polsek Bagor"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bgr));
                return true;

            case R.id.pc:
                LatLng pc = new LatLng(-7.647883, 111.895694);
                mMap.addMarker(new MarkerOptions().position(pc).title("Marker in Polsek Pace"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(pc));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
