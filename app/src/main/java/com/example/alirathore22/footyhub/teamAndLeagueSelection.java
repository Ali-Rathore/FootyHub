package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class teamAndLeagueSelection extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    Button logOut;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_and_league_selection);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        //setting user
        FirebaseUser user = firebaseAuth.getCurrentUser();


        logOut = findViewById(R.id.logoutButton);
        done = findViewById(R.id.doneButton);
        logOut.setOnClickListener(this);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //logging out current user and starting the login Activity
        if(v == logOut ){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(v == done){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

    }
}
