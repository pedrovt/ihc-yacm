package com.ihc.yacm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CreateEditEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_edit_event);
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
