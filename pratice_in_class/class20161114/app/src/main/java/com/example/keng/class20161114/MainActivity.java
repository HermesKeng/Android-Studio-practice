package com.example.keng.class20161114;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FirstkFragment.Listener{

    Button btn1,btn2;
    FirstkFragment ff=new FirstkFragment();
    SecondFragment sf=new SecondFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trans=fm.beginTransaction();
        trans.add(R.id.frame,ff);
        trans.commit();


        FragmentManager sm=getSupportFragmentManager();
        FragmentTransaction strans=sm.beginTransaction();

        strans.add(R.id.frame2,sf);
        strans.commit();

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(btn1listener);
        btn1.setOnClickListener(btn2listener);
    }

    View.OnClickListener btn1listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //sf=SecondFragment.newInstance("改成第二個Fragment片段");
        //getSupportFragmentManager().beginTransaction().replace(R.id.frame,sf).commit();
        }
    };

    View.OnClickListener btn2listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //getSupportFragmentManager().beginTransaction().remove(sf).commit();
        }
    };

    @Override
    public void BtnClick(double tmp) {
        FragmentManager sm=getSupportFragmentManager();
        SecondFragment tf=(SecondFragment)sm.findFragmentById(R.id.output);
        tf.Output(tmp);
    }
}
