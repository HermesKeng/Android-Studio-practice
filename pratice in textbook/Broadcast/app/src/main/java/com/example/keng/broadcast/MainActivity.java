package com.example.keng.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.icu.util.Calendar.getInstance;

public class MainActivity extends AppCompatActivity {

    //to make alarm manager
    AlarmManager alarmManager;
    TimePicker picker;
    TextView set_Text;
    Context context;
    Calendar calender;
    Button start, end;
    Intent it;
    PendingIntent pending_intent;

    public MainActivity(Calendar calender) {
        this.calender = calender;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;

        //initialize alarmManger
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //initialize timepicker
        picker = (TimePicker) findViewById(R.id.timePicker);
        //initialize timepicker
        set_Text = (TextView) findViewById(R.id.set_Text);

        //Create intent to Broadcast
        it=new Intent(this.context,AlarmReceiver.class);
        //setup calender using to set time
       // calender=Calendar.getInstance();
        //set onClick
        start = (Button) findViewById(R.id.start_alarm);
        start.setOnClickListener(startlistener);
        end = (Button) findViewById(R.id.end_alarm);
        end.setOnClickListener(endlistener);


    }

    View.OnClickListener startlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            calender.set(Calendar.HOUR_OF_DAY,picker.getHour());
            calender.set(Calendar.MINUTE,picker.getMinute());
            int hour=picker.getHour();
            int minute=picker.getMinute();

            String hour_str=String.valueOf(hour);
            String minute_str=String.valueOf(minute);
            if(minute<10){
                minute_str='0'+minute_str;
            }
            set_Text.setText("alarm on ->"+hour_str+":"+minute_str);
            it.putExtra("extra","on");
            //create a pending intent delay intent
            //until time arrived
            pending_intent=PendingIntent.getBroadcast(ManActivity.this,0,it,PendingIntent.FLAG_UPDATE_CURRENT);
            //set the alarmManger
            alarmManager.set(AlarmManager.,calender.getTimeInMillis(),pending_intent);
            Log.e("set up time","Oh!!!!!!");
        }
    };
    View.OnClickListener endlistener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            set_Text.setText("alarm off !");
            //cancel
            it.putExtra("extra","off");
            alarmManager.cancel(pending_intent);
            sendBroadcast(it);
        }
    };

}
