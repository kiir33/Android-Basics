package com.example.basicui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button login, signup;
    private EditText email,pwd;
    Notification.Builder notif;
    private static final int unique_id = 23421;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login_btn);
        signup = (Button)findViewById(R.id.signup_btn);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.password);

        notif = new Notification.Builder(this);
        notif.setAutoCancel(true);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notif.setSmallIcon(R.drawable.ic_face_black_24dp);
                notif.setTicker("This is ticker!");
                notif.setWhen(System.currentTimeMillis());
                notif.setContentTitle("You clicked Login");
                notif.setContentText("This is just a Notification");

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notif.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(unique_id, notif.build());
            }
        });

    }
}
