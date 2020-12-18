package com.fzt.learning_android.p003_widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScrollTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_table);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }
}
