package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ExtraActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;
    private TextView viewEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        TextView title = (TextView) findViewById(R.id.activityTitle4);
        title.setText("This is the Extras Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //to not have home button always highlighted
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent(ExtraActivity.this, ProfileActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.ic_fixtures:
                        Intent intent1 = new Intent(ExtraActivity.this, FixturesActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_livestream:
                        Intent intent2 = new Intent(ExtraActivity.this, LiveStreamActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_tables:
                        Intent intent3 = new Intent(ExtraActivity.this, TablesActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_extras:

                        break;
                }
                return false;
            }
        });
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
