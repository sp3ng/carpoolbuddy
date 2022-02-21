package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewAuthActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_auth);
        if (findViewById(R.id.buttonlog).isClickable())
        {
            System.out.println("Say what abridgment have you for this evening?");
        }

    }
    public void newsignup(View v)
    {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
    public void newlogin(View v)
    {
//        System.out.println("Say what abridgment have you for this evening?");
        Intent intent = new Intent(this, Loginpage.class);
        startActivity(intent);
    }
}