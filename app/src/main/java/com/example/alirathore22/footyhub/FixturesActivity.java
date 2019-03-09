package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FixturesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        TextView title = (TextView) findViewById(R.id.activityTitle1);
        title.setText("This is the Fixtures Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //to not have home button always highlighted
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent(FixturesActivity.this, ProfileActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.ic_fixtures:

                        break;
                    case R.id.ic_livestream:
                        Intent intent1 = new Intent(FixturesActivity.this, LiveStreamActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_tables:
                        Intent intent2 = new Intent(FixturesActivity.this, TablesActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_extras:
                        Intent intent3 = new Intent(FixturesActivity.this, ExtraActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
