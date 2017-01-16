package com.example.keng.class1121_2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnClick(View view){
        MyDialog dlg=MyDialog.newInstance("確認");
        FragmentManager fm=getSupportFragmentManager();
        dlg.show(fm,"dialog");
    }
    public void doPositiveClick(){
        Toast.makeText(this,"按下確認鈕",Toast.LENGTH_SHORT).show();
    }
    public void doNeagtiveClick(){
        Toast.makeText(this,"按下取消鈕",Toast.LENGTH_SHORT).show();
    }
}
