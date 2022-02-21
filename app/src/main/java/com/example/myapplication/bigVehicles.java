package com.example.myapplication;

import java.util.ArrayList;

public class bigVehicles
{
    private String owner;
    private String model;
    private int capacity;
    private String veID;
    ArrayList<String> riderID;
    private boolean open;
    private String vehicletype;
    private double baseprice;
    ArrayList<Reviews> reviews;


    public bigVehicles(String owner, String model, int capacity, String veID, ArrayList<String> riderID, boolean open, String vehicletype, double baseprice, ArrayList<Reviews> reviews)
    {
        this.owner = owner;
        this.model = model;
        this.capacity = capacity;
        this.veID = veID;
        this.riderID = riderID;
        this.open = open;
        this.vehicletype = vehicletype;
        this.baseprice = baseprice;
        this.reviews = reviews;
    }

    public bigVehicles()
    {
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public String getVeID()
    {
        return veID;
    }

    public void setVeID(String veID)
    {
        this.veID = veID;
    }

    public ArrayList<String> getRiderID()
    {
        return riderID;
    }

    public void setRiderID(ArrayList<String> riderID)
    {
        this.riderID = riderID;
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
    }

    public String getVehicletype()
    {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype)
    {
        this.vehicletype = vehicletype;
    }

    public double getBaseprice()
    {
        return baseprice;
    }

    public void setBaseprice(double baseprice)
    {
        this.baseprice = baseprice;
    }

    public ArrayList<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Reviews> reviews) {
        this.reviews = reviews;
    }

}
