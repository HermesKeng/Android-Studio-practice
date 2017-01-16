package com.example.keng.ch6_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,Button.OnClickListener {

    double[] energyRate={3.1,4.4,13.2,9.7,5.1,3.7};
    EditText weight,time;
    TextView total,txvRate;
    Spinner sports;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight=(EditText) findViewById(R.id.weight);
        time=(EditText)findViewById(R.id.spantime);
        total=(TextView)findViewById(R.id.calorie);
        txvRate=(TextView)findViewById(R.id.calrate);
        sports=(Spinner)findViewById(R.id.sport);
        btn=(Button)findViewById(R.id.btn);
        sports.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txvRate.setText(String.valueOf(energyRate[position]));
        calc(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        double w=Double.parseDouble(weight.getText().toString());
        double t=Double.parseDouble(time.getText().toString());

        int selected=sports.getSelectedItemPosition();
        long consumedEnergy=Math.round(energyRate[selected]*t*w);

        total.setText("消耗卡路里："+consumedEnergy+"千卡");

    }
    public void calc(View v){
        if(weight.getText().length()==0||time.getText().length()==0){
            return;
        }
        else {
            double w = Double.parseDouble(weight.getText().toString());
            double t = Double.parseDouble(time.getText().toString());


            int selected = sports.getSelectedItemPosition();
            long consumedEnergy = Math.round(energyRate[selected] * t * w);

            total.setText("消耗卡路里：" + consumedEnergy + "千卡");
        }
    }
}
