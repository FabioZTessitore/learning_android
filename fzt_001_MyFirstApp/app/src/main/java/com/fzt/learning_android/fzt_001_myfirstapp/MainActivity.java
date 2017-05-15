package com.fzt.learning_android.fzt_001_myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_EXTRA = "com.fzt.learning_android.fzt_001_myfirstapp.MESSAGE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetEditText();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        resetEditText();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString().trim();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivity(intent);
    }

    private void resetEditText() {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
    }
}
