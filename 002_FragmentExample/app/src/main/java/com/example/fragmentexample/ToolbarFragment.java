package com.example.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentexample.databinding.ToolbarFragmentBinding;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private int seekvalue = 10;
    private ToolbarFragmentBinding binding;

    ToolbarListener activityCallback;

    public interface ToolbarListener {
        public void onButtonClick(int position, String text);
        public void onSeekbarChange(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            activityCallback = (ToolbarListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ToolbarListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ToolbarFragmentBinding.inflate(inflater, container, false);

        binding.seekBar.setOnSeekBarChangeListener(this);

        binding.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        return binding.getRoot();
    }

    public void buttonClicked(View view) {
        activityCallback.onButtonClick(seekvalue, binding.editText.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        seekvalue = i;
        activityCallback.onSeekbarChange(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
