package com.example.keng.alarmgo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.e("Service : ","create");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //SETUP RINGTONE
        RingtoneManager Ring_manager=new RingtoneManager(this);
        //get the uri of sound
        Uri uri=Ring_manager.getActualDefaultRingtoneUri(this,RingtoneManager.TYPE_ALARM);
        //set up ringtone
        Ringtone ringtone = Ring_manager.getRingtone(getApplicationContext(),uri);
        //play sound!
        ringtone.play();
        //BUILD UP NOTIFICATION

        //setup notification service
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //create Notification Compat
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                                        .setSmallIcon(R.mipmap.clock)
                                        .setContentTitle("Clock is Ringing")
                                        .setContentText("Merry Christmas！");
        //setup intent goes to mainactivity
        Intent notify_intent=new Intent(this,MainActivity.class);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notify_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        //make the notification parameter

        builder.setContentIntent(pendingIntent);
        notificationManager.notify(0,builder.build());

        return  START_NOT_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public  void onDestroy(){
        Toast.makeText(this,"Call destroy",Toast.LENGTH_SHORT);
    }

}
