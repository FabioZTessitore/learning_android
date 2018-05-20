package com.fzt.learning.android.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button dateButton;
    Button date2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateButton = (Button) findViewById(R.id.dateButton);
        date2Button = (Button) findViewById(R.id.date2Button);
        this.updateDate(dateButton);
        this.updateDate(date2Button);

        // dateButton gestisce il click mediante
        // View.OnClickListener
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate((TextView)v);
            }
        });

        // date2Button gestisce il click assegnando
        // ad android:onCLick la funzione handler (activity_main.xml)
        // Deve avere prototipo
        // public void foo(View v);
    }

    public void changeDate(View v) {
        this.updateDate((TextView)v);
    }

    private void updateDate(TextView v) {
        v.setText( new Date().toString() );
    }
}
