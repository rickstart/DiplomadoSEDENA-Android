package com.mobintum.foursquaresedena.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobintum.foursquaresedena.R;
import com.mobintum.foursquaresedena.adapters.VenueRVAdapter;
import com.mobintum.foursquaresedena.models.Location;
import com.mobintum.foursquaresedena.models.Venue;

import java.io.Serializable;
import java.util.List;

public class RvVenuesFragment extends Fragment {

    public static final String TAG = "RvVenuesFragment";
    private static final String ARG_PARAM_LIST_VENUES = "paramVenues";
    private RecyclerView rvVenue;
    private List<Venue> venues;
    private VenueRVAdapter adapter;


    public RvVenuesFragment() {
        // Required empty public constructor
    }


    public static RvVenuesFragment newInstance(List<Venue> venues) {
        RvVenuesFragment fragment = new RvVenuesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_LIST_VENUES, (Serializable) venues);
        fragment.setArguments(args);
        return fragment;
    }

    public void loadVenues(List<Venue> venues){
        adapter = new VenueRVAdapter(venues,this);
        rvVenue.setAdapter(adapter);

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.venues = (List<Venue>) getArguments().getSerializable(ARG_PARAM_LIST_VENUES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rv_venues, container, false);
        rvVenue = (RecyclerView) view.findViewById(R.id.rvVenues);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvVenue.setLayoutManager(layoutManager);
        return view;
    }


}
