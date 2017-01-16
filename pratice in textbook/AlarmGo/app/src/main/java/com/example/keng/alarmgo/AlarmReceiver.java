package com.example.keng.alarmgo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by keng on 08/12/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("start up AlarmReceiver","Oh!!!!!!");
        //create an Service
        Intent service=new Intent(context,MyService.class);
        context.startService(service);
        Toast.makeText(context,"alarm",Toast.LENGTH_LONG).show();
    }
}
