package com.example.fall2021profejct1;

public class MemberClass {

    //Attributes
    public String memberID;
    public LinkedList<ClassClass> enrolled;

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
        for (int i = 0 ; i < enrolled.size(); i++){
            print(enrolled[i]);
        }
    }
    public ClassClass searchDay(String day) throws NoSuchElementException{
        // input array of the main of classes
        for (int i = 0 ; i < arr.size(); i++) {
            if (day == enrolled[i].day) {
                return enrolled[i];
            }
        }
        throw new NoSuchElementException("No class on that day");

    }
    public ClassClass searchName(String name) throws NoSuchElementException {
        // input array of the main of classes
        for (int i = 0 ; i < enrolled.size(); i++) {
            if (name == enrolled[i].name) {
                return enrolled[i];
            }
        }
        throw new NoSuchElementException("No class on that day");
    }
    public void enroll(ClassClass className) throws NoSuchElementException{
        //Not implemented. Need database.

    }
    public void deroll(ClassClass className) throws NoSuchElementException{
        //Not implemented. Need database.
    }

    public String getUserType(){
        return "Memeber";
    }


}
