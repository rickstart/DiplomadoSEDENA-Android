package com.mobintum.crmlite.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobintum.crmlite.R;
import com.mobintum.crmlite.adapters.CustomerRVAdapter;
import com.mobintum.crmlite.models.Customer;


public class RVCustomersFragment extends Fragment {

    public static final String TAG = "RVCustomersFragment";
    private RecyclerView rvCustomers;
    private CustomerRVAdapter adapter;

    public RVCustomersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rvcustomers, container, false);
        rvCustomers = (RecyclerView) view.findViewById(R.id.rvCustomers);
        adapter = new CustomerRVAdapter(Customer.getCustomers(getContext()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvCustomers.setLayoutManager(llm);
        rvCustomers.setAdapter(adapter);
        return view;
    }

    public void refreshCustomers(){
        adapter = new CustomerRVAdapter(Customer.getCustomers(getContext()));
        rvCustomers.setAdapter(adapter);
    }

}
