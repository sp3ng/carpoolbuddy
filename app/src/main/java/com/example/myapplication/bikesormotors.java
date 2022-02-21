package com.example.myapplication;

import java.util.ArrayList;

public class bikesormotors extends bigVehicles
{
    private String bikeormotortype;
    private int weight;
    private int weightcapacity;
    public bikesormotors()
    {
    }

    public bikesormotors(String owner, String model, int capacity, String veID, ArrayList<String> riderID, boolean open, String vehicletype, double baseprice, ArrayList<Reviews> reviews, String bikeormotortype, int weight, int weightcapacity)
    {
        super(owner, model, capacity, veID, riderID, open, vehicletype, baseprice, reviews);
        this.bikeormotortype = bikeormotortype;
        this.weight = weight;
        this.weightcapacity = weightcapacity;

    }

    public String getBikeormotortype() {
        return bikeormotortype;
    }

    public void setBikeormotortype(String bikeormotortype) {
        this.bikeormotortype = bikeormotortype;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeightcapacity() {
        return weightcapacity;
    }

    public void setWeightcapacity(int weightcapacity) {
        this.weightcapacity = weightcapacity;
    }
}
