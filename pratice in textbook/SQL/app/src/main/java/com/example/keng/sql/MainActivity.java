package com.example.keng.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private DBHelper dbhelper;
    TextView output;
    EditText title,txtprice,newPrice;
    private static String DATABASE_TABLE = "titles";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new DBHelper(this);
        db=dbhelper.getWritableDatabase();
        output=(TextView)findViewById(R.id.textView);
        title=(EditText)findViewById(R.id.item);
        txtprice=(EditText)findViewById(R.id.price);
        newPrice=(EditText)findViewById(R.id.newPrice);

    }
    public void Click(View v){



        //output.setText("資料庫是否開啟："+db.isOpen()+"\n資料庫版本"+db.getVersion());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        if(id==R.id.action_insert){
            // use column to setup content value
            ContentValues cv=new ContentValues();
            //insert data to each column (column_name,column_value)
            cv.put("title",title.getText().toString());
            double price=Double.parseDouble(txtprice.getText().toString());
            cv.put("price",price);
            long new_id=db.insert(DATABASE_TABLE,null,cv);
            output.setText("新增資料成功："+new_id);
            return true;

        }else if(id==R.id.action_update){
            String title_name=title.getText().toString();
            ContentValues cv=new ContentValues();
            double price=Double.parseDouble(newPrice.getText().toString());
            cv.put("price",price);
            int count=db.update(DATABASE_TABLE,cv,"title='"+title_name+"'",null);
            output.setText("更新紀錄成功:"+count);
            return true;

        }else if(id==R.id.action_delete){

            String title_name=title.getText().toString();
            int count=db.delete(DATABASE_TABLE, "title='" + title_name + "'", null);
            output.setText("資料刪除成功："+count);
            return true;
        }else if(id==R.id.action_queryAll){
            String[] colNames=new String[]{"_id","title","price"};
            String data ="";
            Cursor c=db.query(DATABASE_TABLE,colNames,null,null,null,null,null,null);
            for (int i = 0; i < colNames.length; i++) {
                data += colNames[i] + "\t\t";
            }
            data+="\n";
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                data += c.getString( c.getColumnIndex(colNames[0])) + "\t\t";
                data += c.getString(1) + "\t\t";//get first column value
                data += c.getString(2) + "\n";//get second column value
                c.moveToNext();
                //move to newx data
            }
            output.setText(data.toString());
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStop(){
        super.onStop();
        db.close();
    }
}
