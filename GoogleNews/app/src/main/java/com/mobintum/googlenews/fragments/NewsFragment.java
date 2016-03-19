package com.mobintum.googlenews.fragments;


import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobintum.googlenews.R;
import com.mobintum.googlenews.adapters.NewsAdapter;
import com.mobintum.googlenews.application.App;
import com.mobintum.googlenews.models.GoogleNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    public static final String  API_NEWS_URL="https://ajax.googleapis.com/ajax/services/search/news";
    private RecyclerView rvNews;
    private NewsAdapter adapter;
    private List<GoogleNews> objects;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search,menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getActivity().getComponentName());
        searchView.setSearchableInfo(searchableInfo);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getGoogleNewsRequest(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void getGoogleNewsRequest(String query){
        String builURL = Uri.parse(API_NEWS_URL).buildUpon()
                .appendQueryParameter("v", "1.0")
                .appendQueryParameter("rsz", "8")
                .appendQueryParameter("q", query).build().toString();
        Log.e("DEBUG", builURL);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, builURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("DEBUG RESPONSE", response);
                        try {
                            JSONObject jResponse = new JSONObject(response);
                            JSONObject jResponseData = jResponse.getJSONObject("responseData");
                            Type listType = new TypeToken<List<GoogleNews>>(){}.getType();
                            Gson gson = new Gson();
                            List<GoogleNews> googleNews = gson.fromJson(jResponseData.get("results").toString(),listType);
                            objects = googleNews;
                            adapter = new NewsAdapter(objects,getContext());
                            rvNews.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
        rvNews = (RecyclerView) view.findViewById(R.id.rvNews);
        objects = new ArrayList<>();
        adapter = new NewsAdapter(objects,getContext());
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(adapter);
        return view;
    }

}
