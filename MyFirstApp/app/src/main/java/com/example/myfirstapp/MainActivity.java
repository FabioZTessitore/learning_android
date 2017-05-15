package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirspapp.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Toast.makeText(this, "Sending Message", Toast.LENGTH_SHORT).show();
        Log.d("FABIO", "Sending Message");
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText textView = (EditText) findViewById(R.id.editText);
        String message = textView.getText().toString().trim();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
