package com.ihc.yacm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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


        // List view
        lstView = (ListView) findViewById(R.id.events_actions);

        // Set the ArrayAdapter as the ListView's adapter.
        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstView);
        //list.add("Cheese, apples, water");

        //lstView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

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
