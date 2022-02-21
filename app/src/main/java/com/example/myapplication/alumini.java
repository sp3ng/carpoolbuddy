package com.example.myapplication;

import java.util.ArrayList;

public class alumini extends User
{
    String graduateyear;
    public alumini()
    {
    }
    public String getGraduateyear() {
        return graduateyear;
    }
    public alumini(String uid, String name, String email, String usertype, double pricemult, ArrayList<String> ownveh, double balance, String graduateyear)
    {
        super(uid, name, email, usertype, pricemult, ownveh, balance);
        this.graduateyear = graduateyear;
    }

    @Override
    public String toString() {
        return "alumini{" +
                "graduateyear='" + graduateyear + '\'' +
                '}';
    }
}
