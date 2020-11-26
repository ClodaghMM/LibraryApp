package com.example.libraryapp;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class AddBook extends AppCompatActivity {

    private EditText BookName;
    private EditText Author;
    private Button addBook_btn;
    private Button return_to_catalogue_btn;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
    }
}
