package com.example.fall2021profejct1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


//Page where admin can create/edit/delete classes

public class AdminLoginPage extends AppCompatActivity{
    //Mostly copied from tutorial slides
    //Attributes
    TextView adminTitleTextView;
    Button addClassBTN, editClassBTN, deleteClassBTN, deleteInstructorBTN, deleteMemberBTN;
    TextView addClassTextView, deleteClassTextView, editClassTextView, editDescriptionTextView;
    TextView editDateTextView, editTimeTextView, editDiffTextView, editCapTextView;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.adminlogin_activity);

        adminTitleTextView = (TextView) findViewById(R.id.adminTitleTextView);

        addClassTextView = (TextView) findViewById(R.id.addClassTextView);
        deleteClassTextView = (TextView) findViewById(R.id.deleteClassTextView);
        editClassTextView = (TextView) findViewById(R.id.editClassTextView);
        editDescriptionTextView = (TextView) findViewById(R.id.editDescriptionTextView);
        editDateTextView = (TextView) findViewById(R.id.editDateTextView);
        editTimeTextView = (TextView) findViewById(R.id.editTimeTextView);
        editDiffTextView = (TextView) findViewById(R.id.editDiffTextView);
        editCapTextView = (TextView) findViewById(R.id.editCapTextView);

        addClassBTN = (Button) findViewById(R.id.addClassBTN);
        deleteClassBTN = (Button) findViewById(R.id.deleteClassBTN);
        editClassBTN = (Button) findViewById(R.id.editClassBTN);
        deleteInstructorBTN = (Button) findViewById(R.id.deleteInstructorBTN);
        deleteMemberBTN = (Button) findViewById(R.id.deleteMemberBTN);


        //adding onClicks to buttons

        addClassBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addClassTextView.getText().toString();

                //Make new object class of new class
                AdminClass createClass = new AdminClass();
                createClass.createClass(name);
            }
        });

        deleteClassBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String className = deleteClassTextView.getText().toString();

                //delete the class
                AdminClass deleteClass = new AdminClass();
                deleteClass.deleteClass(className);
            }
        });

    }
}
