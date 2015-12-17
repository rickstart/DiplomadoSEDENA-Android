package com.mobintum.chicasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgChica;
    private Button btnNext;
    private Button btnBack;
    private TextView textName;
    private List<Chica> chicas = new ArrayList<Chica>();
    private int posicion=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgChica = (ImageView) findViewById(R.id.imgChica);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnBack = (Button) findViewById(R.id.btnBack);
        textName = (TextView) findViewById(R.id.textName);

        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        Chica chica1 = new Chica("Jenniffer Lawrence", getResources().getDrawable(R.drawable.img_jennifer_lawrence));
        Chica chica2 = new Chica("Emma Watson", getResources().getDrawable(R.drawable.img_emma_watson));
        Chica chica3 = new Chica("Alexis Texas", getResources().getDrawable(R.drawable.img_alexis_texas));
        chicas.add(chica1);
        chicas.add(chica2);
        chicas.add(chica3);
        loadChica(chicas.get(posicion));

    }

    public void loadChica(Chica chica){
        imgChica.setImageDrawable(chica.getImagen());
        textName.setText(chica.getName());
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btnBack:
               if(posicion>0){
                   posicion--;
                   loadChica(chicas.get(posicion));
               }


               break;

           case R.id.btnNext:
               if(posicion<chicas.size()-1){
                   posicion++;
                   loadChica(chicas.get(posicion));

               }


               break;
       }
    }
}
