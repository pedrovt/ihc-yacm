package com.ihc.yacm;

import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
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
