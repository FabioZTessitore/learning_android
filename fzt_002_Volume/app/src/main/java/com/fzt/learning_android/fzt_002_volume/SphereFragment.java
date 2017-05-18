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
public class SphereFragment extends Fragment {


    public SphereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = (View) inflater.inflate(R.layout.fragment_sphere, container, false);

        Button mButton = (Button) rootView.findViewById(R.id.buttonSphere);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

                EditText editText = (EditText) getView().findViewById(R.id.editTextSphere);
                String value_str = editText.getText().toString().trim();

                double value = Double.parseDouble(value_str);
                double result_div_pi = 4. / 3. * value * value * value;
                double result = Math.PI * result_div_pi;

                String result_str = String.format("The volume of the Sphere is %g\u03c0 = %g", result_div_pi, result);

                TextView textView = (TextView) getView().findViewById(R.id.textViewSphere);
                textView.setText(result_str);
            }
        });

        return rootView;
    }

}