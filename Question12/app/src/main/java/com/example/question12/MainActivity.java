package com.example.question12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler handler = new DbHandler(this,"studentDb",null,1);
        List<Student> array = handler.getAllStudent();
        String[] arrayData = new String[array.size()];
        for (int i = 0;i<array.size();i++){
            arrayData[i] = array.get(i).toString();
        }
        ArrayAdapter ad = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arrayData
        );
        listView = findViewById(R.id.listView);
        listView.setAdapter(ad);
        Intent intent = new Intent(this,AddUser.class);
        addButton = findViewById(R.id.addUserButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }

}