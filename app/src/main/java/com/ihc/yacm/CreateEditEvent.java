package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateEditEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_edit_event);

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
