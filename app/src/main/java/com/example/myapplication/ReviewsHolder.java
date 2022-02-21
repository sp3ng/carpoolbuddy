package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewsHolder extends RecyclerView.ViewHolder
{
    TextView deReview;
    TextView deagreenum;

    public ReviewsHolder(@NonNull View itemView)
    {
        super(itemView);
        deReview = (TextView) itemView.findViewById(R.id.thereview);
        deagreenum = (TextView) itemView.findViewById(R.id.agreenum);
    }
}
