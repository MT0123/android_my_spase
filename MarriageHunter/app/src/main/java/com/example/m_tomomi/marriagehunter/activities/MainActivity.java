package com.example.m_tomomi.marriagehunter.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.m_tomomi.marriagehunter.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int MENU_ID_MAIN = 0;
    private static final int MENU_ID_EVENT_LIST = 1;
    private static final int MENU_ID_SCHEDULE_LIST = 2;
    private static final int MENU_ID_TARGET_LIST = 3;
    private static final int MENU_ID_USER_PROFILE = 4;
    private static final int MENU_ID_DRAFT = 5;

    //フラグメント
    final String[] fragments ={
            "com.example.m_tomomi.marriagehunter.fragments.MainFragment",
            "com.example.m_tomomi.marriagehunter.fragments.EventListFragment",
            "com.example.m_tomomi.marriagehunter.fragments.ScheduleListFragment",
            "com.example.m_tomomi.marriagehunter.fragments.TargetListFragment",
            "com.example.m_tomomi.marriagehunter.fragments.UserProfileFragment",
            "com.example.m_tomomi.marriagehunter.fragments.DraftFragment"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity_main.xml を生成
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        //activity_main.xml / drawer_layout インスタンスを生成
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //activity_main.xml / nav_view インスタンスを生成
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //drawer.openDrawer(GravityCompat.START);
        //★初期表示のフラグメントを表示する処理追加
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Toast.makeText(this, "nav_main", Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction()
                .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_MAIN]))
                .commit();
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

    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(item.getItemId()) {
            case R.id.nav_main: {
                //★　Main
                //Toast.makeText(this, "nav_main", Toast.LENGTH_SHORT).show();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_MAIN]))
                        .commit();
                break;
            }
            case R.id.nav_event_list: {
                //★　EventList
                //Toast.makeText(this, "nav_event_list", Toast.LENGTH_SHORT).show();
                //fragmentManager.beginTransaction()
                //        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_EVENT_LIST]))
                //        .commit();
                break;
            }
            case R.id.nav_schedule_list: {
                //★　ScheduleList
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_SCHEDULE_LIST]))
                        .commit();
                break;
            }
            case R.id.nav_target_list: {
                //★　TargetList
                //fragmentManager.beginTransaction()
                //        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_TARGET_LIST]))
                //        .commit();
                break;
            }
            case R.id.nav_user_profile: {
                //★　UserProfile
                //fragmentManager.beginTransaction()
                //        .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[MENU_ID_USER_PROFILE]))
                //        .commit();
                break;
            }
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //method to handle when a MenuItem has been selected in Menu
    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "You clicked on Item 1", Toast.LENGTH_LONG).show();
                return true;
            case 1:
                Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(this, "You clicked on Item 4", Toast.LENGTH_LONG).show();
                return true;
            case 4:
                Toast.makeText(this, "You clicked on Item 5", Toast.LENGTH_LONG).show();
                return true;
            case 5:
                Toast.makeText(this, "You clicked on Item 6", Toast.LENGTH_LONG).show();
                return true;
            case 6:
                Toast.makeText(this, "You clicked on Item 7", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }
}
