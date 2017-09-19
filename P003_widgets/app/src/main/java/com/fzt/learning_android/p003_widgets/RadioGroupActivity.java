package com.fzt.learning_android.p003_widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class RadioGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);

        RadioGroupListener radioGroupListener = new RadioGroupListener();

        RadioGroup orientation = (RadioGroup) findViewById(R.id.orientation);
        RadioGroup gravity = (RadioGroup) findViewById(R.id.gravity);
        orientation.clearCheck();
        gravity.clearCheck();
        orientation.setOnCheckedChangeListener(radioGroupListener);
        gravity.setOnCheckedChangeListener(radioGroupListener);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, CheckBoxActivity.class);
        startActivity(intent);
    }


    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener
    {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioGroup orientation = (RadioGroup) findViewById(R.id.orientation);
            RadioGroup gravity = (RadioGroup) findViewById(R.id.gravity);

            switch (checkedId) {
                case R.id.horizontal:
                    orientation.setOrientation(LinearLayout.HORIZONTAL);
                    break;
                case R.id.vertical:
                    orientation.setOrientation(LinearLayout.VERTICAL);
                    break;

                case R.id.left:
                    gravity.setGravity(Gravity.LEFT);
                    break;
                case R.id.center:
                    gravity.setGravity(Gravity.CENTER_HORIZONTAL);
                    break;
                case R.id.right:
                    gravity.setGravity(Gravity.RIGHT);
                    break;

                default:
                    break;
            }
        }
    }
}
