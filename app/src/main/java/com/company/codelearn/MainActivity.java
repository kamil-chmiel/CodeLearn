package com.company.codelearn;

import android.content.Intent;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements LecturesFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {
    private UserData userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userData = (UserData) getIntent().getSerializableExtra("UserData");

        System.out.println(userData);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment lecturesFragment = LecturesFragment.newInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.learn_container, lecturesFragment)
                .commit();

        Button quizTab = findViewById(R.id.quiz_tab);
        quizTab.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Fragment quizFragment = QuizFragment.newInstance();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.learn_container, quizFragment)
                        .commit();
            }
        });

        Button learnTab = findViewById(R.id.learn_tab);
        learnTab.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Fragment lecturesFragment = LecturesFragment.newInstance();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.learn_container, lecturesFragment)
                        .commit();
            }
        });

        Button socialTab = findViewById(R.id.social_tab);
        socialTab.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Fragment socialFragment = SocialFragment.newInstance();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.learn_container, socialFragment)
                        .commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intentProfile = new Intent(MainActivity.this , ProfileActivity.class);
            startActivity(intentProfile);
        } else if (id == R.id.nav_ranking) {
            Toast.makeText(this,"ranking", Toast.LENGTH_SHORT).show();
            Intent intentShowStats = new Intent(MainActivity.this , RankingActivity.class);
            startActivity(intentShowStats);
        } else if (id == R.id.nav_contact) {
            Toast.makeText(this,"Contact", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_invite) {
            Intent intentShowStats = new Intent(MainActivity.this ,InviteFriendActivity.class);
            startActivity(intentShowStats);
        } else if (id == R.id.nav_friends) {
            Toast.makeText(this,"Friends List", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
