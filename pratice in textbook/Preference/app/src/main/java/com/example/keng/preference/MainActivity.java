package com.example.keng.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText txt_weight,txt_height;
    private TextView textView;
    private static final String PREF_height="Height";
    private static final String PREF_weight="Weight";
    private SharedPreferences preferences;
    private boolean is_open=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_height=(EditText)findViewById(R.id.height);
        txt_weight=(EditText)findViewById(R.id.weight);
        textView=(TextView)findViewById(R.id.txt_bmi);
        //only in this activity can be store/load
        preferences=getPreferences(MODE_PRIVATE);


    }

    //when activity end, it will call onPause function.
    @Override
    protected void onPause(){
        super.onPause();
        //create sharepreference editor preparing to edit preference data
        SharedPreferences.Editor editor=preferences.edit();
        float height,weight;

           height = (float) Double.parseDouble(txt_height.getText().toString());
           weight = (float) Double.parseDouble(txt_weight.getText().toString());
            //put(int.float.string....)(key_name,key_value)
           editor.putFloat(PREF_height, height);
           editor.putFloat(PREF_weight, weight);
            //we need to store preference data , so we use editor.apply()
            //if we don't use it,it won't store the preference setting
           editor.apply();

    }
    //when activity start, it will call onResume function.
    @Override
    protected void onResume(){
            super.onResume();
            float height = preferences.getFloat(PREF_height, 150.0F);
            float weight = preferences.getFloat(PREF_weight, 40.0F);
            txt_height.setText(String.valueOf(height));
            txt_weight.setText(String.valueOf(weight));

    }
    public void Click(View view){
        float bmi,weight,height;
        if(txt_weight.getText().length()==0||txt_height.getText().length()==0){
            textView.setText("input cannot be 0");
        }else{
            height=(float)Double.parseDouble(txt_height.getText().toString());
            weight=(float)Double.parseDouble(txt_weight.getText().toString());
            bmi=weight/(height/100*height/100);
            textView.setText("bmi :"+String.valueOf(bmi));
            is_open=true;
        }
    }
}
