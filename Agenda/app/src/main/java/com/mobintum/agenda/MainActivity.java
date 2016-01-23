package com.mobintum.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listContacts = (ListView) findViewById(R.id.listContacts);
        ArrayAdapterContact adapter = new ArrayAdapterContact(getApplicationContext(), R.layout.item_contact, Contact.getContacts());
        listContacts.setAdapter(adapter);
    }
}
