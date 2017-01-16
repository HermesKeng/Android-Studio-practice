package com.example.keng.ch6_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    TextView txv;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView) findViewById(R.id.TextView);
        lv=(ListView)findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView output=(TextView)view;
        String item=output.getText().toString();
        txv.setText("地點"+item);
    }
}
