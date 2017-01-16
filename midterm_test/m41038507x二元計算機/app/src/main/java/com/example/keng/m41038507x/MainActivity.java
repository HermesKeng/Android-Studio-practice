package com.example.keng.m41038507x;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup operator;
    EditText input1,input2;
    CheckBox int_div;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(listener);
        input1=(EditText)findViewById(R.id.input1);
        input2=(EditText)findViewById(R.id.editText2);
        operator=(RadioGroup)findViewById(R.id.mode);
        int_div=(CheckBox)findViewById(R.id.int_divd);
        output=(TextView)findViewById(R.id.output);

    }

    View.OnClickListener listener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            calc();
        }
    };
    public void calc() {

        double a=Double.parseDouble(input1.getText().toString());
        double b=Double.parseDouble(input2.getText().toString());
        double ans =0 ;
        String cd;
        int intAns;
        int id=operator.getCheckedRadioButtonId();
        switch(id){
            case R.id.add:
                ans=a+b;
                output.setText(Double.toString(ans));
                break;
            case R.id.minus:
                ans=a-b;
                output.setText(Double.toString(ans));
                break;
            case R.id.multiply:
                ans=a*b;
                output.setText(Double.toString(ans));
                break;
            case R.id.division:
                ans=a/b;
                if(int_div.isChecked()){
                    output.setText(String.format("%.0d",ans));
                }
                else{
                    output.setText(Double.toString(ans));
                }
                break;
        }

    }
}
