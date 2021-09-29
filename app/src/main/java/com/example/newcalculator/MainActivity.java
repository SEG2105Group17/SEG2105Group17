package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnEquals, btnClear, btnNeg, btnDot;

    TextView display;
    double val1, val2, answer;

    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnClear = findViewById(R.id.btnClear);
        btnEquals = findViewById(R.id.btnEquals);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnDot = findViewById(R.id.btnDot);
        btnNeg = findViewById(R.id.btnNeg);

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "9");
            }
        });

        //-----------------------------------------------------------------------
        //Neg and Dot
        btnNeg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + "-");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(display.getText() + ".");
            }
        });
        //------------------------------------------------------------------------
        //Operators
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                add = true;

                String str1 = display.getText().toString();
                val1 = Double.parseDouble(str1);

                display.setText(" ");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sub = true;

                String str1 = display.getText().toString();
                val1 = Double.parseDouble(str1);

                display.setText(" ");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mul = true;

                String str1 = display.getText().toString();
                val1 = Double.parseDouble(str1);

                display.setText(" ");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                div = true;

                String str1 = display.getText().toString();
                val1 = Double.parseDouble(str1);

                display.setText(" ");
            }
        });
        //--------------------------------------------------------------------------
        //clear and equals
        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText(" ");

                val1 = 0;
                val2 = 0;
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //save 2nd value
                String str2 = display.getText().toString();
                val2 = Double.parseDouble(str2);

                display.setText(" ");
                //add
                if(add == true){
                    answer = val1 + val2;
                }
                else if(sub == true){
                    answer = val1 - val2;
                }
                else if(mul == true){
                    answer = val1 * val2;
                }
                else{
                    answer = val1 / val2;
                }

                String strA = Double.toString(answer);
                display.setText(strA);

                //reset
                add = false;
                sub = false;
                mul = false;
                div = false;
            }
        });
    }
}