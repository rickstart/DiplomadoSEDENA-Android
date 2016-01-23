package com.mobintum.listviewprimerejemplo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Rick on 23/01/16.
 */
public class ArrayAdapterImage extends ArrayAdapter<Drawable> {
    private int resource;
    private LayoutInflater inflater;
    private Drawable[] objects;

    public ArrayAdapterImage(Context context, int resource, Drawable[] objects) {
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
            holder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            convertView.setTag(holder);
        }else{
            holder = (Viewholder) convertView.getTag();
        }

        holder.image1.setImageDrawable(objects[position]);

        return convertView;
    }

    class Viewholder {
        ImageView image1;
    }
}
