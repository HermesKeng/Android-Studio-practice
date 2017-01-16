package com.example.keng.ch7toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] que={"什麼門永遠關不上？","什麼東西沒人愛吃？","什麼瓜不能吃？","什麼布切不斷？","什麼鼠最愛乾淨？","偷什麼不犯法?"};
    String[] ans={"球門","虧","傻瓜","瀑布","環保署","偷笑"};
    Toast tos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,que);
        ListView lv=(ListView)findViewById(R.id.lv);
        tos=Toast.makeText(this,"",Toast.LENGTH_SHORT);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position%2==0){
            tos.setGravity(Gravity.TOP|Gravity.RIGHT,0,0);
            tos.setDuration(Toast.LENGTH_SHORT);

        }
        else{
            tos.setGravity(Gravity.TOP|Gravity.RIGHT,100,0);
            tos.setDuration(Toast.LENGTH_LONG);

        }
        tos.setText("答案："+ans[position]);
        tos.show();
    }
}
