package com.mobintum.slideshowcities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ArrayList<City> cities = new ArrayList<>();
    int index;
    ImageView photo;
    TextView txtTitle, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(getIntent().getExtras()!=null){
            this.index = getIntent().getExtras().getInt("index");

        }

        photo = (ImageView) findViewById(R.id.photo);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
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
        loadData();
    }

    private void loadData(){
        City city = cities.get(index);
        photo.setImageDrawable(city.getPhoto());
        txtTitle.setText(city.getName());
        txtDescription.setText(city.getDescription());
    }
}
