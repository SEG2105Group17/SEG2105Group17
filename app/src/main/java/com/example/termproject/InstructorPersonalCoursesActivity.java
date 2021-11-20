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
import java.util.Arrays;

//delete crashes when new item selected after used/
// error with txtClassInfo list on click display when edit used (back and return seems to make it better)
public class InstructorPersonalCoursesActivity extends AppCompatActivity {
    Button btnIAdd, btnIDelete, btnIEdit, btnIBack;
    TextView txtIID, txtClassInfo;
    EditText editIName,editIDate,editITime,editIDifficulty,editICapacity;
    ListView listI;

    ArrayList<Integer> listIds;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_personal_courses);

        btnIAdd=findViewById(R.id.btnIAdd);
        btnIDelete=findViewById(R.id.btnIDelete);
        btnIEdit=findViewById(R.id.btnIEdit);
        btnIBack=findViewById(R.id.btnIBack);
        txtIID=findViewById(R.id.txtIID);
        txtClassInfo=findViewById(R.id.txtClassInfo);
        editIName=findViewById(R.id.editIName);
        editIDate=findViewById(R.id.editIDate);
        editITime=findViewById(R.id.editITime);
        editIDifficulty=findViewById(R.id.editIDifficulty);
        editICapacity=findViewById(R.id.editICapacity);
        listI=findViewById(R.id.listI);

        username = getIntent().getExtras().getString("username");

        CourseDetailsDBHandler dbHandler=new CourseDetailsDBHandler(this);
        CourseDBHandler check= new CourseDBHandler(this);
        listItem = new ArrayList<>();
        listIds = new ArrayList<>();

        viewData();
        listI.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text= listI.getItemAtPosition(i).toString();
                Toast.makeText(InstructorPersonalCoursesActivity.this,""+text,Toast.LENGTH_SHORT).show();

                int id = listIds.get(i);
                ClassClass course = dbHandler.find(id);
                txtIID.setText(""+id);

                txtClassInfo.setText("Course: "+course.name +"\nDescription: "+course.description +
                        "\nDate: "+course.date +"\nTime: "+course.time +
                        "\nDifficulty: "+course.difficulty +"\nCapacity: "+course.capacity);

            }
        });



    }

    public void newProduct(View view){
        CourseDetailsDBHandler dbHandler =new CourseDetailsDBHandler(this);
        CourseDBHandler check =new CourseDBHandler(this);

        if(editIName.getText().toString().equals("") || editICapacity.getText().toString().equals("") ||
                editIDate.getText().toString().equals("") || editITime.getText().toString().equals("") ||
                    editIDifficulty.getText().toString().equals("")){

            txtIID.setText("Enter valid price/product name");
        }
        else{
            String name =editIName.getText().toString().trim();
            if(check.find(name)==null){
                txtIID.setText("Course not offered by gym");
                return;
            }

            String description= check.find(name).description;
            int capacity, difficulty;
            try {
                if(!isValidCapacity(Integer.parseInt(editICapacity.getText().toString().trim()))||!isValidDifficulty(Integer.parseInt(editIDifficulty.getText().toString().trim()))){
                    return;
                }
                capacity = Integer.parseInt(editICapacity.getText().toString().trim());
                difficulty =Integer.parseInt(editIDifficulty.getText().toString().trim());
            }
            catch(NumberFormatException e) {
                txtIID.setText("Please enter an integer value for capacity and difficulty");
                return;
            }
            if(!isDay(editIDate.getText().toString())){
                txtIID.setText("Please enter valid day of week for date");
                return;
            }
            String date =editIDate.getText().toString().trim().toLowerCase();
            String time =editITime.getText().toString().trim();

            ClassClass newCourse = new ClassClass(name, description, date, time, difficulty,capacity,username);
            dbHandler.add(newCourse);
        }
        editIName.setText("");
        editIDate.setText("");
        editITime.setText("");
        editICapacity.setText("");
        editIDifficulty.setText("");

        listItem.clear();
        listIds.clear();
        viewData();
    }

    public void removeProduct(View view){ //crashes when you select new element after deleting
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        int delID;
        try {
            delID = Integer.parseInt(txtIID.getText().toString());
            dbHandler.delete(delID);

        }
        catch(NumberFormatException e) {
            txtIID.setText("Please select item from list");
            return;
        }
            editIName.setText("");
            editIDate.setText("");
            editITime.setText("");
            editICapacity.setText("");
            editIDifficulty.setText("");
            txtClassInfo.setText("");
            txtIID.setText("");
            listItem.clear();
            listIds.clear();
            viewData();

    }
            public void editProduct(View view){
                CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
                int editID;
                ClassClass course;
                try {
                    editID = Integer.parseInt(txtIID.getText().toString());
                    course= dbHandler.find(editID);
                }
                catch(NumberFormatException e) {
                    txtIID.setText("Please select item from list");
                    return;
                }
                if(!editIDate.getText().toString().trim().equals("") && isDay(editIDate.getText().toString().trim())){
                    String date=editIDate.getText().toString().trim();
                    dbHandler.editIDate(editID,date);
                }
                if(!editITime.getText().toString().trim().equals("")){
                    String hours=editITime.getText().toString().trim();
                    dbHandler.editITime(editID,hours);
                }
                if(!editICapacity.getText().toString().trim().equals("") && isValidCapacity(Integer.parseInt(editICapacity.getText().toString().trim()))) {
                    try {
                        int capacity = Integer.parseInt(editICapacity.getText().toString().trim());
                        dbHandler.editICapacity(editID, capacity);
                    } catch (NumberFormatException e) {
                    }
                }
                if(!editIDifficulty.getText().toString().trim().equals("") && isValidDifficulty(Integer.parseInt(editIDifficulty.getText().toString().trim()))){
                    try{
                            int difficulty =Integer.parseInt(editIDifficulty.getText().toString().trim());
                            dbHandler.editIDifficulty(editID,difficulty);

                    }catch(NumberFormatException e){
                    }
                }
                editIName.setText("");
                editIDate.setText("");
                editITime.setText("");
                editICapacity.setText("");
                editIDifficulty.setText("");
                txtClassInfo.setText("");
                txtIID.setText("");

                listItem.clear();
                listIds.clear();
                viewData();
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
        listI.setAdapter(adapter);
    }


    public void backI(View view){
        Intent intent= new Intent(this, InstructorSelectActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    //for newProduct and edit
    public boolean isDay(String day){
        String[] days = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
        boolean flag =false;
        day = day.trim().toLowerCase();
        for (int i=0;i<days.length;i++){
            if (day!=null&&day.equals(days[i])){ flag=true;}
        }
        return flag;
    }
    public boolean isValidCapacity(int i){
        boolean flag=true;
        if (i<=0){
            flag=false;
            txtIID.setText("Must have a capacity of at least one");
        }
        else if (i>50){
            flag=false;
            txtIID.setText("Max capacity of 50 people per course");
        }
        return flag;
    }
    public boolean isValidDifficulty(int i){
        boolean flag=true;
        if (i<=0 || i>5){
            flag=false;
            txtIID.setText("Please select a difficulty level between 1(easy) and 5(expert)");
        }
        return flag;
    }


}