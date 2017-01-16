package com.example.keng.ch3_pratice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText sname,fname,phone;
    TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化變數
        sname=(EditText)findViewById(R.id.surname);
        fname=(EditText)findViewById(R.id.firstname);
        phone=(EditText)findViewById(R.id.phone);
        txv=(TextView)findViewById(R.id.txv);
    }
    public void onclick(View v){
        txv.setText(sname.getText().toString()+
                    fname.getText()+
                    "的電話是"+phone.getText());
    }
}
