package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class showReviewsAndAddReviews extends VehiclesInfoActivity
{
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore firestore;
    private ArrayList<Reviews> allreviews;
    private ArrayList<String> allonlyreviews;
    private ArrayList<String> allagreenums;
    private bigVehicles currentVehicle;
    private TextInputEditText getreview;
    RecyclerView reviewView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reviews_and_add_reviews);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        currentVehicle = currvehicle;
        getreview = findViewById(R.id.reviewinput);
        reviewView = findViewById(R.id.recyclerView);
        allreviews = currentVehicle.getReviews();
        for (Reviews rev : allreviews)
        {
            allonlyreviews.add(rev.getReviewss());
        }
        for (Reviews ree : allreviews)
        {
            allagreenums.add(Integer.toString(ree.getAgreenum()));
        }
        ReviewAdapter deadapter = new ReviewAdapter(allreviews);
        reviewView.setAdapter(deadapter);
        reviewView.setItemAnimator(new DefaultItemAnimator());
    }
    public void addreviews(View v)
    {
        String review = getreview.getText().toString();
        String id = currvehicle.getVeID();
        DocumentReference updateinfo = firestore.collection("Vehicles").document(id);
        updateinfo.update("Reviews", currvehicle.getRiderID().add(review));
    }

}