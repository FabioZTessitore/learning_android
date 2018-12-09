package com.fzt.learning.android.resource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* In activity_main.xml e' presente la struttura
            dell'attivita' principale: il layout ConstraintLayout e'
            stato trasformato in LinearLayout e al suo interno e'
            inserita una casella di testo (TextView).

            Si vogliono modificare le caratteristiche di questa
            casella (testo, dimensione, colore) attraverso
            dei valori che verranno memorizzati in "risorse".
        */

        /* Aggiunta di una stringa:

            In res.values.strings.xml sono presenti le stringhe
            utilizzate nell'applicazione.

            E' stata aggiunta la stringa (con localizzazione)
                name: welcome
                value: Welcome to Android App Development!

            In activity_main.xml ora la casella di testo
            fa riferimento a @string/welcome nel campo text.

            (Tutte queste operazioni, dalla creazione della nuova
            stringa nel file delle risorse, all'assegnazione
            alla TextView possono essere effettuate anche graficamente
            tramite la scheda Design di activity_main.xml)
        */

        /* Modifica della dimensione del testo:

            In res.values.dimens.xml (non presente inizialmente)
            sono presenti le dimensioni usate nell'applicazione.

            E' stata aggiunta una nuova dimensione:
                name: welcome_textsize
                value: 40sp (scale indipendent, tiene conto delle preferenze dell'utente)

            Ora la TextView fa riferimento a @dimen/welcome_textsize
            nel campo textSize

            Con lo stesso meccanismo si possono creare altre due
            welcome_textsize di valore pari a 80sp
            da utilizzare quando screen_width > 600
            oppure screen_height > 600 (tablet)
        */

        /* Modifica del colore del testo:

            Con lo stesso meccanismo possiamo creare una risorsa per il colore del testo.

                name: welcome_textcolor
                value: #2196f3
        */

        /* Modificando i valori di gravity e layout_gravity possiamo centrare il testo */
    }
}
