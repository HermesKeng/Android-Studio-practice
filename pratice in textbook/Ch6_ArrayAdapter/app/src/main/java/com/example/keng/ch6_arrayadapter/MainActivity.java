package com.example.keng.ch6_arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    Spinner drink,temp;
    TextView list;
    String[] temp_set={"冰","去冰","溫"};
    String[] temp_set2={"冰","去冰"};
    String[] drink_set={"珍珠奶茶","檸檬紅茶","仙草凍奶茶","檸檬汁"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(TextView)findViewById(R.id.list);
        drink=(Spinner)findViewById(R.id.drink);
        temp=(Spinner)findViewById(R.id.temp);
        ArrayAdapter<String>drinkAd=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,drink_set);
        drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drink.setAdapter(drinkAd);
        drink.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] tempSet;
        if(position==3){
            tempSet=temp_set2;//檸檬汁沒有溫的
        }
        else{
            tempSet=temp_set;//其他都是去冰
        }
        ArrayAdapter<String>tempAd=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,tempSet);//建立下拉式選單
        tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp.setAdapter(tempAd);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Click(View view){
        String msg=drink.getSelectedItem()+", "+temp.getSelectedItem();
        list.setText(msg);
    }
}
