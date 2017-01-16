package com.example.keng.ch3_1101pratice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txvR,txvG,txvB;
    View colorblock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get 3 textview & linearLayout
        txvR=(TextView)findViewById(R.id.txvR);
        txvG=(TextView)findViewById(R.id.txvG);
        txvB=(TextView)findViewById(R.id.txvB);
        Button btn=(Button)findViewById(R.id.button);
        colorblock=findViewById(R.id.colorblock);

        btn.setOnClickListener(listener);
    }
    View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Random x=new Random();
            int red=x.nextInt(256);
            txvR.setText("紅：" +red);
            txvR.setTextColor(Color.rgb(red,0,0));
            int green=x.nextInt(256);
            txvG.setText("綠："+green);
            txvG.setTextColor(Color.rgb(0,green,0));
            int blue=x.nextInt(256);
            txvB.setText("藍："+blue);
            txvB.setTextColor(Color.rgb(0,0,blue));

            //set linear layout background-color
            colorblock.setBackgroundColor(Color.rgb(red,green,blue));
        }
    };

}
