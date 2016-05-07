package com.mobintum.crmlite.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mobintum.crmlite.R;
import com.mobintum.crmlite.database.AndroidDatabaseManager;
import com.mobintum.crmlite.dialogs.AddCustomerDialog;
import com.mobintum.crmlite.fragments.RVCustomersFragment;
import com.mobintum.crmlite.models.Customer;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCustomerDialog dialog = new AddCustomerDialog();
                dialog.show(fm,AddCustomerDialog.TAG);

            }
        });
        fm.beginTransaction().replace(R.id.content, new RVCustomersFragment(), RVCustomersFragment.TAG).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, AndroidDatabaseManager.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
