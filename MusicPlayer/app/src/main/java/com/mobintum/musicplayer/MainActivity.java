package com.mobintum.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listSongs;
    ListSongAdapter adapter;
    LinearLayout layoutPlayer;
    ImageButton btnPlay;
    Song song;
    MediaPlayer mPlayer;
    TextView txtSong;
    int flag = 0;
    public int positionG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Song[] songs = Song.getSongs();
        listSongs = (ListView) findViewById(R.id.listSongs);
        layoutPlayer = (LinearLayout) findViewById(R.id.layoutPlayer);
        txtSong = (TextView) findViewById(R.id.txtSong);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
        layoutPlayer.setOnClickListener(this);
        adapter = new ListSongAdapter(getApplicationContext(),R.layout.item_list_song,songs);

        listSongs.setAdapter(adapter);

        listSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionG = position;
                load();
                play();
            }
        });

        load();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                play();
                break;
            case R.id.layoutPlayer:
                mPlayer.pause();
                Intent intent = new Intent(getApplicationContext(), PlayerSongActivity.class);
                intent.putExtra("position", positionG);
                intent.putExtra("currentPosition", mPlayer.getCurrentPosition());
                startActivity(intent);
                break;
        }

    }
    private void load(){
        if(mPlayer!=null)stop();
        song = Song.getSongs()[positionG];
        mPlayer = MediaPlayer.create(this,getResources().getIdentifier("raw/"+song.getUrlSong(), "raw", this.getPackageName()));
        txtSong.setText(song.getTitle());
    }
    private void stop(){
        mPlayer.stop();
        flag = 0;
        btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.btn_pause));
    }

    private void play(){
        if(flag==0) {
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.btn_pause));
            flag = 1;
            mPlayer.start();

        }else {
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.btn_play));
            flag=0;
            mPlayer.pause();
        }

    }


}

