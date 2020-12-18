package com.fzt.learning.android.orientation;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView messageTextView;
    private Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = (TextView) findViewById(R.id.messageTextView);
        messageTextView.setText(R.string.portrait);

        config = getResources().getConfiguration();

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            messageTextView.setText(R.string.portrait);
        } else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            messageTextView.setText(R.string.landscape);
        }
    }
}
