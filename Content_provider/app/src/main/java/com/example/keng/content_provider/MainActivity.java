package com.example.keng.content_provider;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    //每個欄位有的內容
    String[] columns = new String[] {//Cursor物件的欄位
             ContactsContract.Contacts.DISPLAY_NAME,
             ContactsContract.Contacts._ID,
    };
    //每個欄位顯示的對應介面元件
    int[] views = new int[] {
            R.id.contactName,
            R.id.contactID, };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri contacts = Uri.parse("content://contacts/people");
        Cursor c=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.list_item,c,columns,views, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        TextView lblID = (TextView) v.findViewById(R.id.contactID);
        TextView lblName = (TextView) v.findViewById(R.id.contactName);
        String cid = lblID.getText().toString();
        String name = lblName.getText().toString();
        Cursor pCur = getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                        new String[]{cid}, null);
        while (pCur.moveToNext()) { //電話號碼可能不只一個! String phoneNo =
            String phoneNo =pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Toast.makeText(this, "姓名: " + name + "\n電話號碼: " + phoneNo, Toast.LENGTH_SHORT).show();
        }
        pCur.close();
    }
}
