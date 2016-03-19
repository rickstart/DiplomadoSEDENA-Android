package com.mobintum.foursquaresedena.fragments;


import android.Manifest;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobintum.foursquaresedena.R;
import com.mobintum.foursquaresedena.models.Location;
import com.mobintum.foursquaresedena.models.Venue;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {
    public static final String TAG = "MapFragment";
    private static final String ARG_PARAM_LIST_VENUES = "paramVenues";
    private List<Venue> venues;
    private GoogleMap gMap;
    private static final double LAT = 19.395244;
    private static final double LON = -99.152449;

    public static MapFragment newInstance(List<Venue> venues) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_LIST_VENUES, (Serializable) venues);
        fragment.setArguments(args);
        return fragment;
    }


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        gMap = map.getMap();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            gMap.setMyLocationEnabled(true);
            Log.e(TAG, "ENABLE");
        }

        gMap.isMyLocationEnabled();
        return view;
    }

    public void loadVenues(List<Venue> venues){
        LatLng latLng = new LatLng(LAT,LON);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 13);
        gMap.animateCamera(cameraUpdate);
        gMap.clear();
        for(Venue venue:venues){
            MarkerOptions markerOptions = new MarkerOptions();
            Location location = venue.getLocation();
            markerOptions.position(new LatLng(location.getLat(),location.getLng()));
            markerOptions.title(venue.getName());
            gMap.addMarker(markerOptions);
        }

    }

}
