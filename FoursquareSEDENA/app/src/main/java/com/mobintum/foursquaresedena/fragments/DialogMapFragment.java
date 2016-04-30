package com.mobintum.foursquaresedena.fragments;


import android.Manifest;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

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
public class DialogMapFragment extends DialogFragment {
    public final static String TAG = "DialogMapFragment";
    private static final String ARG_PARAM_VENUE = "paramVenue";
    private Venue venue;


    public static DialogMapFragment newInstance(Venue venue){
        DialogMapFragment fragment = new DialogMapFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_VENUE,venue);
        fragment.setArguments(args);
        return fragment;
    }

    public DialogMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            this.venue = (Venue) getArguments().getSerializable(ARG_PARAM_VENUE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_map, container, false);



        SupportMapFragment fragment = new SupportMapFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.mapLoc, fragment, "APA").commit();
        getChildFragmentManager().executePendingTransactions();
        Fragment fragments = getChildFragmentManager().findFragmentById(R.id.mapLoc);
        if(fragments!=null)
            Log.e("DEBUG", "NOT NULL");
        else
            Log.e("DEBUG", "NULL");

        fragment = (SupportMapFragment) fragments;
        GoogleMap gMap = fragment.getMap();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            gMap.setMyLocationEnabled(true);
            Log.e(TAG, "ENABLE");
        }

        gMap.isMyLocationEnabled();

        LatLng latLng = new LatLng(venue.getLocation().getLat(),venue.getLocation().getLng());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 13);
        gMap.animateCamera(cameraUpdate);
        gMap.clear();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(venue.getName());
        gMap.addMarker(markerOptions);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

}
