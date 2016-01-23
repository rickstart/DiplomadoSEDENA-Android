package com.mobintum.slideshowcities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Rick on 16/01/16.
 */
public class CityAdapter extends ArrayAdapter {

    LayoutInflater inflater;
    int resource;
    ArrayList<City> cities;

    public CityAdapter(Context context, int resource, ArrayList<City> cities) {
        super(context, resource, cities);
        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
        this.cities= cities;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  inflater.inflate(R.layout.item_city, parent,false);
        ImageView thumb = (ImageView) convertView.findViewById(R.id.thumb);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        City city = cities.get(position);
        thumb.setImageDrawable(city.getPhoto());
        txtTitle.setText(city.getName());

        return convertView;
    }
}
