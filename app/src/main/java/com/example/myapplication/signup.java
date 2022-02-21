package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class signup extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    private static FirebaseFirestore mFstore;
    private EditText enteremail;
    private EditText enterpassword;
    private TextInputEditText enteraftertype;
    private EditText entername;
    private Button studentch;
    private Button teacherch;
    private Button aluminich;
    private Button parentch;
    private Button signinbutton;
    private FirebaseUser signedupuser;
    private User signupuser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        mFstore = FirebaseFirestore.getInstance();
        enteremail = findViewById(R.id.editTextTextEmailAddress);
        enterpassword = findViewById(R.id.editTextTextPassword);
        entername = findViewById(R.id.name);
        enteraftertype = findViewById(R.id.afterselectingtype);
        studentch = findViewById(R.id.studentchoice);
        teacherch = findViewById(R.id.techerchoice);
        aluminich = findViewById(R.id.aluminichoice);
        parentch = findViewById(R.id.parentchoice);
        signinbutton = findViewById(R.id.button);

    }
    public void signupparent(View v)
    {
        String eemail = enteremail.getText().toString();
        String ppassword = enterpassword.getText().toString();
        String name = entername.getText().toString();
        mAuth.createUserWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful()) {
                    Log.d("SIGN UP", "SUCCESSFULLY SIGNED UP");
                    FirebaseUser user = mAuth.getCurrentUser();
                    enteraftertype.setHint("children");
                    String children = enteraftertype.getText().toString();
                    ArrayList<String>childrens;
                    if(children.contains(","))
                    {
                        childrens = new ArrayList<String>(Arrays.asList(children.split(",")));
                    }
                    else
                    {
                        childrens = new ArrayList<String>();
                        childrens.add(children);
                    }
                    parent parrot = new parent(user.getUid(), name, eemail, "parent", 1, new ArrayList<String>(), 1000, childrens);
                    signup.mFstore.collection("Users").document(user.getUid()).set(parrot);
//                    updateUI(user);
                }
                else
                {
                    Log.w("SIGN UP", "createuserwithemail:failed",task.getException());
                    updateUI(null);
                }

            }
        });

    }

    public void signupstudent(View v)
    {
        System.out.println("wassupshawtytakemeouttodinner");
        String eemail = enteremail.getText().toString();
        String ppassword = enterpassword.getText().toString();
        String name = entername.getText().toString();
        mAuth.createUserWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful()) {
                    Log.d("SIGN UP", "SUCCESSFULLY SIGNED UP");
                    FirebaseUser user = mAuth.getCurrentUser();
                    enteraftertype.setHint("graduation year");
                    String graduationYear = enteraftertype.getText(). toString();
                    student stud = new student(user.getUid(), name, eemail, "student", 0.5, new ArrayList<String>(), 1000, graduationYear, new ArrayList<String>());
                    signup.mFstore.collection("Users").document(user.getUid()).set(stud);
//                    updateUI(user);
                }
                else
                {
                    Log.w("SIGN UP", "createuserwithemail:failed",task.getException());
                    updateUI(null);
                }

            }
        });

    }

    public void signupteacher(View v)
    {
        String eemail = enteremail.getText().toString();
        String ppassword = enterpassword.getText().toString();
        String name = entername.getText().toString();
        mAuth.createUserWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful()) {
                    Log.d("SIGN UP", "SUCCESSFULLY SIGNED UP");
                    FirebaseUser user = mAuth.getCurrentUser();
                    enteraftertype.setHint("in school title");
                    String inschooltit = enteraftertype.getText().toString();
                    teacher tech = new teacher(user.getUid(), name, eemail, "teacher", 0.5, new ArrayList<String>(), 1000, inschooltit);
                    signup.mFstore.collection("Users").document(user.getUid()).set(tech);
//                    updateUI(user);
                }
                else
                {
                    Log.w("SIGN UP", "createuserwithemail:failed",task.getException());
//                    updateUI(null);
                }

            }
        });

    }

    public void signupalum(View v)
    {
        String eemail = enteremail.getText().toString();
        String ppassword = enterpassword.getText().toString();
        String name = entername.getText().toString();
        mAuth.createUserWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Log.d("SIGN UP", "SUCCESSFULLY SIGNED UP");
                    FirebaseUser user = mAuth.getCurrentUser();
                    enteraftertype.setHint("graduation year");
                    String gradyr = enteraftertype.getText().toString();
                    alumini aloo = new alumini(user.getUid(), name, eemail, "alumini", 1, new ArrayList<String>(), 1000, gradyr);
                    signup.mFstore.collection("Users").document(user.getUid()).set(aloo);
//                    updateUI(user);
                }
                else
                {
                    Log.w("SIGN UP", "createuserwithemail:failed",task.getException());
//                    updateUI(null);
                }

            }
        });

    }

    public void signup(View v)
    {
        signedupuser = mAuth.getCurrentUser();
        try
        {
            mFstore.collection("User").get().addOnCompleteListener(this, new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task)
                {
                    for (QueryDocumentSnapshot theuser : Objects.requireNonNull(task.getResult()))
                    {
                        signupuser = theuser.toObject(User.class);
                        if (signupuser.getName().equals(entername.getText().toString()))
                        {
                            if (signupuser.getUsertype().equals("student"))
                            {
                                DocumentReference updateinfo = mFstore.collection("User").document(signupuser.getUid());
                                updateinfo.update("graduationyear",enteraftertype.getText().toString());
                                signedupuser = mAuth.getCurrentUser();
                                updateUI(signedupuser);

                            }
                            if (signupuser.getUsertype().equals("teacher"))
                            {
                                DocumentReference updateinfo = mFstore.collection("User").document(signupuser.getUid());
                                updateinfo.update("inschooltitle",enteraftertype.getText().toString());
                                signedupuser = mAuth.getCurrentUser();
                                updateUI(signedupuser);
                            }
                            if (signupuser.getUsertype().equals("parent"))
                            {
                                String children = enteraftertype.getText().toString();
                                ArrayList<String>childrens;
                                if(children.contains(","))
                                {
                                    childrens = new ArrayList<String>(Arrays.asList(children.split(",")));
                                }
                                else
                                {
                                    childrens = new ArrayList<String>();
                                    childrens.add(children);
                                }
                                DocumentReference updateinfo = mFstore.collection("User").document(signupuser.getUid());
                                updateinfo.update("childrenuids",childrens);
                                signedupuser = mAuth.getCurrentUser();
                                updateUI(signedupuser);
                            }
                            if (signupuser.getUsertype().equals("alumini"))
                            {
                                DocumentReference updateinfo = mFstore.collection("User").document(signupuser.getUid());
                                updateinfo.update("graduationyear",enteraftertype.getText().toString());
                                signedupuser = mAuth.getCurrentUser();
                                updateUI(signedupuser);
                            }
                        }

                    }
                }
            });

        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        System.out.println("alright");
        updateUI(signedupuser);


//        System.out.println("sign up");
//        String eemail = enteremail.getText().toString();
//        String ppassword = enterpassword.getText().toString();
//        String name = entername.getText().toString();
//
//        mAuth.createUserWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task)
//            {
//                if (task.isSuccessful())
//                {
//                    Log.d("SIGN UP", "SUCCESSFULLY SIGNED UP");
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    if(parentch.isPressed())
//                    {
//                        enteraftertype.setHint("children");
//                        String children = enteraftertype.getText().toString();
//                        ArrayList<String>childrens;
//                        if(children.contains(","))
//                        {
//                            childrens = new ArrayList<String>(Arrays.asList(children.split(",")));
//                        }
//                        else
//                        {
//                            childrens = new ArrayList<String>();
//                            childrens.add(children);
//                        }
//                        parent parrot = new parent(user.getUid(), name, eemail, "parent", 1, new ArrayList<String>(), 1000, childrens);
//                        signup.mFstore.collection("Users").document(user.getUid()).set(parrot);
//                    }
//                    else if(teacherch.isPressed())
//                    {
//                        enteraftertype.setHint("in school title");
//                        String inschooltit = enteraftertype.getText().toString();
//                        teacher tech = new teacher(user.getUid(), name, eemail, "teacher", 0.5, new ArrayList<String>(), 1000, inschooltit);
//                        signup.mFstore.collection("Users").document(user.getUid()).set(tech);
//                    }
//                    else if(aluminich.isPressed())
//                    {
//                        enteraftertype.setHint("graduation year");
//                        String gradyr = enteraftertype.getText().toString();
//                        alumini aloo = new alumini(user.getUid(), name, eemail, "alumini", 1, new ArrayList<String>(), 1000, gradyr);
//                        signup.mFstore.collection("Users").document(user.getUid()).set(aloo);
//
//                    }
//                    else if(studentch.isPressed())
//                    {
//                        enteraftertype.setHint("graduation year");
//                        String graduationYear = enteraftertype.getText(). toString();
//                        student stud = new student(user.getUid(), name, eemail, "stude t", 0.5, new ArrayList<String>(), 1000, graduationYear, new ArrayList<String>());
//                        signup.mFstore.collection("Users").document(user.getUid()).set(stud);
//
//                    }
//                    updateUI(user);
//                }
//                else
//                {
//                    Log.w("SIGN UP", "createuserwithemail:failed",task.getException());
//                    updateUI(null);
//                }
//
//            }
//        });
    }
    public void updateUI(FirebaseUser user)
    {
            System.out.println("button clicked");
            if (user != null)
            {
                Intent intent = new Intent(this, UserProfileActivity.class);
                startActivity(intent);
            }
    }
}