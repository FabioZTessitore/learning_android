package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentexample.databinding.TextFragmentBinding;

public class TextFragment extends Fragment {
    private TextFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TextFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void changeTextProperties(int fontsize, String text) {
        binding.textView.setTextSize(fontsize);
        binding.textView.setText(text);
    }

    public void changeFontSize(int fontsize) {
        binding.textView.setTextSize(fontsize);
    }
}
