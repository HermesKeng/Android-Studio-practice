package com.example.keng.ch5_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Button btn;
    ArrayList<CompoundButton>selected=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(listener);
        CheckBox chk;
        int [] id={R.id.burger,R.id.cola,R.id.soup,R.id.frenchfries,R.id.friedchicken,R.id.cafe,R.id.salad,R.id.applepie,R.id.small};

        for(int i:id){
            chk=(CheckBox)findViewById(i);
            chk.setOnCheckedChangeListener(this);
        }

    }

    View.OnClickListener listener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            String msg="";

            for(CompoundButton chk:selected){
                msg+="\n"+chk.getText();
            }

            if(msg.length()>0){
                msg="你點的餐點"+msg;
            }
            else{
                msg="請點餐！";
            }
            ((TextView)findViewById(R.id.output)).setText(msg);

        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView.getId()==R.id.small){

            if(isChecked) {
                ((TextView) findViewById(R.id.output)).setTextSize(20);
            }
            else {
                ((TextView) findViewById(R.id.output)).setTextSize(50);
            }
            return;
        }
        else {
            if (isChecked) {
                selected.add(buttonView);
            } else {
                selected.remove(buttonView);
            }
        }
    }
}
