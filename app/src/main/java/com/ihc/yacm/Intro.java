package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.yacm.ui.login.LoginActivity;

import java.util.Arrays;
import java.util.HashSet;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        // Button
        Button clickButton = (Button) findViewById(R.id.intro_start_button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // initialize data
        SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String[] eventsName = {"Midterms DETI Run", "Gellers Cup", "Tour de Aveiro", "Tour de France"};
        String[] eventsDate = {"10-05-2019", "11-05-2019", "12-05-2019", "13-05-2019"};
        String[] eventsLocation = {"Aveiro", "Porto", "Aveiro", "Paris"};
        String[] eventsTags = {"DETI\nSchool", "Family Event\nInformal Event", "City Sponsored\nMajor event", "Nationwide event\nParis event"};

        editor.putStringSet("events", new HashSet<String>(Arrays.asList(eventsName)));     //names

        for (int i = 0; i < eventsName.length; i++) {
            editor.putString("event" + i + "_name", eventsName[i]);     //name
            editor.putString("event" + i + "_date", eventsDate[i]);     //date
            editor.putString("event" + i + "_location", eventsLocation[i]);     //date
            editor.putString("event" + i + "_tags", eventsTags[i]);     //tags
        }
        editor.apply();

        editor.putInt("numEvents", eventsName.length);
    }


}


class Event {

    private String name;
    private String date;
    private String location;
    private String tags;

    public Event (String name, String date, String location, String tagList) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tagList;
    }

    public String getName()     { return this.name; }
    public String getDate()     { return this.date; }
    public String getLocation() { return this.location; }
    public String getTags()     { return this.tags; }

    public void setName(String name)            { this.name = name; }
    public void setDate(String date)            { this.date = date; }
    public void setLocation(String location)    { this.location = location; }
    public void setTags(String tags)            { this.tags = tags; }
}
