package com.example.myapplication;

import java.util.ArrayList;

public class Segway extends bigVehicles
{
    public Segway()
    {
    }
    private int range;
    private int weightcapacity;
    public Segway(String owner, String model, int capacity, String veID, ArrayList<String> riderID, boolean open, String vehicletype, double baseprice, ArrayList<Reviews> reviews, int range, int weightcapacity)
    {
        super(owner, model, capacity, veID, riderID, open, vehicletype, baseprice, reviews);
        this.range = range;
        this.weightcapacity = weightcapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeightcapacity() {
        return weightcapacity;
    }

    public void setWeightcapacity(int weightcapacity) {
        this.weightcapacity = weightcapacity;
    }
}
