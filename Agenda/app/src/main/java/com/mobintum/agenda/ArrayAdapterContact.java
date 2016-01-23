package com.mobintum.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * Created by Rick on 23/01/16.
 */
public class ArrayAdapterContact extends ArrayAdapter<Contact> {

    private int resource;
    private Contact[] objects;
    private LayoutInflater inflater;
    private Context context;

    public ArrayAdapterContact(Context context, int resource, Contact[] objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.objects = objects;
        this.inflater = LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;
        if(convertView == null){
            convertView = inflater.inflate(resource,parent, false);
            holder = new Viewholder();
            holder.photo = (ImageView) convertView.findViewById(R.id.photo);
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            convertView.setTag(holder);
        }else{
            holder = (Viewholder) convertView.getTag();
        }

        Picasso.with(context).load(objects[position].getPhoto()).into(holder.photo);
        holder.txtName.setText(objects[position].getName());


        return convertView;
    }

    class Viewholder{
        ImageView photo;
        TextView txtName;
    }
}
