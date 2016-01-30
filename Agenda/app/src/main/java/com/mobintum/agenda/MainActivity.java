package com.mobintum.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Contact[] contacts = Contact.getContacts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listContacts = (ListView) findViewById(R.id.listContacts);
        ArrayAdapterContact adapter = new ArrayAdapterContact(getApplicationContext(), R.layout.item_contact, contacts);
        listContacts.setAdapter(adapter);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailContactActivity.class);
                Contact contact = contacts[position];
                intent.putExtra("contact",(Serializable) contact);
                startActivity(intent);

            }
        });
    }
}
