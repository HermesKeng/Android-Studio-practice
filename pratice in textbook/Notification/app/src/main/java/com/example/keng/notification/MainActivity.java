package com.example.keng.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static  final int NOTIF_ID=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Click(View view){
        //create Notification service
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //create Notification Compat
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this)
                                                    .setSmallIcon(R.drawable.ic_clock)
                                                    .setContentTitle("Clock is Ringing")
                                                    .setContentText("Merry Christmas！");
        //create Intent & pending Intent
        Intent intent =new Intent(this, NotificationAct.class);
        intent.putExtra("Notification_ID",NOTIF_ID);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        //set builder to use pendingIntent
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(NOTIF_ID,builder.build());
    }
}
