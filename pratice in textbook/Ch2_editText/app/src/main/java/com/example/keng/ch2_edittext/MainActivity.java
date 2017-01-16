package com.example.keng.ch2_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void say_Hello(View view){

        EditText name=(EditText)findViewById(R.id.name);
        TextView txv=(TextView)findViewById(R.id.txt);
        String str=name.getText().toString();
        if(str.length()==0){
            txv.setText("Please input your name !");
        }
        else {
            txv.setText("Hi "+str+" !");
        }
    }
}

