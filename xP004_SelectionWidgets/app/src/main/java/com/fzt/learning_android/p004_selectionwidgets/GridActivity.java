package com.fzt.learning_android.p004_selectionwidgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    String[] items={ "lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        GridView grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(arrayAdapter);

        ItemClickHandler itemSelectionHandler = new ItemClickHandler();
        grid.setOnItemClickListener(itemSelectionHandler);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Grid2Activity.class);
        startActivity(intent);
    }

    class ItemClickHandler implements AdapterView.OnItemClickListener
    {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            TextView selection = (TextView) findViewById(R.id.selection);
            selection.setText(items[position]);
        }
    }
}
