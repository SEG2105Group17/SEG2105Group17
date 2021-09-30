package com.example.lab1;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnEqual,btnAdd,
            btnSub, btnMul, btnDiv, btnClear, btnDec;
    TextView display;
    double val1, val2;
    boolean add, sub, mul, div, reset, Eq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnClear=findViewById(R.id.btnClear);
        btnEqual=findViewById(R.id.btnEqual);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnDiv=findViewById(R.id.btnDiv);
        btnDec=findViewById(R.id.btnDec);
        btnMul=findViewById(R.id.btnMul);

        display=findViewById(R.id.display);

        val1=0.0;
        val2=0.0;
        display.setText(""); // equals pressed first== no crash

        //0-9 and decimal display
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Eq==true){
                    btnClear.performClick();
                }
                display.setText(display.getText() + "9");
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                char dec = '.';

                for (int i = 0; i < display.getText().length(); i++){
                    if(display.getText().charAt(i) == dec){

                        
                        return;
                    }
                }


                if(display.getText()==""){
                    display.setText("0.");
                }
                else if (Eq==true){
                    btnClear.performClick();
                    display.setText("0.");
                }
                else{
                    display.setText(display.getText() + ".");
                }

            }
        });

        //operations

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                display.setText("");
                val2=0.0;
                val1=0.0;
                reset=false;
                Eq=false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculate();
                add=true;

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (display.getText()==""){
                    display.setText("-");
                }
                else if(display.getText()=="-"){
                    return;
                }
                else{
                    calculate();
                    sub=true;

                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculate();
                mul=true;

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculate();
                div=true;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                calculate();
                if (val1%1==0){
                    display.setText(Integer.toString((int)val1));
                }
                else{
                    display.setText(Double.toString(val1));
                }
                Eq=true;
            }
        });
    }

    private void calculate(){
        Eq=false;
        if (!reset && display.getText()!=""){ //no initial value (first +-/* sign)

            try {
                val1= Double.parseDouble(display.getText().toString()); //new second value
                display.setText("");
            }
            catch(NumberFormatException e) {
                val1= Double.NaN;
                display.setText("NaN");
            }
            reset=true;
        }

        else if (reset && display.getText()!=""){
            try {
                val2= Double.parseDouble(display.getText().toString()); //new second value
                display.setText("");
            }
            catch(NumberFormatException e) {
                val2= Double.NaN;
                display.setText("NaN");
            }

            if (add){         //do calculation
                val1+=val2;
                add =false;
            }
            else if (sub){
                val1-=val2;
                sub=false;
            }
            else if (mul){
                val1*=val2;
                mul=false;
            }
            else if (div){
                val1/=val2;
                div=false;
            }
            val2=0.0;
        }
    }


}