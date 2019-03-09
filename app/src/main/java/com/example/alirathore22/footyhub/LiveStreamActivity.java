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

public class LiveStreamActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestream);
        TextView title = (TextView) findViewById(R.id.activityTitle2);
        title.setText("This is the LiveStreaming Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //to not have home button always highlighted
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent(LiveStreamActivity.this, ProfileActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.ic_fixtures:
                        Intent intent1 = new Intent(LiveStreamActivity.this, FixturesActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_livestream:

                        break;
                    case R.id.ic_tables:
                        Intent intent2 = new Intent(LiveStreamActivity.this, TablesActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_extras:
                        Intent intent3 = new Intent(LiveStreamActivity.this, ExtraActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
