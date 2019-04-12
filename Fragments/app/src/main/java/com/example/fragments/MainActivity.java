package com.example.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements topFragment.OnMessageReader {

    private TextView textView;
    private Object topFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }

            topFragment fragment = new topFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragment_container,fragment,null);
            fragmentTransaction.commit();
        }


    }

    @Override
    public void onMessageRead(String message) {
        textView = (TextView)findViewById(R.id.output);
        textView.setText(message);
    }
}
