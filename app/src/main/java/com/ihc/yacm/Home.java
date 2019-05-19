package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Set;

public class Home extends AppCompatActivity {

    // Instance Fields
    private ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Intent intent = getIntent();
        String user = "Sarah";
        if (intent != null) {
            user = intent.getStringExtra("User");
        }

        // Topbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Welcome " + user + "!");

        // Events list
        lstView = (ListView) findViewById(R.id.events_actions);

        SharedPreferences prefs = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        Set<String> eventNames = prefs.getStringSet("events", null);
        Toast.makeText(getApplicationContext(), "EVENTS IS " + eventNames, Toast.LENGTH_SHORT);

        String[] eventsNamesArray = eventNames.toArray(new String[eventNames.size()]);

        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventsNamesArray));

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
