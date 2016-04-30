package com.mobintum.foursquaresedena.activities;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mobintum.foursquaresedena.R;
import com.mobintum.foursquaresedena.application.App;
import com.mobintum.foursquaresedena.fragments.MapFragment;
import com.mobintum.foursquaresedena.fragments.RvVenuesFragment;
import com.mobintum.foursquaresedena.models.Venue;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<String>{

    public static final String URL_FOURSQUARE = "https://api.foursquare.com/v2/venues/search?";
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content, new RvVenuesFragment(), RvVenuesFragment.TAG).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(searchableInfo);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getVenues(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    public void getVenues(String query){
        String builURL = Uri.parse(URL_FOURSQUARE).buildUpon()
                .appendQueryParameter("client_id", getString(R.string.four_client_id))
                .appendQueryParameter("client_secret", getString(R.string.four_client_secret))
                .appendQueryParameter("v", "20130815")
                .appendQueryParameter("ll","19.395244, -99.152449" )
                .appendQueryParameter("query", query).build().toString();

        Log.e("DEBUG", builURL);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,builURL,this,this);
        App.getInstance().getRequestQueue().add(stringRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                break;
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        Log.e("DEBUG RESPONSE", response);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Venue>>(){}.getType();
            List<Venue> venues =  gson.fromJson(jsonObject.getJSONObject("response").get("venues").toString(), listType);
            MapFragment mapFragment = (MapFragment) fm.findFragmentByTag(MapFragment.TAG);
            RvVenuesFragment rvVenuesFragment = (RvVenuesFragment) fm.findFragmentByTag(RvVenuesFragment.TAG);
            if(mapFragment!=null)
                mapFragment.loadVenues(venues);
            else
                rvVenuesFragment.loadVenues(venues);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
