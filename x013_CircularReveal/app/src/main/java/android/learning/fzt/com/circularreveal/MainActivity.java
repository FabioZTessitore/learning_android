package android.learning.fzt.com.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    ImageView imageView;
    int centerX, centerY;
    int radius;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void changeImage(View v) {
        centerX = (mainLayout.getLeft() + mainLayout.getRight()) / 2;
        centerY = (mainLayout.getTop() + mainLayout.getBottom()) / 2;
        radius = Math.max(mainLayout.getWidth(), mainLayout.getHeight());

        Animator animator = ViewAnimationUtils.createCircularReveal(mainLayout, centerX, centerY, radius, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.setImageResource(imageIndex == 0 ? R.drawable.ferrari2 : R.drawable.ferrari);
                imageIndex = 1 - imageIndex;
                Animator reverse = ViewAnimationUtils.createCircularReveal(mainLayout, centerX, centerY, 0, radius);
                reverse.setDuration(500);
                reverse.start();
            }
        });
        animator.setDuration(500);
        animator.start();
    }
}
