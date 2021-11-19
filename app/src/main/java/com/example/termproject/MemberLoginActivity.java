package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databases.MyDBHandler;

public class MemberLoginActivity extends AppCompatActivity {


    TextView memberTitle, memberPassword, memberUsername;
    Button mBTN;
    EditText usernameBox, passwordBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        memberTitle = (TextView) findViewById(R.id.adminTitle);
        memberUsername = (TextView) findViewById(R.id.adminUsername);
        memberPassword = (TextView) findViewById(R.id.adminPassword);

        mBTN = (Button) findViewById(R.id.adminLoginBTN);

        usernameBox = (EditText) findViewById(R.id.editUsernameA);
        passwordBox = (EditText) findViewById(R.id.editPasswordA);

    }

    public void newMember(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);
        User user = new User(usernameBox.getText().toString(), "Member");
        dbHandler.addUser(user);
        usernameBox.setText("");
        passwordBox.setText("");

    }
}