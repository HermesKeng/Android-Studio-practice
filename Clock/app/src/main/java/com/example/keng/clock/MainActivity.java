package com.example.keng.clock;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity
implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {

    TextClock clock;
    AlarmManager alarm;

    TextView show_timeSet;
    public static final String BROADCAST_ACTION =
            "net.macdidi.broadcast01.action.MYBROADCAST01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //得到時間
        clock=(TextClock)findViewById(R.id.Clock);
        clock.setFormat12Hour(null);
        clock.setFormat24Hour("HH:mm:ss");
        Intent intent=new Intent(BROADCAST_ACTION);
        show_timeSet=(TextView)findViewById(R.id.show_timeSet);
    }


    public void btnClick(View v) {
        new TimePickerDialog(this, this,Calendar.HOUR_OF_DAY, Calendar.MINUTE, true).show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calendar= new Calendar() {
                @Override
                protected int handleGetLimit(int i, int i1) {
                    return 0;
                }

                @Override
                protected int handleComputeMonthStart(int i, int i1, boolean b) {
                    return 0;
                }

                @Override
                protected int handleGetExtendedYear() {
                    return 0;
                }
            };
            calendar.set(Calendar.DAY_OF_YEAR,Calendar.DAY_OF_MONTH,Calendar.DATE,hourOfDay,minute,0);
            show_timeSet.setText("設定時間："+hourOfDay+":"+minute);
            Intent it=new Intent();
            it.setClass(this,Alarm.class);
            PendingIntent pending = PendingIntent.getBroadcast(MainActivity.this
                    , 0, it, 0);
            alarm.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pending);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
