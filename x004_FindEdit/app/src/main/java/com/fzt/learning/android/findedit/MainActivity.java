package com.fzt.learning.android.findedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Dopo aver creato una stringa nelle risorse
            modifichiamo il testo della TextView.

            Preliminarmente viene modificato l'ID
            della TextView in "welcomeTextView"
        */

        // seleziona la TextView
        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);

        // modifica il testo
        welcomeTextView.setText(R.string.welcome);
    }
}
