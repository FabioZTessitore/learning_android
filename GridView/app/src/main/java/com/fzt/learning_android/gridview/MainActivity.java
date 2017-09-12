package com.fzt.learning_android.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView selection;
    String[] items = { "Android", "Java", "Linux", "Ubuntu", "Debian", "CentOS" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.selection = (TextView)findViewById(R.id.selection);

        GridView grid = (GridView)findViewById(R.id.grid);
        grid.setAdapter(new FunnyLookingAdapter(this, android.R.layout.simple_list_item_1, items));

        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        this.selection.setText(items[position]);
    }


    private class FunnyLookingAdapter extends ArrayAdapter {
        Context ctxt;

        FunnyLookingAdapter(Context ctxt, int resource, String[] items) {
            super(ctxt, resource, items);

            this.ctxt = ctxt;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView label = (TextView)convertView;

            if (convertView == null) {
                convertView = new TextView(this.ctxt);
                label = (TextView)convertView;
            }

            label.setText(items[position]);

            return convertView;
        }
    }
}
