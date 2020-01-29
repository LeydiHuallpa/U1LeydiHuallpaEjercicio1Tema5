package com.example.ejercicio1tarea5;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMapClickListener {
    GoogleMap mapa;
    Polygon polygon= null;
    List<LatLng> latLngList= new ArrayList<>();
    List<Marker> markerList = new ArrayList<>();
    LatLng mpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.007633, -70.239271), 14));

        mapa.addMarker(new MarkerOptions().position(new LatLng(-18.004905, -70.235160))
                .title("Postgrado UPT")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.markera)));
        PolygonOptions polygonOptions = new PolygonOptions()
                .add(new LatLng(-18.004806, -70.235560),
                        new LatLng(-18.005302, -70.235287),
                        new LatLng(-18.004966, -70.234752),
                        new LatLng(-18.004543, -70.235130));

        polygon = mapa.addPolygon(polygonOptions);
        polygon.setFillColor(Color.GREEN);

        mapa.addMarker(new MarkerOptions().position(new LatLng(-18.005705, -70.225211))
                .title("Campus")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.markera)));
        PolygonOptions Campus = new PolygonOptions()
                .add(new LatLng(-18.003327, -70.224879),
                                        new LatLng(-18.004332, -70.224278),
                new LatLng(-18.005643, -70.223838),
                new LatLng(-18.007194, -70.225716),
                new LatLng(-18.006664, -70.226204),
                new LatLng(-18.007286, -70.227169),
                new LatLng(-18.006756, -70.227604),
                new LatLng(-18.005740, -70.226182),
                new LatLng(-18.005087, -70.226708),
                new LatLng(-18.003348, -70.224879)

                );
        polygon = mapa.addPolygon(Campus);
        polygon.setFillColor(Color.YELLOW);

        mapa.addMarker(new MarkerOptions().position(new LatLng(-18.013421, -70.250047))
                .title("Admisión")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.markera)));
        PolygonOptions Admision = new PolygonOptions()
                .add(new LatLng(-18.013372, -70.250048),
                        new LatLng(-18.013429, -70.249986),
                        new LatLng(-18.013464, -70.250025),
                        new LatLng(-18.013408, -70.250095)

                );
        polygon = mapa.addPolygon(Admision);
        polygon.setFillColor(Color.MAGENTA);

        mapa.addMarker(new MarkerOptions().position(new LatLng(-18.009603, -70.242777))
                .title("Rectorado")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.markera)));
        PolygonOptions Rectorado = new PolygonOptions()
                .add(new LatLng(-18.009175, -70.242766),
                        new LatLng(-18.009501, -70.243147),
                        new LatLng(-18.009858, -70.242664),
                        new LatLng(-18.009481, -70.242321)

                );
        polygon = mapa.addPolygon(Rectorado);
        polygon.setFillColor(Color.GRAY);

    }
    @Override
    public void onInfoWindowClick(Marker marker) {

    }
    @Override public void onMapClick(LatLng puntoPulsado) {

    }

    public void postgrado(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.004905, -70.235160), 19));
    }

    public void campus(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.005705, -70.225211), 18));
    }

    public void admision(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.013421, -70.250047), 20));
    }

    public void vertodo(View view) {
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.007633, -70.239271), 14));

    }

    public void rectorado(View view) {
        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-18.009603, -70.250047), 20));

    }
}
