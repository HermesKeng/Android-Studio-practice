package com.example.keng.ch8_multiactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    public void goback(View v){
        finish();
    }
}
