package android.learning.fzt.com.animate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Animation shakeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        //shakeAnimation.setRepeatCount(3);
    }

    public void shakeImage(View v) {
        imageView.startAnimation(shakeAnimation);
    }
}
