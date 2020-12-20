package com.example.endurance;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] tankFillings = { "0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4" };

    private PlaneFuelAttributes planeFuelAttributes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SharedPreferences settings = this.getPreferences(Context.MODE_PRIVATE);
        this.planeFuelAttributes = new PlaneFuelAttributes(
                settings.getInt("capacity", 0),
                settings.getInt("hourlyConsumption", 0)
        );*/
        this.planeFuelAttributes = new PlaneFuelAttributes(0, 0);

        TextView capacityText = (TextView) findViewById(R.id.capacityText);
        TextView hourlyConsumptionText = (TextView) findViewById(R.id.hourlyConsumptionText);
        // capacityText.setText(String.format("%d", planeFuelAttributes.getCapacity()));
        // hourlyConsumptionText.setText(String.format("%d", planeFuelAttributes.getHourlyConsumption()));

        Spinner tankLeftSpinner = (Spinner) findViewById(R.id.tankLeftSpinner);
        Spinner tankRightSpinner = (Spinner) findViewById(R.id.tankRightSpinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tankFillings);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tankLeftSpinner.setAdapter(arrayAdapter);
        tankRightSpinner.setAdapter(arrayAdapter);

        ItemSelectionHandler itemSelectionHandler = new ItemSelectionHandler();
        tankLeftSpinner.setOnItemSelectedListener(itemSelectionHandler);
        tankRightSpinner.setOnItemSelectedListener(itemSelectionHandler);
    }

    public void savePreferences(View view) {
        TextView capacityText = (TextView) findViewById(R.id.capacityText);
        TextView hourlyConsumptionText = (TextView) findViewById(R.id.hourlyConsumptionText);

        planeFuelAttributes.setCapacity( Integer.parseInt(capacityText.getText().toString()) );
        planeFuelAttributes.setHourlyConsumption( Integer.parseInt(hourlyConsumptionText.getText().toString()) );

        // SharedPreferences settings = this.getPreferences(Context.MODE_PRIVATE);
        // SharedPreferences.Editor editor = settings.edit();
        // editor.putInt("capacity", planeFuelAttributes.getCapacity());
        // editor.putInt("hourlyConsumption", planeFuelAttributes.getHourlyConsumption());
        // editor.commit();

        updateEndurance();
    }

    private void updateEndurance() {
        double endurance = planeFuelAttributes.getFuel() / planeFuelAttributes.getHourlyConsumption();
        int hours = (int)endurance;
        int minutes = (int)((endurance-hours) * 60);

        TextView enduranceHH = (TextView) findViewById(R.id.enduranceHH);
        TextView enduranceMM = (TextView) findViewById(R.id.enduranceMM);
        TextView onBoardText = (TextView) findViewById(R.id.fuelOnBoardText);

        enduranceHH.setText(String.format("%02d h", hours));
        enduranceMM.setText(String.format("%02d m", minutes));
        onBoardText.setText(String.format("%02d lt", (int) planeFuelAttributes.getFuel()));
    }

    class ItemSelectionHandler implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            Spinner s1 = (Spinner) findViewById(R.id.tankLeftSpinner);
            Spinner s2 = (Spinner) findViewById(R.id.tankRightSpinner);

            double tankFillingPosition = Double.parseDouble(tankFillings[position]);

            if (parent == s1) {
                planeFuelAttributes.setTankLeft( tankFillingPosition );
            } else if (parent == s2) {
                planeFuelAttributes.setTankRight( tankFillingPosition );
            }

            updateEndurance();
        }

        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    }
}
