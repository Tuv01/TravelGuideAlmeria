package com.tuv01.travelguidealmeria;

/**
 * Created by Tuv01 on 3/26/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.tuv01.travelguidealmeria.accountfirebase.LoginActivity;
import com.tuv01.travelguidealmeria.adapter.PagerAdapter;
import com.tuv01.travelguidealmeria.fragment.TabFragment;

import static com.tuv01.travelguidealmeria.model.Config.TAB_SELECT;

/**
 * Create an {@link PagerAdapter} activity which shows
 * a view pager with an {@link TabFragment} tab layout.
 */

public class PagerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private FirebaseAuth auth;
    private static int tabSelect = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Set the content of the activity to use the category_main.xml layout file. */
        setContentView(R.layout.category_main);
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //handling navigation view item event
        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(PagerActivity.this);



        /* Get Intent Extra */
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            tabSelect = bundle.getInt(TAB_SELECT);
        }

        /* Find the view pager that will allow the user to swipe between fragments. */
        ViewPager vp = findViewById(R.id.viewpager);
        /* Create an adapter that knows which fragment should be shown on each page. */
        PagerAdapter adapter = new PagerAdapter(this, getSupportFragmentManager());

        /* Set the adapter onto the view pager. */
        vp.setAdapter(adapter);
        vp.setCurrentItem(tabSelect);

        /* Find the tab layout that shows the tabs. */
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vp);
    }

    //Handling navigation drawer menuItem selected
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (menuItem.getItemId()) {
            case R.id.nav_coupon:
                Intent intent = new Intent(this, CouponActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_game:
                Intent intent2 = new Intent(this, GameActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_map:
                Intent intent3 = new Intent(this, MapActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_event:
                Intent intent4 = new Intent(this, EventActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_login:
                signOut();
                Intent intent5 = new Intent(this, LoginActivity.class);
                startActivity(intent5);
                break;
            default:
                Intent intentd = new Intent(this, PagerActivity.class);
                startActivity(intentd);
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert drawerLayout != null;
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //sign out method (firebase)
    public void signOut() {
        auth.signOut();
    }
}