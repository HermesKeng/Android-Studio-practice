package com.example.keng.f410385007x2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText temp;
    Intent intent1,intent2;
    int ReSultCode1=0,ResultCode2=1;
    TextView txt;
    String ans;
    String str;
    double temperatures;
    private static final String PREF_Temp = "Temperature";
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp=(EditText)findViewById(R.id.temprature);
        prefs = getPreferences(MODE_PRIVATE);
    }
    @Override
    protected void onResume(){
        super.onResume();

        str=prefs.getString(PREF_Temp,"0");
        temp.setText(str);
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString(PREF_Temp, temp.getText().toString());
        prefEdit.commit();
    }
    public void Click1(View v){

        temperatures =Double.parseDouble(temp.getText().toString());
        intent1=new Intent(this,ConvertC.class);
        intent1.putExtra("Temp", temperatures);
        startActivityForResult(intent1,ReSultCode1);
    }
    public void Click2(View v){
        temperatures =Double.parseDouble(temp.getText().toString());
        intent2=new Intent("tw.edu.ntpu.Sec8.2.4.SecondActivity");
        intent2.putExtra("Temp",temperatures);
        startActivity(intent2);

    }
    protected void onActivityResult(int requestCode,int ResultCode,Intent it){
        if(ResultCode==RESULT_OK){
            ans=it.getStringExtra("output");
            txt=(TextView)findViewById(R.id.output);
            txt.setText(ans);
        }
    }
}
