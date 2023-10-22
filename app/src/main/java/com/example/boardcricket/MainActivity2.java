package com.example.boardcricket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    CardView cardView1, cardView2;
    Button b1,music_btn;
    MediaPlayer mp1 = new MediaPlayer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);

        b1 = findViewById(R.id.button);
//hello
//        mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        String path1 = "android.resource://" + getPackageName() + "/raw/wdlbobsbeat";
//
//        Uri audioURI1 = Uri.parse(path1);
//        try {
//            mp1.setDataSource(this, audioURI1);
//            mp1.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mp1.start();
/*
        music_btn = findViewById(R.id.music_btn);

        music_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if(Objects.equals(music_btn.getBackground().getConstantState(),getResources().getDrawable(R.drawable.music_on).getConstantState())){
                    music_btn.setBackgroundResource(R.drawable.music_off);
                    mp1.pause();
                }
                else {
                    music_btn.setBackgroundResource(R.drawable.music_on);
                    mp1.start();
                }
            }
        });
*/
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Future Goal !!", Toast.LENGTH_SHORT).show();
            }
        });

        /*

        mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String path1 = "android.resource://" + getPackageName() + "/raw/wdlbobsbeat";

        Uri audioURI1 = Uri.parse(path1);
        try {
            mp1.setDataSource(this, audioURI1);
            mp1.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp1.start();

         */

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Future Goal !!", Toast.LENGTH_SHORT).show();
            }
        });


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("check","1");
                startActivity(intent);
                finish();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("check","2");
                startActivity(intent);
                finish();
            }
        });

    }


}