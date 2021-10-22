package com.example.fall2021profejct1;

public class InstructorClass {
    //Attributes
    String instrctorId;
    LinkedList<ClassClass> teaching= new LinkedList<ClassClass>();

    //Constructors
    InstructorClass(String instructorID){
        this.instrctorId = instructorID;
        teaching = null;
    }
    InstructorClass(String instructorID, LinkedList<ClassClass> teaching){
        this.instrctorId = instructorID;
        this.teaching = teaching;
    }


    //Methods

    //Array needs to be modified
    public void teachClass(ClassClass classC){
        teaching,add(classC);
    }
    public void setDate(ClassClass className, String date){
        className.changeDate(date);
    }
    public void setTime(ClassClass className, String time){
        className.changeTime(time);
    }
    public void setDiff(ClassClass className, int difficulty){
        className.changeDifficulty(difficulty);
    }
    public void setCap(ClassClass className, int capacity){
        className.changeCapacity(capacity);
    }

    //Method to delete class
    public void cancel(ClassClass className){
        className = null;
    }

    public String getUserType(){
        return "Instroctor";
    }
}
