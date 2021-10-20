package com.example.fall2021profejct1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MemberLoginPage extends AppCompatActivity {

    //Attributes
    TextView memberTitleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberlogin_activity);

        memberTitleTextView = findViewById(R.id.memberTitleTextView);
    }
}