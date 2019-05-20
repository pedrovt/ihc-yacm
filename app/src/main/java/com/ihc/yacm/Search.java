package com.ihc.yacm;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

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

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //commented to ensure build
                //String keywords = keywordsBox.getEditText().getText().toString();
                EditText text = (EditText)findViewById(R.id.keywords);
                String value = text.getText().toString();

                SharedPreferences preferences = getSharedPreferences(Utils.PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

            }
        });
    }

    ImageButton searchButton = (ImageButton) findViewById(R.id.imageButton);
    TextInputEditText keywordsBox = (TextInputEditText) findViewById(R.id.keywords);


}
