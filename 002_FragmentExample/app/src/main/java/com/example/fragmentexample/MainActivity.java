package com.example.fragmentexample;


import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {

    private TextFragment textFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.textFragment);
    }

    @Override
    public void onButtonClick(int position, String text) {
        textFragment.changeTextProperties(position, text);
    }

    @Override
    public void onSeekbarChange(int position) {
        textFragment.changeFontSize(position);
    }
}