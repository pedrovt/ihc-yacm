package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateEditEvent extends AppCompatActivity {

    // boolean index
    // == -1 --> create
    // != -1 --> edit
    private int eventIndex = -1;
    private Button bottomButton;
    private AppBarLayout topBar;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_edit_event);

        this.eventIndex = getIntent().getIntExtra("EventIndex",-1);

        this.event =  new Event(getIntent().getStringExtra("EventName"),
                            getIntent().getStringExtra("EventDate"),
                            getIntent().getStringExtra("EventLocation"),
                            getIntent().getStringExtra("EventTags"));
        bottomButton = (Button)findViewById(R.id.button3);
        topBar = (AppBarLayout) findViewById(R.id.appBarLayout);
        if (this.eventIndex == -1) {
            bottomButton.setText("Create");
            bottomButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String eventName = ((EditText)findViewById(R.id.editText_eventName)).getText().toString();
                    String eventDate = ((EditText)findViewById(R.id.editText_eventDate)).getText().toString();
                    String eventLocation = ((EditText)findViewById(R.id.editText_eventLocation)).getText().toString();
                    String eventTags = ((EditText)findViewById(R.id.editText_eventTags)).getText().toString();

                    createEvent(eventName, eventDate, eventLocation, eventTags);
                    finish();
                }
            });
            setTitle("Create Event");
        } else {
            ((EditText)findViewById(R.id.editText_eventName)).setText(this.event.getName());
            ((EditText)findViewById(R.id.editText_eventDate)).setText(this.event.getDate());
            ((EditText)findViewById(R.id.editText_eventLocation)).setText(this.event.getLocation());
            ((EditText)findViewById(R.id.editText_eventTags)).setText(this.event.getTags());
            bottomButton.setText("Save");
            bottomButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String eventName = ((EditText)findViewById(R.id.editText_eventName)).getText().toString();
                    String eventDate = ((EditText)findViewById(R.id.editText_eventDate)).getText().toString();
                    String eventLocation = ((EditText)findViewById(R.id.editText_eventLocation)).getText().toString();
                    String eventTags = ((EditText)findViewById(R.id.editText_eventTags)).getText().toString();

                    editEvent(eventName, eventDate, eventLocation, eventTags);
                    finish();
                }
            });
            setTitle("Edit Event");
        }

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //Toast.makeText(Home.this,"Home", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        return true;
                    case R.id.navigation_dashboard:
                        //Toast.makeText(Home.this,"Create Event", Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), CreateEditEvent.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_notifications:
                        //Toast.makeText(Home.this,"Notifications", Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), Notifications.class);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        return true;
                }
                return false;
            };
        });
    }


    private void createEvent(String eventName, String eventDate, String eventLocation, String eventTags) {
        /*SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int i = preferences.getInt("numEvents", -1) + 1;

        editor.putInt("numEvents", i);

        // Update events names list
        String eventsName = preferences.getString("events", null);     //names
        eventsName.concat("," + eventName);

        editor.putString("events", eventsName);
        editor.putString("event" + i + "_name", eventName);             //name
        editor.putString("event" + i + "_date", eventDate);             //date
        editor.putString("event" + i + "_location", eventLocation);     //date
        editor.putString("event" + i + "_tags", eventTags);             //tags

        editor.apply();*/
        Assistant.addEvent(new Event(eventName,eventDate,eventLocation,eventTags));
    }

    /*private void editEvent(int eventIndex, String eventName, String eventDate, String eventLocation, String eventTags) {
        SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("event" + eventIndex + "_date", eventDate);             //date
        editor.putString("event" + eventIndex + "_location", eventLocation);     //date
        editor.putString("event" + eventIndex + "_tags", eventTags);             //tags

        editor.apply();

    }*/
    private void editEvent(String eventName, String eventDate, String eventLocation, String eventTags) {
        Assistant.removeEvent(this.event);
        this.event.setName(eventName);
        this.event.setDate(eventDate);
        this.event.setLocation(eventLocation);
        this.event.setTags(eventTags);
        Assistant.addEvent(this.event);
    }
}
