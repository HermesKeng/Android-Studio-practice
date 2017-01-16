package com.example.keng.class1031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtHeight,txtWeight,amount;
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(listener);

        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(listener2);
    }

    View.OnClickListener listener=new View.OnClickListener(){
        public void onClick(View v){

            double height,weight,bmi;
            //取得輸入值
            txtHeight=(EditText)findViewById(R.id.height);
            txtWeight=(EditText)findViewById(R.id.weight);
            height=Double.parseDouble(txtHeight.getText().toString());
            weight=Double.parseDouble(txtWeight.getText().toString());
            //compute Bmi
            height/=100.00;
            bmi=weight/(height*height);
            //顯示Bmi
            TextView output=(TextView)findViewById(R.id.output);
            output.setText(Double.toString(bmi));

        }
    };
    View.OnClickListener listener2=new View.OnClickListener(){
        public void onClick(View v){
            int quantity;
            int sum=0;
            amount=(EditText) findViewById(R.id.amount);
            quantity= Integer.parseInt(amount.getText().toString());
            CheckBox original=(CheckBox)findViewById(R.id.original);
            CheckBox seafood=(CheckBox)findViewById(R.id.seafood);
            CheckBox beef=(CheckBox)findViewById(R.id.beef);
            if(original.isChecked()){
                sum+=250*quantity;
            }
            if(seafood.isChecked()){
                sum+=275*quantity;
            }
            if(beef.isChecked()){
                sum+=350*quantity;
            }

            TextView output=(TextView)findViewById(R.id.sum);
            output.setText(Integer.toString(sum));
        }
    };
}
