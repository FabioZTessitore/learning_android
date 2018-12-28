package android.learning.fzt.com.toastalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toastButton = (Button) findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), R.string.toast_message, Toast.LENGTH_SHORT).show();
            }
        });

        Button alertButton = (Button) findViewById(R.id.alertButton);
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(R.string.alert_message_title)
                        .setMessage(R.string.alert_message)
                        .setNeutralButton(R.string.alert_neutral, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // nothing to do
                            }
                        }).show();
            }
        });
    }
}
