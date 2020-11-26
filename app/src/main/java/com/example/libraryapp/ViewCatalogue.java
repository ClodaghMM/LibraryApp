package com.example.libraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ViewCatalogue extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView catalogueList;
    private Button add_btn;
    private Button go_back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
        catalogueList = (ListView)findViewById(R.id.cataogue_list);
        add_btn = (Button)findViewById(R.id.add_book_btn);
        go_back_btn = (Button)findViewById(R.id.return_to_main_btn);

        go_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCatalogue.this, MainMenu.class);
                startActivity(intent);
                finish();
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCatalogue.this, AddBook.class);
                startActivity(intent);
                finish();
            }
        });


}}
