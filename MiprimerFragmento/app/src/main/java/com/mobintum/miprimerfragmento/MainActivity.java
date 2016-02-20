package com.mobintum.miprimerfragmento;

import android.location.Location;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JugadorFragment.CharlaJugadores {

    FragmentManager dt;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dt = getSupportFragmentManager();
        if(savedInstanceState == null) {
            FragmentTransaction ft = dt.beginTransaction();
            ft.add(R.id.portero1, JugadorFragment.newInstance(1, "Portero 1"));
            ft.add(R.id.delIzq1, JugadorFragment.newInstance(2, "Delantero Izq 1"));
            ft.add(R.id.delDer1, JugadorFragment.newInstance(3, "Delantero Der 1"));
            ft.add(R.id.delIzq2, JugadorFragment.newInstance(4, "Delantero Izq 2"));
            ft.add(R.id.delDer2, JugadorFragment.newInstance(5, "Delantero Der 2"));
            ft.add(R.id.portero2, JugadorFragment.newInstance(1, "Portero 2"));
            ft.commit();
        }else {
            for (Fragment fragment: dt.getFragments()) {
                FragmentTransaction ft = dt.beginTransaction();
                ft.replace(fragment.getId(), fragment);
                ft.commit();
            }

        }
    }

    private void quitarBalon(){
        List<Fragment> fragmentList = dt.getFragments();
        for(Fragment fragment : fragmentList){
            JugadorFragment jugadorFragment = (JugadorFragment) fragment;
            jugadorFragment.showBall(false);
        }
    }



    @Override
    public void pasarBalon(int id) {
        Log.e("TAG", "PASA " + dt.getFragments().size());
        this.id = id;
        JugadorFragment jugadorFragment = (JugadorFragment) dt.getFragments().get(id);
        quitarBalon();
        jugadorFragment.showBall(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("id",id);
    }
}
