package com.fzt.learning_android.fzt_003_thesum;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private int totalSum = 0;
    private int partialSum = 0;
    private final String filename = "thesum.dat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.totalSum = 0;
        this.partialSum = 0;
        this.updatePartialSum();

        FileInputStream inputStream;
        try {
            inputStream = openFileInput(this.filename);
            Scanner scanner = new Scanner(inputStream);
            this.totalSum = scanner.nextInt();
            inputStream.close();

            this.updateTotalSum();
        } catch (Exception e) {
            FileOutputStream outputStream;
            String initialValue = "0";
            try {
                outputStream = openFileOutput(this.filename, this.MODE_PRIVATE);
                outputStream.write(initialValue.getBytes());
                outputStream.close();
            } catch (Exception ee) {
                Toast.makeText(this, getString(R.string.unable_create_file) + " " + filename, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.partialSum = 0;
        this.updatePartialSum();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void add(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText editText = (EditText) findViewById(R.id.editText);
        String value_to_add_str = editText.getText().toString().trim();
        editText.setText("");

        int value_to_add = 0;
        try {
            value_to_add = Integer.parseInt(value_to_add_str);
        } catch (Exception e) {
            value_to_add = 0;
            Toast.makeText(this, getString(R.string.int_too_big), Toast.LENGTH_SHORT).show();
        }

        partialSum += value_to_add;
        totalSum += value_to_add;
        if (totalSum < 0) {
            totalSum = 0;
            Toast.makeText(this, getString(R.string.max_value), Toast.LENGTH_SHORT).show();
        }

        this.updatePartialSum();
        this.updateTotalSum();
        this.saveTotalSum();
    }

    private void updatePartialSum() {
        TextView partialText = (TextView) findViewById(R.id.partialView);
        partialText.setText(String.format("%d", partialSum));
    }

    private void updateTotalSum() {
        TextView totalText = (TextView) findViewById(R.id.totalView);
        totalText.setText(String.format("%d", totalSum));
    }

    private void saveTotalSum() {
        FileOutputStream outputStream;

        TextView textView = (TextView) findViewById(R.id.totalView);
        String total = textView.getText().toString();

        try {
            outputStream = openFileOutput(this.filename, this.MODE_PRIVATE);
            outputStream.write(total.getBytes());
            outputStream.close();
        } catch (Exception ee) {
            Toast.makeText(this, getString(R.string.unable_save_data), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuReset:
                this.totalSum = 0;
                this.updateTotalSum();
                this.saveTotalSum();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
