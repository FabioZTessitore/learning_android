package com.fzt.learning_android.p003_widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, RadioGroupActivity.class);
        startActivity(intent);
    }

    public void next(View view) {
        Intent intent = new Intent(this, ScrollTableActivity.class);
        startActivity(intent);
    }

    public void setName(View view) {
        EditText editText = (EditText) findViewById(R.id.tb_name);
        TextView textView = (TextView) findViewById(R.id.tb_name_show);

        textView.setText(editText.getText().toString().trim());
    }

    public void resetName(View view) {
        EditText editText = (EditText) findViewById(R.id.tb_name);
        TextView textView = (TextView) findViewById(R.id.tb_name_show);

        editText.setText("");
        textView.setText("");
    }
}
