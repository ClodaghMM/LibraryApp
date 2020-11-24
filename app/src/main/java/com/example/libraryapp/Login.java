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

public class Login extends AppCompatActivity {

    private Button login_btn;
    private EditText emailAddress_login;
    private EditText password_login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    login_btn.findViewById(R.id.login_btn);
    emailAddress_login.findViewById(R.id.email_Input);
    password_login.findViewById(R.id.password_login);

    auth = FirebaseAuth.getInstance();
    login_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = emailAddress_login.getText().toString();
            final String password = password_login.getText().toString();
            if(TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter Email Address", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                return;
            }
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(!task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(Login.this, MainMenu.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    });

    }
}
