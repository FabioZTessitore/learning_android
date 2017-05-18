package com.fzt.learning_android.fzt_002_volume;


import android.app.Activity;
import android.inputmethodservice.InputMethodService;
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
public class CubeFragment extends Fragment {

    public CubeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = (View) inflater.inflate(R.layout.fragment_cube, container, false);

        Button mButton = (Button) rootView.findViewById(R.id.buttonCube);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

                EditText editText = (EditText) getView().findViewById(R.id.editTextCube);
                String value_str = editText.getText().toString().trim();

                double value = Double.parseDouble(value_str);

                double result = value * value * value;
                String result_str = String.format("The volume of the Cube is %g", result);

                TextView textView = (TextView) getView().findViewById(R.id.textViewCube);
                textView.setText(result_str);
            }
        });

        return rootView;
    }
}
