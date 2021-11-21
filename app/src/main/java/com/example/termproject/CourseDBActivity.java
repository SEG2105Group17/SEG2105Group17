package com.example.termproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CourseDBActivity extends AppCompatActivity {
    Button btnAdd,btnFind,btnDelete, btnBack;
    TextView txtID2, txt1;
    EditText editName, editDescription;
    ListView list;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_dbactivity);
        btnAdd=findViewById(R.id.btnAdd);
        btnFind=findViewById(R.id.btnFind);
        btnDelete=findViewById(R.id.btnDelete);
        btnBack=findViewById(R.id.btnBack);
        txtID2=findViewById(R.id.txtID2);
        txt1=findViewById(R.id.txt1);
        editName=findViewById(R.id.editName);
        editDescription=findViewById(R.id.editDescription);
        list=findViewById(R.id.list);

        CourseDBHandler dbHandler=new CourseDBHandler(this);
        listItem = new ArrayList<>();
        viewData();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text= list.getItemAtPosition(i).toString();
                Toast.makeText(CourseDBActivity.this,""+text,Toast.LENGTH_SHORT).show();
                txt1.setText("Description: "+dbHandler.find(text).description);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                back();
            }
        });
    }
    private void back(){
        Intent intent= new Intent(this, AdminSelectActivity.class);
        startActivity(intent);
    }
    public void newProduct(View view){
        CourseDBHandler dbHandler =new CourseDBHandler(this);

        if(editName.getText().toString().equals("") || editDescription.getText().toString().equals("")){
            txtID2.setText("Enter valid price/product name");

        }
        else{
            String description =editDescription.getText().toString().trim();
            ClassClass course = new ClassClass(editName.getText().toString().trim().toLowerCase(), description);
            dbHandler.add(course);
        }
        editName.setText("");
        editDescription.setText("");

        listItem.clear();
        viewData();
    }
    public void lookupProduct(View view){
        CourseDBHandler dbHandler= new CourseDBHandler(this);
        ClassClass course= dbHandler.find(editName.getText().toString());
        if(course!=null){
            txtID2.setText(String.valueOf(course.id));
            editDescription.setText(String.valueOf(course.description));

        }else{
            txtID2.setText("No Match Found");
        }
    }
    public void removeProduct(View view){
        CourseDBHandler dbHandler= new CourseDBHandler(this);
        boolean result = dbHandler.delete(editName.getText().toString());
        listItem.clear();
        viewData();

        if(result){
            txtID2.setText("Record Deleted");
            editDescription.setText("");
            editName.setText("");
        }
        else
            txtID2.setText("No Match Found");
    }
    private void viewData(){
        CourseDBHandler dbHandler= new CourseDBHandler(this);
        Cursor cursor= dbHandler.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this,"Not data to show",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }
        }
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
        list.setAdapter(adapter);
    }

}