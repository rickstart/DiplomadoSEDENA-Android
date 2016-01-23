package com.mobintum.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rick on 23/01/16.
 */
public class ArrayAdapterContact extends ArrayAdapter<Contact> {

    private int resource;
    private Contact[] objects;
    private LayoutInflater inflater;

    public ArrayAdapterContact(Context context, int resource, Contact[] objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.objects = objects;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    class Viewholder{
        ImageView photo;
        TextView txtName;
    }
}
