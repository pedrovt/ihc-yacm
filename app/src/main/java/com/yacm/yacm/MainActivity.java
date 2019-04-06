package com.yacm.yacm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    /* go to home */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                    /* go to dashboard */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_dashboard, Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_dashboard);

                    return true;

                case R.id.navigation_search:
                    /* go to search */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_search, Toast.LENGTH_SHORT).show();
                    }

                    //mTextMessage.setText("Search");

                    return true;

                case R.id.navigation_notifications:
                    /* go to notifications */

                    if (BuildConfig.DEBUG) {
                        Toast.makeText(getApplicationContext(), R.string.title_notifications, Toast.LENGTH_SHORT).show();
                    }

                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
