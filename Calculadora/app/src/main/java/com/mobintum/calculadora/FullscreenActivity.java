package com.mobintum.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullscreenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnZero,btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAC, btnPlusLess, btnPercent, btnDivision, btnMultiply, btnLess, btnPlus, btnEqual, btnDot ;
    private TextView textResult;
    private Double oper1=0.0, oper2, result;
    private Boolean flagOper = false;
    private final static int SUM=1;
    private final static int MULTIPLY=2;
    private final static int DIVISION=3;
    private final static int SUBSTRACTION=4;
    private final static int PERCENT=5;
    private int typeOper;
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

    public String formatResult(Double result){
        String strResult = Double.toString(result);
        String number[] = strResult.split("\\.");
        if(Integer.parseInt(number[1])==0){
            return number[0];
        }else{
            return strResult;
        }
    }

    public Double operation(int typeOper, double oper1, double oper2){
        Double result = 0.0;
        switch (typeOper){
            case SUM:
                result = oper1 + oper2;
                break;
            case SUBSTRACTION:
                result = oper1 - oper2;
                break;
            case MULTIPLY:
                result = oper1 * oper2;
                break;
            case DIVISION:
                result = oper1 / oper2;
                break;
        }
        return result;
    }

    public void setOper(){
        Double number = Double.parseDouble(textResult.getText().toString());
        if(number!=0.0 && oper1==0.0){
            oper1 = number;
        }else if(oper1!=0.0 && flagOper){
            oper1 = operation(typeOper, oper1, number);
            textResult.setText(formatResult(oper1));
        }
        flagOper = false;
    }
    @Override
    public void onClick(View v) {
        Double number = 0.0;

        switch (v.getId()) {

            case R.id.btnLess:
                setOper();
                typeOper = SUBSTRACTION;
                break;

            case R.id.btnPlus:
                setOper();
                typeOper = SUM;
                break;
            case R.id.btnDivision:
                setOper();
                typeOper = DIVISION;
                break;
            case R.id.btnMultiply:
                setOper();
                typeOper = MULTIPLY;
                break;
            case R.id.btnAC:
                textResult.setText("0");
                oper1 = 0.0;
                flagOper = false;
                break;
            case R.id.btnEqual:
                if(oper1!=0.0 && flagOper){
                    number = Double.parseDouble(textResult.getText().toString());
                    oper1 = operation(typeOper, oper1, number);
                    textResult.setText(formatResult(oper1));
                    flagOper = false;
                }

                break;
            default:
                Button btnTemp = (Button) v;
                String text = btnTemp.getText().toString();
                number = Double.parseDouble(textResult.getText().toString());
                if(number!=0.0 && flagOper) {
                    textResult.append(text);
                }else{
                    textResult.setText(text);
                    flagOper = true;
                }
                break;

        }

    }
}
