package com.example.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        Toast.makeText(this, "Starting Service ...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(), MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Toast.makeText(this, "Stopping Service ...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(), MyService.class);
        stopService(intent);
    }

    public void broadcastAnIntent(View view) {
        Toast.makeText(this, "Broadcasting a custom intent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent("servicetest.example.com.FOO");
        sendBroadcast(intent);
    }
}
