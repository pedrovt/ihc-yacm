package com.ihc.yacm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    }

    ImageButton searchButton = (ImageButton) findViewById(R.id.imageButton);
    TextInputEditText keywordsBox = (TextInputEditText) findViewById(R.id.keywords);

    searchButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            String keywords = keywordsBox.getEditText().getText().toString();
        }
    });
}
