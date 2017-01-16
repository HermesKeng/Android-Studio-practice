package com.example.keng.fragment_pratice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Second_Fragment sf=new Second_Fragment();
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        BlankFragment blk=new BlankFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trans=fm.beginTransaction();
        trans.add(R.id.frame,blk);
        trans.commit();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1){

           sf=Second_Fragment.newInstance("hello");
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,sf).commit();
        }
        else if(v.getId()==R.id.btn2){
            getSupportFragmentManager().beginTransaction().remove(sf).commit();
        }
    }
}
