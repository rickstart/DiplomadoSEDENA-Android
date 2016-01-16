package com.mobintum.slideshowcities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnBack, btnNext;
    ImageView photo;
    ArrayList<City> cities = new ArrayList<>();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        photo = (ImageView) findViewById(R.id.photo);

        City huatulco = new City("Huatulco","1000000","Oaxaca Beach", getResources().getDrawable(R.drawable.ic_back));
        cities.add(huatulco);

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
        }

    }
}
