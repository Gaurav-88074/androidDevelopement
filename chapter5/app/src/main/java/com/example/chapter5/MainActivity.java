package com.example.chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private String[] arr = {"Gaurav","Vision","Ultron"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //built in adaptor
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        listview = findViewById(R.id.ListView);
        listview.setAdapter(ad);
        //-----------
        //custom adaptor

    }
}