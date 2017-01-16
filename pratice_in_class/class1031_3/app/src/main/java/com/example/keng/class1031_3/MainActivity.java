package com.example.keng.class1031_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    TextView output;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView)findViewById(R.id.lblOutput);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
    }
    @Override
    public boolean onLongClick(View v){

        output.setText("Long Click");
        return false;
    }
    @Override
    public void onClick(View v){
        output.setText("Click");
    }

}
