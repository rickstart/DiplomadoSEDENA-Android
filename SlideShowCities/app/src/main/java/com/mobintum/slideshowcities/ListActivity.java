package com.mobintum.slideshowcities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<City> cities = new ArrayList<>();
    ListView listCities;
    CityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        City huatulco = new City("Huatulco","1000000","Oaxaca Beach", getResources().getDrawable(R.drawable.huatulco));
        City acapulco = new City("Acapulco","1000000","Acapulco Beach", getResources().getDrawable(R.drawable.acapulco));
        City holbox = new City("Holbox","1000000","Holbox Beach", getResources().getDrawable(R.drawable.holbox));
        City cabos = new City("Los Cabos","1000000","Los Cabos Beach", getResources().getDrawable(R.drawable.los_cabos));
        City tulum = new City("Tulum","1000000","Tulum Beach", getResources().getDrawable(R.drawable.tulum));
        cities.add(huatulco);
        cities.add(acapulco);
        cities.add(holbox);
        cities.add(cabos);
        cities.add(tulum);
        cities.add(huatulco);
        cities.add(acapulco);
        cities.add(holbox);
        cities.add(cabos);
        cities.add(tulum);
        cities.add(huatulco);
        cities.add(acapulco);
        cities.add(holbox);
        cities.add(cabos);
        cities.add(tulum);
        cities.add(huatulco);
        cities.add(acapulco);
        cities.add(holbox);
        cities.add(cabos);
        cities.add(tulum);
        cities.add(huatulco);
        cities.add(acapulco);
        cities.add(holbox);
        cities.add(cabos);
        cities.add(tulum);
        adapter = new CityAdapter(getApplicationContext(),R.layout.item_city, cities);
        listCities = (ListView) findViewById(R.id.listCities);
        listCities.setAdapter(adapter);


    }
}
