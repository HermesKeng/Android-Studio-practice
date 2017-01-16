package com.example.keng.ch5_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,TextWatcher {

    RadioGroup unit;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit=(RadioGroup)findViewById(R.id.type);
        unit.setOnCheckedChangeListener(this);

        value=(EditText) findViewById(R.id.value);
        value.setText("55");
        value.addTextChangedListener(this);

    }
    private void calc() {
        TextView degF=(TextView)findViewById(R.id.degF);
        TextView degC=(TextView)findViewById(R.id.degC);

        double c,f;

        if(unit.getCheckedRadioButtonId()==R.id.changeF){
            f=Double.parseDouble(value.getText().toString());
            c=(f-32)*5/9;
        }
        else{
            c=Double.parseDouble(value.getText().toString());
            f=c*9/5+32;
        }
        degC.setText(String.format("%.1f",c)+getResources().getString(R.string.charC));
        degF.setText(String.format("%.1f",f)+getResources().getString(R.string.charF));
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //文字變動之前
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //文字變動時

    }

    @Override
    public void afterTextChanged(Editable s) {
        //文字變動後
        //calc();
        String str=value.getText().toString().trim();
        if(str.length()==0) {
            return ;
        }
        else{
            calc();
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String str=value.getText().toString().trim();
        if(str.length()==0) {
            return ;
        }
        else{
            calc();
        }
    }


}
