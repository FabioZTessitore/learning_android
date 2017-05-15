package com.example.activitycicle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    String msg = "Android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(msg, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(msg, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(msg, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(msg, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(msg, "onStop");
    }

    public void click(View view) {
        Log.d(msg, "Hello");
    }
}
