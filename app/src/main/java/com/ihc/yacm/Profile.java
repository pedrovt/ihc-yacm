package com.ihc.yacm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        TextView nameView = (TextView) findViewById(R.id.nameView);
        nameView.setText("Quim Barreiros");

        ListView lstView = (ListView) findViewById(R.id.profile_info);
        List<String> options =  new ArrayList<>();
        options.add("Age: 71");
        options.add("Sex: Muito");
        options.add("Bio: Sempre tive um especial afeto por gado caprino.");

        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));
    }
}
