package com.mobintum.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlayerSongActivity extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer mPlayer;
    ImageButton btnPlay, btnForward, btnBackward;
    ImageView imgThumbDetail;
    TextView textDetailSong, textDetailArtist, textDetailAlbum, textDetailTime;
    ProgressBar progressBar;

    Song song;
    Song[] songs;
    Intent intent ;
    int position;
    int flag = 0;

    Thread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_song);
        intent= getIntent();
        //position = (intent.getExtras()!=null)? intent.getExtras().getInt("ID"): 0 ;
        if(intent.getExtras()!=null){
            position = intent.getExtras().getInt("position");
        }else{
            position= 0;
        }

        songs = Song.getSongs();

        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnBackward = (ImageButton) findViewById(R.id.btnBackward);
        btnForward = (ImageButton) findViewById(R.id.btnForward);

        imgThumbDetail = (ImageView) findViewById(R.id.imgThumbDetail);
        textDetailSong = (TextView) findViewById(R.id.textDetailSong);
        textDetailArtist = (TextView) findViewById(R.id.textDetailArtist);
        textDetailAlbum = (TextView) findViewById(R.id.textDetailAlbum);
        textDetailTime = (TextView) findViewById(R.id.textDetailTime);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        btnPlay.setOnClickListener(this);
        btnBackward.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        loadData();



    }





    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    public void loadData(){
        Song song = songs[position];

        //imgThumbDetail.setImageDrawable(song.getAlbumImage());
        Picasso.with(getApplicationContext()).load(song.getAlbumImage()).into(imgThumbDetail);
        textDetailSong.setText(song.getTitle());
        textDetailArtist.setText(song.getArtist());
        textDetailAlbum.setText(song.getAlbum());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnPlay:
                if(flag==0) {
                    btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.btn_pause));
                    flag = 1;
                }else {
                    btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.btn_play));
                    flag=0;
                }
                break;
            case R.id.btnBackward:
                if(position>0)
                    position--;
                loadData();
                break;
            case R.id.btnForward:
                if(position < songs.length -1)
                    position++;
                loadData();

                break;
        }
    }




}
