package unicauca.movil.tubarberia;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import unicauca.movil.tubarberia.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    ActivityMapsBinding binding;
    GoogleMap map;
    private Marker marcador;
    double lat = 0.0, lng = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    //region onMapReady
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMapType(googleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);

        myUbication();

        LatLng barber1 = new LatLng(2.454221433053574,-76.59498453140259);
        map.moveCamera(CameraUpdateFactory.newLatLng(barber1));

        LatLng barber2 = new LatLng(2.442258981110637,-76.61614179611206);
        map.moveCamera(CameraUpdateFactory.newLatLng(barber2));

        LatLng barber3 = new LatLng(2.447318382417115,-76.61906003952026);
        map.moveCamera(CameraUpdateFactory.newLatLng(barber3));

        LatLng barber4 = new LatLng(2.352686,-76.68335200000001);
        map.moveCamera(CameraUpdateFactory.newLatLng(barber4));

        MarkerOptions barber_figaro = new MarkerOptions().title("Figaro Barber").position(barber1);
        MarkerOptions barber_factory = new MarkerOptions().title("Barber Factory").position(barber2);
        MarkerOptions barber_londres = new MarkerOptions().title("Barber Londres").position(barber3);
        MarkerOptions barber_timbio = new MarkerOptions().title("Barber Timbio").position(barber4);

        map.addMarker(barber_figaro);
        map.addMarker(barber_factory);
        map.addMarker(barber_londres);
        map.addMarker(barber_timbio);

    }
    //endregion

    //region addMarquer and updateUbication
    private void addMarker(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miPosicion = CameraUpdateFactory.newLatLngZoom(coordenadas, 14);
        if (marcador != null)
            marcador.remove();

        marcador = map.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Tu ubicacion actual"));
        map.animateCamera(miPosicion);
    }

    private void updateUbication(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            addMarker(lat, lng);
        }
    }
    //endregion

    //region Methods location an myUbication
    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            updateUbication(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private void myUbication() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateUbication(location);

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,12000,0,listener);
    }
    //endregion
}
