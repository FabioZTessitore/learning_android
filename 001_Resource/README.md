### package android.learning.fzt.com

# learning_android

## Resource

Modificare alcune caratteristiche di una casella di testo (testo, dimensione, colore) attraverso valori che verranno memorizzati in *risorse*.

#### Aggiunta di una stringa

In res.values.strings.xml sono presenti le stringhe utilizzate nell'applicazione.

E' stata aggiunta la stringa (con localizzazione)

	name: welcome
    value: Welcome to Android App Development!

In activity_main.xml ora la casella di testo
fa riferimento a @string/welcome nel campo text.

        (Tutte queste operazioni, dalla creazione della nuova
        stringa nel file delle risorse, all'assegnazione
        alla TextView possono essere effettuate anche graficamente
        tramite la scheda Design di activity_main.xml)
