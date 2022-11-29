package com.example.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.TreeSet;

public class DbHelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME = "MY_DATABASE.DB";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE = "COUNTRY";
    public static final String KEY_ID = "id";
    public static final String USER_NAME = "name";
    public static final String PHONE_NUMBER = "phone_no";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null ,DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + DATABASE_TABLE +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT," +
                PHONE_NUMBER + " TEXT ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);


    }
     public void addContact(String name,String phone_no ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
         ContentValues values = new ContentValues();
         values.put(USER_NAME,name);
         values.put(PHONE_NUMBER,phone_no);


         sqLiteDatabase.insert(DATABASE_TABLE,null,values);

     }
        public ArrayList<ModalClass> fetchContact(){
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
           Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM "  + DATABASE_TABLE,null );
           ArrayList<ModalClass> arrayList = new ArrayList<>();

           while (cursor.moveToNext()){
               ModalClass modalClass = new ModalClass();
               modalClass.id = cursor.getInt(0);
               modalClass.name=cursor.getString(1);
               modalClass.phone_no = cursor.getString(2);
               arrayList.add(modalClass);
           }
           return arrayList;

        }


}
