package com.example.keng.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

    String[] aMemo={
            "1. 按一下可以編輯",
            "2. 長按可以清除備忘","3.","4.","5.","6."
    };
    ListView lv;
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        aa=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,aMemo);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it=new Intent(this,Edit.class);
        it.putExtra("備忘",aMemo[position]);
        startActivityForResult(it,position);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        aMemo[position]=(position+1)+".";
        aa.notifyDataSetChanged();
        return true;

    }
    protected  void onActivityResult(int requestcode,int resultcode,Intent it){
        if(resultcode==RESULT_OK){
            aMemo[requestcode]=it.getStringExtra("備忘");
            Toast.makeText(this,"修改時間： "+it.getStringExtra("時間"),Toast.LENGTH_SHORT).show();
            aa.notifyDataSetChanged();
        }
    }
}
