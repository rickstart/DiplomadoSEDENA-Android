package com.mobintum.googlenews.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.mobintum.googlenews.R;
import com.mobintum.googlenews.application.App;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    public static final String  API_NEWS_URL="https://ajax.googleapis.com/ajax/services/search/news";

    public NewsFragment() {
        // Required empty public constructor
    }

    public void getGoogleNewsRequest(){
        String builURL = Uri.parse(API_NEWS_URL).buildUpon()
                .appendQueryParameter("v", "1.0")
                .appendQueryParameter("rsz", "1")
                .appendQueryParameter("q","NASA").build().toString();
        Log.e("DEBUG", builURL);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, builURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("DEBUG RESPONSE", response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("DEBUG ERROR", error.toString());

                    }
                });
        App.getInstance().getRequestQueue().add(stringRequest);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        getGoogleNewsRequest();

        return view;
    }

}
