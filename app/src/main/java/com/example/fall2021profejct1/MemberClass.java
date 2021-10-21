package com.example.fall2021profejct1;

public class MemberClass {

    //Attributes
    String memberID;
    ClassClass enrolled;

    MemberClass(String memberID){
        this.memberID = memberID;
    }
    MemberClass(String memberID, ClassClass enrolled){
        this.memberID = memberID;
        this.enrolled = enrolled;
    }


    //Methods
    public void viewClasses(){
        //Not implemented. Need database.
    }
    public ClassClass searchDay(String day){
        //Not implemented. Need database.
        return null;
    }
    public ClassClass searchName(String name){
        //Not implemented. Need database.
        return null;
    }
    public void enroll(ClassClass className){
        //Not implemented. Need database.

    }
    public void deroll(ClassClass className){
        //Not implemented. Need database.
    }
        

}
