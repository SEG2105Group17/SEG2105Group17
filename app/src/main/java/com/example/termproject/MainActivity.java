package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titleTV;

    Button member, instructor, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = (TextView) findViewById(R.id.titleTV);

        member = (Button) findViewById(R.id.memberBTN);
        instructor = (Button) findViewById(R.id.instructorBTN);
        admin = (Button) findViewById(R.id.adminBTN);

    }

    //set methods for when buttons are pressed

    //Method to switch to login activities


    //-----------------------------------------------
    //intents
    //set onClick methods to these
    //Opens the admin activity
    public void openActivityAdmin(View view){
        Intent intent1 = new Intent(this, AdminLoginActivity.class);
        startActivity(intent1);

    }
    //Opens Member activity
    public void openActivityMember(View view){
        Intent intent2 = new Intent(this, MemberLoginActivity.class);
        startActivity(intent2);

    }
    //Opens Member activity
    public void openActivityInstructor(View view){
        Intent intent3 = new Intent(this, MemberLoginActivity.class);
        startActivity(intent3);

    }
    //-----------------------------------------

}