package com.example.fall2021profejct1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        memberTitleTextView.setText("Welcome "+ str + " You are logged in as member!");
    }
}