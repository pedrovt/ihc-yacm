package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.yacm.ui.login.LoginActivity;

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
        editor.clear();
        editor.apply();

        String eventsNames = "Midterms DETI Run,Gellers Cup,Tour de Aveiro,Tour de France";
        String[] eventsName = {"Midterms DETI Run", "Gellers Cup", "Tour de Aveiro", "Tour de France"};
        String[] eventsDate = {"10-05-2019", "11-05-2019", "12-05-2019", "13-05-2019"};
        String[] eventsLocation = {"Aveiro", "Porto", "Aveiro", "Paris"};
        String[] eventsTags = {"DETI\nSchool", "Family Event\nInformal Event", "City Sponsored\nMajor event", "Nationwide event\nParis event"};

        editor.putString("events", eventsNames);     //names

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
