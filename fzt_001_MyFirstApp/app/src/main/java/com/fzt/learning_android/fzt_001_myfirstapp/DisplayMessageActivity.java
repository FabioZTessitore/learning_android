package com.fzt.learning_android.fzt_001_myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        if (!message.equals("")) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(message);
        }
    }
}
