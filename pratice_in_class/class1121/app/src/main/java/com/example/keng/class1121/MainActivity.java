package com.example.keng.class1121;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    private AlertDialog dialog,dialog2;//前面記得要做宣告（投影片沒有）
    String[] items={"Android","iOS","Windows Phone","Firfox OS"};
    boolean[] itemsChecked=new boolean[items.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("選擇按鈕以改變背景");
        String[] options={"紅","黃","綠"};
        builder.setItems(options,listener);
        builder.setNegativeButton("取消",null);
        dialog=builder.create();
        //dialog2
        dialog2=new AlertDialog.Builder(this).setTitle("請勾選使用過的作業系統")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "";
                        for (int index = 0; index < items.length; index++) {
                            if (itemsChecked[index]) {
                                msg += items[index] + "\n";
                            }
                        }
                        TextView output = (TextView) findViewById(R.id.output);
                        output.setText(msg);
                    }
                }).setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this,items[which]+(isChecked?"勾選":"沒有勾選"),
                                Toast.LENGTH_SHORT).show();
                            }
                        }
                ).create();
    }
    DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Button btn=(Button)findViewById(R.id.button3);
            switch (which){
                case 0:
                    btn.setBackgroundColor(Color.RED);
                    break;
                case 1:
                    btn.setBackgroundColor(Color.YELLOW);
                    break;
                case 2:
                    btn.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
    };
    public void OnClick(View view){
       AlertDialog.Builder builder=new AlertDialog.Builder(this);
       builder.setTitle("Title");
       builder.setMessage("訊息對話方塊內容\n Hi");
       builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
       builder.setNegativeButton("放棄", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
       builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });//也可以builder.setNeutralButton("取消",NULL)如果不做事的話
       builder.show();
   }
    public void OnClick2(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Test2")
                .setMessage("是否結束程式\nTest2")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("取消",null)
                .show();

    }
    public void OnClick3(View view){

        dialog.show();
    }
    public void OnClick4(View view){

        dialog2.show();
    }

}
