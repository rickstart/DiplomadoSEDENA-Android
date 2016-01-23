package com.mobintum.listviewprimerejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by Rick on 23/01/16.
 */
public class ArrayAdapterCustom extends ArrayAdapter<String> {

    private int resource;
    private String[] objects;
    private LayoutInflater inflater;

    public ArrayAdapterCustom(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.objects = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;
        if(convertView == null){
            convertView = inflater.inflate(resource,parent,false);
            holder = new Viewholder();
            holder.text1 = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }

        holder.text1.setText(objects[position]);


        return convertView;
    }


    class Viewholder{
        TextView text1;
    }
}
