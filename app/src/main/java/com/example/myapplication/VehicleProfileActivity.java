package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class VehicleProfileActivity extends VehiclesInfoActivity
{
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    bigVehicles currentvehicle;
    FirebaseFirestore firestore;
    TextView vname;
    TextView vcap;
    TextView vprice;
    TextView openornot;
    Button open;
    Button close;
    Button bookride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        currentvehicle = currvehicle;
        vname = findViewById(R.id.vname);
        vcap = findViewById(R.id.vcap);
        vprice = findViewById(R.id.vprice);
        openornot = findViewById(R.id.openedotnot);
        open = findViewById(R.id.openbutton);
        close = findViewById(R.id.bookbutton);
        bookride = findViewById(R.id.closebutton);
        vname.setText(currentvehicle.getModel());
        vcap.setText(Integer.toString(currentvehicle.getCapacity()));
        vprice.setText(Double.toString(currentvehicle.getBaseprice()));
        if (currentvehicle.isOpen())
        {
            openornot.setText("open");
        }
        else
        {
            openornot.setText("closed");
        }

    }
    void setUpButton()
    {
        if(mUser.getUid().equals(currentvehicle.getOwner()))
        {
            bookride.setVisibility(View.GONE);
        }
        else
        {
            open.setVisibility(View.GONE);
            close.setVisibility(View.GONE);
        }
    }

    public void bookRide(View v)
    {
        if(currentvehicle.getCapacity() != 0)
        {
            if (currentvehicle.getRiderID().contains(mUser.getDisplayName()))
            {
                Toast.makeText(VehicleProfileActivity.this,"you booked it already",Toast.LENGTH_SHORT).show();
            }
            else
                {
                    String id = currentvehicle.getVeID();
                    DocumentReference updateinfo = firestore.collection("Vehicles").document(id);
                    updateinfo.update("capacity",currentvehicle.getCapacity()-1);
                    updateinfo.update("riderID", currentvehicle.getRiderID().add(mUser.getDisplayName()));
                    Toast.makeText(VehicleProfileActivity.this,"u booked it",Toast.LENGTH_SHORT).show();

                }
        }
        else
            {
                Toast.makeText(VehicleProfileActivity.this,"u cannot book it it's full",Toast.LENGTH_SHORT).show();
            }
    }
    public void open(View v)
    {
        try
        {
            String id = currentvehicle.getVeID();
            DocumentReference updateinfo = firestore.collection("Vehicles").document(id);
            updateinfo.update("open", true);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
    public void close(View v)
    {
        try
        {
            String id = currentvehicle.getVeID();
            DocumentReference updateinfo = firestore.collection("Vehicles").document(id);
            updateinfo.update("open", false);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
    public void gotoseereview (View v)
    {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
    }
}