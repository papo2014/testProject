package com.pj.test.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pj.test.model.UserInfo;

/**
 * Created by Administrator on 2016/2/5.
 */
public class DataBaseHelper extends SQLiteOpenHelper{
    protected  static final String DB_NAME = "test.db";
    protected  int version = 1;
    public static final String TB_NAME= "users";
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS "+
                TB_NAME+ "("+
                UserInfo. ID+ " integer primary key,"+
                UserInfo. USERID+ " varchar"+

                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
