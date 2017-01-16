package com.example.keng.coundown;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView) findViewById(R.id.txt);
        String btnString="<u>兌換優惠</u>";

        btn=(Button)findViewById(R.id.btn);
        btn.setText(Html.fromHtml(btnString));
        btn.setOnClickListener(listener);
    }

    View.OnClickListener listener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            new CountDownTimer(150000, 1000) {
                long min,sec;
                public void onTick(long millisUntilFinished) {
                    sec=millisUntilFinished/1000;
                    min=sec/60;
                    sec=sec%60;
                    btn.setText("優惠倒數 " + min+":"+sec);
                }
                public void onFinish() {
                    btn.setText("done!");
                }
            }.start();
            btn.setClickable(false);
        }
    };
}
