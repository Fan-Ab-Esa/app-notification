package com.notification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel firstChannel= new NotificationChannel("channelA","Order", NotificationManager.IMPORTANCE_DEFAULT);
            firstChannel.setDescription("This notification shows your orders");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(firstChannel);
        }
    }
}
