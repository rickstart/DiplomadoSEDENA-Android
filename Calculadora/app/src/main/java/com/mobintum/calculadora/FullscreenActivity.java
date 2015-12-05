package com.mobintum.calculadora;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnZero,btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAC, btnPlusLess, btnPercent, btnDivision, btnMultiply, btnLess, btnPlus, btnEqual, btnDot ;
    private TextView textResult;
    private int oper1, oper2, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        btnAC = (Button) findViewById(R.id.btnAC);
        textResult = (TextView) findViewById(R.id.textResult);

        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnAC= (Button) findViewById(R.id.btnAC);
        btnPlusLess = (Button) findViewById(R.id.btnLessMore);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnLess = (Button) findViewById(R.id.btnLess);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDot = (Button) findViewById(R.id.btnDot);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnPlusLess.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnLess.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlus:


                break;
            default:
                Button btnTemp = (Button) v;
                if(oper1==0)
                    oper1 = Integer.parseInt(btnTemp.getText().toString());
                else {
                    result = oper1 + Integer.parseInt(btnTemp.getText().toString());
                    textResult.setText(Integer.toString(result));
                    oper1=0;
                }

                break;

        }


    }
}
