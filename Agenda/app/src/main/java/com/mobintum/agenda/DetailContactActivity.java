package com.mobintum.agenda;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        Intent intent;
        switch (v.getId()){
            case R.id.btnEmail:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ricrdo.celj@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Esta es una prueba de tema");
                intent.putExtra(Intent.EXTRA_TEXT, "Este mensaje fue generado desde Java");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ricardo.celj@gmail.com","mobilestudiotest@gmail.com"});

                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    e.printStackTrace();
                    Toast.makeText(this, "No tienes un email configurado", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(521) 5514382887"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "No tienes el permiso para llamar", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }

                break;
            case R.id.btnGithub:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com"));

                startActivity(intent);
                break;
        }
    }
}
