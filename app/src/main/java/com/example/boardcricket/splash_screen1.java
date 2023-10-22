package com.example.boardcricket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen1 extends AppCompatActivity {

    ImageView ball, bat, stump;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        ball = findViewById(R.id.cricket_ball);
        bat = findViewById(R.id.cricket_bat);
        stump = findViewById(R.id.cricket_stump);

        Animation alpha1 = AnimationUtils.loadAnimation(this,R.anim.alpha1);
        Animation alpha2 = AnimationUtils.loadAnimation(this,R.anim.alpha2);
        Animation roll = AnimationUtils.loadAnimation(this,R.anim.roll);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stump.startAnimation(alpha1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bat.startAnimation(alpha2);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ball.startAnimation(roll);
                            }
                        },700);
                    }
                },600);
            }
        },500);


        /*stump.startAnimation(alpha);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                bat.startAnimation(alpha);
            }
        }, 1200);

         */


       /* new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                bat.startAnimation(alpha);
            }
        }.start();

        */


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen1.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}