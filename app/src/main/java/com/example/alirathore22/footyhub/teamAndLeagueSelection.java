package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class teamAndLeagueSelection extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    Button logOut;
    Button done;
    GridLayout mainGrid;
    CardView cardView_1;
    String keyword = " ";
    Intent profileActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_and_league_selection);

        cardView_1 = findViewById(R.id.barcelona_card);
        cardView_1.setOnClickListener(this);

        profileActivity = new Intent(this, ProfileActivity.class);

        mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        SetToggleEvent(mainGrid);

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
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            final CardView cardView=(CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1)
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    }
                    else
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
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
            finish();
            profileActivity.putExtra("keyword", keyword);
            startActivity(profileActivity);
        }
        if (v.getId() == R.id.barcelona_card)
        {
            keyword += "barcelona ";
        }

    }
}
