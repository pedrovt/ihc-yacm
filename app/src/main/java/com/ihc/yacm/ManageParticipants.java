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
