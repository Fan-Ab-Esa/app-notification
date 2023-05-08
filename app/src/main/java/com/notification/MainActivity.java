package com.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }
    private void sendNotification(){
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent myPendingIntent= PendingIntent.getActivity(this,2,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"channelA")
                .setContentTitle("Hello world")
                .setSmallIcon(R.drawable.ic_notificatoin)
                .setContentText("Your order is ready")
                .setContentIntent(myPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationManagerCompat.IMPORTANCE_DEFAULT);

        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        manager.notify(1,builder.build());
    }
}