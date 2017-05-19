package com.fzt.learning_android.fzt_002_volume;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VolumeFragment extends Fragment {

    private Volume object3d;    /* Cube or Sphere */
    private int edit;
    private int btn;

    public VolumeFragment(Volume obj, int edit, int btn) {
        this.object3d = obj;
        this.edit = edit;
        this.btn = btn;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = (View) inflater.inflate(R.layout.fragment_volume, container, false);

        final EditText editText = (EditText) rootView.findViewById(R.id.editTextVolume);
        editText.setHint(this.edit);
        Button button = (Button) rootView.findViewById(R.id.buttonVolume);
        button.setText(this.btn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

                //editText = (EditText) getView().findViewById(R.id.editTextVolume);
                String value_str = editText.getText().toString().trim();
                double value = Double.parseDouble(value_str);
                String result_str = object3d.volume(value);
                TextView textView = (TextView) getView().findViewById(R.id.textViewVolume);
                textView.setText(result_str);
            }
        });

        return rootView;
    }
}
