package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

public class NotificationHelper extends ContextWrapper {

    private static final String CHANNEL_ID = "com.example.notification";
    private static final String CHANNEL_NAME = "Kiran Channel";
    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    private void createChannels() {

        NotificationChannel kiranChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        kiranChannel.enableLights(true);
        kiranChannel.enableVibration(true);
        kiranChannel.setLightColor(Color.BLUE);
        kiranChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(kiranChannel);

    }

    public NotificationManager getManager() {
        if(manager == null){
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public Notification.Builder getChannelNotification(String title, String body){
        return  new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);
    }
}
