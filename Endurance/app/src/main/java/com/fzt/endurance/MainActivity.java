package com.fzt.endurance;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] parts = { "0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4" };

    private PlaneFuelAttributes planeAttributes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = this.getPreferences(Context.MODE_PRIVATE);
        this.planeAttributes = new PlaneFuelAttributes(
                settings.getInt("capacity", 0),
                settings.getInt("hourlyConsumption", 0)
        );

        TextView capacityText = (TextView) findViewById(R.id.capacityText);
        TextView hourlyConsumptionText = (TextView) findViewById(R.id.hourlyConsumptionText);
        capacityText.setText(String.format("%d", planeAttributes.getCapacity()));
        hourlyConsumptionText.setText(String.format("%d", planeAttributes.getHourlyConsumption()));

        Spinner serb1spinner = (Spinner) findViewById(R.id.serb1spinner);
        Spinner serb2spinner = (Spinner) findViewById(R.id.serb2spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, parts);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serb1spinner.setAdapter(arrayAdapter);
        serb2spinner.setAdapter(arrayAdapter);

        ItemSelectionHandler itemSelectionHandler = new ItemSelectionHandler();
        serb1spinner.setOnItemSelectedListener(itemSelectionHandler);
        serb2spinner.setOnItemSelectedListener(itemSelectionHandler);
    }

    public void save(View view) {
        TextView capacityText = (TextView) findViewById(R.id.capacityText);
        TextView hourlyConsumptionText = (TextView) findViewById(R.id.hourlyConsumptionText);

        planeAttributes.setCapacity(Integer.parseInt(capacityText.getText().toString()));
        planeAttributes.setHourlyConsumption(Integer.parseInt(hourlyConsumptionText.getText().toString()));

        SharedPreferences settings = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("capacity", planeAttributes.getCapacity());
        editor.putInt("hourlyConsumption", planeAttributes.getHourlyConsumption());
        editor.commit();

        updateEndurance();
    }

    private void updateEndurance() {
        double endurance = planeAttributes.getFuel() / planeAttributes.getHourlyConsumption();
        int hours = (int)endurance;
        int minutes = (int)((endurance-hours) * 60);

        TextView enduranceHH = (TextView) findViewById(R.id.enduranceHH);
        TextView enduranceMM = (TextView) findViewById(R.id.enduranceMM);
        TextView onBoardText = (TextView) findViewById(R.id.fuelOnBoardText);

        enduranceHH.setText(String.format("%02d h", hours));
        enduranceMM.setText(String.format("%02d m", minutes));
        onBoardText.setText(String.format("%02d lt", (int)planeAttributes.getFuel()));
    }

    class ItemSelectionHandler implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            Spinner s1 = (Spinner) findViewById(R.id.serb1spinner);
            Spinner s2 = (Spinner) findViewById(R.id.serb2spinner);

            if (parent == s1) {
                planeAttributes.setTank(0, Double.parseDouble(parts[position]));
            } else if (parent == s2) {
                planeAttributes.setTank(1, Double.parseDouble(parts[position]));
            }

            updateEndurance();
        }

        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    }
}
