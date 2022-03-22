package com.example.chapter4_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    TextView nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nameText = findViewById(R.id.userName);
        Intent intent = getIntent();
//        String receivedName = intent.getStringExtra(MainActivity.ExtraUserInputName);
//        List<String> receivedName = intent.getStringArrayListExtra(MainActivity.ExtraUserInputName);
        List<String> receivedName = (List<String>)intent.getSerializableExtra(MainActivity.ExtraUserInputName);
        nameText.setText(receivedName.toString());

    }
}