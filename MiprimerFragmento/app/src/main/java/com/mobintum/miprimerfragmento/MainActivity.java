package com.mobintum.miprimerfragmento;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dt = getSupportFragmentManager();
        FragmentTransaction ft = dt.beginTransaction();
        ft.add(R.id.cancha, JugadorFragment.newInstance(2,"Portero"));
        ft.commit();

    }
}
