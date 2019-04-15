package com.example.alirathore22.footyhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FixturesActivity extends Fragment {

    private FragmentManager fragmentManager;

    private FragmentTransaction ft;
    private Fragment frag;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fixtures);

        fragmentManager = getFragmentManager();

        if (fragmentManager == null)
        {
            Toast.makeText(getContext(), "fragment manager null", Toast.LENGTH_LONG).show();
        }
        else
        {
            ft = fragmentManager.beginTransaction();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        View view = inflater.inflate(R.layout.activity_fixtures, container, false);

        TextView title = (TextView) view.findViewById(R.id.activityTitle1);
        title.setText("This is the Fixtures Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //to not have home button always highlighted
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        set_botton_navigation_listener(bottomNavigationView);

        return view;
    }

    public void set_botton_navigation_listener(BottomNavigationView bottomNavigationView)
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        startActivity(new Intent(getContext(), ProfileActivity.class));
                        break;
                    case R.id.ic_fixtures:
////                        Intent intent = new Intent(ProfileActivity.this, FixturesActivity.class);
////                        startActivity(intent);
//                        frag = new FixturesActivity();
//                        ft.replace(R.id.mainLayout, frag);
////                        ft.addToBackStack(stack);
//                        ft.commit();
                        break;
                    case R.id.ic_livestream:
//                        Intent intent1 = new Intent(ProfileActivity.this, LiveStreamActivity.class);
//                        startActivity(intent1);
                        frag = new LiveStreamActivity();
                        ft.replace(R.id.mainLayout, frag);
//                        ft.addToBackStack(stack);
                        ft.commit();
                        break;
                    case R.id.ic_tables:
//                        Intent intent2 = new Intent(ProfileActivity.this, TablesActivity.class);
//                        startActivity(intent2);
                        frag = new TablesActivity();
                        ft.replace(R.id.mainLayout, frag);
//                        ft.addToBackStack(stack);
                        ft.commit();
                        break;
                    case R.id.ic_extras:
                        frag = new ExtraActivity();
                        ft.replace(R.id.mainLayout, frag);
//                        ft.addToBackStack(stack);
                        ft.commit();
                        break;
                }
                return false;
            }
        });
    }
}
