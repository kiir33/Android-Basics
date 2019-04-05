package com.example.linkify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);

        Linkify.addLinks(tv1, Linkify.WEB_URLS);
        Linkify.addLinks(tv2,Linkify.PHONE_NUMBERS);
        Linkify.addLinks(tv3,Linkify.EMAIL_ADDRESSES);
    }
}
