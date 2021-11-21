package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
//currently listview displays all classes
///TODO: implement search button:(so list view results can narrowed using editInstructor/editSearch or both)
public class InstructorSearchActivity extends AppCompatActivity {
    TextView txtInfo;
    ListView list;
    EditText editInstructor, editCourse;
    Button btnBack,btnSearch;

    ArrayList<Integer> listIds;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    String username;

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

        username = getIntent().getExtras().getString("username");
        CourseDetailsDBHandler dbHandler=new CourseDetailsDBHandler(this);
        CourseDBHandler check= new CourseDBHandler(this);
        listItem = new ArrayList<>();
        listIds = new ArrayList<>();

        viewData();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text= list.getItemAtPosition(i).toString();
                Toast.makeText(InstructorSearchActivity.this,""+text,Toast.LENGTH_SHORT).show();

                int id = listIds.get(i);
                ClassClass course = dbHandler.find(id);

                txtInfo.setText("Course: "+course.name +"\nDescription: "+course.description +"\nInstructor: "+course.instructor+
                        "\nDate: "+course.date +"\nTime: "+course.time +
                        "\nDifficulty: "+course.difficulty +"\nCapacity: "+course.capacity+ "\nID: "+id);

            }
        });

    }


    private void viewData(){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        Cursor cursor= dbHandler.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this,"Not data to show",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                    listItem.add(cursor.getString(1));
                    listIds.add(cursor.getInt(0));

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