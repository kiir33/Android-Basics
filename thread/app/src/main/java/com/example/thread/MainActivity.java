package com.example.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int rn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text);
        Thread t = new Thread(){
            @Override
            public void run(){
                try{
                    while (!isInterrupted()){
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rn = getRn();
                                String a = String.valueOf(rn);
                                tv.setText(""+rn);
                                if(a.contains("7"))
                                    Toast.makeText(getApplicationContext(),"You are lucky",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }
                catch (InterruptedException e){

                }
            }
        };
        t.start();}

    private int getRn(){
        Random r = new Random();
        return r.nextInt(100);
    }
}