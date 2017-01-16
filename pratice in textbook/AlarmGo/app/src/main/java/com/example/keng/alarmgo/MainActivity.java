package com.example.keng.alarmgo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
    implements TimePickerDialog.OnTimeSetListener, View.OnClickListener {

    Calendar calendar;
    Button set_Time;
    TextView txv;
    int hour,minute;
    Intent it;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context=this;
        //initialize alarmManger
        alarmManager=(AlarmManager)context.getSystemService(ALARM_SERVICE);
        //initialize & time to prepare for calling Timepicker

        calendar=Calendar.getInstance();

        it=new Intent(this.context,AlarmReceiver.class);
        //get Btn & setup listener
        set_Time=(Button)findViewById(R.id.timeSet);
        set_Time.setOnClickListener(this);

        txv=(TextView)findViewById(R.id.display);
        /*
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(getIntent().getExtras().getInt("Notification_ID"));
        */
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minuteofHour) {

        String hour_str,minute_str;
        //set hour,minute through timepicker
        hour=hourOfDay;
        minute=minuteofHour;
        //convert to string
        hour_str=String.valueOf(hour);
        minute_str=String.valueOf(minute);
        if(minute<10){
            minute_str="0"+minute_str;
        }

        //set Calender time
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);

        pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,it,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        //make toast & set output Text
        Toast.makeText(MainActivity.this,"Time :"+hour_str+":"+minute_str+" is set",Toast.LENGTH_SHORT).show();
        txv.setText("alarm on ->"+hour_str+":"+minute_str);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.timeSet:
                int hr=calendar.get(Calendar.HOUR_OF_DAY);
                int min=calendar.get(Calendar.MINUTE);
                new TimePickerDialog(this,2,this,hr,min,true).show();
                break;
            case R.id.alarmoff:
                Intent service=new Intent(this,MyService.class);
                stopService(service);
                break;

        }

    }
}
