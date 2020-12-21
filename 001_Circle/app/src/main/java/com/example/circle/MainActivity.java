package com.example.circle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.circle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( binding.getRoot() );
    }

    public void calculateArea(View view) {
        String radiusString = binding.radiusEditText.getText().toString();
        if (radiusString.equals("")) {
            binding.areaTextView.setText(R.string.no_value_string);
            binding.radiusTextView.setText(R.string.no_value_string);
        } else {
            Double radius = Double.parseDouble(radiusString);
            Double area = radius * radius * Math.PI;
            binding.radiusTextView.setText( String.format("%g", radius) );
            binding.areaTextView.setText( String.format("%g", area) );
        }
        binding.radiusEditText.setText("");
    }
}