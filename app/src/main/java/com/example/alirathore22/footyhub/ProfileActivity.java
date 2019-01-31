package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private Button buttonLogout;
    private TextView viewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        //setting user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonLogout = findViewById(R.id.buttonLogout);
        viewEmail = findViewById(R.id.viewEmail);

        buttonLogout.setOnClickListener(this);

        //getting email for current user and setting in Text View.
        viewEmail.setText("Select the option "+user.getEmail());
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogout){
            //logging out current user and starting the login Activity
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }
    }
}
