package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class teamAndLeagueSelection extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    Button logOut;
    Button done;
    GridLayout mainGrid;
    CardView cd;
    Intent profileActivity;

    private DatabaseReference mDatabase;
    List<Integer> selected = new ArrayList<Integer>();
    List<String> selected_val = new ArrayList<String>();
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_and_league_selection);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        SetToggleEvent(mainGrid);

        email = getIntent().getStringExtra("email");
        Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
        Log.d("email", "get_vals: " + email);

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

    private void SetToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        cardView.setCardBackgroundColor(Color.parseColor("#daa520"));
                        selected.add(finalI);
                    } else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        int index = selected.indexOf(5);
                        selected.remove(index);
                    }
                }
            });
        }
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
            get_vals();
            finish();
            Intent intent = new Intent(this, ProfileActivity.class);
//            intent.putExtra("teams", selected_val.toString().substring(1,selected_val.size()-2));
            startActivity(intent);
        }
    }

    private void get_vals() {
        for(int i=0;i<selected.size();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(selected.get(i));
            ViewGroup viewGroup = ((ViewGroup)cardView.getChildAt(0));
            String getName = ((TextView)viewGroup.getChildAt(1)).getText().toString();
            selected_val.add(getName);
        }

//        Toast.makeText(teamAndLeagueSelection.this, selected_val.toString(), Toast.LENGTH_LONG).show();
        String user = firebaseAuth.getCurrentUser().getEmail().split("@")[0];
        Log.d("FBUSER", user);
//            mDatabase.child("users").child(user).setValue(getName);
        mDatabase.child("users").child(user).setValue(selected_val);
    }

}
