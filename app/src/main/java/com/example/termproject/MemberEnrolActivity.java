package com.example.termproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
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
import java.util.Locale;

public class MemberEnrolActivity extends AppCompatActivity {
    Button btnSearch,btnAllCourse,btnEnrol,btnPerCourse,btnUnenrol, btnBack;
    TextView txtInfo,txtWelcome, txtMID;
    EditText editCourse,editDay;
    ListView list;

    ArrayList<Integer> listIds;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    String username;
    boolean DBP, DBA;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_enrol);

        btnSearch=findViewById(R.id.btnMSearch);
        btnAllCourse=findViewById(R.id.btnMAllCourse);
        btnEnrol=findViewById(R.id.btnEnrol);
        btnPerCourse=findViewById(R.id.btnMPCourse);
        btnUnenrol=findViewById(R.id.btnUnenrol);
        btnBack=findViewById(R.id.btnMBack);
        txtInfo=findViewById(R.id.txtMInfo);
        txtWelcome=findViewById(R.id.txtWelcome);
        editCourse=findViewById(R.id.editMCourse);
        editDay=findViewById(R.id.editMDay);
        list=findViewById(R.id.listM);
        txtMID = findViewById(R.id.MID);


        username = getIntent().getExtras().getString("username");
        DBP=true;
        DBA=false;
        txtWelcome.setText("Welcome "+username+"! You are logged in as Member.");
        txtInfo.setText("Please select course for more information.");

        CourseDetailsDBHandler dbHandler=new CourseDetailsDBHandler(this);
        CourseDBHandler check= new CourseDBHandler(this);
        listItem = new ArrayList<>();
        listIds = new ArrayList<>();


        viewData();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text= list.getItemAtPosition(i).toString();
                Toast.makeText(MemberEnrolActivity.this,""+text,Toast.LENGTH_SHORT).show();

                int id = listIds.get(i);
                ClassClass course = dbHandler.find(id);
                txtMID.setText(""+id);

                txtInfo.setText("Course: "+course.name +"\nDescription: "+course.description +
                        "\nDate: "+course.date +"\nTime: "+course.time +
                        "\nDifficulty: "+course.difficulty +"\nCapacity: "+course.capacity
                        +"\nMembers: "+course.membersString);

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                back02();
            }
        });
        btnEnrol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(DBA){
                    addMember();
                }else{
                    txtInfo.setText("Please select course from 'All courses' menu to enroll in");
                }
                txtMID.setText("");
            }
        });
        btnUnenrol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(DBP){deleteMember();}
                else{
                    txtInfo.setText("Please select course from 'Personal Courses' menu to unenroll from");
                }
                txtMID.setText("");
            }
        });
        btnAllCourse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DBA=true;
                DBP=false;
                viewData();
            }
        });
        btnPerCourse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DBA=false;
                DBP=true;
                viewData();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                searchMemberClasses();
            }
        });
    }
    private void viewData(){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        listItem.clear();
        listIds.clear();

        if(DBP){
            Cursor cursor= dbHandler.viewData();
            String[] mem;

            if(cursor.getCount() == 0){
                Toast.makeText(MemberEnrolActivity.this,"No Classes Exist",Toast.LENGTH_SHORT).show();
            } else {
                    while(cursor.moveToNext()){
                        boolean flag=false;
                        mem=cursor.getString(8).split(":::");
                        for(int i=0;i<mem.length;i++){
                            if(mem[i].equals(username)){flag=true;}
                        }

                        if(flag){
                            listItem.add(cursor.getString(1));
                            listIds.add(cursor.getInt(0));
                        }
                    }
            }
        }
        else if(DBA){
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
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
        list.setAdapter(adapter);
    }

    private void back02(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void deleteMember(){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        int delID;
        ClassClass course;
        String[] mem;
        String mem2;

        try {
            delID = Integer.parseInt(txtMID.getText().toString());
            course= dbHandler.find(delID);
        }
        catch(NumberFormatException e) {
            txtInfo.setText("Please select item from list");
            return;
        }

        mem= course.membersString.split(":::");
        mem2="";

        for (int i= 0; i<mem.length; i++){
            if(!mem[i].equals(username)) {
                if (mem2.equals("")) {mem2 = mem[i];}
                else {mem2=mem2+":::"+mem[i];}
            }
        }
        dbHandler.editMember(delID,mem2);
        txtInfo.setText(username+" has unenrolled from "+course.name);
        txtMID.setText("");

        listItem.clear();
        listIds.clear();
        viewData();
    }
    private void addMember(){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        int delID;
        ClassClass course;
        String[] mem;

        try {
            delID = Integer.parseInt(txtMID.getText().toString());
            course= dbHandler.find(delID);

        }
        catch(NumberFormatException e) {
            txtInfo.setText("Please select item from list");
            return;
        }

        mem= course.getMembers();
        String s;

        for (int i= 0; i<mem.length; i++){

            if (mem[i].equals(username)){
                txtInfo.setText("You are already enrolled in this course");
                txtMID.setText("");
                return;}
        }

        if((mem.length+1)>course.capacity){
            txtInfo.setText("This class is already full");
            txtMID.setText("");
            return;
        }
        if(timeConflict(course.time,course.date)){
            txtInfo.setText("Scheduling conflict with existing class");
            txtMID.setText("");
            return;
        }

        if(course.membersString.equals("")){s=username;}
        else{s=course.membersString+":::"+username;}

        dbHandler.editMember(delID,s);
        txtInfo.setText(username+" has enrolled in "+course.name);
        txtMID.setText(""+mem.length);

        listItem.clear();
        listIds.clear();
        viewData();

    }

    public void searchMemberClasses(){

        String day = editDay.getText().toString().trim().toLowerCase();
        String className = editCourse.getText().toString().trim().toLowerCase();
        CourseDetailsDBHandler search = new CourseDetailsDBHandler(this);
        Cursor cursor= search.viewData();
        listItem.clear();
        listIds.clear();
        if(!isDay(day) && !day.equals("")){
            txtInfo.setText("Invalid day of week for search by day. Should be, for example, 'thursday'");
            txtMID.setText("");
            return;
        }
            if(cursor.getCount() == 0){
                Toast.makeText(MemberEnrolActivity.this,"No Classes Exist",Toast.LENGTH_SHORT).show();
            } else {
                if(!className.equals("") && !day.equals("")){
                    while(cursor.moveToNext()){
                        if(cursor.getString(1).equals(className) && cursor.getString(3).equals(day)){
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
                } else if(!day.equals("")){
                    while(cursor.moveToNext()) {
                        if (cursor.getString(3).equals(day)) {
                            listItem.add(cursor.getString(1));
                            listIds.add(cursor.getInt(0));
                        }
                    }
                }
            }
            editCourse.setText("");
            editDay.setText("");
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            list.setAdapter(adapter);
    }
    public boolean isDay(String day){
        String[] days = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
        boolean flag =false;
        day = day.trim().toLowerCase();
        for (int i=0;i<days.length;i++){
            if (day!=null&&day.equals(days[i])){ flag=true;}
        }
        return flag;
    }
    public boolean timeConflict(String t, String d){
        CourseDetailsDBHandler dbHandler= new CourseDetailsDBHandler(this);
        Cursor cursor= dbHandler.viewData();
        String[] mem;
        String date;
        String time;

        boolean conflict=false;
        while(cursor.moveToNext()){
            boolean flag=false;
            mem=cursor.getString(8).split(":::");
            date=cursor.getString(3);
            time=cursor.getString(4);
            for(int i=0;i<mem.length;i++){
                if(mem[i].equals(username)){flag=true;}
            }

            if(flag && date.equals(d)&& hourConflict(time,t)){
                conflict=true;
            }
        }
        return conflict;
    }
    public boolean hourConflict(String time1, String time2){
        boolean flag=true;
        String[] parts1,start1,end1,parts2,start2,end2;
        int S1,S2,E1,E2;

        parts1=time1.split("-");
        parts2=time2.split("-");
        start1=parts1[0].split(":");
        end1=parts1[1].split(":");
        start2=parts2[0].split(":");
        end2=parts2[1].split(":");

        S1=Integer.parseInt(start1[0])*60 +Integer.parseInt(start1[1]);
        E1=Integer.parseInt(end1[0])*60 +Integer.parseInt(end1[1]);

        S2=Integer.parseInt(start2[0])*60+Integer.parseInt(start2[1]);
        E2=Integer.parseInt(end2[0])*60 +Integer.parseInt(end2[1]);

        if((S1<=S2 && E1<=S2)||(S1>=E2 && E1>=E2)){flag=false;}


        return flag;
    }

}