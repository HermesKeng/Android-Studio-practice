package com.example.keng.fragment_;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment2 sf=new Fragment2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 ff=new Fragment1();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.add(R.id.frame,ff);
        trans.commit();
    }
    public void Click1(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,sf).commit();
    }
    public void Click2(View view){
        getSupportFragmentManager().beginTransaction().remove(sf).commit();
    }
}
