package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorSelectActivity extends AppCompatActivity {

    TextView txtView;
    Button btnAll, btnPersonal, btnBack6;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_select);

        txtView = findViewById(R.id.txtView);
        btnAll = findViewById(R.id.btnAll);
        btnPersonal = findViewById(R.id.btnPersonal);
        btnBack6 = findViewById(R.id.btnBack6);

        username = getIntent().getExtras().getString("username");

        txtView.setText("Welcome "+ username +"! You are logged in as Instructor.");

        btnAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openClassSearch();
            }
        });
        btnPersonal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPersonal();
            }
        });
        btnBack6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                back6();
            }
        });

    }
    public void openPersonal(){
        Intent intent= new Intent(this, InstructorPersonalCoursesActivity.class);
            intent.putExtra("username", username);
        startActivity(intent);
    }
    public void openClassSearch(){
        Intent intent= new Intent(this, InstructorSearchActivity.class);
            intent.putExtra("username", username);
        startActivity(intent);
    }
    public void back6(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}