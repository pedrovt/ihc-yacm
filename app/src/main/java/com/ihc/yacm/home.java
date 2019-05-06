package com.ihc.yacm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    // Instance Fields
    private ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // List view
        lstView = (ListView) findViewById(R.id.events_listGroup);

        // Set the ArrayAdapter as the ListView's adapter.
        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstView);
        //list.add("Cheese, apples, water");

        //lstView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
/*
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.LTGRAY);*/


                if (BuildConfig.DEBUG) {
                    Toast.makeText(getApplicationContext(), "Selected item is " + i, Toast.LENGTH_SHORT).show();
                }


                /*Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                intent.putExtra("info", list.get(i));
                intent.putExtra("selectedTemplateIndex", selectedItemIndex);
                startActivityForResult(intent, 100);*/
            }
        });
    }
}
