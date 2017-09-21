package com.fzt.learning_android.p004_selectionwidgets;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyListActivity extends ListActivity {

    String[] items={ "lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        this.setListAdapter(arrayAdapter);
    }

    public void prev(View view) {
        Intent intent = new Intent(this, MyListViewActivity.class);
        startActivity(intent);
    }

    public void next(View view) {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    public void onListItemClick(ListView parent, View view, int position, long id) {
        TextView selection = (TextView) findViewById(R.id.selection);
        selection.setText(items[position]);
    }
}
