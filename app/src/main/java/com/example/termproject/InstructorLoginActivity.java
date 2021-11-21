package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.databases.MyDBHandler;

public class InstructorLoginActivity extends AppCompatActivity {

    TextView instructorTitle, instructorPassword, instructorUsername;
    Button iBTN, btnBack3;
    EditText usernameBox, passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_login);

        instructorTitle = (TextView) findViewById(R.id.adminTitle);
        instructorUsername = (TextView) findViewById(R.id.adminUsername);
        instructorPassword = (TextView) findViewById(R.id.adminPassword);

        iBTN = (Button) findViewById(R.id.adminLoginBTN);
        btnBack3 = (Button) findViewById(R.id.btnBack3);

        usernameBox = (EditText) findViewById(R.id.editUsernameA);
        passwordBox = (EditText) findViewById(R.id.editPasswordA);

        btnBack3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                back3();
            }
        });
        iBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ adminLogin(); }
        });
    }
    private void back3(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void adminLogin() {
        Intent intent = new Intent(this, InstructorSelectActivity.class);
            intent.putExtra("username", usernameBox.getText().toString().trim());
        startActivity(intent);
    }

    public void newInstructor(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);
        User user = new User(usernameBox.getText().toString(), "Instructor");
        dbHandler.addUser(user);
        usernameBox.setText("");
        passwordBox.setText("");
    }

}