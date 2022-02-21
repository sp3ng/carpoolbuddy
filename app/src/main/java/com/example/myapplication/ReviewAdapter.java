package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter <ReviewsHolder>
{
    ArrayList<Reviews> allreviews;
    LayoutInflater inflater;
    public ReviewAdapter(ArrayList<Reviews> allreviews)
    {
        this.allreviews = allreviews;

    }

    @NonNull
    @Override
    public ReviewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviewviewrow, parent);
        ReviewsHolder holder = new ReviewsHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsHolder holder, int position)
    {
        Reviews currreview = allreviews.get(position);
        holder.deReview.setText(currreview.getReviewss());
        holder.deagreenum.setText(Integer.toString(currreview.getAgreenum()));
    }

    @Override
    public int getItemCount() {
        return allreviews.size();
    }
}
