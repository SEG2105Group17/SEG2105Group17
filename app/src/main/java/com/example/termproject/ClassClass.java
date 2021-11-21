package com.example.termproject;

public class ClassClass {
    // Attributes
    public int id = -1;
    public String name = "";
    public String description = "";
    public String date = "";
    public String time = "";
    public int difficulty = -1;
    public int capacity = -1;

    public String instructor;

    //Constructors
    public ClassClass(){}
    public ClassClass(int id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }

    public ClassClass(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ClassClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ClassClass(String name) {
        // Only given name, set default to others (can edit later using methods)
        this.name = name;
        description = "Not Specified";
        date = "Not Specified";
        time = "Not Specified";
        difficulty = 0;
        int capacity = 50;
    }
    public ClassClass(String name, String description, String date, String time, int difficulty, int capasity,String instructor){
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.difficulty = difficulty;
        this.capacity = capasity;
        this.instructor=instructor;
    }

    public boolean isCourse() {
        return date == null && time == null && difficulty == -1 && capacity == -1 && instructor == null;
    }

    //Methods to change constructors
    public void changeID(int id){this.id=id;}
    public void changeName(String name){
        this.name = name;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeDate(String date) {
        this.date = date;
    }

    public void changeTime(String time) {
        this.time = time;
    }

    public void changeDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void changeCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void changeInstructor(String instructor){this.instructor=instructor;};


    //Methods
    //@param int people, amount of people in the class
    //@return, true if room, false if full
    public boolean checkIfFull(int people){
        if(people >= capacity){
            return false;
        }
        return true;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

}
