package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
private EditText inputEmail, inputPassword;
private Button Signup_btn;
private Button return_btn;
private FirebaseAuth auth;
private String emailHolder, passwordHolder;
private FirebaseAuth firebaseAuth;
boolean edittextstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//This gives us access to the instance of the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

      //  DatabaseReference myRef = database.getReference();

        //Initialises a new firebase object
        firebaseAuth = firebaseAuth.getInstance();

        //Code to go back to the main page.
        return_btn.findViewById(R.id.back);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





}}
