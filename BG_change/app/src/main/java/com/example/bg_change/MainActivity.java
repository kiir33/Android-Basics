package com.example.bg_change;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout f ;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = (RelativeLayout)findViewById(R.id.frame);
        button = (Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btnName = button.getText().toString();
                int col = Color.parseColor("#ff0000");

                if(btnName.equals("RED")){
                    f.setBackgroundColor(col);
                    button.setText("GREEN");
                    Toast.makeText(getApplicationContext(),String.valueOf(col),Toast.LENGTH_SHORT).show();
                }else if(btnName.equals("GREEN")){
                    f.setBackgroundColor(Color.parseColor("#00ff00"));
                    button.setText("BLUE");
                }else{
                    f.setBackgroundColor(Color.parseColor("#0000ff"));
                    button.setText("RED");
                }
            }
        });

    }
}
