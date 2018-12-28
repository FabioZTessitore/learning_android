package android.learning.fzt.com.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_TAG = "android.learning.fzt.com.intent.MainActivity";
    EditText msgEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgEditText = (EditText) findViewById(R.id.msgEditText);
    }

    public void sendMessage(View v) {
        String msg = msgEditText.getText().toString();
        Intent intent = new Intent(this, ShowMsgActivity.class);
        intent.putExtra(MESSAGE_TAG, msg);
        startActivity(intent);
    }
}
