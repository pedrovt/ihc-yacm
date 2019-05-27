package com.ihc.yacm;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class ManageParticipants extends AppCompatActivity {

    private Assistant assistant;
    private ListView lstView;
    private String eventName = null;
    private List<Participant> participantList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_participants);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Participants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

        assistant = Assistant.getInstance();

        eventName = getIntent().getStringExtra("EventName");
        lstView = (ListView) findViewById(R.id.participants_list);

        List<Event> eventList = assistant.getEventList();
        Event event = null;
        for(Event e : eventList) {
            if(e.getName().equals(eventName))
                event = e;
                break;
        }

        participantList = event.getParticipants();
        List<String> participantNames =  new ArrayList<>();
        for(Participant participant : participantList){
            participantNames.add(participant.getName());
        }

        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, participantNames));

        // Listener
        lstView = (ListView) findViewById(R.id.participants_list);

        // Click on a event name on the list of events
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (BuildConfig.DEBUG) {
                    Toast.makeText(getApplicationContext(), "Selected item is " + i, Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
            }});

        // Downbar
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
}
