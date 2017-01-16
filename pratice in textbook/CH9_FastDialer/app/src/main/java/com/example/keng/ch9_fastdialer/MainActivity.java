package com.example.keng.ch9_fastdialer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Call(View view){
        Intent it=new Intent();
        it.setAction(Intent.ACTION_VIEW);
        it.setData(Uri.parse("geo:25.047095,121.517308"));
        startActivity(it);
    }
}
