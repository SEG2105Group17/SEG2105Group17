package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }
    //add numbers to display
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }
    //when zero is pressed
    public void zerobtn(View view){
        updateText("0");
    }
    public void onebtn(View view){
        updateText("1");
    }
    public void towbtn(View view){
        updateText("2");
    }
    public void threebtn(View view){
        updateText("3");
    }
    public void fourbtn(View view){
        updateText("4");
    }
    public void fivebtn(View view){
        updateText("5");
    }
    public void sixbtn(View view){
        updateText("6");
    }
    public void sevenbtn(View view){
        updateText("7");
    }
    public void eightbtn(View view){
        updateText("8");
    }
    public void ninebtn(View view){
        updateText("9");
    }

    public void clearbtn(View view){
        updateText("");
    }
    public void equalbtn(View view){

    }
    public void addbtn(View view){
        updateText("+");
    }
    public void subtractbtn(View view){
        updateText("-");
    }
    public void multiplybtn(View view){
        updateText("x");
    }
    public void dividebtn(View view){
        updateText("/");
    }
    public void plusminusbtn(View view){
        updateText("-");
    }
    public void pointbtn(View view){
        updateText(".");
    }


}
