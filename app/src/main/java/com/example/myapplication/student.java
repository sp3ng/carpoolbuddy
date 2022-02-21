package com.example.myapplication;

import java.util.ArrayList;

public class student extends User
{
    String graduationyear;
    ArrayList<String> parentUID;

    public student ()
    {
    }

    public String getGraduationyear() {
        return graduationyear;
    }

    public void setGraduationyear(String graduationyear) {
        this.graduationyear = graduationyear;
    }

    public ArrayList<String> getParentUID() {
        return parentUID;
    }

    public void setParentUID(ArrayList<String> parentUID) {
        this.parentUID = parentUID;
    }

    public student(String uid, String name, String email, String usertype, double pricemult, ArrayList<String> ownveh, double balance, String graduationyear, ArrayList<String> parentUID )
    {
        super(uid, name, email, usertype, pricemult, ownveh, balance);
        this.graduationyear = graduationyear;
        this.parentUID = parentUID;
    }

    @Override
    public String toString() {
        return "student{" +
                "graduationyear='" + graduationyear + '\'' +
                ", parentUID=" + parentUID +
                '}';
    }
}
