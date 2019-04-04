package com.example.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button clickme;
    private TextView textView;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickme = (Button)findViewById(R.id.clickme_btn);
        textView = (TextView)findViewById(R.id.textView);

        clickme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter++;
                Toast.makeText(getApplicationContext(),"You clicked The button", Toast.LENGTH_SHORT).show();
                textView.setText("You clicked the button " + counter + " times");
                Log.i("first try","This is a test");
            }
        });

    }
}
