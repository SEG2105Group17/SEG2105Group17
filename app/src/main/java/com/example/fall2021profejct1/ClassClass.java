package com.example.fall2021profejct1;

public class ClassClass {
    //Attributes

    String name;
    String description;
    String date;
    String time;
    int difficulty;
    int capacity;

    //Constructors
    ClassClass(String name){
        //Only given name, set default to others (can edit later using methods)
        this.name = name;
        description = "Not Specified";
        date = "Not Specified";
        time = "Not Specified";
        difficulty = 0;
        int capacity = 50;
    }
    ClassClass(String name, String description, String date, String time, int difficulty, int capasity){
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.difficulty = difficulty;
        this.capacity = capasity;
    }



    //Methods to change constructors
    public void changeName(String name){
        this.name = name;
    }
    public void changeDescription(String description){
        this.description = description;
    }
    public void changeDate(String date){
        this.date = date;
    }
    public void changeTime(String time){
        this.time = time;
    }
    public void changeDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public void changeCapacity(int capacity){
        this.capacity = capacity;
    }


    //Methods
    //@param int people, amount of people in the class
    //@return, true if room, false if full
    public boolean checkIfFull(int people){
        if(people >= capacity){
            return false;
        }
        return true;
    }
}
