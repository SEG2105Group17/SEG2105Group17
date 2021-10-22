package com.example.fall2021profejct1;
import java.util.LinkedList;

public class AdminClass {



    //Any Admin based logic/functionality goes here
    //Attributes

    ClassClass classID;
    LinkedList<ClassClass> classList= new LinkedList<ClassClass>();

    int count = 0;

    AdminClass(){

    }



    //Methods
    public void createClass(String className, String description){
        classID = new ClassClass(className, description);

        classList.add(classID) ;
        this.count++;
    }

    public int numClass(){
        return this.count;
    }

    public void editClassName(ClassClass className, String newName){
        className.changeName(newName);
    }

    public void editClassDesciption(ClassClass className, String newDescription) {
        className.changeDescription(newDescription);
    }

    public void deleteClass(String className){

        ClassClass temp = new ClassClass(className);

        for(int i = 0; i < classList.length; i++){
            if(classList[i] == temp){
                classList[i] = null;
            }
        }
    }

    public String getUserType(){
        return "Admin";
    }

    //needDataBAse
    public deleteInstroctor() {

    }
    //needDataBAse
    public deleteMemeber() {

    }
}
