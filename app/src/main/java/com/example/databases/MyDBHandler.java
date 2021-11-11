package com.example.databases;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int  DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productname";
    private static final String  COLUMN_PRICE = "price";

    public MyDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PPRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_PRODUCTNAME + " TEXT,"
                + COLUMN_PRICE + " DOUBLE" + ")";
        db.execSQL(CREATE_PPRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Product product){



        SQLiteDatabase db = this.getWritableDatabase();

        //creating an empty set of values
        ContentValues values = new ContentValues();
        //add values to the set
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLUMN_PRICE, product.getPrice());

        //Insert the set into the products table and close
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    public Product findProduct(String productname){
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME == "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        //moves cursor to the first row
        if(cursor.moveToFirst()){
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setProductName(cursor.getString(1));
            product.setPrice(Double.parseDouble(cursor.getString(2)));
            cursor.close();
        } else {
            product = null;
        }
        db.close();

        //we return the first product in the query result with the specified product name
        //or null if there is no product with that name
        return product;
    }

    public boolean deleteProduct(String productname){
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product with the specified product name, then delete
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME == "productname"
        String query = "SELECT * FROM " + TABLE_PRODUCTS
                + " WHERE " + COLUMN_PRODUCTNAME
                + " = \"" + productname + "\"";
        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        //moves the cursor to the first row
        //this deletes the first occurrence of the product with the specified name
        if (cursor.moveToFirst()){
            String idStr = cursor.getString(0);
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();

        //if the product is deleted this return true
        return result;
    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;

        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        //returns all products from table
        return cursor;
    }
}























