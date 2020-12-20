package com.example.circle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateArea(View view) {
        EditText radiusEditText = (EditText) findViewById(R.id.radiusEditText);
        TextView textView = (TextView) findViewById(R.id.textView);

        String radiusString = radiusEditText.getText().toString();
        if (radiusString.equals("")) {
            textView.setText(R.string.no_value_string);
        } else {
            Double radius = Double.parseDouble(radiusString);
            Double area = radius * radius * Math.PI;
            textView.setText( String.format("%g", area) );
        }
    }
}