package com.mobintum.noticiero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rick on 27/02/16.
 */
public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    private List<Noticia> noticias;
    private int resource;
    private Context context;
    private LayoutInflater inflater;
    private static final String URL = "http://www.nytimes.com/";

    public NoticiaAdapter(Context context, int resource, List<Noticia> noticias) {
        super(context, resource, noticias);
        this.context = context;
        this.resource = resource;
        this.noticias = noticias;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(resource,parent,false);
            holder = new ViewHolder();
            holder.imgNoticia = (ImageView) convertView.findViewById(R.id.imgNoticia);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            holder.txtDescription = (TextView) convertView.findViewById(R.id.txtDescription);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Noticia noticia = noticias.get(position);
        holder.txtDescription.setText(noticia.getDescripcion());
        holder.txtTitle.setText(noticia.getTitulo());
        Picasso.with(context).load(URL+noticia.getUrlImagen()).into(holder.imgNoticia);

        return convertView;
    }

    class ViewHolder{
        TextView txtTitle;
        TextView txtDescription;
        ImageView imgNoticia;
    }
}
