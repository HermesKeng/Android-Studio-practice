package com.example.keng.ch9_intent;

import android.app.SearchManager;
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
    public void OnClick(View view){
        Intent it=new Intent(Intent.ACTION_VIEW);
        switch (view.getId()){
            case R.id.button_email:{
                it.setData(Uri.parse("mailto:kaining1101@gmail.com"));
                it.putExtra(Intent.EXTRA_CC,new String[]{"kaining1101@gmail.com"});
                it.putExtra(Intent.EXTRA_SUBJECT,"資料已送到");
                it.putExtra(Intent.EXTRA_TEXT,"你好");
                break;
            }
            case R.id.button_map:{
                it.setData(Uri.parse("geo:25.047095,121.517308"));
                break;
            }
            case R.id.button_sms:{
                it.setData(Uri.parse("sms:0921-581851?body=love!"));
                break;
            }
            case R.id.button_search:{
                it.setAction(Intent.ACTION_WEB_SEARCH);
                it.putExtra(SearchManager.QUERY,"NTPU");
                break;
            }
            case R.id.button_website:{
                it.setData(Uri.parse("http://www.google.com.tw"));
            }
        }
        startActivity(it);
    }
}
