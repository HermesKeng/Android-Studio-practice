package com.example.keng.sql_pra;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String db_name="Database";
    static final String tb_name="Handsome";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);

        String createTable="CREATE TABLE IF NOT EXISTS "+tb_name +
                "(name VARCHAR(32), "+
                "age VARCHAR(10), "+
                "phone VARCHAR(16))";
        db.execSQL(createTable);
        addData("keng","21","0921581851");
        addData("hermes","22","23097305");

        TextView txv=(TextView)findViewById(R.id.txv);
        txv.setText("資料庫路徑 : "+db.getPath()+"\n"+
                "資料分頁大小："+db.getPageSize()+" Bytes\n"+
                "資料庫上限："+db.getMaximumSize()+" Bytes\n");
        db.close();
    }
    private void addData(String name,String age,String phone){
        //利用content value 將每個欄位進行input
        ContentValues cv=new ContentValues(3);
        cv.put("name",name);
        cv.put("age",age);
        cv.put("phone",phone);
        db.insert(tb_name,null,cv);
    }
}
