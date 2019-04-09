package com.example.time;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public DateTimeFormatter t;
    public TextView time, date;
    Handler handler = new Handler();
    Runnable refresh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        time = (TextView)findViewById(R.id.timeDisp);
        date = (TextView)findViewById(R.id.dateDisp); 


        refresh = new Runnable() {
            public void run() {
                // Do something
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                String t = s.format(new Date());
                time.setText("Current Time: " + t);

                getDateTime();

                handler.postDelayed(refresh, 1000);
            }
        };
        handler.post(refresh);

    }

    private void getDateTime(){
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dt = s.format(new Date());
        date.setText("Today's Date: " + dt);
    }
}
