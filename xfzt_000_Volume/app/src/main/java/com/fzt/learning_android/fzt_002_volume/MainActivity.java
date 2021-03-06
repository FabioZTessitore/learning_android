package com.fzt.learning_android.fzt_002_volume;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset();
    }

    public void chooseGeometry(View view) {
        int id = ((RadioButton) view).getId();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (id) {
            case R.id.radioCube:
                Cube cube = new Cube();
                VolumeFragment cubeFragment = new VolumeFragment(cube, R.string.cube_side, R.string.cube_do);
                fragmentTransaction.replace(R.id.fragment_container, cubeFragment).commit();
                break;
            case R.id.radioSphere:
                Sphere sphere = new Sphere();
                VolumeFragment sphereFragment = new VolumeFragment(sphere, R.string.sphere_radius, R.string.sphere_do);
                fragmentTransaction.replace(R.id.fragment_container, sphereFragment).commit();
                break;
        }
    }

    public void onReset(View view) {
        reset();
    }

    private void reset() {
        RadioButton radioCube = (RadioButton) findViewById(R.id.radioCube);
        RadioButton radioSphere = (RadioButton) findViewById(R.id.radioSphere);

        radioCube.setChecked(false);
        radioSphere.setChecked(false);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new InitialFragment()).commit();
    }
}
