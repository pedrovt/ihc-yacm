package com.ihc.yacm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class EventDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String eventName = null;
    private Event event = null;
    private Assistant assistant;
    private int eventIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        this.assistant = Assistant.getInstance();

        this.eventName = getIntent().getStringExtra("EventName");
        this.eventIndex = getIntent().getIntExtra("EventIndex",-1);
        List<Event> eventList = assistant.getEventList();
        for(Event e : eventList) {
            if(e.getName().equals(eventName))
                event = e;
            break;
        }

        /* Topbar */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Event Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

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

        ((TextView)findViewById(R.id.eventName)).setText(event.getName());
        ((TextView)findViewById(R.id.eventDate)).setText(event.getDate());
        ((TextView)findViewById(R.id.eventLocation)).setText(event.getLocation());
        ((TextView)findViewById(R.id.eventTags)).setText(event.getTags());

        ListView lstView = (ListView) findViewById(R.id.events_actions);

        // Click on a event name on the list of events
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (BuildConfig.DEBUG) {
                    Toast.makeText(getApplicationContext(), "Selected item is " + i, Toast.LENGTH_SHORT).show();
                }

                Intent intent;
                switch (i) {
                    case 0:         // Edit Event
                        intent = new Intent(getApplicationContext(), CreateEditEvent.class);
                        intent.putExtra("EventName", event.getName());
                        intent.putExtra("EventDate", event.getDate());
                        intent.putExtra("EventLocation", event.getLocation());
                        intent.putExtra("EventTags", event.getTags());
                        intent.putExtra("EventIndex",eventIndex);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        break;

                    case 1:         // Manage participants
                        intent = new Intent(getApplicationContext(), ManageParticipants.class);
                        intent.putExtra("EventName", eventName);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        break;

                    case 2:         // Results
                        intent = new Intent(getApplicationContext(), ManageResults.class);
                        intent.putExtra("EventName", eventName);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        break;

                    case 3:         // Teams
                        intent = new Intent(getApplicationContext(), ManageTeams.class);
                        intent.putExtra("EventName", eventName);
                        intent.putExtra("Title", "Event Details");
                        startActivity(intent);
                        break;
                }


            }
        });

        Button editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateEditEvent.class);
                intent.putExtra("EventName", event.getName());
                intent.putExtra("EventDate", event.getDate());
                intent.putExtra("EventLocation", event.getLocation());
                intent.putExtra("EventTags", event.getTags());
                intent.putExtra("EventIndex",eventIndex);
                intent.putExtra("Title", "Event Details");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            if (BuildConfig.DEBUG) {
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_notifications) {
            if (BuildConfig.DEBUG) {
                Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_account) {
            if (BuildConfig.DEBUG) {
                Toast.makeText(getApplicationContext(), "Account", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_logout) {
            if (BuildConfig.DEBUG) {
                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}