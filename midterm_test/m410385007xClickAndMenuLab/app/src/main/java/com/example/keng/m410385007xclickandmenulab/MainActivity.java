package com.example.keng.m410385007xclickandmenulab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        btn=(Button)findViewById(R.id.button);
        txv=(TextView)findViewById(R.id.text);
        btn.setOnLongClickListener(listener);
        btn.setOnClickListener(listener2);
    }
    View.OnLongClickListener listener=new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {

            txv.setText(String.format("姓名：耿楷寗\n學號:410385007"));
            return true;
        }
    };
    View.OnClickListener listener2=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            txv.setText(String.format("試題3"));

        }
    };
}
