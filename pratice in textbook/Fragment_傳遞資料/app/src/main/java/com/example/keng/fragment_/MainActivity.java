package com.example.keng.fragment_;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
                            implements BlankFragment.BMIListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void buttonClicked(double bmi) {
        FragmentManager fm=getSupportFragmentManager();
        TextFragment textFragment=(TextFragment)fm.findFragmentById(R.id.fragment2);
        textFragment.changedBMIvalue(bmi);
    }
}
