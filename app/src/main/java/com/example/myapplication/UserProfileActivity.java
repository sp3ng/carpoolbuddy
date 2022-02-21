package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.rpc.context.AttributeContext;

public class UserProfileActivity extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private static FirebaseFirestore firestore;
    private TextView name;
    private TextView type;


    //layout objects
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        firestore = FirebaseFirestore.getInstance();
        name = findViewById(R.id.usersname);
        type = findViewById(R.id.usertype);
        updateScreen(FirebaseAuth.getInstance().getCurrentUser());
    }

    public void updateScreen(FirebaseUser user)
    {
        firestore.collection("Users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if(task.isSuccessful())
                {
                    DocumentSnapshot deez = task.getResult();
                    User curruser = deez.toObject(User.class);
                    name.setText(curruser.getName());
                    type.setText(curruser.getUsertype());
                }
                else
                {
                    Toast.makeText(UserProfileActivity.this,"task failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void signOut(View v)
    {
        mAuth.signOut();
        Intent intent = new Intent(this, NewAuthActivity.class);
        finish();
        startActivity(intent);
    }

    public void seeVehicles(View v)
    {
        Intent intent = new Intent(this, VehiclesInfoActivity.class);
        startActivity(intent);
    }

}