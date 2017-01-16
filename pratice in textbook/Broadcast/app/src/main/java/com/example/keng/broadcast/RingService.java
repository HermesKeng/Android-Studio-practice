package com.example.keng.broadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by keng on 08/12/2016.
 */

public class RingService extends Service {
    MediaPlayer song;
    int start_id=0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        song=MediaPlayer.create(this,R.raw.test);
        String play_song=intent.getExtras().getString("extra");

        Log.e("ring state",play_song);

        assert play_song!=null;
        if(play_song.equals("on")){
            start_id=1;
            song.start();

        }else if(play_song.equals("off")){
            start_id=0;
            song.release();
        }

        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Toast.makeText(this,"on destroy call", Toast.LENGTH_SHORT).show();
    }


}
