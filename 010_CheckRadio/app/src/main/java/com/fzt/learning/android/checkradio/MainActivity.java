package com.fzt.learning.android.checkradio;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private RadioGroup gravityRadioGroup;
    private RadioGroup orientationRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(false);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean checked = buttonView.isChecked();
                //buttonView.setChecked();
                buttonView.setText( checked ? R.string.checkbox_checked : R.string.checkbox_unchecked );
            }
        });

        gravityRadioGroup = (RadioGroup) findViewById(R.id.gravityRadioGroup);
        gravityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int gravity;

                switch (checkedId) {
                    case R.id.gravityLeft:
                        gravity = Gravity.LEFT;
                        break;
                    case R.id.gravityCenter:
                        gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.gravityRight:
                        gravity = Gravity.RIGHT;
                        break;
                    default:
                        gravity = Gravity.LEFT;
                        break;
                }

                group.setGravity( gravity );
            }
        });

        orientationRadioGroup = (RadioGroup) findViewById(R.id.orientationRadioGroup);
        orientationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int orientation;

                switch (checkedId) {
                    case R.id.orientationHorizontal:
                        orientation = LinearLayout.HORIZONTAL;
                        break;
                    case R.id.orientationVertical:
                        orientation = LinearLayout.VERTICAL;
                        break;
                    default:
                        orientation = LinearLayout.HORIZONTAL;
                        break;
                }

                group.setOrientation( orientation );
            }
        });
    }
}
