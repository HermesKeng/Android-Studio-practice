package com.example.keng.menu;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText)findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_name,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int tmp=0;
        double result;
        String a;
        if(input.getText().toString().length()>0) {
            tmp = Integer.parseInt(input.getText().toString());
        }
        switch (item.getItemId()){
            case R.id.toF:
                result=(tmp*9/5)+32;
                output.setText("溫度"+result);
                break;
            case R.id.toC:
                result=(tmp-32)*5/9;
                output.setText("溫度"+result);
                break;
            case R.id.item1:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
