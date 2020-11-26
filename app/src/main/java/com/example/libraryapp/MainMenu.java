package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

private Button catalogue_btn;
private Button view_profile_btn;
private Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        log_out = (Button)findViewById(R.id.log_out);
        catalogue_btn = (Button)findViewById(R.id.catalogue_btn);
        view_profile_btn = (Button)findViewById(R.id.view_accountbtn);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        catalogue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainMenu.this, ViewCatalogue.class);
                startActivity(intent);
                finish();
            }
        });

        view_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
