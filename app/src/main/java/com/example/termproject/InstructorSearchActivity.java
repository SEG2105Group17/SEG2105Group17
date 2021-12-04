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
//currently listview displays all classes
///TODO: implement search button:(so list view results can narrowed using editInstructor/editSearch or both)
public class InstructorSearchActivity extends AppCompatActivity {
    TextView txtInfo, txtlist;
    ListView list;
    EditText editInstructor, editCourse;
    Button btnBack,btnSearch, btnDB1, btnDB2;

    ArrayList<Integer> listIds;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    String username;
    boolean DB1,DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_search);
        txtInfo =findViewById(R.id.txtICourseSearchInfo);
        list=findViewById(R.id.listIAllCourse);
        editInstructor=findViewById(R.id.editInstructorSearch);
        editCourse=findViewById(R.id.txtICourseSearch);
        btnBack=findViewById(R.id.btnBack7);
        btnSearch=findViewById(R.id.btnSearch);
        btnDB1=findViewById(R.id.btnDB1);
        btnDB2=findViewById(R.id.btnDB2);
        txtlist=findViewById(R.id.txtlist);

        username = getIntent().getExtras().getString("username");
        CourseDetailsDBHandler dbHandler=new CourseDetailsDBHandler(this);
        CourseDBHandler check= new CourseDBHandler(this);
        listItem = new ArrayList<>();
        listIds = new ArrayList<>();

        DB1=true;
        DB2=false;

        viewData();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text= list.getItemAtPosition(i).toString();
                Toast.makeText(InstructorSearchActivity.this,""+text,Toast.LENGTH_SHORT).show();

                if(DB1){
                    int id = listIds.get(i);
                    ClassClass course = dbHandler.find(id);

                    txtInfo.setText("Course: "+course.name +"\nDescription: "+course.description +"\nInstructor: "+course.instructor+
                            "\nDate: "+course.date +"\nTime: "+course.time +
                            "\nDifficulty: "+course.difficulty +"\nCapacity: "+course.capacity+ "\nID: "+id);

                }
                else if(DB2){
                    int id = listIds.get(i);
                    ClassClass course = check.find(id);

                    txtInfo.setText("Course: "+course.name +"\nDescription: "+course.description + "\nID: "+id);

                }

            }
        });
        btnDB1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DB1=false;
                DB2=true;
                txtlist.setText("Class types offered by the gym:");
                txtInfo.setText("Select for class details");
                viewData();
            }
        });
        btnDB2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DB1=true;
                DB2=false;
                txtlist.setText("Classes booked by instructors:");
                txtInfo.setText("Select for class details");
                viewData();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchClasses(view);
            }
        });

    }
    public void searchClasses(View view){

        String instructorName = editInstructor.getText().toString();
        String className = editCourse.getText().toString();
        CourseDetailsDBHandler search = new CourseDetailsDBHandler(this);
        Cursor cursor= search.viewData();
        listItem.clear();
        listIds.clear();

        if(DB1){
            if(cursor.getCount() == 0){
                Toast.makeText(InstructorSearchActivity.this,"No Classes Exist",Toast.LENGTH_SHORT).show();
            } else {
                if(!className.equals("") && !instructorName.equals("")){
                    while(cursor.moveToNext()){
                        if(cursor.getString(1).equals(className) && cursor.getString(7).equals(instructorName)){
                            listItem.add(cursor.getString(1));
                            listIds.add(cursor.getInt(0));
                        }
                    }

                } else if(!className.equals("")) {
                    while(cursor.moveToNext()){
                        if(cursor.getString(1).equals(className)){
                            listItem.add(cursor.getString(1));
                            listIds.add(cursor.getInt(0));
                        }
                    }
                } else if(!instructorName.equals("")){
                    while(cursor.moveToNext()) {
                        if (cursor.getString(7).equals(instructorName)) {
                            listItem.add(cursor.getString(1));
                            listIds.add(cursor.getInt(0));
                        }
                    }
                }
            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            list.setAdapter(adapter);
        }else if (DB2){txtInfo.setText("Please select booked to search database");}

    }


    private void viewData(){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        CourseDBHandler check=new CourseDBHandler(this);
        listItem.clear();
        listIds.clear();

        if(DB1){

            Cursor cursor= dbHandler.viewData();
            if(cursor.getCount()==0){
                Toast.makeText(this,"Not data to show",Toast.LENGTH_SHORT).show();
            }else{
                while(cursor.moveToNext()){
                    listItem.add(cursor.getString(1));
                    listIds.add(cursor.getInt(0));

                }
            }
        }
        else if(DB2){
            Cursor cursor= check.viewData();
            if(cursor.getCount()==0){
                Toast.makeText(this,"Not data to show",Toast.LENGTH_SHORT).show();
            }else{
                while(cursor.moveToNext()){
                    listItem.add(cursor.getString(1));
                    listIds.add(cursor.getInt(0));

                }
            }
        }
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
        list.setAdapter(adapter);
    }
    public void backSI(View view){
        Intent intent= new Intent(this, InstructorSelectActivity.class);
            intent.putExtra("username", username);
        startActivity(intent);
    }
}