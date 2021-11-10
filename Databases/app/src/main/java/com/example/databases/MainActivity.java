package com.example.databases;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText editPrice;
    EditText editName;

    ListView productList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    Button addBTN, findBTN, deleteBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = findViewById(R.id.ProductID);
        editPrice = findViewById(R.id.ProductPrice);
        editName = findViewById(R.id.ProductName);
        productList = findViewById(R.id.listView);

        addBTN = findViewById(R.id.AddProduct);
        findBTN = findViewById(R.id.FindProduct);
        deleteBTN = findViewById(R.id.DeleteProduct);

        MyDBHandler dbHandler = new MyDBHandler(this);
        listItem = new ArrayList<>();

        //call the viewData() method to display the existing products
        viewData();

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = productList.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //we use onClick for the Add button in our layout to call this method
    public void newProduct (View view){
        MyDBHandler dbHandler = new MyDBHandler(this);

        //get price from the text box
        double price = Double.parseDouble(editPrice.getText().toString());

        //get the product name from the text bob
        // use the constructor from Product.java
        Product product = new Product(editName.getText().toString(), price);

        //add to database with the addProduct() method from MyDBHandler.java
        dbHandler.addProduct(product);

        //clear the text boxes
        editPrice.setText("");
        editName.setText("");

        //clearing the list of products
        //calling viewData() method to display the updated list of products
        //this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();
    }

    //we use onClick for the Find Button in our layout to call this method
    public void lookupProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        //get product in the databse using findProduct() method from MyDBHandler.java
        Product product = dbHandler.findProduct(editName.getText().toString());

        //if found, then display the product details
        //if not, display "No match Found"
        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            editPrice.setText(String.valueOf(product.getPrice()));
        } else {
            idView.setText("No Match Found");
        }
    }

    //we use onClick for the Delete button in our layout to call this method
    public void removeProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);

        //delete product in the database using deleteProduct method from MyDBHandler.java
        boolean result = dbHandler.deleteProduct(editName.getText().toString());

        //clearing the list of products
        //calling viewData() method to display the updated list of Products
        //this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();

        // "Record Deleted" or "No Match Found"
        if(result){
            idView.setText("Record Deleted");
            editName.setText("");
            editPrice.setText("");
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
            productList.setAdapter(adapter);
        }

    }
}