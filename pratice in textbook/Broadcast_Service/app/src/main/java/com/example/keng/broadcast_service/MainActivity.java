package com.example.keng.broadcast_service;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn1Click(View view){

        Intent i=new Intent("android.broadcast.TOAST");
        sendBroadcast(i);
    }
    public void btn2Click(View view){
        RingtoneManager Ring_manager=new RingtoneManager(this);
        Uri uri=Ring_manager.getActualDefaultRingtoneUri(this,RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = Ring_manager.getRingtone(getApplicationContext(),uri);
        ringtone.play();

    }
    public void btn3Click(View view){

        AlarmClock alarmclock=new AlarmClock();
    }
}
