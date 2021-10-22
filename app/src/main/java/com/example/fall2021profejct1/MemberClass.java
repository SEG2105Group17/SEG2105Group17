package com.example.fall2021profejct1;

public class MemberClass {

    //Attributes
    public String memberID;
    public ClassClass enrolled;

    MemberClass(String memberID){
        this.memberID = memberID;
    }
    MemberClass(String memberID, ClassClass enrolled){
        this.memberID = memberID;
        this.enrolled = enrolled;
    }


    //Methods
    public void viewClasses(){
        // input array of the main of classes
        for (int i = 0 ; i < arr.length; i++){
            print(arr[i]);
        }
    }
    public ClassClass searchDay(String day) throws NoSuchElementException{
        // input array of the main of classes
        for (int i = 0 ; i < arr.length; i++) {
            if (day == arr[i].day) {
                return arr[i];
            }
        }
        throw new NoSuchElementException("No class on that day");

    }
    public ClassClass searchName(String name) throws NoSuchElementException {
        // input array of the main of classes
        for (int i = 0 ; i < arr.length; i++) {
            if (name == arr[i].name) {
                return arr[i];
            }
        }
        throw new NoSuchElementException("No class on that day");
    }
    public void enroll(ClassClass className) throws {
        //Not implemented. Need database.

    }
    public void deroll(ClassClass className){
        //Not implemented. Need database.
    }


}
