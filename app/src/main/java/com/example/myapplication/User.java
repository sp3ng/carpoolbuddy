package com.example.myapplication;

import java.util.ArrayList;

public class User
{
    private String uid;

    public User() {
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public double getPricemult() {
        return pricemult;
    }

    public void setPricemult(double pricemult) {
        this.pricemult = pricemult;
    }

    public ArrayList<String> getOwnveh() {
        return ownveh;
    }

    public void setOwnveh(ArrayList<String> ownveh) {
        this.ownveh = ownveh;
    }

    public String getUid() {
        return uid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String name;
    private String email;
    private double balance;
    private String usertype;
    private double pricemult;
    private ArrayList<String> ownveh;

    public User(String uid, String name, String email, String usertype, double pricemult, ArrayList<String> ownveh, double balance) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.usertype = usertype;
        this.pricemult = pricemult;
        this.ownveh = ownveh;
        this.balance = balance;
    }




}
