package com.example.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView upper, lower;
    Button[] upperBtn, lowerBtn;
    private static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upper = (TextView)findViewById(R.id.upper);
        lower = (TextView)findViewById(R.id.lower);

        upperBtn = new Button[]{
                findViewById(R.id.upper_ast),
                findViewById(R.id.upper_zero),
                findViewById(R.id.upper_hash)};

        lowerBtn = new Button[]{
                findViewById(R.id.lower_ast),
                findViewById(R.id.lower_zero),
                findViewById(R.id.lower_hash)};



        for(i = 0; i<3; i++){
            upperBtn[i].setOnClickListener(btnClick);
            lowerBtn[i].setOnClickListener(btnClick);
        }

    }

    public View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.upper_ast:
                    upper.setText("*");
                    break;
                case R.id.upper_zero:
                    upper.setText("0");
                    break;
                case R.id.upper_hash:
                    upper.setText("#");
                    break;

                case R.id.lower_ast:
                    lower.setText("*");
                    break;
                case R.id.lower_zero:
                    lower.setText("0");
                    break;
                case R.id.lower_hash:
                    lower.setText("#");
                    break;
            }
        }
    };
}
