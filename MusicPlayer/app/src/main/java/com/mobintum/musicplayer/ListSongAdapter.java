package com.mobintum.musicplayer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobintum.musicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rick on 06/05/15.
 */
public class ListSongAdapter extends ArrayAdapter {

    private Song[] songs;
    private Context context;


    public ListSongAdapter(Context context, int resource,Song[] songs) {
        super(context, resource, songs);

        this.songs = songs;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_list_song, parent, false);

        ViewHolder holder = new ViewHolder();
        holder.textSong = (TextView) rowView.findViewById(R.id.textSong);
        holder.textArtist = (TextView) rowView.findViewById(R.id.textArtist);
        holder.imageThumbSong = (ImageView) rowView.findViewById(R.id.imgThumbSong);
        holder.textSong.setText(songs[position].getTitle());
        holder.textArtist.setText(songs[position].getArtist());
        Picasso.with(context).load(songs[position].getAlbumImage()).into(holder.imageThumbSong);



        return rowView;
    }


    class ViewHolder{
        TextView textSong;
        TextView textArtist;
        TextView textTime;
        ImageView imageThumbSong;
    }
}
