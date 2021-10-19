package com.example.fall2021profejct1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdminLogIn.AdminLogInListener, UserLogin.UserLoginListener {

    Button Administrator, Member, Instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Administrator = findViewById(R.id.Administrator);
        Instructor = findViewById(R.id.Instructor);
        Member = findViewById(R.id.Member);

        //Creates the admin login dialog
        Administrator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AdminLogIn adminLogin = new AdminLogIn();
                adminLogin.show(getSupportFragmentManager(),"adminlogin");
            }
        });

        //Creates the user dialog
        Member.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                UserLogin userLogin = new UserLogin();
                userLogin.show(getSupportFragmentManager(),"userlogin");
            }
        });
    }

    //Receives data from the AdminLogin dialog
    //This should verify the username and password
    //If right this should open the page where the admin changes classes and users
    @Override
    public void applyTexts(String username, String password) {

    }

    //receives data from the UserLogin dialog
    //Should open welcome page for user
    @Override
    public void userText(String username, String password) {
        
    }
}