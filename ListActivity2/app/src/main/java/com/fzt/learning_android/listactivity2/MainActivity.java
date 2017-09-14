package com.fzt.learning_android.listactivity2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Wrapper;

public class MainActivity extends ListActivity {

    TextView selection;
    ListView list;

    String[] items={ "lorem", "ipsum", "dolor", "sit", "amet",
"consectetuer", "adipiscing", "elit", "morbi", "vel",
"ligula", "vitae", "arcu", "aliquet", "mollis",
"etiam", "vel", "erat", "placerat", "ante",
"porttitor", "sodales", "pellentesque", "augue",
"purus" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = (TextView)findViewById(R.id.selection);

        this.setListAdapter(new IconicAdapter());
    }

    private String getModel(int position) {
        return (String) ((IconicAdapter)getListAdapter()).getItem(position);
    }

    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(getModel(position));
    }

    private class IconicAdapter extends ArrayAdapter {
        IconicAdapter () {
            super (MainActivity.this, R.layout.row, items);
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewWrapper wrapper = null;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);

                wrapper = new ViewWrapper(row);
                row.setTag(wrapper);
            } else {
                wrapper = (ViewWrapper)row.getTag();
            }

            wrapper.getLabel().setText(getModel(position));

            if (getModel(position).length() > 4) {
                wrapper.getIcon().setImageResource(android.R.drawable.ic_delete);
            } else {
                wrapper.getIcon().setImageResource(android.R.drawable.star_on);
            }

            return row;
        }
    }

    private class ViewWrapper {
        View base;
        TextView label = null;
        ImageView icon = null;

        ViewWrapper(View base) {
            this.base = base;
        }

        TextView getLabel() {
            if (label == null) {
                label = (TextView) base.findViewById(R.id.label);
            }

            return label;
        }

        ImageView getIcon() {
            if (icon == null) {
                icon = (ImageView) base.findViewById(R.id.icon);
            }

            return icon;
        }
    }
}
