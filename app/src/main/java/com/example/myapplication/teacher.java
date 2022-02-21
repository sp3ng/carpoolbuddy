package com.example.myapplication;

import java.util.ArrayList;

public class teacher extends User
{
    String inschooltitle;

    public teacher ()
    {
    }

    public String getInschooltitle() {
        return inschooltitle;
    }

    public void setInschooltitle(String inschooltitle) {
        this.inschooltitle = inschooltitle;
    }

    public teacher(String uid, String name, String email, String usertype, double pricemult, ArrayList<String> ownveh, double balance, String inschooltitle) {
        super(uid, name, email, usertype, pricemult, ownveh, balance);
        this.inschooltitle = inschooltitle;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "inschooltitle='" + inschooltitle + '\'' +
                '}';
    }
}
