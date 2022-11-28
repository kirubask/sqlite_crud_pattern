package com.example.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.TreeSet;

public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "MY_DATABASE.DB";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_TABLE = "COUNTRY";
    static final String KEY_ID = "ID";
    static final String USER_NAME = "name";
    static final String PHONE_NUMBER = "phone_no";



    public DbHelper( Context context) {
        super(context, DATABASE_NAME,null ,DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE "+DATABASE_TABLE+"("+KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ USER_NAME+"TEXT ,"+PHONE_NUMBER+"TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);


    }
     public void addcontact(String name,String phone_no ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
         ContentValues values = new ContentValues();
         values.put(USER_NAME,name);
         values.put(PHONE_NUMBER,phone_no);

         sqLiteDatabase.insert(USER_NAME,null,values);

     }



}
