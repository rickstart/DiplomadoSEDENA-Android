package com.mobintum.miprimerfragmento;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class MainActivity extends AppCompatActivity implements JugadorFragment.CharlaJugadores {

    FragmentManager dt;
    ImageView imgGol;
    TextView scoreRight, scoreLeft;
    int sLeft, sRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getResources().getBoolean(R.bool.landscape_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        this.dt = getSupportFragmentManager();
        imgGol = (ImageView) findViewById(R.id.imgGol);
        scoreRight = (TextView) findViewById(R.id.scoreRight);
        scoreLeft = (TextView) findViewById(R.id.scoreLeft);

        if(savedInstanceState == null) {

            FragmentTransaction ft = dt.beginTransaction();
            ft.add(R.id.portero1, JugadorFragment.newInstance(1, "Portero 1"));
            ft.add(R.id.delIzq1, JugadorFragment.newInstance(2, "Delantero Izq 1") );
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
        JugadorFragment jugadorFragment = (JugadorFragment) dt.getFragments().get(id);
        quitarBalon();
        jugadorFragment.showBall(true);
        if(id==0) {
            sRight++;
            scoreRight.setText(""+sRight);

        }
        if(id==5) {
            sLeft++;
            scoreLeft.setText(""+sLeft);

        }

        if(sLeft == 5 || sRight == 5){
            sLeft=0;
            sRight=0;
            scoreLeft.setText(""+sLeft);
            scoreRight.setText(""+sRight);
        }

    }

    @Override
    public void goal(boolean gol) {
        if(gol) {
            imgGol.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    imgGol.setVisibility(View.GONE);
                }
            }, 1000);
        }


    }


}
