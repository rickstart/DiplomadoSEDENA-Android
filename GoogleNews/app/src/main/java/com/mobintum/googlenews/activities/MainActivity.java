package com.mobintum.googlenews.activities;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobintum.googlenews.R;
import com.mobintum.googlenews.fragments.NewsFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new NewsFragment());
        ft.commit();
    }
}
