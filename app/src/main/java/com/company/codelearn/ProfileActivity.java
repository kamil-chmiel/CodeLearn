package com.company.codelearn;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Fragment profileFragment = ProfileFragment.newInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.profile_container, profileFragment)
                .commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intentProfile = new Intent(ProfileActivity.this , ProfileActivity.class);
            startActivity(intentProfile);
        } else if (id == R.id.nav_ranking) {
            Toast.makeText(this,"ranking", Toast.LENGTH_SHORT).show();
            Intent intentShowStats = new Intent(ProfileActivity.this , RankingActivity.class);
            startActivity(intentShowStats);
        } else if (id == R.id.nav_contact) {
            Toast.makeText(this,"Contact", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_invite) {
            Intent intentShowStats = new Intent(ProfileActivity.this ,InviteFriendActivity.class);
            startActivity(intentShowStats);
        } else if (id == R.id.nav_friends) {
            Toast.makeText(this,"Friends List", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
