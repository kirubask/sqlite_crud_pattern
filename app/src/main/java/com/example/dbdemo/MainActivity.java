package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DbHelper myDbHelper = new DbHelper(this);
//        myDbHelper.addcontact("sundar","95472658");
        DbHelper mydb = new DbHelper(this);
        mydb.addcontact("sundar","9990");


    }
}