package com.fzt.learning_android.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.updateCheckbox();
    }

    private void updateCheckbox() {
        cb = (CheckBox)findViewById(R.id.checkBox);

        boolean toggleStatus = cb.isChecked();

        cb.setChecked(toggleStatus);
        cb.setText(toggleStatus ? R.string.toggle_on : R.string.toggle_off);
    }

    public void onToggle(View view) {
        this.updateCheckbox();
    }
}
