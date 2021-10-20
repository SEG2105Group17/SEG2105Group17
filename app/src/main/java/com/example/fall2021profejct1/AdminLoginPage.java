package com.example.fall2021profejct1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class AdminLoginPage extends AppCompatActivity{

    //Attributes
    TextView adminTitleTextView;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.adminlogin_activity);

        adminTitleTextView = findViewById(R.id.adminTitleTextView);



    }



}
