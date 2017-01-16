package com.example.keng.notification;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationManager notif_Manger=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        int n=getIntent().getExtras().getInt("Notification_ID");
        notif_Manger.cancel(n);
    }
}
