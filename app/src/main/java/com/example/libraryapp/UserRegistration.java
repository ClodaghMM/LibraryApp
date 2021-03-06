package com.example.libraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistration extends AppCompatActivity {
private EditText inputEmail, inputPassword;
private Button Signup_btn;
private Button return_btn;
private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        inputEmail = (EditText) findViewById(R.id.emailinput);
        inputPassword = (EditText) findViewById(R.id.password_input);
        Signup_btn = (Button) findViewById(R.id.register);
        return_btn = findViewById(R.id.back);

//This gives us access to the instance of the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

      //  DatabaseReference myRef = database.getReference();

        //Initialises a new firebase object
        firebaseAuth = firebaseAuth.getInstance();

        //Code to go back to the main page.

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserRegistration.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                registerUser();
            }
        });
}



//Consider whether or not you still need this block of code.
private void Registration() {
        firebaseAuth.createUserWithEmailAndPassword("user email here", "user password here")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                        }
                        else {}}}); }
                        //Consider whether you need the block of code above.

private void registerUser() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {

        Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
        return;
    }

    if(TextUtils.isEmpty(password)) {

        Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
        return;
    }

    //creating a new user
    firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(UserRegistration.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Toast.makeText(UserRegistration.this,"Registration Error",Toast.LENGTH_LONG).show();
;                    }
                }
            });
}
}
