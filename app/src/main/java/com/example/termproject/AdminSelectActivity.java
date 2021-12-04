package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminSelectActivity extends AppCompatActivity {
    TextView textView;
    Button btnUserDB, btnCourseDB, btnBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_select);

        textView = findViewById(R.id.textView);
        btnUserDB = findViewById(R.id.btnUserDB);
        btnCourseDB = findViewById(R.id.btnCourseDB);
        btnBack1 = findViewById(R.id.btnBack1);

        textView.setText("Welcome! You are logged in as Admin.");

        btnCourseDB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openCoursePage();
            }
        });
        btnUserDB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openUserPage();
            }
        });
        btnBack1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                back1();
            }
        });

    }
    public void openUserPage(){
        Intent intent= new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }
    public void openCoursePage(){
        Intent intent= new Intent(this, CourseDBActivity.class);
        startActivity(intent);
    }
    public void back1(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}