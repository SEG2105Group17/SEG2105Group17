package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Main Activity Class
    //Class Shows start screen, where user can select team flag, team name, postal code

    //Declare variables of ID's
    ImageView imageView;
    TextView Title, teamName, teamAddress;
    EditText teamNameEdit, postalCodeEdit;
    Button googleMaps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------
        imageView = findViewById(R.id.imageView);

        Title = findViewById(R.id.Title);
        teamName = findViewById(R.id.teamName);
        teamAddress = findViewById(R.id.teamAddress);

        teamNameEdit = findViewById(R.id.teamNameEdit);
        postalCodeEdit = findViewById(R.id.postalCodeEdit);

        googleMaps = findViewById(R.id.googleMaps);
        //-------------------------------------------

        //onClicks
        googleMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText address = (EditText) findViewById(R.id.postalCodeEdit);

                //Create a uri from a string. Use the result to create an intent
                Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + address.getText());

                //Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                //Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                //Attempt to start the activity that can handle the Intent
                startActivity(mapIntent);
            }
        });

    }

}