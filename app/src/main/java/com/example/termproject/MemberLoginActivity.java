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
    Button mBTN, btnBack4;
    EditText usernameBox, passwordBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        memberTitle = (TextView) findViewById(R.id.adminTitle);
        memberUsername = (TextView) findViewById(R.id.adminUsername);
        memberPassword = (TextView) findViewById(R.id.adminPassword);

        mBTN = (Button) findViewById(R.id.adminLoginBTN);
        btnBack4 = (Button) findViewById(R.id.btnBack4);

        usernameBox = (EditText) findViewById(R.id.editUsernameA);
        passwordBox = (EditText) findViewById(R.id.editPasswordA);

    }

    public void newMember(View view){

        if(!usernameBox.getText().toString().trim().equals("") &&!passwordBox.getText().toString().trim().equals("")){
            MyDBHandler dbHandler = new MyDBHandler(this);
            User user = new User(usernameBox.getText().toString(), "Member");
            dbHandler.addUser(user);

            //start member enrol activity
            Intent intent = new Intent(this, MemberEnrolActivity.class);
            intent.putExtra("username", usernameBox.getText().toString().trim());
            startActivity(intent);
        }
        if(usernameBox.getText().toString().trim().equals("")){usernameBox.setHint("Please enter username");}
        if(passwordBox.getText().toString().trim().equals("")){passwordBox.setHint("Please enter password");}
    }



    private void back01(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}