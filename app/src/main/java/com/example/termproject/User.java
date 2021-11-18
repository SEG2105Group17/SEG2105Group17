package com.example.termproject;

public class User {
    private int _id;
    private String _username;
    private String _usertype;

    public User(){

    }
    public User(int id, String username, String usertype){
        _id = id;
        _username = username;
        _usertype = usertype;
    }
    public User(String username, String usertype){
        _username = username;
        _usertype = usertype;
    }


    public void setID(int id){_id = id;}
    public int getID(){return _id;}
    public void setUserName(String username){_username = username;}
    public String getUserName(){return _username;}
    public void setUserType(String usertype){_usertype = usertype;}
    public String getUserType(){return _usertype;}
}
