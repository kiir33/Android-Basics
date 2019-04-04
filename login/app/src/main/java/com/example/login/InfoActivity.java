package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {


    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info =  (TextView)findViewById(R.id.info);
        info.setText("Welcome " + getIntent().getStringExtra("USER"));


    }
}
