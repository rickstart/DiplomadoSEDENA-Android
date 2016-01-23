package com.mobintum.listviewprimerejemplo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] nombres = {"Sesai", "Liho", "Ivan", "Fernando", "Ricardo" };
        Resources r = getResources();
        Drawable[] imagenes = {r.getDrawable(R.drawable.img_eagle), r.getDrawable(R.drawable.img_elephant),r.getDrawable(R.drawable.img_gorila), r.getDrawable(R.drawable.img_jaguar), r.getDrawable(R.drawable.img_lion)};
        ArrayAdapterCustom adapter = new ArrayAdapterCustom (getApplicationContext(), R.layout.simple_list_item_text, nombres );
        ArrayAdapterImage iAdapter = new ArrayAdapterImage(getApplicationContext(),R.layout.simple_list_item_image, imagenes);

        ListView listNombres = (ListView) findViewById(R.id.listNombres);
        //listNombres.setAdapter(adapter);
        listNombres.setAdapter(iAdapter);
    }
}
