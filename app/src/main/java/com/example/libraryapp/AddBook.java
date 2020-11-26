package com.example.libraryapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        setContentView(R.layout.activity_adding_book);

        BookName = (EditText) findViewById(R.id.book_title);
        Author = (EditText)findViewById(R.id.author_title);
        addBook_btn = (Button) findViewById(R.id.Add_To_Catalogue_Btn);
        return_to_catalogue_btn =(Button) findViewById(R.id.go_back_n);

        return_to_catalogue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBook.this, ViewCatalogue.class);
                startActivity(intent);
                finish();
            }
        });

        firebaseDatabase.getInstance().getReference().child("Book");

        addBook_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBookToCatalogue();
            }
        }); }

            private void AddBookToCatalogue() { //Change this to add the datasnapshot
            String title = BookName.getText().toString();
            String author = Author.getText().toString();
            Book book = new Book(title, author);
            //Add to the database.
            assert title != null; //Not sure about this line, enquire about it.
            firebaseDatabase.getReference().child("Book");
            Toast.makeText(AddBook.this,"Book Added!",Toast.LENGTH_SHORT).show();
    }





}
