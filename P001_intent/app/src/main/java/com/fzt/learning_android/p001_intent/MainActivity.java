package com.fzt.learning_android.p001_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_TAG = "com.fzt.learning_android.P001_intent.MESSAGE_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resetEditText("onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.resetEditText("onResume");
    }

    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString().trim();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(MESSAGE_TAG, message);
        startActivity(intent);
    }

    private void resetEditText(String message) {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
