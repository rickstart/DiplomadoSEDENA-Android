package com.mobintum.noticiero;

/**
 * Created by Rick on 27/02/16.
 */

import java.util.List;
import java.util.ArrayList;
public class Noticia {
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private String url;

    public Noticia(String titulo, String descripcion, String urlImagen, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<Noticia> getData(){
        List<Noticia> noticias = new ArrayList<>();

        for (int i=0;i<1000;i++)
            noticias.add(new Noticia("Australia in Position to Stay Atop Rankings","Having reclaimed the no. 1 spot in test cricket, the bigger test for Australia will be staying there.","images/2016/02/27/sports/27cricket-web1/27cricket-web1-thumbWide.jpg","http://www.nytimes.com/2016/02/27/sports/cricket/australia-in-position-to-stay-atop-rankings.html"));

        return noticias;
    }

}
