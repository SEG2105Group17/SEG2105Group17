package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminLoginActivity extends AppCompatActivity {

    TextView adminTitle, adminPassword, adminUsername;
    Button aBTN;
    EditText usernameBox, passwordBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminTitle = (TextView) findViewById(R.id.adminTitle);
        adminUsername = (TextView) findViewById(R.id.adminUsername);
        adminPassword = (TextView) findViewById(R.id.adminPassword);

        aBTN = (Button) findViewById(R.id.adminLoginBTN);

        usernameBox = (EditText) findViewById(R.id.editUsernameA);
        passwordBox = (EditText) findViewById(R.id.editPasswordA);
    }



    //set onClick for button
    //do not add to database...only move on to next activity
    //*and check for correct password
    public void adminLogin(View view){
        Intent intent = new Intent(this, AdminSelectActivity.class);
        startActivity(intent);
        /*
        String user = usernameBox.getText().toString();
        String pass = passwordBox.getText().toString();
        boolean validU = false;
        boolean validP = false;

        //check for credentials
        if(user == "admin"){
            validU = true;
        }
        if(pass == "admin123"){
            validP = true;
        }


        if(validU == true){
            if(validP == true){
                //move to next activity
                Intent intent = new Intent(this, DatabaseActivity.class);
                startActivity(intent);

            }else{
                passwordBox.setText("Incorrect Password");
            }
        }else{
            usernameBox.setText("Incorrect Username");
        }
        */

    }
}