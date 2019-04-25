package com.example.alirathore22.footyhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alirathore22.footyhub.models.Event;
import com.example.alirathore22.footyhub.models.Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class FixturesActivity extends Fragment {

    private FragmentManager fragmentManager;

    private FragmentTransaction ft;
    private Fragment frag;

    RecyclerView myView;
    MatchFixtureAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RequestQueue mRequestQueue;
    GsonBuilder gsonBuilder;
    Gson gson;
    ProgressDialog pDialog;
    List<Event> table;

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

        myView = view.findViewById(R.id.fixtures_view);
        get_fixtures();

        //TextView title = (TextView) view.findViewById(R.id.activityTitle1);
        //title.setText("This is the Fixtures Activity");

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

    public void get_fixtures()
    {
        String tag_json_arry = "json_array_req";

        String url = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328";

        mRequestQueue = Volley.newRequestQueue(getContext());

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        pDialog = new ProgressDialog(   getContext());
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest req = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("events");

                    table = Arrays.asList(gson.fromJson(jsonArray.toString(), Event[].class));
                    Log.d("Response:",  table.toString());

                    for (int i = 0; i < table.size(); i++)
                        Log.d("Data: ", table.get(i).getStrEvent());

//                    layoutManager = new LinearLayoutManager(getContext());
//                    myView.setLayoutManager(layoutManager);

                    adapter = new MatchFixtureAdapter(table);
//                    myView.setAdapter(adapter);
//                    myView = view.findViewById(R.id.table_view);
                    layoutManager = new LinearLayoutManager(getContext());
                    myView.setLayoutManager(layoutManager);

                    myView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
//                    adapter.notifyDataSetChanged();
                    pDialog.hide();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error:", error.getMessage());
                pDialog.hide();
            }
        });


        // Adding request to request queue

        mRequestQueue.add(req);

    }

}
