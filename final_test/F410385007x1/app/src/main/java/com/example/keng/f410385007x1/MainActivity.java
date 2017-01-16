package com.example.keng.f410385007x1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
                            implements TransFragment.TempListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onbuttonClick(double temp) {
        FragmentManager fm=getSupportFragmentManager();
        TextFragment tf=(TextFragment)fm.findFragmentById(R.id.fragment2);
        tf.changvalue(temp);
    }
}
