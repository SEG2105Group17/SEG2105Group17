package com.example.lab1seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button mod;
    private Button dec;
    private Button sin;
    private Button cos;
    private Button tan;
    private Button pi;
    private Button exp;
    private Button sqrt;
    private Button e;
    private Button clr;
    private Button del;
    private Button eq;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setupButtons(){
        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        zero = (Button)findViewById(R.id.button0);
        add = (Button)findViewById(R.id.buttonA);
        sub = (Button)findViewById(R.id.buttonS);
        mul = (Button)findViewById(R.id.buttonMu);
        div = (Button)findViewById(R.id.buttonD);
        mod = (Button)findViewById(R.id.buttonMod);
        eq = (Button)findViewById(R.id.buttonEq);
        clr = (Button)findViewById(R.id.buttonClr);
        del = (Button)findViewById(R.id.buttonDel);
        dec = (Button)findViewById(R.id.buttonDec);
        sin = (Button)findViewById(R.id.buttonSin);
        cos = (Button)findViewById(R.id.buttonCos);
        tan = (Button)findViewById(R.id.buttonTan);
        pi = (Button)findViewById(R.id.buttonPie);
        exp = (Button)findViewById(R.id.buttonPow);
        e = (Button)findViewById(R.id.buttonE);
        sqrt = (Button)findViewById(R.id.buttonSqrt);
    }
}