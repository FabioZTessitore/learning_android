package com.fzt.learning_android.fzt_002_volume;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cube, container, false);

        View rootView = (View) inflater.inflate(R.layout.fragment_cube, container, false);

        Button mButton = (Button) rootView.findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) getView().findViewById(R.id.editText2);
                String value_str = editText.getText().toString().trim();
                double value = Double.parseDouble(value_str);
                double result = value * value * value;
                String result_str = String.format("The volume of the Cube is %.2g", result);
                TextView textView = (TextView) getView().findViewById(R.id.textView4);
                textView.setText(result_str);
            }
        });

        return rootView;
    }
}
