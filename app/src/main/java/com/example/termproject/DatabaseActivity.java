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

import com.example.databases.MyDBHandler;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    TextView idView;
    EditText editName;
    EditText editType;

    ListView userList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;


    Button addBTN, findBTN, deleteBTN, btnBACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        idView = findViewById(R.id.UserID);
        editName = findViewById(R.id.UserName);
        editType = findViewById(R.id.UserType);
        userList = findViewById(R.id.listView);

        addBTN = findViewById(R.id.AddProduct);
        findBTN = findViewById(R.id.FindProduct);
        deleteBTN = findViewById(R.id.DeleteProduct);
        btnBACK = findViewById(R.id.btnBACK);

        MyDBHandler dbHandler = new MyDBHandler(this);
        listItem = new ArrayList<>();

        //call the viewData() method to display the existing products
        viewData();

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(DatabaseActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
        btnBACK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                backI01();
            }
        });
    }

    //we use onClick for the Add button in our layout to call this method
    public void newUser (View view){
        MyDBHandler dbHandler = new MyDBHandler(this);




        //get price from the text box
        //double userType = Double.parseDouble(editType.getText().toString());

        //get the product name from the text bob
        // use the constructor from Product.java
        User user = new User(editName.getText().toString(), editType.getText().toString());

        //add to database with the addProduct() method from MyDBHandler.java
        dbHandler.addUser(user);

        //clear the text boxes
        editType.setText("");
        editName.setText("");
        //clearing the list of products
        //calling viewData() method to display the updated list of products
        //this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();

    }
    //we use onClick for the Find Button in our layout to call this method
    public void lookupUser(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        //get product in the databse using findProduct() method from MyDBHandler.java
        User user = dbHandler.findUser(editName.getText().toString());

        //if found, then display the product details
        //if not, display "No match Found"
        if (user != null) {
            idView.setText(String.valueOf(user.getID()));
            editType.setText(String.valueOf(user.getUserType()));
        } else {
            idView.setText("No Match Found");
        }
    }

    //we use onClick for the Delete button in our layout to call this method
    public void removeUser(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);

        //delete product in the database using deleteProduct method from MyDBHandler.java
        boolean result = dbHandler.deleteUser(editName.getText().toString());

        //clearing the list of products
        //calling viewData() method to display the updated list of Products
        //this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();

        // "Record Deleted" or "No Match Found"
        if(result){
            idView.setText("Record Deleted");
            editName.setText("");
            editType.setText("");
        }else{
            idView.setText("No Match Found");
        }
    }

    private void viewData() {
        MyDBHandler dbHandler = new MyDBHandler(this);

        //call the viewData() method in MyDBHandler that runs the query
        Cursor cursor = dbHandler.viewData();

        //if there are no products in the table a toast says there is not data to show
        //otherwise, while there are products, keep moving to the next product
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                //I just want to display the product name so I only get column 1 from the table row
                listItem.add(cursor.getString(1));
            }
            //create an array adapter that provides a view for each item
            //simplest_list_item_1 is a built-in xml layout from android
            //I decided to use this instead of creating my own .sml file for items of the ListView
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);

            //attaching the adapter to the ListView
            userList.setAdapter(adapter);
        }

    }
    private void backI01(){
        Intent intent= new Intent(this, AdminSelectActivity.class);
        startActivity(intent);
    }
}