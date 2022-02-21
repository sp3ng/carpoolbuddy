package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AddVehicleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static FirebaseFirestore firestore;
    private FirebaseUser mUser;
    private TextInputEditText owner;
    private EditText vtype;
    private EditText capacity;
    private EditText model;
    private EditText vid;
    private EditText baseprice;
    private EditText carboatange;
    private EditText biketype;
    private EditText bikeweight;
    private EditText bikeweightcapacity;
    private EditText maxaltitude;
    private EditText maxairspeed;
    private EditText segwayrange;
    private EditText segwayweightcapacity;
    public bigVehicles currvehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        firestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        owner = findViewById(R.id.ownertype);
        vtype = findViewById(R.id.vtypet);
        capacity = findViewById(R.id.capt);
        model = findViewById(R.id.modelt);
        vid = findViewById(R.id.vehidt);
        baseprice = findViewById(R.id.basepricet);
        carboatange = findViewById(R.id.ranget);
        biketype = findViewById(R.id.biketypet);
        bikeweight = findViewById(R.id.weightt);
        bikeweightcapacity = findViewById(R.id.weightcapt);
        maxaltitude = findViewById(R.id.maxaltt);
        maxairspeed = findViewById(R.id.maxairt);
        segwayrange = findViewById(R.id.segwayranget);
        segwayweightcapacity = findViewById(R.id.segweightcapt);

    }

    public void addNewVehicle(View v)
    {

        try {
            String nameowner = owner.getText().toString();
            String vehicletype = vtype.getText().toString();
            int vehiclecapacity = Integer.parseInt(capacity.getText().toString());
            String vehiclemodel = model.getText().toString();
            String vehicleid = vid.getText().toString();
            double bassprice = Double.parseDouble(baseprice.getText().toString());

            if (vehicletype.toLowerCase().equals("boat"))
            {
                int rangecarorboat = Integer.parseInt(carboatange.getText().toString());
                oversea newc = new oversea(nameowner, vehiclemodel, vehiclecapacity, vehicleid, new ArrayList<String>(), true, vehicletype, bassprice, new ArrayList<Reviews>(), rangecarorboat);
                firestore.collection("Vehicles").document(vehicleid).set(newc);
                currvehicle = newc;
            }
            if (vehicletype.toLowerCase().equals("car"))
            {
                int rangecarorboat = Integer.parseInt(carboatange.getText().toString());
                car newc = new car(nameowner, vehiclemodel, vehiclecapacity, vehicleid, new ArrayList<String>(), true, vehicletype, bassprice, new ArrayList<Reviews>(), rangecarorboat);
                firestore.collection("Vehicles").document(vehicleid).set(newc);
                currvehicle = newc;
            }
            if (vehicletype.toLowerCase().equals("segway"))
            {
                int rangeseg = Integer.parseInt(segwayrange.getText().toString());
                int capseg = Integer.parseInt(segwayweightcapacity.getText().toString());
                Segway newc = new Segway(nameowner, vehiclemodel, vehiclecapacity, vehicleid, new ArrayList<String>(), true, vehicletype, bassprice, new ArrayList<Reviews>(), rangeseg, capseg);
                firestore.collection("Vehicles").document(vehicleid).set(newc);
                currvehicle = newc;
            }
            if (vehicletype.toLowerCase().equals("bike") || vehicletype.toLowerCase().equals("bicycle") || vehicletype.toLowerCase().equals("motorcycle"))
            {
                String dabiketype = biketype.getText().toString();
                int weightbike = Integer.parseInt(bikeweight.getText().toString());
                int weightcapbike = Integer.parseInt(bikeweightcapacity.getText().toString());
                bikesormotors newc = new bikesormotors(nameowner, vehiclemodel, vehiclecapacity, vehicleid, new ArrayList<String>(), true, vehicletype, bassprice, new ArrayList<Reviews>(), dabiketype, weightbike, weightcapbike);
                firestore.collection("Vehicles").document(vehicleid).set(newc);
                currvehicle = newc;
            }
            if (vehicletype.toLowerCase().equals("plane"))
            {
                int altitude = Integer.parseInt(maxaltitude.getText().toString());
                int airspeed = Integer.parseInt(maxairspeed.getText().toString());
                inair newc = new inair(nameowner, vehiclemodel, vehiclecapacity, vehicleid, new ArrayList<String>(), true, vehicletype, bassprice, new ArrayList<Reviews>(), altitude, airspeed);
                firestore.collection("Vehicles").document(vehicleid).set(newc);
                currvehicle = newc;
            }
            Intent intent = new Intent(this, VehicleProfileActivityForAddVehicle.class);
            startActivity(intent);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }


    }
}