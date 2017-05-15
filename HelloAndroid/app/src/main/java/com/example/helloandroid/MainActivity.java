package com.example.helloandroid;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AudioManager audioManager;
    private boolean phoneIsSilent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        this.setup();
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.setup();
    }

    /*@Override
    protected void OnPause() {
        super.onPause();

        this.setup();
    }*/

    private void setup() {
        this.phoneIsSilent = this.checkRingerMode();
        this.setPhoneImage();
    }

    public void onToggleSilentMode(View view) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (nm.isNotificationPolicyAccessGranted()) {
            this.audioManager.setRingerMode(this.phoneIsSilent ? AudioManager.RINGER_MODE_NORMAL : AudioManager.RINGER_MODE_SILENT);
            this.phoneIsSilent = !this.phoneIsSilent;
            this.setPhoneImage();
        } else {
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }
    }

    private boolean checkRingerMode() {
        return (this.audioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT);
    }

    private void setPhoneImage() {
        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        Drawable img = this.getDrawable(this.phoneIsSilent ? R.drawable.phone_silent : R.drawable.phone_on);
        imgView.setImageDrawable(img);
    }
}
