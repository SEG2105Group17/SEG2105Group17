package com.example.databases;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.termproject.User;


public class MyDBHandler extends SQLiteOpenHelper {
    private static final int  DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String  COLUMN_USERTYPE = "usertype";

    public MyDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_USERTYPE + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(User user){

        SQLiteDatabase db = this.getWritableDatabase();

        //creating an empty set of values
        ContentValues values = new ContentValues();
        //add values to the set
        values.put(COLUMN_USERNAME, user.getUserName());
        values.put(COLUMN_USERTYPE, user.getUserType());

        //Insert the set into the products table and close
        db.insert(TABLE_USERS, null, values);
        db.close();

    }

    public User findUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product with the specified product name
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME == "productname"
        String query = "SELECT * FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME
                + " = \"" + username + "\"";
        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        User user = new User();

        //moves cursor to the first row
        if(cursor.moveToFirst()){
            user.setID(Integer.parseInt(cursor.getString(0)));
            user.setUserName(cursor.getString(1));
            user.setUserType(cursor.getString(2));
            cursor.close();
        } else {
            user = null;
        }
        db.close();

        //we return the first product in the query result with the specified product name
        //or null if there is no product with that name
        return user;
    }

    public boolean deleteUser(String username){
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product with the specified product name, then delete
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME == "productname"
        String query = "SELECT * FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME
                + " = \"" + username + "\"";
        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        //moves the cursor to the first row
        //this deletes the first occurrence of the product with the specified name
        if (cursor.moveToFirst()){
            String idStr = cursor.getString(0);
            db.delete(TABLE_USERS, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();

        //if the product is deleted this return true
        return result;
    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS;

        //passing the query
        Cursor cursor = db.rawQuery(query, null);

        //returns all products from table
        return cursor;
    }
}

