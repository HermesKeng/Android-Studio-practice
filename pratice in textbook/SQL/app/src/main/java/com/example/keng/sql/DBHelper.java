package com.example.keng.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by keng on 25/12/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbNAME = "MyBooks";
    private static final int dbVERSION = 1;
    public DBHelper(Context context) {
        super(context, dbNAME, null, dbVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE titles (_id integer "+"primary key autoincrement, "+"name text no null, "
                        +"phone text no null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST titles");
        onCreate(db);
    }
}
