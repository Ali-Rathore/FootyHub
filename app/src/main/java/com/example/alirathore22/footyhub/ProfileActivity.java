package com.example.alirathore22.footyhub;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alirathore22.footyhub.api.ApiClient;
import com.example.alirathore22.footyhub.api.ApiInterface;
import com.example.alirathore22.footyhub.models.Article;
import com.example.alirathore22.footyhub.models.News;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String API_KEY = "e0a61c52954d4b72b6f47a427ea29306";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();
    private TextView topHeadline;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RelativeLayout errorLayout;
    private ImageView errorImage;
    private TextView errorTitle, errorMessage;
    private Button btnRetry;

    private String email;
    private FirebaseAuth firebaseAuth;



    /*
    * HOW TO INTEGRATE FIREBASE IN THE CURRENT IMPLEMENTATION?
    * The keywords for each user are to be fetched from firebase
    * the club names are to be then arranged in a string separated by comma ','
    * set the following variable "keyword" as the strings of club names separated by commas ','
    * all should work perfectly now!!!
    * Good LUCK
    *
    *
    * hasan ka code as follows
    *
    * TextView textView;
    private ListView listView;
    private LinearLayout myLinearLayout;
    List<String> list_firebase = new ArrayList<String>();
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private String email;
    private String name;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        email = getIntent().getStringExtra("email");
        Log.d("SHIT",email);
        myref = FirebaseDatabase.getInstance().getReference().child("users").child(email);
        myLinearLayout = findViewById(R.id.activity_extras);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String zeroth_team=dataSnapshot.child("0").getValue().toString();
                long count = dataSnapshot.getChildrenCount();
                show_vals(dataSnapshot,count);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    private void show_vals(DataSnapshot dataSnapshot, long count) {
        //final int N = 10; // total number of textviews to add
        int N = (int) count;
        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            final TextView rowTextView = new TextView(ExtraActivity.this);

            String team = dataSnapshot.child(String.valueOf(i)).getValue().toString();

            rowTextView.setText(team);

            myLinearLayout.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i] = rowTextView;
        }
    }
}
    *
    * */
    private String keyword = "barcelona";


    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction ft = fragmentManager.beginTransaction();
    private Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


//        if (getIntent() != null)
//            keyword = "barcelona football" + getIntent().getStringExtra("keyword");
//        keyword = "soccer football";

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        topHeadline = findViewById(R.id.topheadelines);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(ProfileActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        onLoadingSwipeRefresh(keyword);

        errorLayout = findViewById(R.id.errorLayout);
        errorImage = findViewById(R.id.errorImage);
        errorTitle = findViewById(R.id.errorTitle);
        errorMessage = findViewById(R.id.errorMessage);
        btnRetry = findViewById(R.id.btnRetry);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //to not have home button always highlighted
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        set_botton_navigation_listener(bottomNavigationView);
    }

    public void set_botton_navigation_listener(BottomNavigationView bottomNavigationView)
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        break;
                    case R.id.ic_fixtures:
//                        Intent intent = new Intent(ProfileActivity.this, FixturesActivity.class);
//                        startActivity(intent);
                        frag = new FixturesActivity();
                        ft.replace(R.id.mainLayout, frag);
//                        ft.addToBackStack(stack);
                        ft.commit();
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

    public void LoadJson(final String keyword){
        errorLayout.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(true);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        String country = Utils.getCountry();
        String language = Utils.getLanguage();
        Call<News> call;
        if(keyword.length() > 0){
            call = apiInterface.getNewsSearch(keyword, language, "publishedAt", API_KEY);
        } else {
            call = apiInterface.getNews(keyword,"sports", country, API_KEY);
        }
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticle() != null){
                    if(!articles.isEmpty()){
                        articles.clear();
                    }
                    articles = response.body().getArticle();
                    adapter = new Adapter(articles, ProfileActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    initListener();
                    topHeadline.setVisibility(View.VISIBLE);
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    topHeadline.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);
                    String errorCode;
                    switch (response.code()) {
                        case 404:
                            errorCode = "Error 404 not found";
                            break;
                        case 500:
                            errorCode = "Error 500 server broken";
                            break;
                        default:
                            errorCode = "Unknown error";
                            break;
                    }
                    showErrorMessage(
                            R.drawable.no_result,
                            "No Result",
                            "Please Try Again!\n"+
                                    errorCode);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                topHeadline.setVisibility(View.INVISIBLE);
                swipeRefreshLayout.setRefreshing(false);
                showErrorMessage(
                        R.drawable.oops,
                        "Oops..",
                        "Network failure, Please Try Again\n"+
                                t.toString());
            }
        });
    }

    private void initListener(){
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ImageView imageView = view.findViewById(R.id.img);
                Intent intent = new Intent(ProfileActivity.this, NewsDetailActivity.class);
                Article article = articles.get(position);
                intent.putExtra("url", article.getUrl());
                intent.putExtra("title", article.getTitle());
                intent.putExtra("img",  article.getUrlToImage());
                intent.putExtra("date",  article.getPublishedAt());
                intent.putExtra("source",  article.getSource().getName());
                intent.putExtra("author",  article.getAuthor());
                Pair<View, String> pair = Pair.create((View)imageView, ViewCompat.getTransitionName(imageView));
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        ProfileActivity.this,
                        pair
                );
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent, optionsCompat.toBundle());
                }else {
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        firebaseAuth = FirebaseAuth.getInstance();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search Latest News...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2){
//                    onLoadingSwipeRefresh(query);
                    LoadJson(query + " football club");
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchMenuItem.getIcon().setVisible(false, false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout:
                firebaseAuth.signOut();
                startActivity(new Intent(this, LoginActivity.class));


        }
        return super.onOptionsItemSelected(item);
    }

    public String[] splitKeywords(String keyword)
    {
        String [] keywords;

        keywords = keyword.split(",");

        return keywords;
    }


    public void loadJSONforKeywords()
    {
        for (String word:splitKeywords(keyword + " football club sports"))
            LoadJson(word);
    }

    @Override
    public void onRefresh() {
        loadJSONforKeywords();
    }

    private void onLoadingSwipeRefresh(final String keyword){
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        loadJSONforKeywords();
                    }
                }
        );
    }

    private void showErrorMessage(int imageView, String title, String message){
        if (errorLayout.getVisibility() == View.GONE) {
            errorLayout.setVisibility(View.VISIBLE);
        }
        errorImage.setImageResource(imageView);
        errorTitle.setText(title);
        errorMessage.setText(message);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onLoadingSwipeRefresh("");
                loadJSONforKeywords();
            }
        });
    }

}
