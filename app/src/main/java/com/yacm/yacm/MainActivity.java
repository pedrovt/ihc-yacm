package com.yacm.yacm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private DrawerLayout drawerLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    /* go to home */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                    /* go to dashboard */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_dashboard, Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_dashboard);

                    return true;

                case R.id.navigation_search:
                    /* go to search */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_search, Toast.LENGTH_SHORT).show();
                    }

                    //mTextMessage.setText("Search");

                    return true;

                case R.id.navigation_notifications:
                    /* go to notifications */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_notifications, Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        drawerLayout = findViewById(R.id.drawer_layout);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
