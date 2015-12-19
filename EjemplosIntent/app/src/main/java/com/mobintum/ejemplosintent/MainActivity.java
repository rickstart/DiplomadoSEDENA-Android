package com.mobintum.ejemplosintent;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnCall, btnEmail, btnShare, btnCamera, btnBrowser, btnActivity, btnTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = (ImageButton) findViewById(R.id.btnCall);
        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnShare = (ImageButton) findViewById(R.id.btnShare);
        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        btnBrowser = (ImageButton) findViewById(R.id.btnBrowser);
        btnActivity = (ImageButton) findViewById(R.id.btnActivity);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);

        btnCall.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnActivity.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(521) 5514382887"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "No tienes el permiso para llamar", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }

                break;

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

            case R.id.btnBrowser:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gaudena.com"));
                startActivity(intent);
                break;

            case R.id.btnCamera:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "No tienes el permiso capturar fotos", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }


                break;

            case R.id.btnShare:

                break;

            case R.id.btnActivity:
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);

                break;

            case R.id.btnTwitter:
                /*
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=rickstart"));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.twitter.android"));
                    try{
                        startActivity(intent);
                    }catch(ActivityNotFoundException k){
                        Toast.makeText(this, "No tienes market instalado", Toast.LENGTH_SHORT).show();
                    }

                }*/
                break;


        }

    }
}
