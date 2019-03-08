package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ProfileActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private FirebaseAuth firebaseAuth;

    private Button buttonLogout;
    private TextView viewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //setting tab icons here we have to change them after deciding how to use them
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_file_download_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_file_upload_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_filter_frames_black_24dp);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

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

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
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
