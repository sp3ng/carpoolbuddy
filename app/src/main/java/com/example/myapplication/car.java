package com.example.myapplication;

import java.util.ArrayList;

public class car extends bigVehicles
{
    private int range;
    public car ()
    {
    }
    public car(String owner, String model, int capacity, String veID, ArrayList<String> riderID, boolean open, String vehicletype, double baseprice, ArrayList<Reviews> reviews, int range)
    {
        super(owner, model, capacity, veID, riderID, open, vehicletype, baseprice, reviews);
        this.range = range;
    }
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
