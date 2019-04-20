package com.example.notification;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText title, content;
    Button send;
    NotificationHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new NotificationHelper(this);

        title = (EditText)findViewById(R.id.title);
        content = (EditText)findViewById(R.id.content);
        send = (Button)findViewById(R.id.send_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title_txt = title.getText().toString();
                String content_txt = content.getText().toString();

                Notification.Builder builder = helper.getChannelNotification(title_txt,content_txt);
                helper.getManager().notify(new Random().nextInt(), builder.build());
            }
        });
    }
}
