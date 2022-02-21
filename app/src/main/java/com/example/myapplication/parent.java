package com.example.myapplication;

import java.util.ArrayList;

public class parent extends User
{
    ArrayList<String> childrenuids;
    public parent()
    {
    }
    public ArrayList<String> getChildrenuids() {
        return childrenuids;
    }

    public void setChildrenuids(ArrayList<String> childrenuids) {
        this.childrenuids = childrenuids;
    }
    public parent(String uid, String name, String email, String usertype, double pricemult, ArrayList<String> ownveh, double balance, ArrayList<String> childrenuids) {
        super(uid, name, email, usertype, pricemult, ownveh, balance);
        this.childrenuids = childrenuids;
    }

    @Override
    public String toString() {
        return "parent{" +
                "childrenuids=" + childrenuids +
                '}';
    }
}
