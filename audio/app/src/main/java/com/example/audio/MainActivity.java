package com.example.audio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.toxicity);
        button = findViewById(R.id.button);
        btnStop = findViewById(R.id.buttonStop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String btn = button.getText().toString();
                    if(btn.equals("PLAY")){
                        try {
                            mediaPlayer.start();
                            button.setText("PAUSE");
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT);
                            Log.e("Music", e.toString());
                        }

                    }else if(btn.equals("PAUSE")){
                        mediaPlayer.pause();
                        button.setText("PLAY");

                    }else {

                    }
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Couldn't Play",Toast.LENGTH_SHORT);

                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
            }
        });
    }
}
