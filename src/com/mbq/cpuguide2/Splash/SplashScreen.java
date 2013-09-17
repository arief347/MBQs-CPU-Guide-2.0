package com.mbq.cpuguide2.Splash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mbq.cpuguide2.GuideActivity;
import com.mbq.cpuguide2.R;

public class SplashScreen extends Activity {
	private static int SPLASH_TIME_OUT = 3100;
	
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Window window = getWindow();
		window.setFormat(PixelFormat.RGBA_8888);
	}
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        StartAnimations();
    }
        
        private void StartAnimations() {
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
            anim.reset();
            RelativeLayout r=(RelativeLayout) findViewById(R.id.r_lay);
            r.clearAnimation();
            r.startAnimation(anim);
            
            anim = AnimationUtils.loadAnimation(this, R.anim.translate);
            anim.reset();
            TextView tv = (TextView) findViewById(R.id.textView1);
            tv.clearAnimation();
            tv.startAnimation(anim);
            
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, GuideActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}
