package com.example.fall2021profejct1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements AdminLogIn.AdminLogInListener, UserLogin.UserLoginListener, InstructorLogin.InstructorLoginListener {

    Button Administrator, Member, Instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Administrator = findViewById(R.id.Administrator);
        Instructor = findViewById(R.id.Instructor);
        Member = findViewById(R.id.Member);

        //Creates the admin login dialog
        Administrator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AdminLogIn adminLogin = new AdminLogIn();
                adminLogin.show(getSupportFragmentManager(),"adminlogin");
            }
        });

        //Creates the user dialog
        Member.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                UserLogin userLogin = new UserLogin();
                userLogin.show(getSupportFragmentManager(),"userlogin");
            }
        });
    }

    public void instructorText(String username, String password){

    }

    //Receives data from the AdminLogin dialog
    //This should verify the username and password
    //If right this should open the page where the admin changes classes and users
    @Override
    public void applyTexts(String username, String password) {
        //Verify the admin credentials are correct
        boolean verify = false;
        if(username == "admin" && password == "admin123"){
            verify = true;
        }

        //If verified,  proceed to page with admin access (edit class/users, delete class/users, add class/users)
        //If not, the tell them incorrect password, and go back

        //VERIFIED
        if(verify == true){
            //open admin page
            openActivityAdmin();
        }else{      //NOT VERIFIED
            System.out.println("Username or Password: Incorrect");
        }
    }

    //receives data from the UserLogin dialog
    //Should open welcome page for user
    @Override
    public void userText(String username, String password) {
        boolean verify = true;          //They create/login at same time, so its assumed its impossible to get password incorrect.


        //Open Member page
        //pass over username, to greet the user with their name
        openActivityMember(username);
    }

    //-----------------------------------------------------------------------------------------------
    //                              Methods to open different activities
    //
    //-----------------------------------------------------------------------------------------------
    //Opens the admin activity
    public void openActivityAdmin(){
        Intent intent1 = new Intent(this, AdminLoginPage.class);
        startActivity(intent1);

    }
    //Opens Member activity
    public void openActivityMember(String name){
        Intent intent2 = new Intent(this, MemberLoginPage.class);
        startActivity(intent2);

    }

     /* Opens Intructor activity... NOTE: Corssed out because intructor activity is not created. IDK
     if we have seperate activity for instructor, or if instructor and user share activity
    public void openActivityIntructor(){
        Intent intent3 = new Intent(this, AdminLoginPage.class);
        startActivity(intent3);

    }
    */
    //-----------------------------------------------------------------------------------------------

}