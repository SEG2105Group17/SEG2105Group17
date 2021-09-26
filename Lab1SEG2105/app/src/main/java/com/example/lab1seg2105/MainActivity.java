package com.example.lab1seg2105;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    private TextView prob;
    private TextView sol;

    private final char ADD = '+';
    private final char SUB = '-';
    private final char DIV = '/';
    private final char MUL = '*';
    private final char MOD = '%';
    private char OPERATION;

    private double num = Double.NaN;
    private double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
        setupText();



        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "9");
            }
        });


        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "0");
            }
        });

        dec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + ".");
            }
        });

        clr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText("");
            }
        });

        pi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "π");
            }
        });

        e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "e");
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "√");
            }
        });

        sin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "sin");
            }
        });

        cos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "cos");
            }
        });

        tan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                prob.setText(prob.getText().toString() + "tan");
            }
        });






    }

    private void setupButtons(){
        // BUttons
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

    private void setupText(){
        //Text view
        prob = (TextView)findViewById(R.id.textViewProb);
        sol = (TextView)findViewById(R.id.textViewSol);
    }

    private void calc(){
        if (!Double.isNaN(num)){
            num2 = Double.parseDouble(prob.getText().toString());

            switch(OPERATION){
                case ADD:
                    num += num2;
                    break;
                case SUB:
                    num -= num2;
                    break;
                case DIV:
                    num /= num2;
                    break;
                case MUL:
                    num *= num2;
                    break;
                case MOD:
                    num %= num2;
                    break;
            }
        } else {
            num = Double.parseDouble(prob.getText().toString());
        }
    }

}