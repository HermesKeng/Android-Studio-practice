package com.example.keng.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view){
        EditText num=(EditText)findViewById(R.id.num);
        int second = 0;
        if(num.getText().length()!=0) {
            second = Integer.parseInt(num.getText().toString());
        }
        Intent i=new Intent(this,AlarmRecv.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,1234,i,0);

        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(second*1000),pendingIntent);

        Toast.makeText(this,"倒數計時建立",Toast.LENGTH_SHORT).show();
    }
    public void click2(View view){

    }
}
