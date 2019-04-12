package com.example.cardview;

import android.graphics.Picture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int i;

    ImageButton[] imageButtons = new ImageButton[15];
    TextView[] textViews = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews[0] = (TextView)findViewById(R.id.textView1);
        textViews[1] = (TextView)findViewById(R.id.textView2);
        textViews[2] = (TextView)findViewById(R.id.textView3);
        textViews[3] = (TextView)findViewById(R.id.textView4);
        textViews[4] = (TextView)findViewById(R.id.textView5);

        for (i = 0; i < 5; i++){
            textViews[i].setText("Picture " + String.valueOf(i+1));
        }

        imageButtons[0] = (ImageButton) findViewById(R.id.like1);
        imageButtons[1] = (ImageButton)findViewById(R.id.like2);
        imageButtons[2] = (ImageButton)findViewById(R.id.like3);
        imageButtons[3] = (ImageButton)findViewById(R.id.like4);
        imageButtons[4] = (ImageButton)findViewById(R.id.like5);

        imageButtons[5] = (ImageButton) findViewById(R.id.share1);
        imageButtons[6] = (ImageButton)findViewById(R.id.share2);
        imageButtons[7] = (ImageButton)findViewById(R.id.share3);
        imageButtons[8] = (ImageButton)findViewById(R.id.share4);
        imageButtons[9] = (ImageButton)findViewById(R.id.share5);

        imageButtons[10] = (ImageButton) findViewById(R.id.comment1);
        imageButtons[11] = (ImageButton)findViewById(R.id.comment2);
        imageButtons[12] = (ImageButton)findViewById(R.id.comment3);
        imageButtons[13] = (ImageButton)findViewById(R.id.comment4);
        imageButtons[14] = (ImageButton)findViewById(R.id.comment5);

        for (i = 0; i < 15; i++){

            imageButtons[i].setOnClickListener(CommonListener);
        }


    }

    public View.OnClickListener CommonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.like1:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.like2:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.like3:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.like4:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.like5:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.comment1:
                    Toast.makeText(MainActivity.this, "Comment Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.comment2:
                    Toast.makeText(MainActivity.this, "Comment Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.comment3:
                    Toast.makeText(MainActivity.this, "Comment Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.comment4:
                    Toast.makeText(MainActivity.this, "Comment Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.comment5:
                    Toast.makeText(MainActivity.this, "Comment Clicked!", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.share1:
                    Toast.makeText(MainActivity.this, "Share Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share2:
                    Toast.makeText(MainActivity.this, "Share Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share3:
                    Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share4:
                    Toast.makeText(MainActivity.this, "Share Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share5:
                    Toast.makeText(MainActivity.this, "Share Clicked!", Toast.LENGTH_SHORT).show();
                    break;


            }

        }
    };


}
