package com.example.samplegame;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import static android.view.animation.Animation.REVERSE;

public class MainActivity extends AppCompatActivity {

    ProgressBar upr,low;
    Button uprBtn, lowBtn;
    TextView uprTxt, lowTxt, uprCount, lowCount;
    AlertDialog.Builder alert;

    private int progressStatus=0;
    private Handler handler = new Handler();
    private static int redNum, greenNum, redWin = 0, greenWin =0;

    private ObjectAnimator greenAnimator, redAnimator;



    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization
        upr = (ProgressBar)findViewById(R.id.upper_prog);
        low = (ProgressBar)findViewById(R.id.lower_prog);
        uprBtn = (Button)findViewById(R.id.upperBtn);
        lowBtn = (Button)findViewById(R.id.lowerBtn);
        uprTxt = (TextView)findViewById(R.id.upr_textView);
        lowTxt = (TextView)findViewById(R.id.low_textView2);
        uprCount = (TextView)findViewById(R.id.uprCount);
        lowCount = (TextView)findViewById(R.id.lowCount);

        //blink animation initialization
        greenAnimator = ObjectAnimator.ofInt(lowTxt,"backgroundColor",
                Color.WHITE,
                Color.argb(255,0,153,51),
                Color.WHITE);
        greenAnimator.setDuration(1000);
        greenAnimator.setEvaluator(new ArgbEvaluator());
        greenAnimator.setRepeatMode(REVERSE);
        greenAnimator.setRepeatCount(Animation.INFINITE);

        redAnimator = ObjectAnimator.ofInt(uprTxt,"backgroundColor",
                Color.WHITE,
                Color.argb(255,255,0,102),
                Color.WHITE);
        redAnimator.setDuration(1000);
        redAnimator.setEvaluator(new ArgbEvaluator());
        redAnimator.setRepeatMode(REVERSE);
        redAnimator.setRepeatCount(Animation.INFINITE);


        alert = new AlertDialog.Builder(MainActivity.this);


        BtnEnabler(1);
        animator(1);


        lowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
                BtnEnabler(0);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus <100){
                            progressStatus++;
                            SystemClock.sleep(10);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    low.setProgress(progressStatus);
                                    lowTxt.setText(String.valueOf(new Random().nextInt(6)+1));
                                }
                            });
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                greenNum = new Random().nextInt(6)+1;
                                lowTxt.setText(String.valueOf(greenNum));
                                animator(-1);
                                BtnEnabler(-1);
                            }
                        });

                    }
                }).start();
            }
        });

        uprBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
                BtnEnabler(0);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus <100){
                            progressStatus++;
                            SystemClock.sleep(10);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    upr.setProgress(progressStatus);
                                    uprTxt.setText(String.valueOf(new Random().nextInt(6)+1));
                                }
                            });
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                redNum = new Random().nextInt(6)+1;
                                uprTxt.setText(String.valueOf(redNum));
                                animator(1);
                                BtnEnabler(1);

                                if(redNum > greenNum){
                                    alertSetter("Red");
                                }else if(redNum == greenNum){
                                    alertSetter("draw");
                                }
                                else {
                                    alertSetter("Green");
                                }

                            }
                        });

                    }
                }).start();

            }
        });
    }

    @SuppressLint("WrongConstant")


    public void BtnEnabler(int user){
        if(user == 1){
            uprBtn.setEnabled(false);
            lowBtn.setEnabled(true);
        }else if(user == 0){
            lowBtn.setEnabled(false);
            uprBtn.setEnabled(false);
        }else {
            lowBtn.setEnabled(false);
            uprBtn.setEnabled(true);
        }
    }


    public void animator(int user){
        if(user == 1){
            redAnimator.end();
            greenAnimator.start();

        }else{
            greenAnimator.end();
            redAnimator.start();
        }
    }

    public void alertSetter(String color){
        String msg,title;
        if(!color.equals("draw")){
            msg = color + " WON!";
            title = "Congrats!";
            if (color == "Red") {
                redWin += 1;
            } else {
                greenWin += 1;
            }

            uprCount.setText(String.valueOf(redWin));
            lowCount.setText(String.valueOf(greenWin));

        }else{
            msg = "DRAW!";
            title = "Oops!";
        }

        alert.setMessage(msg)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                greenNum = 0;
                redNum = 0;
            }
        });

        AlertDialog alertDialog =alert.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {


        alert.setMessage("Are you sure you want to Exit this app ?").
                setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        redWin = greenWin = 0;
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog =alert.create();
        alertDialog.setTitle("Closing App !");
        alertDialog.show();
    }
}
