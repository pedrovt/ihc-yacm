package com.ihc.yacm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;

public class CreateEditEvent extends AppCompatActivity {

    // boolean create
    // true = create
    // false = edit
    private boolean create = true;
    private Button bottomButton;
    private AppBarLayout topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.create = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_edit_event);
        bottomButton = (Button)findViewById(R.id.button3);
        topBar = (AppBarLayout) findViewById(R.id.appBarLayout);
        bottomButton.setText("Create");
        setTitle("Create Event");
    }

    protected void onCreate(Bundle savedInstanceState, boolean create) {
        this.create = create;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_edit_event);
        bottomButton = (Button)findViewById(R.id.button3);
        topBar = (AppBarLayout) findViewById(R.id.appBarLayout);
        if (this.create) {
            bottomButton.setText("Create");
            setTitle("Create Event");
        } else {
            bottomButton.setText("Save");
            setTitle("Edit Event");
        }
    }


    private void createEvent(String eventName, String eventDate, String eventLocation, String eventTags) {
        SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int i = preferences.getInt("numEvents", -1) + 1;

        editor.putInt("numEvents", i);

        // Update events names list
        String eventsName = preferences.getString("events", null);     //names
        eventsName.concat("," + eventName);

        editor.putString("event" + i + "_name", eventName);             //name
        editor.putString("event" + i + "_date", eventDate);             //date
        editor.putString("event" + i + "_location", eventLocation);     //date
        editor.putString("event" + i + "_tags", eventTags);             //tags

    }

    private void editEvent(int eventIndex, String eventName, String eventDate, String eventLocation, String eventTags) {
        SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        

        editor.putString("event" + eventIndex + "_date", eventDate);             //date
        editor.putString("event" + eventIndex + "_location", eventLocation);     //date
        editor.putString("event" + eventIndex + "_tags", eventTags);             //tags

    }
}
