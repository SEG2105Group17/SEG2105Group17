package com.example.fall2021profejct1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.View;

import java.util.ArrayList;
import java.util.List;

public class AdminLoginPage extends AppCompatActivity{
    //Mostly copied from tutorial slides
    //Attributes
    TextView adminTitleTextView, adminAddClasstextView;
    Button addClassBTN, editClassBTN, deleteClassBTN, deleteInstructorBTN, deleteMemberBTN;
    ListView listViewClasses;


    List<ClassClass> classes;
    DatabaseReference databaseClasses;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.adminlogin_activity);

        adminTitleTextView = (TextView)findViewById(R.id.adminTitleTextView);
        adminAddClasstextView= (TextView)findViewById(R.id.adminAddClassTextView);

        listViewClasses = (ListView) findViewById(R.id.listViewClasses);

        addClassBTN = (Button) findViewById(R.id.addClassBTN);
        editClassBTN = (Button) findViewById(R.id.editClassBTN);
        deleteClassBTN = (Button) findViewById(R.id.deleteClassBTN);
        deleteInstructorBTN = (Button) findViewById(R.id.deleteInstructorBTN);
        deleteMemberBTN = (Button) findViewById(R.id.deleteMemberBTN);

        classes = new ArrayList<>();
        databaseClasses = FirebaseDatabase.getInstance.getReference("classes");

        //adding an onClicklistener to add button
        addClassBTN.setOnClickListener(new View.onClickListener(){
            @Override
            public void onClick(View view){
                addClass();
            }
        });




    }
    //onStart
    //copied from slide
    @Override
    protected void onStart(){
        super.onStart();
        databaseClasses.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                classes.clear();
                for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                    ClassClass Class = postSnapShot.getValue(ClassClass.class);
                    classes.add(Class);
                }
                AdminCreateClass classAdapter = new AdminCreateClass(AdminLoginPage.this, classes);
                listViewClasses.setAdapter(classAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addClass(){
        String name = adminAddClasstextView.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {
            String id = databaseClasses.push().getKey();

            ClassClass Class = new ClassClass(name);
            databaseClasses.child(id).setValue(Class);

            adminAddClasstextView.setText("");

            Toast.makeText(this, "Class added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Enter name of Class", Toast.LENGTH_LONG).show();

        }
    }



}
