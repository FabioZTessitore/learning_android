package android.learning.fzt.com.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_msg);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.MESSAGE_TAG);

        TextView msgTextView = (TextView) findViewById(R.id.msgTextView);
        if (msg=="") msgTextView.setText(R.string.nomsg);
        else msgTextView.setText(msg);
    }

    public void goHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
