package com.fzt.learning_android.p002_now;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.updateTime();
    }

    private void updateTime() {
        Button btn = (Button)findViewById(R.id.button);
        btn.setText(new Date().toString());
    }

    public void onClick(View view) {
        this.updateTime();
    }
}