package com.example.fall2021profejct1;

public class AdminClass {



    //Any Admin based logic/functionality goes here
    //Attributes
    String className;
    ClassClass classID;

    AdminClass(){

    }



    //Methods
    public void createClass(ClassClass classID, String className){
        classID = new ClassClass(className);
    }
    public void editClassName(ClassClass className, String newName){
        className.changeName(newName);
    }

    public void editClassDesciption(ClassClass className, String newDescription){
        className.changeDescription(newDescription);
    }
}
