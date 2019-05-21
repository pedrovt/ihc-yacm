package com.ihc.yacm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.yacm.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        /*SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
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

        editor.putInt("numEvents", eventsName.length);*/

        List<Participant> participantList = Arrays.asList(new Participant[]{
                new Participant("Toy",'M',56),
                new Participant("Quim Barreiros",'M',71),
                new Participant("Maria Leal",'F',50)
        });

        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("Midterms DETI Run", "10-05-2019", "Aveiro", "DETI\nSchool", participantList));
        eventList.add(new Event("Gellers Cup","11-06-2019","Porto","Family Event\nInformal Event", participantList));
        eventList.add(new Event("Tour de Aveiro","12-07-2019","Aveiro","City Sponsored\nMajor event", participantList));
        eventList.add(new Event("Tour de France","13-08-2019","Paris","Nationwide event\nParis event", participantList));
        Assistant assistant = Assistant.getInstance(eventList);

    }


}