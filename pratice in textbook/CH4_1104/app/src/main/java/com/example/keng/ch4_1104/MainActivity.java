package com.example.keng.ch4_1104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    TextView txv;
    Button btn;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView)findViewById(R.id.count);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        txv.setOnClickListener(this);
        txv.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.count){
            txv.setText(String.valueOf(--counter));
        }
        else {
            counter++;
            txv.setText(String.valueOf(counter));
        }
    }

    @Override
    public boolean onLongClick(View v) {

        if(v.getId()==R.id.count){
            counter=0;
            txv.setText("0");

        }
        else{
            counter+=2;
            txv.setText(String.valueOf(counter));
        }
        return true;
    }
}
