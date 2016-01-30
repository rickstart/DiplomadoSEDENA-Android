package com.mobintum.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailContactActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView photo;
    private TextView txtName, txtEmail, txtPhone, txtGithub;
    private ImageButton btnEmail, btnPhone, btnGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        photo = (ImageView) findViewById(R.id.photo);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtGithub = (TextView) findViewById(R.id.txtGithub);

        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnPhone = (ImageButton) findViewById(R.id.btnPhone);
        btnGithub = (ImageButton) findViewById(R.id.btnGithub);

        btnEmail.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnGithub.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEmail:
                break;
            case R.id.btnPhone:
                break;
            case R.id.btnGithub:
                break;
        }
    }
}
