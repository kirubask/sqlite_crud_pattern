package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper myDb = new DbHelper(this);
        myDb.addContact("sundar","9990");
      ArrayList<ModalClass>  data = myDb.fetchContact();
      for (int i=0; i < data.size(); i++)
          Log.d("contact info","NAME" + data.get(i).name + "phone"+data.get(i).phone_no);


    }
}