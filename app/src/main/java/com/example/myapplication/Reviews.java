package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Reviews extends AppCompatActivity {
    private int agreenum;
    private int diagreenum;
    private String reviewss;

    public int getAgreenum() {
        return agreenum;
    }

    public void setAgreenum(int agreenum) {
        this.agreenum = agreenum;
    }

    public int getDiagreenum() {
        return diagreenum;
    }

    public void setDiagreenum(int diagreenum) {
        this.diagreenum = diagreenum;
    }

    public String getReviewss() {
        return reviewss;
    }

    public void setReviewss(String reviews) {
        this.reviewss = reviewss;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
    }

    public Reviews(int agreenum, int diagreenum, String reviewss)
    {
        this.agreenum = agreenum;
        this.diagreenum = diagreenum;
        this.reviewss = reviewss;
    }
}