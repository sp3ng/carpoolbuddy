package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class VehiclesInfoActivity extends AppCompatActivity
{
    public FirebaseAuth mAuth;
    public FirebaseUser mUser;
    public FirebaseFirestore firestore;
    public static ArrayList<bigVehicles> allavailableVehicles;
    public static bigVehicles currvehicle;
    RecyclerView VehiclesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        allavailableVehicles = new ArrayList<bigVehicles>();
        VehiclesView = findViewById(R.id.vhlistview);
        getAndPopulateData();

    }
    public void getAndPopulateData()
    {
        ArrayList<bigVehicles> thelist = new ArrayList<>();
        try
        {
            firestore.collection("Vehicles").get().addOnCompleteListener(this, new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task)
                {
                    if (task.isSuccessful())
                    {
                        for (QueryDocumentSnapshot vehicle : Objects.requireNonNull(task.getResult()))
                        {
                            bigVehicles v = vehicle.toObject(bigVehicles.class);
                            if (v.isOpen())
                            {
                                thelist.add(v);
                            }
                        }
                        allavailableVehicles = thelist;
                        VehicleAdapter daadapter = new VehicleAdapter(allavailableVehicles, getBaseContext());
                        VehiclesView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        VehiclesView.setAdapter(daadapter);
                        VehiclesView.setItemAnimator(new DefaultItemAnimator());
                        try
                        {
                            daadapter.setOnItemClickListener(new VehicleAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    currvehicle=allavailableVehicles.get(position);
                                    Intent intent = new Intent(getBaseContext(), VehicleProfileActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        catch (Exception error){}
                    }
                    else
                    {
                        Toast.makeText(VehiclesInfoActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }
    public void goToAddVehicle(View v)
    {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
    }
    public void seevehicle(View v)
    {
        currvehicle = allavailableVehicles.get(getCurrentFocus().getVerticalScrollbarPosition());
        Intent intent = new Intent(this, VehicleProfileActivity.class);
        startActivity(intent);
    }
//    public void seereviews(View v)
//    {
//        Intent intenttt = new Intent(this, showReviewsAndAddReviews.class);
//        startActivity(intenttt);
//    }
//    public void bookride(View v)
//    {
//        currvehicle = allavailableVehicles.get(getCurrentFocus().getVerticalScrollbarPosition());
//        if(currvehicle.getCapacity() != 0)
//        {
//            if (currvehicle.getRiderID().contains(mUser.getUid()))
//            {
//                Toast.makeText(VehiclesInfoActivity.this,"you booked it already",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, VehiclesInfoActivity.class);
//                startActivity(intent);
//            }
//            else
//            {
//                String id = currvehicle.getVeID();
//                DocumentReference updateinfo = firestore.collection("Vehicles").document(id);
//                updateinfo.update("capacity",currvehicle.getCapacity()-1);
//                updateinfo.update("riderID", currvehicle.getRiderID().add(mUser.getUid()));
//                Toast.makeText(VehiclesInfoActivity.this,"u booked it",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, VehiclesInfoActivity.class);
//                startActivity(intent);
//
//            }
//        }
//        else
//        {
//            Toast.makeText(VehiclesInfoActivity.this,"u cannot book it it's full",Toast.LENGTH_SHORT).show();
//        }
//    }
}