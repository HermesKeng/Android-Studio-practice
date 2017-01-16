package com.example.keng.m410385007xsumlabmix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ToggleButton a;

    EditText input;
    TextView output,name;
    Button btn;
    ImageButton btn2;
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText) findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn2=(ImageButton)findViewById(R.id.btn2);
        a=(ToggleButton)findViewById(R.id.toggleButton2);
        a.setOnClickListener(listener);
        name=(TextView)findViewById(R.id.name);

    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(n==0){
                name.setText(String.format("學號:410385007\n 姓名：耿楷寗"));
                n++;
            }
            else{
                name.setText(String.format("編號2"));
                n--;
            }
        }
    };

    public void message(View view){
        Toast.makeText(this,"行動裝置開發程式設計",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        int a,sum=0;
        if(input.getText().length()==0){
            return;
        }
        else {
          a=Integer.parseInt(input.getText().toString());
            for(int i=1;i<a;i++){
                sum=sum+i;
            }
            output.setText(Integer.toString(sum));
        }
    }
}
