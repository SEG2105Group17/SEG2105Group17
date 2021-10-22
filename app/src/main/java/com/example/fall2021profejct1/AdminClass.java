package com.example.fall2021profejct1;

public class AdminClass {



    //Any Admin based logic/functionality goes here
    //Attributes

    ClassClass classID;
    ClassClass[] classList= new ClassClass[100];

    int count = 0;

    AdminClass(){

    }



    //Methods
    public void createClass(String className){
        classID = new ClassClass(className);

        classList[count] = classID;
        count++;
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
}
