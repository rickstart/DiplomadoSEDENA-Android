package com.mobintum.musicplayer;

import android.content.Context;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Created by Rick on 17/10/15.
 */
public class Song implements Serializable{
    private String title;
    private String artist;
    private String album;
    private String urlSong;
    private String time;
    private String albumImage;

    public Song(String title, String artist, String album, String urlSong, String time, String albumImage) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.urlSong = urlSong;
        this.time = time;
        this.albumImage = albumImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public static Song[] getSongs(){

        Song song1 = new Song("Get Lucky", "Daft Punk", "Get Lucky","song_getlucky","5:03","https://upload.wikimedia.org/wikipedia/en/7/71/Get_Lucky.jpg");
        Song song2 = new Song("Tachas y Perico", "Galatzia", "Unknow","song_tachas","5:03","https://i.ytimg.com/vi/GU_JcYi6TyY/maxresdefault.jpg");
        Song song3 = new Song("Love Me Again", "John Newman", "Unknow","john_newman_loveme_again","5:03","http://assets5.capitalfm.com/2013/50/john-newman-love-me-again-1387299002-view-0.jpg");
        Song[] arraySongs = {song1,song2,song3,song1,song2,song3,song1,song2,song3,song1,song2,song3,song1,song2,song3};
        return arraySongs;

    }



}
