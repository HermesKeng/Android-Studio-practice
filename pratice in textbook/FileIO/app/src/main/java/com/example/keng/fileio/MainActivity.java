package com.example.keng.fileio;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final int READ_BLOCK_SIZE=100;
    private String filePath="/IOLabforSD";
    private String file_name="christmas.txt";
    private File file;
    Button saveBtn,loadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn=(Button)findViewById(R.id.store_btn);
        loadBtn=(Button)findViewById(R.id.load_btn);
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"沒有外部儲存裝置",Toast.LENGTH_LONG).show();
            finish();
            return;
        }else{
            try{
                File sd=Environment.getExternalStorageDirectory();
                File dir=new File(sd.getAbsolutePath()+filePath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                file=new File(dir,file_name);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        saveBtn.setOnClickListener(saveBtnlistener);
        loadBtn.setOnClickListener(loadBtnlistener);
    }

    public View.OnClickListener saveBtnlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText input=(EditText)findViewById(R.id.editText);

            String str=input.getText().toString();
            try{
                FileOutputStream outstream=openFileOutput(file_name,MODE_PRIVATE);//openFileOutput(filename,MODE)
                OutputStreamWriter sw=new OutputStreamWriter(outstream);
                sw.write(str);
                sw.flush();
                sw.close();
                Toast.makeText(v.getContext(),"Write Data Successfully",Toast.LENGTH_LONG).show();
                input.setText("");

            }catch(IOException ex){//you need to declare fileouput first ,and it won't have red line alert
                ex.getStackTrace();
            }
        }
    };
    public  View.OnClickListener loadBtnlistener=new View.OnClickListener(){

        char[] buffer=new char[READ_BLOCK_SIZE];
        String str="";
        int count;
        @Override
        public void onClick(View v) {
            try{
                //FileInputStream instream=openFileInput(file_name);
                InputStream instream= v.getResources().openRawResource(R.raw.christmas);
                InputStreamReader sr=new InputStreamReader(instream);
                BufferedReader br=new BufferedReader(sr);
                String s=null,str="";
                while((s=br.readLine())!=null){
                    str+=s;
                    str+="\n";
                }
               /*
                while((count=sr.read(buffer))>0){
                    String s=String.copyValueOf(buffer,0,count);
                    str+=s;
                    buffer=new char[READ_BLOCK_SIZE];
                }*/
                br.close();
                sr.close();
                Toast.makeText(v.getContext(),"Read Data Sucessfully",Toast.LENGTH_LONG).show();
                TextView output=(TextView)findViewById(R.id.output);
                output.setText("Read Data :\n"+str);

            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    };
}
