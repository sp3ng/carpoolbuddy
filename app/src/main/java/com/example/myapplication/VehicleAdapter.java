package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter <VehiclesHolder>
{
    FirebaseFirestore firestore;
    ArrayList<bigVehicles> allofthevehicles;
    Context ctx;
    OnItemClickListener vListener;
    OnItemClickListener rListener;
//    String veename;
//    int seatasleft;
//    double price;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
//        void onAddClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener)
    {
        vListener = listener;
        rListener = listener;
    }

    public VehicleAdapter(ArrayList<bigVehicles> allvehicles, Context ctx)
    {
        allofthevehicles = allvehicles;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VehiclesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View myView = LayoutInflater.from(this.ctx).inflate(R.layout.vehiclerowview, parent, false);
        VehiclesHolder holder = new VehiclesHolder(myView, vListener);
        firestore = FirebaseFirestore.getInstance();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesHolder holder, int position)
    {
        bigVehicles currentvehicle = (allofthevehicles.get(position));
//        veename = currentvehicle.getModel();
//        seatasleft = currentvehicle.getCapacity();
//        price = currentvehicle.getBaseprice();
        holder.deVehicle.setText("name: " + currentvehicle.getModel());
        holder.deseatsleft.setText("seatd left:" + Integer.toString(currentvehicle.getCapacity()));
        holder.destatusoc.setText("price:" + Double.toString(currentvehicle.getBaseprice()));

    }

    @Override
    public int getItemCount() {
        return allofthevehicles.size();
    }
}
