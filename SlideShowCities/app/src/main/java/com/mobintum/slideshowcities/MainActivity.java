package com.mobintum.slideshowcities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnBack, btnNext;
    Button btnGo;
    ImageView photo;
    ArrayList<City> cities = new ArrayList<>();
    int index = 0;
    float a = 1.69f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        photo = (ImageView) findViewById(R.id.photo);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnBack:
                if(index>0){
                    index--;
                    loadData();
                }
                break;
            case R.id.btnNext:
                if(index < cities.size()-1){
                    index++;
                    loadData();
                }
                break;
            case R.id.btnGo:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
                break;
        }

    }
}
