package com.fzt.learning_android.p004_selectionwidgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteTextViewActivity extends AppCompatActivity {

    String[] items={ "lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(arrayAdapter);

        TextWatcherHandler textWatcherHandler = new TextWatcherHandler();
        textView.addTextChangedListener(textWatcherHandler);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, Grid2Activity.class);
        startActivity(intent);
    }

    class TextWatcherHandler implements TextWatcher
    {
        public void afterTextChanged(Editable editable) { }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            TextView textView = (TextView) findViewById(R.id.selection);
            AutoCompleteTextView editView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
            textView.setText(editView.getText());
        }
    }
}
