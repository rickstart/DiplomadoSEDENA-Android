package com.mobintum.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listSongs;
    ListSongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Song[] songs = Song.getSongs();
        listSongs = (ListView) findViewById(R.id.listSongs);
        adapter = new ListSongAdapter(getApplicationContext(),R.layout.item_list_song,songs);

        listSongs.setAdapter(adapter);

        listSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), PlayerSongActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
    }


}

