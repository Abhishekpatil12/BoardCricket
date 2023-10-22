package com.example.boardcricket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    Animation anim, move, translate;
    int delayTime = 20;
    int i=0;
    int rollAnimations = 40;
    int flag=0,run1=0,run2=0;
    int resplayer1,resplayer2;
    Double ov1 = 0.0;
    Double ov2 = 0.0;
    int check1=0,check2=0;
    View view1, view2;
    ImageView roller,imgset,imgplayerplay1,imgplayerplay2;
    TextView txtrun1,txtrun2,txtout1,txtout2,txtname1,txtname2,txtplayerrun1,txtplayerrun2,over1,over2;
    Random random = new Random();
    String str="imageView";
    Handler handler = new Handler();
    int[] diceImages = new int[]{R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

    ImageView out,six,four,wide,noball;
    LottieAnimationView lottie, lottie2;
    MediaPlayer mp1 = new MediaPlayer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mp1.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String path1 = "android.resource://"+getPackageName()+"/raw/cheer";
        Uri audioURI1 = Uri.parse(path1);
        try {
            mp1.setDataSource(this,audioURI1);
            mp1.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        roller = findViewById(R.id.roller1);
        txtrun1 = findViewById(R.id.textView4);
        txtrun2 = findViewById(R.id.textView6);

        txtout1 = findViewById(R.id.textView9);
        txtout2 = findViewById(R.id.textView10);

        txtname1 = findViewById(R.id.textView3);
        txtname2 = findViewById(R.id.textView5);

        txtplayerrun1 = findViewById(R.id.textView8);
        txtplayerrun2 = findViewById(R.id.textView7);

        imgplayerplay1 = findViewById(R.id.imageView101);
        imgplayerplay2 = findViewById(R.id.imageView102);

        over1 = findViewById(R.id.textView15);
        over2 = findViewById(R.id.textView16);

        txtrun1.setText("0");
        txtrun2.setText("0");

        txtout1.setText("0");
        txtout2.setText("0");

        txtplayerrun1.setText("0");
        txtplayerrun2.setText("0");

        resplayer1 = getResources().getIdentifier("virat", "drawable", getPackageName());
        resplayer2 = getResources().getIdentifier("steve", "drawable", getPackageName());

        view1 = findViewById(R.id.view9);
        view2 = findViewById(R.id.view11);

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        view1.startAnimation(anim);

        move = AnimationUtils.loadAnimation(MainActivity3.this, R.anim.move);
        translate = AnimationUtils.loadAnimation(MainActivity3.this, R.anim.translate);
        lottie2 = findViewById(R.id.lottie2);
        six = findViewById(R.id.img_six);
        four = findViewById(R.id.img_four);
        out = findViewById(R.id.out);
        wide = findViewById(R.id.img_wide);
        noball = findViewById(R.id.img_no);

        roller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    rollDice();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    private void rollDice() throws InterruptedException {

        i = random.nextInt(6)+1;
        roller.setImageResource(diceImages[i-1]);

        if(flag==0)
        {

            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            int score = Integer.parseInt((String) txtrun1.getText());

            ov1 = Double.parseDouble((String) over1.getText());

            if(check1==0) {

                ov1 = ov1 + 0.1;
                ov1 = Double.valueOf(decimalFormat.format(ov1));

                if (ov1 == 0.7 || ov1 == 1.7 || ov1 == 2.7 || ov1 == 3.7 || ov1 == 4.7) {
                    ov1 = ov1 + 0.3;
                    ov1 = Double.valueOf(decimalFormat.format(ov1));
                }
                check1=0;
            }

            if(check1==1)
            {
                check1=0;
            }

            int prevscore = score;

            if(score!=0) {


                String setstr1 = "imageView" + score;
                int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                String setstr2 = "img_" + score;
                int res2 = getResources().getIdentifier(setstr2, "drawable", getPackageName());
                imgset = findViewById(res);
                //String strprev = "img_25";
                imgset.setImageResource(res2);

            }

            if(i==6)
            {
                mp1.start();
                six.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        six.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);
            }

            if(i==4)
            {
                mp1.start();
                four.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        four.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);
            }

            if(i!=5)
            {
                score = score + i;
                run1 = run1 + i;
            }

            if(i==5) {

                String setstr1 = "imageView" + score;
                int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                //String setstr2 = "img_" + score;
                //int res2 = getResources().getIdentifier(setstr2, "drawable", getPackageName());
                imgset = findViewById(res);
                //String strprev = "img_25";
                imgset.setImageResource(resplayer1);

            }



            int time1 = 200, time2=400;

            int score10 = Integer.parseInt((String) txtrun2.getText());

            for(int a=prevscore; a<score ; a++) {
                String str = "imageView" + (a + 1);
                int resID = getResources().getIdentifier(str, "id", getPackageName());
                ImageView img = findViewById(resID);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        img.setImageResource(resplayer1);
                    }
                }, time1);
                time1 += 400;

                if(a<score-1){
                    String str1 = "img_" + (a + 1);
                    int resID1 = getResources().getIdentifier(str1, "drawable", getPackageName());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageResource(resID1);
                        }
                    }, time2);
                    time2 += 400;
                }
            }

            String setstr = str + score;

            over1.setText(""+ov1);
            txtrun1.setText(""+score);
            txtplayerrun1.setText(""+run1);

            flag=1;

            if(score==9 || score==26 || score==56 || score==63 || score==79)
            {
                flag=0;
                check1=1;

                noball.startAnimation(move);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        noball.clearAnimation();
                    }
                },2000);
            }

            if(score==4 || score==24 || score==29 || score==37 || score==44 || score==52 || score==60 || score==68 || score==73 || score==85 || score==94)
            {
                mp1.start();
                out.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        out.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);

                int out = Integer.parseInt((String) txtout1.getText());

                run1 = 0;

                out = out + 1;

                txtout1.setText(""+out);

                if(out==1)
                {
                    txtname1.setText("Rohit");
                    txtplayerrun1.setText("0");
                    resplayer1 = getResources().getIdentifier("rohit", "drawable", getPackageName());

                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());

                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer1);
                    imgplayerplay1.setImageResource(resplayer1);


                }
                if(out==2)
                {
                    txtname1.setText("KL Rahul");
                    txtplayerrun1.setText("0");
                    resplayer1 = getResources().getIdentifier("kl", "drawable", getPackageName());

                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());

                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer1);
                    imgplayerplay1.setImageResource(resplayer1);
                }
                if(out==3)
                {
                    txtname1.setText("MS Dhoni");
                    txtplayerrun1.setText("0");
                    resplayer1 = getResources().getIdentifier("dhoni", "drawable", getPackageName());
                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());

                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer1);
                    imgplayerplay1.setImageResource(resplayer1);
                }
                if(out==4)
                {
                    txtname1.setText("Jadeja");
                    txtplayerrun1.setText("0");
                    resplayer1 = getResources().getIdentifier("jadeja", "drawable", getPackageName());
                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());

                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer1);
                    imgplayerplay1.setImageResource(resplayer1);
                }
            }

            if(flag == 1){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view1.clearAnimation();
                        view2.startAnimation(anim);
                    }
                },1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        roller.performClick();
                    }
                }, 2500);
            }

        }
        else
        {

            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            int score = Integer.parseInt((String) txtrun2.getText());


            ov2 = Double.parseDouble((String) over2.getText());

            if(check2==0) {

                ov2 = ov2 + 0.1;
                ov2 = Double.valueOf(decimalFormat.format(ov2));

                if (ov2 == 0.7 || ov2 == 1.7 || ov2 == 2.7 || ov2 == 3.7 || ov2 == 4.7) {
                    ov2 = ov2 + 0.3;
                    ov2 = Double.valueOf(decimalFormat.format(ov2));
                }
                check2=0;

            }

            if(check2==1)
            {
                check2=0;
            }

            int prevscore = score;

            if(score!=0) {

                String setstr1 = "imageView" + score;
                int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                String setstr2 = "img_" + score;
                int res2 = getResources().getIdentifier(setstr2, "drawable", getPackageName());
                imgset = findViewById(res);
                //String strprev = "img_25";
                imgset.setImageResource(res2);

            }
            if(i==6)
            {
                mp1.start();
                six.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        six.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);
            }

            if(i==4)
            {
                mp1.start();
                four.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        four.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);
            }

            if(i!=5)
            {
                score = score + i;
                run2 = run2 + i;
            }

            if(i==5) {

                String setstr1 = "imageView" + score;
                int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                //String setstr2 = "img_" + score;
                //int res2 = getResources().getIdentifier(setstr2, "drawable", getPackageName());
                imgset = findViewById(res);
                //String strprev = "img_25";
                imgset.setImageResource(resplayer2);

            }

            int time1 = 200, time2=400;

            for(int a=prevscore; a<score; a++) {
                String str = "imageView" + (a + 1);
                int resID = getResources().getIdentifier(str, "id", getPackageName());
                ImageView img = findViewById(resID);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        img.setImageResource(resplayer2);
                    }
                }, time1);
                time1 += 400;

                if(a<score-1){
                    String str1 = "img_" + (a + 1);
                    int resID1 = getResources().getIdentifier(str1, "drawable", getPackageName());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            img.setImageResource(resID1);
                        }
                    }, time2);
                    time2 += 400;
                }
            }



            String setstr = str + score;

            String strprev="img_10";

            int res1 = getResources().getIdentifier(setstr,"id",getPackageName());

            txtrun2.setText(""+score);
            over2.setText(""+ov2);
            txtplayerrun2.setText(""+run2);

            flag=0;

            /*

            if(score==6 || score==19 || score==32 || score==51 || score==75)
            {

                String setstr1 = "imageView" + score;
                int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                String setstr2 = "img_" + score;
                int res2 = getResources().getIdentifier(setstr2, "drawable", getPackageName());
                imgset = findViewById(res);
                //String strprev = "img_25";
                imgset.setImageResource(res2);

                score = score + 1;

                setstr = str + score;


                res1 = getResources().getIdentifier(setstr,"id",getPackageName());

                imgset = findViewById(res1);
                imgset.setImageResource(R.drawable.steve);

                txtrun1.setText(""+score);

            }

             */

            if(score==9 || score==26 || score==56 || score==63 || score==79)
            {
                flag=1;
                check2=1;

                noball.startAnimation(move);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        noball.clearAnimation();
                    }
                },2000);
            }

            if(score==4 || score==24 || score==29 || score==37 || score==44 || score==52 || score==60 || score==68 || score==73 || score==85 || score==94)
            {

                mp1.start();
                out.startAnimation(move);
                lottie2.startAnimation(translate);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mp1.pause();
                        out.clearAnimation();
                        lottie2.clearAnimation();
                    }
                },2000);

                int out = Integer.parseInt((String) txtout2.getText());
                System.out.println("out : "+out);

                out = out + 1;

                run2 = 0;

                System.out.println("out1 : "+out);

                txtout2.setText(""+out);

                if(out==1)
                {
                    txtname2.setText("Finch");
                    txtplayerrun2.setText("0");
                    resplayer2 = getResources().getIdentifier("finch", "drawable", getPackageName());

                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());
                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer2);
                    imgplayerplay2.setImageResource(resplayer2);
                }
                if(out==2)
                {
                    txtname2.setText("Warner");
                    txtplayerrun2.setText("0");
                    resplayer2 = getResources().getIdentifier("warner", "drawable", getPackageName());
                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());
                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer2);
                    imgplayerplay2.setImageResource(resplayer2);
                }
                if(out==3)
                {
                    txtname2.setText("Watson");
                    txtplayerrun2.setText("0");
                    resplayer2 = getResources().getIdentifier("watson", "drawable", getPackageName());
                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());
                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer2);
                    imgplayerplay2.setImageResource(resplayer2);
                }
                if(out==4)
                {
                    txtname2.setText("Marnus");
                    txtplayerrun2.setText("0");
                    resplayer2 = getResources().getIdentifier("marnus", "drawable", getPackageName());
                    int res2 = getResources().getIdentifier(setstr,"id",getPackageName());
                    imgset = findViewById(res2);
                    imgset.setImageResource(resplayer2);
                    imgplayerplay2.setImageResource(resplayer2);
                }

            }


            if(flag == 1){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        roller.performClick();
                    }
                }, 2500);
            }else{
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view2.clearAnimation();
                        view1.startAnimation(anim);
                    }
                },1000);
            }

        }


//        Animation anim = AnimationUtils.loadAnimation(this,R.anim.roll);
        switch(i){
            case 1:
                roller.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                roller.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                roller.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                roller.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                roller.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                roller.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void roll(){

    }


}