package com.fzt.learning_android.p003_widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        this.updateCheckbox();
    }

    private void updateCheckbox() {
        CheckBox cb = (CheckBox)findViewById(R.id.checkBox);

        boolean toggleStatus = cb.isChecked();

        cb.setText(toggleStatus ? R.string.cb_toggle_on : R.string.cb_toggle_off);
    }

    public void onToggle(View view) {
        this.updateCheckbox();
    }

    public void prev(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void next(View view) {
        Intent intent = new Intent(this, RadioGroupActivity.class);
        startActivity(intent);
    }
}
