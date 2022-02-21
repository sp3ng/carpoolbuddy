package com.example.myapplication;

import java.util.ArrayList;

public class inair extends bigVehicles
{
    public inair()
    {
    }
    private int mxalt;
    private int maxairspeed;
    public inair(String owner, String model, int capacity, String veID, ArrayList<String> riderID, boolean open, String vehicletype, double baseprice, ArrayList<Reviews> reviews, int mxalt, int maxairspeed)
    {
        super(owner, model, capacity, veID, riderID, open, vehicletype, baseprice, reviews);
        this.mxalt = mxalt;
        this.maxairspeed = maxairspeed;
    }

    public int getMxalt() {
        return mxalt;
    }

    public void setMxalt(int mxalt) {
        this.mxalt = mxalt;
    }

    public int getMaxairspeed() {
        return maxairspeed;
    }

    public void setMaxairspeed(int maxairspeed) {
        this.maxairspeed = maxairspeed;
    }
}
