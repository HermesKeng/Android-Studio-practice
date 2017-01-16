package com.example.keng.f410385007x3;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.Manifest.permission;

public class MainActivity extends ListActivity {
    private static final String dbNAME = "Contact";
    private static final String tbNAME = "contactList";
    static final int PERMISSIONS_REQUEST_READ_CONTACTS=100;
    private static final int REQUEST_WRITE_STORAGE = 112;
    private String fname = "ContactList.txt";
    private String fpath = "/F122603";
    private File file;
    FileOutputStream out;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=openOrCreateDatabase(dbNAME, Context.MODE_PRIVATE,null);
        String createTable="CREATE TABLE IF NOT EXISTS "+ tbNAME
                        +"(_id VARCHAR(3),"
                        +"name VARCHAR(32),"
                        +"phone VARCHAR(16))";
        db.execSQL(createTable);
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "沒有外部儲存裝置...", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        try {
            File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File dir = new File(sd.getAbsolutePath()+fpath);
            Log.e("path:",sd.getAbsolutePath() + fpath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            file = new File(dir, fname);
            Log.e("start: ", "sd_path");
            Log.e("start: ", "sd_path");
        }
        catch (Exception ex) {
            ex.printStackTrace(); }
        try {
            out = new FileOutputStream(file);
            Log.e("start: ", "file writer");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{permission.READ_CONTACTS,permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
        else {
            Uri contacts = Uri.parse("content://contacts/people");
            Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null); //取得聯絡人資料的cursor物件
            //建立欄位和介面元件的參數陣列
            String[] columns = new String[]{ //Cursor物件的欄位
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts._ID,
            };
            int[] views = new int[]{ //對應欄位顯示的介面元件
                    R.id.contactName,
                    R.id.contactID,
            };
            //建立SimpleCursorAdapter物件
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this, R.layout.list_item, c, columns, views,
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            setListAdapter(adapter); //指定adapter物件
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Uri contacts = Uri.parse("content://contacts/people");
            Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null); //取得聯絡人資料的cursor物件
            //建立欄位和介面元件的參數陣列
            String[] columns = new String[]{ //Cursor物件的欄位
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts._ID,
            };
            int[] views = new int[]{ //對應欄位顯示的介面元件
                    R.id.contactName,
                    R.id.contactID,
            };
            //建立SimpleCursorAdapter物件
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this, R.layout.list_item, c, columns, views,
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            setListAdapter(adapter); //指定adapter物件
            if (!Environment.getExternalStorageState().
                    equals(Environment.MEDIA_MOUNTED)) { Toast.makeText(this, "沒有外部儲存裝置...",
                    Toast.LENGTH_SHORT).show(); finish();
                return;
            }
            try {
                File sd = Environment.getExternalStorageDirectory();
                File dir = new File(sd.getAbsolutePath() + fpath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                file = new File(dir, fname);
            }
            catch (Exception ex) {
                ex.printStackTrace(); }
            try {
                out = new FileOutputStream(file);
                Log.e("start: ", "file writer");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //取得選擇聯絡人的contactID和contactName的TextView元件
        TextView lblID = (TextView) v.findViewById(R.id.contactID);
        TextView lblName = (TextView) v.findViewById(R.id.contactName);
        // 取得_ID和姓名
        String cid = lblID.getText().toString();
        String name = lblName.getText().toString();
        // 查詢電話號碼
        Cursor pCur = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                new String[]{cid}, null);
        // 顯示電話號碼

        //檢查資料是否相同
        while (pCur.moveToNext()) {
            String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //Toast.makeText(this, "姓名: " + name + "\n電話號碼: " + phoneNo, Toast.LENGTH_SHORT).show();
            if(!check(name,phoneNo)) {
                addData(cid, name, phoneNo);
            }
        }
        //OUTPUT
        display();


    }
    private void  addData(String _id,String name,String phone){
        ContentValues cv=new ContentValues(3);
        cv.put("_id",_id);
        cv.put("name",name);
        cv.put("phone",phone);
        db.insert(tbNAME,null,cv);
        Log.e("data :",_id);
    }
    private boolean check(String name,String phone){
        String[] colNames=new String[]{"_id","name","phone"};
        Cursor c=db.query(tbNAME,colNames,null,null,null,null,null,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++) {
            if (c.getString(1).equals(name) && c.getString(2).equals(phone)) {
                Log.e("Same:", "1");
                return true;
            }
            c.moveToNext();
        }
        Log.e("Same:","0");
        return false;
    }
    private void display(){
        String[] colNames=new String[]{"_id","name","phone"};
        String data ="";
        Cursor c=db.query(tbNAME,colNames,null,null,null,null,null,null);
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
        try {
            OutputStreamWriter sw = new OutputStreamWriter(out);
            sw.write(data);
            sw.flush();
            sw.close();
            Log.e("writer :"," data is written");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}