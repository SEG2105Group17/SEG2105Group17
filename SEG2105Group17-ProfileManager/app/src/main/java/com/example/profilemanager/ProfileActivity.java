package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    TextView textViewAvatar;
    ImageView imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);

        //onClicks
        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Creating a return Intent to pass to the Main Activity
                Intent returnIntent = new Intent();

                //Figuring out which image was clicked
                ImageView selectedImage = (ImageView) view;

                //Adding details to the return intent
                returnIntent.putExtra("imageView2", selectedImage.getId());

                //Finishing the activity and returning to the main screen
                finish();
            }
        });

    }
}