package com.example.boardcricket;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Animation anim, move, translate, translate2;
    View view1, view2;
    int delayTime = 20;
    int i = 0;
    int rollAnimations = 40;
    int flag = 0, run1 = 0, run2 = 0;
    int score1 = 0, score2 = 0;
    int out1 = 0, out2 = 0;
    int resplayer1, resplayer2, australia, india, resplayer1change, resplayer2change;
    Double ov1 = 0.0;
    Double ov2 = 0.0;
    int check1 = 0, check2 = 0;
    int checknoball=0;
    int outflag = 0;
    ImageView roller, imgset, imgplayerplay1, imgplayerplay2;
    TextView txtrun1, txtrun2, txtout1, txtout2, txtname1, txtname2, txtplayerrun1, txtplayerrun2, over1, over2;
    Random random = new Random();
    String out_name1 = "Kohli",out_name2="Smith";
    Handler handler = new Handler();
    int[] diceImages = new int[]{R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

    ImageView out, six, four, wide, noball;
    LottieAnimationView lottie, lottie2, lottieOut, lottieFour, lottieSix, lottieNo;

    Dialog dialog;

    //MediaPlayer mp1 = new MediaPlayer();

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
//        startActivity(intent);
        showAlert();
    }

    @Override
    public void onPause()
    {

        super.onPause();
        /*
        if(mp1.isPlaying()) {
            mp1.pause();
        }

         */
    }

    @Override
    protected void onResume() {

        super.onResume();
        // Resume audio playback when returning to the foreground
        /*
        if (!mp1.isPlaying()) {
            mp1.start();
        }

         */
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottie = findViewById(R.id.lottie3);
        lottieOut = findViewById(R.id.lottie4);
        lottieSix = findViewById(R.id.lottie5);
        lottieFour = findViewById(R.id.lottie6);
        translate2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate2);

        australia = getResources().getIdentifier("australia", "drawable", getPackageName());
        india = getResources().getIdentifier("india", "drawable", getPackageName());

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

        resplayer1change = resplayer1;
        resplayer2change = resplayer2;

//        String check123 = getIntent().getStringExtra("check");
//        int opt = Integer.parseInt(check123);

        view1 = findViewById(R.id.view12);
        view2 = findViewById(R.id.view13);

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        view1.startAnimation(anim);

        move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
        translate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);
        lottie2 = findViewById(R.id.lottie2);
        six = findViewById(R.id.img_six);
        four = findViewById(R.id.img_four);
        out = findViewById(R.id.out);
        wide = findViewById(R.id.img_wide);
        noball = findViewById(R.id.img_no);

        lottie.startAnimation(translate2);

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
        mp1.setLooping(true);
        mp1.start();

         */

        showRules();

        roller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lottie.clearAnimation();
                    rollDice();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void rollDice() throws InterruptedException {


//        Animation anim = AnimationUtils.loadAnimation(this,R.anim.roll);

        String check123 = getIntent().getStringExtra("check");
        int opt = Integer.parseInt(check123);

        int time1 = 100;

        roller.setEnabled(false);
        for (int i = 0; i < 40; i++) {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    int die = random.nextInt(5) + 1;
                    roller.setImageResource(diceImages[die - 1]);
                }
            }, time1);
            time1 += 50;
        }


        int time2 = time1 + 100;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                i = random.nextInt(6) + 1;
                //roller.setImageResource(diceImages[i - 1]);
            }
        }, time2);

        int time3 = time2 + 100;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                switch (i) {
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

                if (i == 6) {
                    lottieSix.startAnimation(translate);
                    lottie2.startAnimation(translate);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lottieSix.clearAnimation();
                            lottie2.clearAnimation();
                        }
                    }, 2400);
                }



                if (i == 4) {
                    lottieFour.startAnimation(translate);
                    lottie2.startAnimation(translate);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lottieFour.clearAnimation();
                            lottie2.clearAnimation();
                        }
                    }, 1600);
                }


                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                resplayer1 = resplayer1change;
                resplayer2 = resplayer2change;

                //i=9;

                // score increment

                int cal2=0;

                if (flag == 0) {

                    int prevscore = score1;

                    if (prevscore == 0) {
                        prevscore = 1;
                    }
                    int b = prevscore;

                    if (i != 5) {
                        score1 = score1 + i;
                        run1 = run1 + i;
                    }

                    if(checknoball!=1) {

                        ov1 = ov1 + 0.1;

                        if (ov1 == 0.6 || ov1 == 1.6 || ov1 == 2.6 || ov1 == 3.6 || ov1 == 4.6) {
                            ov1 = ov1 + 0.4;
                        }

                        ov1 = Double.valueOf(decimalFormat.format(ov1));
                    }



                    if(checknoball==1)
                    {
                        checknoball=0;
                    }

                    int time4=200,time5=400;

                    roller.setEnabled(false);

                    for (int a = prevscore; a <= score1; a++) {

                        String str = "imageView" + a;
                        int resID = getResources().getIdentifier(str, "id", getPackageName());
                        ImageView img = findViewById(resID);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                img.setImageResource(resplayer1);

                                if (score2 != 0) {
                                    String setstr1 = "imageView" + score2;
                                    int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                                    imgset = findViewById(res);
                                    imgset.setImageResource(resplayer2);
                                }
                            }
                        }, time4);

                        time4 += 400;


                        String str2 = "imageView" + b;
                        int resID2 = getResources().getIdentifier(str2, "id", getPackageName());
                        ImageView img2 = findViewById(resID2);

                        if (b < score1 && b != 0) {
                            String str1 = "img_" + b;
                            int resID1 = getResources().getIdentifier(str1, "drawable", getPackageName());
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    img2.setImageResource(resID1);

                                    if (score2 != 0) {

                                        String setstr1 = "imageView" + score2;
                                        int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                                        imgset = findViewById(res);
                                        imgset.setImageResource(resplayer2);
                                    }

                                }
                            }, time5);
                            time5 += 400;
                        }
                        b++;

                    }


                    if (score1 == 7 || score1 == 19 || score1 == 29 || score1 == 37 || score1 == 44 || score1 == 52 || score1 == 60 || score1 == 68 || score1 == 73 || score1 == 85 || score1 == 94) {

                        outflag = 1;
                        out1++;
                        run1 = 0;

                        if (out1 == 1) {
                            out_name1= "Rohit";
                            resplayer1change = getResources().getIdentifier("rohit", "drawable", getPackageName());
                        }
                        if (out1 == 2) {
                            out_name1= "KL";
                            resplayer1change = getResources().getIdentifier("kl", "drawable", getPackageName());

                        }
                        if (out1 == 3) {
                            out_name1= "Dhoni";
                            resplayer1change = getResources().getIdentifier("dhoni", "drawable", getPackageName());

                        }
                        if (out1 == 4) {
                            out_name1= "Jadeja";
                            resplayer1change = getResources().getIdentifier("jadeja", "drawable", getPackageName());
                        }

                        if(out1 == 5){
                            outnotify("Australia");
                        }

                    }

                    int cal = time5 + 100;

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (score1 != 0) {
                                String str = "imageView" + score1;
                                int resID = getResources().getIdentifier(str, "id", getPackageName());
                                ImageView img = findViewById(resID);
                                img.setImageResource(resplayer1change);
                                txtname1.setText(out_name1);
                                imgplayerplay1.setImageResource(resplayer1change);
                            }
                        }
                    }, cal);


                    txtrun1.setText("" + score1);
                    txtplayerrun1.setText("" + run1);
                    txtout1.setText("" + out1);
                    over1.setText("" + ov1);

                    if(out2!=5)
                    {
                        flag = 1;
                    }



                    if (score1 == 5 || score1 == 26 || score1 == 56 || score1 == 63 || score1 == 79) {
                        flag = 0;
                        checknoball=1;
                        roller.setEnabled(true);
                    }

                    cal2 = cal + 100;

                    if (flag == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view1.clearAnimation();
                                view2.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                roller.setEnabled(true);
                            }
                        }, cal2);
                    }
                    else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view2.clearAnimation();
                                view1.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                roller.setEnabled(true);
                            }
                        }, cal2);
                    }


                } else {

                    int prevscore = score2;

                    if (prevscore == 0) {
                        prevscore = 1;
                    }

                    int b = prevscore;

                    if (i != 5) {
                        score2 = score2 + i;
                        run2 = run2 + i;
                    }

                    if(checknoball!=1) {

                        ov2 = ov2 + 0.1;

                        if (ov2 == 0.6 || ov2 == 1.6 || ov2 == 2.6 || ov2 == 3.6 || ov2 == 4.6) {
                            ov2 = ov2 + 0.4;
                        }

                    }


                    if(checknoball==1)
                    {
                        checknoball=0;
                    }

                    ov2 = Double.valueOf(decimalFormat.format(ov2));



                    int time4 = 200, time5 = 400;

                    roller.setEnabled(false);

                    for (int a = prevscore; a <= score2; a++) {

                        String str = "imageView" + a;
                        int resID = getResources().getIdentifier(str, "id", getPackageName());
                        ImageView img = findViewById(resID);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                img.setImageResource(resplayer2);

                                if (score1 != 0) {

                                    String setstr1 = "imageView" + score1;
                                    int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                                    imgset = findViewById(res);
                                    imgset.setImageResource(resplayer1);
                                }

                            }
                        }, time4);
                        time4 += 400;


                        String str2 = "imageView" + b;
                        int resID2 = getResources().getIdentifier(str2, "id", getPackageName());
                        ImageView img2 = findViewById(resID2);

                        if (b < score2 && b != 0) {
                            String str1 = "img_" + b;
                            int resID1 = getResources().getIdentifier(str1, "drawable", getPackageName());
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setImageResource(resID1);

                                    if (score1 != 0) {

                                        String setstr1 = "imageView" + score1;
                                        int res = getResources().getIdentifier(setstr1, "id", getPackageName());
                                        imgset = findViewById(res);
                                        imgset.setImageResource(resplayer1);
                                    }
                                }
                            }, time5);
                            time5 += 400;
                        }

                        b++;

                    }

                    if (score2 == 7 || score2 == 19 || score2 == 29 || score2 == 37 || score2 == 44 || score2 == 52 || score2 == 60 || score2 == 68 || score2 == 73 || score2 == 85 || score2 == 94) {

                        outflag=1;
                        out2++;
                        run2 = 0;

                        if (out2 == 1) {
                            out_name2 = "Finch";
                            resplayer2change = getResources().getIdentifier("finch", "drawable", getPackageName());
                        }
                        if (out2 == 2) {
                            out_name2 = "Warner";
                            resplayer2change = getResources().getIdentifier("warner", "drawable", getPackageName());
                        }
                        if (out2 == 3) {
                            out_name2 = "Watson";
                            resplayer2change = getResources().getIdentifier("watson", "drawable", getPackageName());
                        }
                        if (out2 == 4) {
                            out_name2 = "Marnus";
                            resplayer2change = getResources().getIdentifier("marnus", "drawable", getPackageName());
                        }

                        if(out2 == 5){
                            outnotify("India");
                        }

                    }

                    int cal = time5 + 100;

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (score2 != 0) {

                                String str = "imageView" + score2;
                                int resID = getResources().getIdentifier(str, "id", getPackageName());
                                ImageView img = findViewById(resID);
                                img.setImageResource(resplayer2change);
                                txtname2.setText(out_name2);
                                imgplayerplay2.setImageResource(resplayer2change);
                            }

                        }
                    }, cal);


                    txtrun2.setText("" + score2);
                    txtplayerrun2.setText("" + run2);
                    txtout2.setText("" + out2);
                    over2.setText("" + ov2);

                    if(out1!=5)
                    {
                        flag = 0;
                    }



                    if (score2 == 5 || score2 == 26 || score2 == 56 || score2 == 63 || score2 == 79) {
                        flag = 1;
                        checknoball=1;
                        roller.setEnabled(true);
                    }

                    cal2 = cal + 100;

                    /*
                    if (flag == 1 && opt == 2) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view1.clearAnimation();
                                view2.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                //roller.performClick();
                            }
                        }, cal2);
                    }

                     */

                    if (flag == 0) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view2.clearAnimation();
                                view1.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                roller.setEnabled(true);
                            }
                        }, cal2);
                    }
                    else{
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view1.clearAnimation();
                                view2.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                roller.setEnabled(true);
                            }
                        }, cal2);
                    }




                    /*
                    if(out1==5)
                    {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view1.clearAnimation();
                                view2.startAnimation(anim);
                                lottie.startAnimation(translate2);
                                roller.setEnabled(true);
                            }
                        }, cal2);
                    }

                     */

                }


                int time6 = cal2 + 100;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //check score

                        if (outflag == 1) {
                            lottieOut.startAnimation(translate);
                            lottie2.startAnimation(translate);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    lottieOut.clearAnimation();
                                    lottie2.clearAnimation();
                                }
                            }, 2000);

                            outflag=0;
                        }

                        if(checknoball==1)
                        {
                            noball.startAnimation(translate);
                            lottie2.startAnimation(translate);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    noball.clearAnimation();
                                    lottie2.clearAnimation();
                                }
                            }, 3000);

                            lottie.startAnimation(translate2);
                        }

                        if(ov1==5.0)
                        {
                            flag=1;
                        }

                        if(ov2==5.0)
                        {
                            flag=0;
                        }


                        if (score1 >= 100) {
                            System.out.println("India won");
                            showAlertDialog(R.layout.winner, india);
                            return;
                        } else if (score2 >= 100) {
                            System.out.println("Australia won");
                            showAlertDialog(R.layout.winner, australia);
                            return;
                        }

                        // check out

                        if (out1 == 5) {
                            if (score2 > score1) {
                                showAlertDialog(R.layout.winner, australia);
                                return;
                            } else {
                                flag = 1;
                            }
                        }
                        if (out2 == 5) {
                            if (score1 > score2) {
                                showAlertDialog(R.layout.winner, india);
                                return;
                            } else {
                                flag = 0;
                            }
                        }

                        //check over

                        if (ov1 == 5.0 && ov2 == 5.0) {
                            if (score1 > score2) {
                                System.out.println("India Won");
                                showAlertDialog(R.layout.winner, india);
                                return;
                            } else if (score2 > score1) {
                                System.out.println("Australia Won 3");
                                showAlertDialog(R.layout.winner, australia);
                                return;
                            } else {
                                System.out.println("Draw");
                                drawMatch(R.layout.draw);
                                return;
                            }
                        }

                        if(out1==5 && ov2==5.0 || out2==5 && ov1==5.0)
                        {
                            if (score1 > score2) {
                                System.out.println("India Won");
                                showAlertDialog(R.layout.winner, india);
                                return;
                            }else if (score2 > score1) {
                                System.out.println("Australia Won 3");
                                showAlertDialog(R.layout.winner, australia);
                                return;
                            } else {
                                System.out.println("Draw");
                                drawMatch(R.layout.draw);
                                return;
                            }
                        }


                        if(flag==1 && opt==2)
                        {
                            System.out.println("IN");
                            roller.performClick();
                        }

                    }
                }, time6);

            }
        }, time3);


    }

    private void showAlertDialog(int myLayout, int t) {

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(myLayout);
        dialog.setCancelable(false);

        Button b1 = dialog.findViewById(R.id.menu);
        ImageView img = dialog.findViewById(R.id.flag);
        img.setImageResource(t);
        dialog.show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        //mp1.pause();
    }

    private void drawMatch(int myLayout) {

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(myLayout);
        dialog.setCancelable(false);

        Button b1 = dialog.findViewById(R.id.menu);
        dialog.show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        //mp1.pause();
    }

    private void showAlert() {

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.alert);
        dialog.setCancelable(false);

        Button yes = dialog.findViewById(R.id.ok);
        Button no = dialog.findViewById(R.id.no);

        dialog.show();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mp1.pause();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void showRules(){
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.rule_book);
        dialog.setCancelable(false);

        Button ok = dialog.findViewById(R.id.ok_btn);

        dialog.show();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void outnotify(String country){
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.out_notify);
        dialog.setCancelable(false);

        Button ok = dialog.findViewById(R.id.ok);
        TextView txt = dialog.findViewById(R.id.textView_out_notify);

        txt.setText("5 wickets have been fallen . Now only "+country+" will continue...");
        dialog.show();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }




}