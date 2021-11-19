package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databases.MyDBHandler;

public class InstructorLoginActivity extends AppCompatActivity {

    TextView instructorTitle, instructorPassword, instructorUsername;
    Button iBTN;
    EditText usernameBox, passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_login);

        instructorTitle = (TextView) findViewById(R.id.adminTitle);
        instructorUsername = (TextView) findViewById(R.id.adminUsername);
        instructorPassword = (TextView) findViewById(R.id.adminPassword);

        iBTN = (Button) findViewById(R.id.adminLoginBTN);

        usernameBox = (EditText) findViewById(R.id.editUsernameA);
        passwordBox = (EditText) findViewById(R.id.editPasswordA);
    }

    public void newInstructor(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);
        User user = new User(usernameBox.getText().toString(), "Instructor");
        dbHandler.addUser(user);
        usernameBox.setText("");
        passwordBox.setText("");
    }
}