package com.example.keng.f410385007x2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConverF extends AppCompatActivity {
    double ans;
    double temp;
    String str;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conver_f);
        double temperature=0;
        Intent it2=getIntent();
        temperature=it2.getDoubleExtra("Temp",0.0);
        output=(TextView)findViewById(R.id.output2);
        temp=temperature;
        temp*=9;
        temp/=5;
        temp+=32;
        ans=temp;
        str="攝氏"+String.valueOf(temperature)+"轉華氏："+String.valueOf(ans);
        output.setText(str);
    }
    public void Click(View v){
        Intent it2=new Intent();
        it2.putExtra("output",str);
        setResult(RESULT_OK,it2);
        finish();
    }

}
