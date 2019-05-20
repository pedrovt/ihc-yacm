package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    // Instance Fields
    private ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Get Shared Preferences and Intent
        SharedPreferences prefs = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        Intent intent = getIntent();

        // Get user
        String user = prefs.getString("User", "Sarah");

        // Topbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Welcome " + user + "!");

        // Downbar
        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // do something for a debug build
                        Toast.makeText(Home.this,"Home", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("Title", "Event Details");
                        Log.d("TEST", "in home");
                        return true;
                    case R.id.navigation_dashboard:
                        Toast.makeText(Home.this,"Dashboard", Toast.LENGTH_LONG).show();

                        intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("Title", "Event Details");


                        return true;
                    case R.id.navigation_notifications:
                        Toast.makeText(Home.this,"Notifications", Toast.LENGTH_LONG).show();

                        intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("Title", "Event Details");

                        return true;
                }
                return false;
            };
        });

        // Events list
        lstView = (ListView) findViewById(R.id.events_actions);

        String eventNames = prefs.getString("events", null);
        String[] eventsNames = eventNames.split(",");
        Toast.makeText(getApplicationContext(), "EVENTS IS " + eventNames, Toast.LENGTH_LONG);

        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventsNames));

        // Click on a event name on the list of events
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (BuildConfig.DEBUG) {
                    Toast.makeText(getApplicationContext(), "Selected item is " + i, Toast.LENGTH_SHORT).show();
                }

                // Start Event Details
                Intent intent = new Intent(getApplicationContext(), EventDetails.class);
                intent.putExtra("EventIndex", i);
                intent.putExtra("Title", "Event Details");

                startActivity(intent);
            }
        });
    }


}
