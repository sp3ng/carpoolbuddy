package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Loginpage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static FirebaseFirestore mFstore;
    private EditText enteremaill;
    private EditText enterpasswordd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        mAuth = FirebaseAuth.getInstance();
        mFstore = FirebaseFirestore.getInstance();
        enteremaill = findViewById(R.id.daemail);
        enterpasswordd = findViewById(R.id.dapassword);

    }
    public void updateUI(FirebaseUser user)
    {
        if (user!=null)
        {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        }
    }
    public void signin(View v)
    {
        System.out.println("log in");
        String eemail = enteremaill.getText().toString();
        String ppassword = enterpasswordd.getText().toString();
        System.out.println(String.format("email: %s and password: %s",eemail,ppassword));

        mAuth.signInWithEmailAndPassword(eemail, ppassword).addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    System.out.println("ayoswaggers");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else
                {
                    System.out.println("ohnowhatamigonnado");
                    Toast.makeText(Loginpage.this,"AuthFailed",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

}