package com.fzt.learning_android.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    TextView selection;
    AutoCompleteTextView edit;

    String[] items={ "lorem", "ipsum", "dolor", "sit", "amet",
"consectetuer", "adipiscing", "elit", "morbi", "vel",
"ligula", "vitae", "arcu", "aliquet", "mollis",
"etiam", "vel", "erat", "placerat", "ante",
"porttitor", "sodales", "pellentesque", "augue", "purus" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = (TextView)findViewById(R.id.selection);
        edit = (AutoCompleteTextView)findViewById(R.id.edit);

        edit.addTextChangedListener(this);
        edit.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items));
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        selection.setText(edit.getText());
    }

    public void afterTextChanged(Editable editable) {

    }

    public void beforeTextChanged(CharSequence s, int start, int before, int count) {

    }
}
