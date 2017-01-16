package com.example.keng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by keng on 08/12/2016.
 */
//construct a broadcast Receiver
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("start up AlarmReceiver","Oh!!!!!!");

        //get extrastring
        //String main_act=intent.getExtras().getString("extra");
        //Log.e("extra",main_act);
        //create intent to Ring
        //Intent service=new Intent(context,RingService.class);
        //pass to ringService
        //service.putExtra("extra",main_act);

        //start service
        //context.startService(service);
    }
}
